/**
 * Exemplo de uso do padrão Strategy
 * Autor: Nathan Solano
 */

import { CreditCardStrategy, PayPalStrategy, BankTransferStrategy } from './payment-strategy';
import { ShoppingCart } from './shopping-cart';

// Criando o carrinho de compras
const cart = new ShoppingCart();

// Adicionando itens ao carrinho
cart.addItem('Notebook', 3500);
cart.addItem('Mouse', 150);
cart.addItem('Teclado', 300);

// Usando a estratégia de cartão de crédito
console.log('\n--- Pagamento com Cartão de Crédito ---');
const creditCardStrategy = new CreditCardStrategy(
  'Nathan Solano',
  '1234567890123456',
  '123',
  '12/2025'
);
cart.setPaymentStrategy(creditCardStrategy);
cart.checkout();

// Criando um novo carrinho
const cart2 = new ShoppingCart();
cart2.addItem('Smartphone', 2500);
cart2.addItem('Fone de ouvido', 200);

// Usando a estratégia de PayPal
console.log('\n--- Pagamento com PayPal ---');
const paypalStrategy = new PayPalStrategy('nathan.solano@example.com', 'senha123');
cart2.setPaymentStrategy(paypalStrategy);
cart2.checkout();

// Criando um novo carrinho
const cart3 = new ShoppingCart();
cart3.addItem('Monitor', 1200);
cart3.addItem('Webcam', 350);

// Usando a estratégia de transferência bancária
console.log('\n--- Pagamento com Transferência Bancária ---');
const bankTransferStrategy = new BankTransferStrategy('Nathan Solano', '12345-6');
cart3.setPaymentStrategy(bankTransferStrategy);
cart3.checkout();