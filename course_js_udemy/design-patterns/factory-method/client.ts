/**
 * Exemplo de uso do padrão Factory Method
 * Autor: Nathan Solano
 */

import { VehicleFactory, CarFactory, MotorcycleFactory, TruckFactory } from './vehicle-factory';

// Função para demonstrar o uso da fábrica
function deliverVehicles(factory: VehicleFactory): void {
  console.log('---- Iniciando entrega ----');
  factory.deliverVehicle();
  console.log('---- Entrega concluída ----\n');
}

// Criando e usando as fábricas concretas
const carFactory = new CarFactory();
deliverVehicles(carFactory);

const motorcycleFactory = new MotorcycleFactory();
deliverVehicles(motorcycleFactory);

const truckFactory = new TruckFactory();
deliverVehicles(truckFactory);