/**
 * Padrão Strategy - Implementação do Contexto
 * Autor: Nathan Solano
 */

import { PaymentStrategy } from './payment-strategy';

// Classe de contexto que usa a estratégia
export class ShoppingCart {
  private items: { name: string; price: number }[] = [];
  private paymentStrategy: PaymentStrategy | null = null;

  addItem(name: string, price: number): void {
    this.items.push({ name, price });
    console.log(`Item adicionado: ${name} - R$ ${price}`);
  }

  getTotal(): number {
    return this.items.reduce((total, item) => total + item.price, 0);
  }

  setPaymentStrategy(paymentStrategy: PaymentStrategy): void {
    this.paymentStrategy = paymentStrategy;
  }

  checkout(): void {
    if (!this.paymentStrategy) {
      console.log('Por favor, defina uma estratégia de pagamento antes de finalizar a compra.');
      return;
    }

    const amount = this.getTotal();
    console.log(`Total da compra: R$ ${amount}`);
    this.paymentStrategy.pay(amount);
    this.items = []; // Limpa o carrinho após o pagamento
  }
}