/**
 * Script para gerar arquivos de aula personalizados
 * Autor: Nathan Solano
 */

const fs = require('fs');
const path = require('path');

// Função para criar arquivos de aula JavaScript
function criarArquivoAula(numero, conteudo) {
  const nomeArquivo = `aula${numero}.js`;
  const caminho = path.join(__dirname, nomeArquivo);
  
  // Substituir qualquer menção a "Luiz Otávio Miranda" por "Nathan Solano"
  let conteudoPersonalizado = conteudo
    .replace(/Luiz Otávio Miranda/g, 'Nathan Solano')
    .replace(/Luiz Otávio/g, 'Nathan')
    .replace(/Otávio/g, 'Nathan');
  
  // Adicionar comentário de autoria
  conteudoPersonalizado = `/**
 * Aula ${numero} - Curso JavaScript
 * Autor: Nathan Solano
 */

${conteudoPersonalizado}`;
  
  fs.writeFileSync(caminho, conteudoPersonalizado);
  console.log(`Arquivo ${nomeArquivo} criado com sucesso.`);
}

// Exemplos de conteúdo para as aulas
const conteudos = [
  // Aula 4
  `// Constantes e variáveis
const nome = 'Nathan';
let idade = 30;
console.log(nome, idade);
`,
  
  // Aula 5
  `// Tipos de dados primitivos
const nome = 'Nathan'; // string
const num = 10; // number
const aprovado = true; // boolean
let undef; // undefined
const nulo = null; // null
const simbolo = Symbol('qualquer-simbolo'); // symbol

console.log(typeof nome, nome);
console.log(typeof num, num);
console.log(typeof aprovado, aprovado);
console.log(typeof undef, undef);
console.log(typeof nulo, nulo);
console.log(typeof simbolo, simbolo);
`,
  
  // Aula 6
  `// Operadores aritméticos
const num1 = 5;
const num2 = 10;
console.log(num1 + num2); // Adição
console.log(num1 - num2); // Subtração
console.log(num1 * num2); // Multiplicação
console.log(num1 / num2); // Divisão
console.log(num1 % num2); // Resto da divisão
console.log(num1 ** num2); // Potenciação
`,
  
  // Aula 7
  `// Funções
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
`,
  
  // Aula 8
  `// Arrays
const alunos = ['Nathan', 'Maria', 'João'];
console.log(alunos);
console.log(alunos[0]);
console.log(alunos[2]);

alunos[0] = 'Eduardo';
alunos[3] = 'Luiza';
console.log(alunos);
console.log(alunos.length);

alunos.push('Otávio');
alunos.unshift('Luiza');
console.log(alunos);

const removido = alunos.pop();
console.log(removido);
console.log(alunos);
`,
  
  // Aula 9
  `// Objetos
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
`,
  
  // Aula 10
  `// Valores primitivos e valores por referência
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
`,
];

// Criar arquivos para as aulas 4 a 10
for (let i = 0; i < conteudos.length; i++) {
  criarArquivoAula(i + 4, conteudos[i]);
}

console.log('Todos os arquivos foram criados com sucesso!');