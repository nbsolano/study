/**
 * Exemplo de uso do padrão Singleton
 * Autor: Nathan Solano
 */

import { Database } from './database';

// Obtém a instância única do banco de dados
const db1 = Database.getInstance();
db1.addUser('Nathan');
db1.addUser('Maria');

console.log('Usuários no db1:', db1.getUsers());

// Tenta obter outra instância do banco de dados
const db2 = Database.getInstance();
console.log('Usuários no db2:', db2.getUsers());

// Adiciona um usuário através da segunda referência
db2.addUser('João');

// Verifica que ambas as referências apontam para o mesmo objeto
console.log('Usuários no db1 após adição em db2:', db1.getUsers());
console.log('Usuários no db2:', db2.getUsers());

// Verifica se as instâncias são iguais
console.log('db1 e db2 são a mesma instância:', db1 === db2);