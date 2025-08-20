/**
 * Exemplos de interfaces em TypeScript
 * Autor: Nathan Solano
 */

// Interface básica
interface Pessoa {
  nome: string;
  idade: number;
  email?: string; // Propriedade opcional
  readonly cpf: string; // Propriedade somente leitura
}

const usuario: Pessoa = {
  nome: 'Nathan',
  idade: 30,
  cpf: '123.456.789-00',
};

// usuario.cpf = '987.654.321-00'; // Erro: não pode atribuir a 'cpf' porque é uma propriedade somente leitura

// Interface com métodos
interface Animal {
  nome: string;
  tipo: string;
  fazerSom(): void;
  correr(velocidade: number): string;
}

const cachorro: Animal = {
  nome: 'Rex',
  tipo: 'Cachorro',
  fazerSom() {
    console.log('Au au!');
  },
  correr(velocidade) {
    return `${this.nome} está correndo a ${velocidade} km/h`;
  },
};

// Interface para indexação
interface Dicionario {
  [chave: string]: string;
}

const cores: Dicionario = {
  vermelho: '#FF0000',
  verde: '#00FF00',
  azul: '#0000FF',
};

// Extensão de interfaces
interface Funcionario extends Pessoa {
  cargo: string;
  salario: number;
  trabalhar(): void;
}

const desenvolvedor: Funcionario = {
  nome: 'Nathan',
  idade: 30,
  cpf: '123.456.789-00',
  cargo: 'Desenvolvedor',
  salario: 5000,
  trabalhar() {
    console.log(`${this.nome} está programando...`);
  },
};

// Interface para classes
interface VeiculoInterface {
  marca: string;
  modelo: string;
  ano: number;
  ligar(): void;
  desligar(): void;
}

class Carro implements VeiculoInterface {
  marca: string;
  modelo: string;
  ano: number;
  private ligado: boolean = false;

  constructor(marca: string, modelo: string, ano: number) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
  }

  ligar(): void {
    this.ligado = true;
    console.log(`O ${this.marca} ${this.modelo} está ligado.`);
  }

  desligar(): void {
    this.ligado = false;
    console.log(`O ${this.marca} ${this.modelo} está desligado.`);
  }

  estaLigado(): boolean {
    return this.ligado;
  }
}

// Usando as interfaces
console.log(usuario);
cachorro.fazerSom();
console.log(cachorro.correr(20));
console.log(cores.vermelho);
desenvolvedor.trabalhar();

const meuCarro = new Carro('Toyota', 'Corolla', 2022);
meuCarro.ligar();
console.log(`O carro está ligado? ${meuCarro.estaLigado() ? 'Sim' : 'Não'}`);
meuCarro.desligar();