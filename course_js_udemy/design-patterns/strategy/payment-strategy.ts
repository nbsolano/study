/**
 * Padrão Strategy - Implementação em TypeScript
 * Autor: Nathan Solano
 */

// Interface da estratégia
export interface PaymentStrategy {
  pay(amount: number): void;
}

// Implementações concretas das estratégias
export class CreditCardStrategy implements PaymentStrategy {
  constructor(
    private readonly name: string,
    private readonly cardNumber: string,
    private readonly cvv: string,
    private readonly expirationDate: string
  ) {}

  pay(amount: number): void {
    console.log(`Pagamento de R$ ${amount} realizado com cartão de crédito`);
    console.log(`Nome: ${this.name}`);
    console.log(`Número do cartão: ${this.cardNumber.slice(-4).padStart(this.cardNumber.length, '*')}`);
  }
}

export class PayPalStrategy implements PaymentStrategy {
  constructor(private readonly email: string, private readonly password: string) {}

  pay(amount: number): void {
    console.log(`Pagamento de R$ ${amount} realizado com PayPal`);
    console.log(`Email: ${this.email}`);
  }
}

export class BankTransferStrategy implements PaymentStrategy {
  constructor(private readonly accountName: string, private readonly accountNumber: string) {}

  pay(amount: number): void {
    console.log(`Pagamento de R$ ${amount} realizado com transferência bancária`);
    console.log(`Conta: ${this.accountName}`);
    console.log(`Número da conta: ${this.accountNumber}`);
  }
}