/**
 * Aula 9 - Curso JavaScript
 * Autor: Nathan Solano
 */

// Objetos
const pessoa = {
  nome: 'Nathan',
  sobrenome: 'Solano',
  idade: 30,
  endereco: {
    rua: 'Av Brasil',
    numero: 320
  }
};

console.log(pessoa.nome);
console.log(pessoa.sobrenome);
console.log(pessoa.endereco.rua);

const { nome, sobrenome, ...resto } = pessoa;
console.log(nome, sobrenome);
console.log(resto);
