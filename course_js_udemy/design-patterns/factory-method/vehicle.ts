/**
 * Padrão Factory Method - Implementação em TypeScript
 * Autor: Nathan Solano
 */

// Interface do produto
export interface Vehicle {
  getType(): string;
  drive(): void;
}

// Implementações concretas do produto
export class Car implements Vehicle {
  getType(): string {
    return 'Car';
  }

  drive(): void {
    console.log('Driving a car at 100 km/h');
  }
}

export class Motorcycle implements Vehicle {
  getType(): string {
    return 'Motorcycle';
  }

  drive(): void {
    console.log('Driving a motorcycle at 120 km/h');
  }
}

export class Truck implements Vehicle {
  getType(): string {
    return 'Truck';
  }

  drive(): void {
    console.log('Driving a truck at 80 km/h');
  }
}