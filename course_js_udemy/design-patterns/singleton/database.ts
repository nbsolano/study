/**
 * Padrão Singleton - Implementação em TypeScript
 * Autor: Nathan Solano
 */

export class Database {
  private static instance: Database | null = null;
  private users: string[] = [];

  // O construtor é privado para impedir a criação de novas instâncias
  private constructor() {
    // Inicialização do banco de dados
    console.log('Conectando ao banco de dados...');
  }

  // Método para obter a instância única
  public static getInstance(): Database {
    if (Database.instance === null) {
      Database.instance = new Database();
    }

    return Database.instance;
  }

  // Métodos de acesso ao banco de dados
  public addUser(user: string): void {
    this.users.push(user);
  }

  public getUsers(): string[] {
    return this.users;
  }
}