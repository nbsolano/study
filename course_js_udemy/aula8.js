/**
 * Aula 8 - Curso JavaScript
 * Autor: Nathan Solano
 */

// Arrays
const alunos = ['Nathan', 'Maria', 'João'];
console.log(alunos);
console.log(alunos[0]);
console.log(alunos[2]);

alunos[0] = 'Eduardo';
alunos[3] = 'Luiza';
console.log(alunos);
console.log(alunos.length);

alunos.push('Nathan');
alunos.unshift('Luiza');
console.log(alunos);

const removido = alunos.pop();
console.log(removido);
console.log(alunos);
