/**
 * Aula 10 - Curso JavaScript
 * Autor: Nathan Solano
 */

// Valores primitivos e valores por referência
let a = 'A';
let b = a; // Cópia
console.log(a, b);

a = 'Outra coisa';
console.log(a, b);

// Referência (array, object, function)
let c = [1, 2, 3];
let d = c;
console.log(c, d);

c.push(4);
console.log(c, d);

d.pop();
console.log(c, d);
