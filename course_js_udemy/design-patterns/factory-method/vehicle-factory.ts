/**
 * Padrão Factory Method - Implementação da Fábrica
 * Autor: Nathan Solano
 */

import { Vehicle, Car, Motorcycle, Truck } from './vehicle';

// Criador abstrato
export abstract class VehicleFactory {
  // Factory Method
  abstract createVehicle(): Vehicle;

  // Método que usa o produto
  deliverVehicle(): void {
    const vehicle = this.createVehicle();
    console.log(`Entregando um novo ${vehicle.getType()}`);
    vehicle.drive();
  }
}

// Criadores concretos
export class CarFactory extends VehicleFactory {
  createVehicle(): Vehicle {
    return new Car();
  }
}

export class MotorcycleFactory extends VehicleFactory {
  createVehicle(): Vehicle {
    return new Motorcycle();
  }
}

export class TruckFactory extends VehicleFactory {
  createVehicle(): Vehicle {
    return new Truck();
  }
}