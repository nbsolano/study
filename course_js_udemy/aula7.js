/**
 * Aula 7 - Curso JavaScript
 * Autor: Nathan Solano
 */

// Funções
function saudacao(nome) {
  return 'Bom dia, ' + nome + '!';
}

const resultado = saudacao('Nathan');
console.log(resultado);

// Função anônima
const raizQuadrada = function(n) {
  return n ** 0.5;
};

console.log(raizQuadrada(9));
console.log(raizQuadrada(16));
console.log(raizQuadrada(25));
