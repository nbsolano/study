/**
 * Exemplos de tipos básicos em TypeScript
 * Autor: Nathan Solano
 */

// Tipos primitivos
const nome: string = 'Nathan';
const idade: number = 30;
const ativo: boolean = true;

// Arrays
const hobbies: string[] = ['Programação', 'Leitura', 'Música'];
const notas: Array<number> = [10, 9.5, 8.7];

// Tupla
const pessoa: [string, number, boolean] = ['Nathan', 30, true];

// Enum
enum Cor {
  Vermelho,
  Verde,
  Azul,
}
const corFavorita: Cor = Cor.Azul;

// Any (evitar usar quando possível)
let valorDinamico: any = 'Isso pode ser qualquer coisa';
valorDinamico = 42;
valorDinamico = true;

// Void
function mostrarMensagem(): void {
  console.log('Esta função não retorna nada');
}

// Null e Undefined
const nulo: null = null;
const indefinido: undefined = undefined;

// Never
function erro(mensagem: string): never {
  throw new Error(mensagem);
}

// Object
const objeto: object = {
  nome: 'Nathan',
  idade: 30,
};

// Type Assertions
const mensagem: any = 'Olá, TypeScript!';
const tamanho: number = (mensagem as string).length;
// Ou usando a sintaxe alternativa
const tamanho2: number = (<string>mensagem).length;

// Union Types
let codigo: string | number = 123;
codigo = 'ABC123';

// Type Aliases
type ID = string | number;
const userId: ID = 'user123';
const productId: ID = 456;

// Literal Types
type Direcao = 'Norte' | 'Sul' | 'Leste' | 'Oeste';
const direcao: Direcao = 'Norte';

// Exibindo os resultados
console.log({ nome, idade, ativo, hobbies, notas, pessoa, corFavorita, valorDinamico });
console.log({ tamanho, tamanho2, codigo, userId, productId, direcao });