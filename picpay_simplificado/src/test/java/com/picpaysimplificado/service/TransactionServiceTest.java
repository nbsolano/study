package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dto.TransactionDTO;
import com.picpaysimplificado.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private TransactionService transactionService;

    private User payer;
    private User payee;
    private TransactionDTO transactionDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        payer = new User();
        payer.setId(1L);
        payer.setFirstName("João");
        payer.setLastName("Silva");
        payer.setDocument("12345678900");
        payer.setEmail("joao@example.com");
        payer.setBalance(new BigDecimal("100.00"));
        payer.setUserType(UserType.COMMON);

        payee = new User();
        payee.setId(2L);
        payee.setFirstName("Maria");
        payee.setLastName("Souza");
        payee.setDocument("98765432100");
        payee.setEmail("maria@example.com");
        payee.setBalance(new BigDecimal("50.00"));
        payee.setUserType(UserType.MERCHANT);

        transactionDTO = new TransactionDTO();
        transactionDTO.setValue(new BigDecimal("10.00"));
        transactionDTO.setPayerId(1L);
        transactionDTO.setPayeeId(2L);
    }

    @Test
    void shouldCreateTransactionSuccessfully() throws Exception {
        when(userService.findUserById(1L)).thenReturn(payer);
        when(userService.findUserById(2L)).thenReturn(payee);
        when(transactionRepository.save(any(Transaction.class))).thenAnswer(i -> i.getArgument(0));

        Transaction transaction = transactionService.createTransaction(transactionDTO);

        assertNotNull(transaction);
        assertEquals(new BigDecimal("10.00"), transaction.getAmount());
        assertEquals(payer, transaction.getSender());
        assertEquals(payee, transaction.getReceiver());

        verify(userService).validateTransaction(payer, new BigDecimal("10.00"));
        verify(userService).updateBalance(payer, payee, new BigDecimal("10.00"));
        verify(transactionRepository).save(any(Transaction.class));
        verify(notificationService).sendNotification(payer, "Transação realizada com sucesso");
        verify(notificationService).sendNotification(payee, "Transação recebida com sucesso");
    }

    @Test
    void shouldThrowExceptionWhenPayerHasInsufficientFunds() {
        payer.setBalance(new BigDecimal("5.00"));
        when(userService.findUserById(1L)).thenReturn(payer);
        when(userService.findUserById(2L)).thenReturn(payee);
        
        doThrow(new RuntimeException("Saldo insuficiente"))
            .when(userService).validateTransaction(payer, new BigDecimal("10.00"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transactionService.createTransaction(transactionDTO);
        });

        assertEquals("Saldo insuficiente", exception.getMessage());
        verify(transactionRepository, never()).save(any(Transaction.class));
    }

    @Test
    void shouldThrowExceptionWhenPayerIsMerchant() {
        payer.setUserType(UserType.MERCHANT);
        when(userService.findUserById(1L)).thenReturn(payer);
        when(userService.findUserById(2L)).thenReturn(payee);
        
        doThrow(new RuntimeException("Usuário do tipo lojista não pode realizar transações"))
            .when(userService).validateTransaction(payer, new BigDecimal("10.00"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transactionService.createTransaction(transactionDTO);
        });

        assertEquals("Usuário do tipo lojista não pode realizar transações", exception.getMessage());
        verify(transactionRepository, never()).save(any(Transaction.class));
    }
}