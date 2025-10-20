package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User commonUser;
    private User merchantUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        commonUser = new User();
        commonUser.setId(1L);
        commonUser.setFirstName("João");
        commonUser.setLastName("Silva");
        commonUser.setDocument("12345678900");
        commonUser.setEmail("joao@example.com");
        commonUser.setBalance(new BigDecimal("100.00"));
        commonUser.setUserType(UserType.COMMON);

        merchantUser = new User();
        merchantUser.setId(2L);
        merchantUser.setFirstName("Maria");
        merchantUser.setLastName("Souza");
        merchantUser.setDocument("98765432100");
        merchantUser.setEmail("maria@example.com");
        merchantUser.setBalance(new BigDecimal("50.00"));
        merchantUser.setUserType(UserType.MERCHANT);
    }

    @Test
    void shouldFindUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(commonUser));

        User foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
        assertEquals(1L, foundUser.getId());
        assertEquals("João", foundUser.getFirstName());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findById(3L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.findUserById(3L);
        });

        assertEquals("Usuário não encontrado", exception.getMessage());
    }

    @Test
    void shouldValidateTransactionSuccessfully() {
        userService.validateTransaction(commonUser, new BigDecimal("50.00"));
        // Se não lançar exceção, o teste passa
    }

    @Test
    void shouldThrowExceptionWhenUserIsMerchant() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.validateTransaction(merchantUser, new BigDecimal("10.00"));
        });

        assertEquals("Usuário do tipo lojista não pode realizar transações", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenInsufficientFunds() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.validateTransaction(commonUser, new BigDecimal("150.00"));
        });

        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    void shouldUpdateBalanceCorrectly() {
        userService.updateBalance(commonUser, merchantUser, new BigDecimal("30.00"));

        assertEquals(new BigDecimal("70.00"), commonUser.getBalance());
        assertEquals(new BigDecimal("80.00"), merchantUser.getBalance());
        
        verify(userRepository).save(commonUser);
        verify(userRepository).save(merchantUser);
    }
}