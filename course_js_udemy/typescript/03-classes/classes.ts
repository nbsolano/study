/**
 * Exemplos de classes em TypeScript
 * Autor: Nathan Solano
 */

// Classe básica
class Pessoa {
  // Propriedades
  nome: string;
  idade: number;

  // Construtor
  constructor(nome: string, idade: number) {
    this.nome = nome;
    this.idade = idade;
  }

  // Métodos
  apresentar(): void {
    console.log(`Olá, meu nome é ${this.nome} e tenho ${this.idade} anos.`);
  }
}

// Instanciando a classe
const pessoa1 = new Pessoa('Nathan', 30);
pessoa1.apresentar();

// Modificadores de acesso
class ContaBancaria {
  private titular: string;
  protected saldo: number;
  readonly numeroConta: string;

  constructor(titular: string, saldo: number, numeroConta: string) {
    this.titular = titular;
    this.saldo = saldo;
    this.numeroConta = numeroConta;
  }

  public depositar(valor: number): void {
    if (valor <= 0) {
      console.log('O valor do depósito deve ser maior que zero.');
      return;
    }

    this.saldo += valor;
    console.log(`Depósito de R$ ${valor} realizado com sucesso.`);
    this.consultarSaldo();
  }

  public sacar(valor: number): void {
    if (valor <= 0) {
      console.log('O valor do saque deve ser maior que zero.');
      return;
    }

    if (valor > this.saldo) {
      console.log('Saldo insuficiente.');
      return;
    }

    this.saldo -= valor;
    console.log(`Saque de R$ ${valor} realizado com sucesso.`);
    this.consultarSaldo();
  }

  public consultarSaldo(): void {
    console.log(`Saldo atual: R$ ${this.saldo}`);
  }

  public getTitular(): string {
    return this.titular;
  }
}

// Herança
class ContaPoupanca extends ContaBancaria {
  private taxaJuros: number;

  constructor(titular: string, saldo: number, numeroConta: string, taxaJuros: number) {
    super(titular, saldo, numeroConta);
    this.taxaJuros = taxaJuros;
  }

  public aplicarJuros(): void {
    const juros = this.saldo * (this.taxaJuros / 100);
    this.depositar(juros);
    console.log(`Juros de R$ ${juros} aplicados com sucesso.`);
  }
}

// Classes abstratas
abstract class Forma {
  abstract calcularArea(): number;

  mostrarArea(): void {
    console.log(`A área é: ${this.calcularArea()}`);
  }
}

class Retangulo extends Forma {
  constructor(private largura: number, private altura: number) {
    super();
  }

  calcularArea(): number {
    return this.largura * this.altura;
  }
}

class Circulo extends Forma {
  constructor(private raio: number) {
    super();
  }

  calcularArea(): number {
    return Math.PI * this.raio ** 2;
  }
}

// Getters e Setters
class Produto {
  private _nome: string;
  private _preco: number;
  private _estoque: number;

  constructor(nome: string, preco: number, estoque: number) {
    this._nome = nome;
    this._preco = preco;
    this._estoque = estoque;
  }

  get nome(): string {
    return this._nome;
  }

  set nome(nome: string) {
    if (nome.trim().length === 0) {
      throw new Error('O nome não pode ser vazio.');
    }
    this._nome = nome;
  }

  get preco(): number {
    return this._preco;
  }

  set preco(preco: number) {
    if (preco <= 0) {
      throw new Error('O preço deve ser maior que zero.');
    }
    this._preco = preco;
  }

  get estoque(): number {
    return this._estoque;
  }

  set estoque(estoque: number) {
    if (estoque < 0) {
      throw new Error('O estoque não pode ser negativo.');
    }
    this._estoque = estoque;
  }

  calcularValorTotal(): number {
    return this._preco * this._estoque;
  }
}

// Usando as classes
console.log('\n--- Conta Bancária ---');
const conta = new ContaBancaria('Nathan Solano', 1000, '12345-6');
conta.depositar(500);
conta.sacar(200);

console.log('\n--- Conta Poupança ---');
const contaPoupanca = new ContaPoupanca('Nathan Solano', 2000, '65432-1', 0.5);
contaPoupanca.consultarSaldo();
contaPoupanca.aplicarJuros();

console.log('\n--- Formas Geométricas ---');
const retangulo = new Retangulo(5, 10);
retangulo.mostrarArea();

const circulo = new Circulo(3);
circulo.mostrarArea();

console.log('\n--- Produto ---');
const produto = new Produto('Notebook', 3500, 10);
console.log(`Produto: ${produto.nome}`);
console.log(`Preço: R$ ${produto.preco}`);
console.log(`Estoque: ${produto.estoque}`);
console.log(`Valor total em estoque: R$ ${produto.calcularValorTotal()}`);

produto.preco = 3200;
console.log(`Novo preço: R$ ${produto.preco}`);
console.log(`Novo valor total em estoque: R$ ${produto.calcularValorTotal()}`);