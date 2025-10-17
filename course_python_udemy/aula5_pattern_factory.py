# Aula 5 - Design Patterns: Factory
# Personalizado por: Nathan Solano
# Data: 2023

# Author: Nathan Solano

"""
Factory Method - É um padrão de projeto que define uma interface para criar um objeto,
mas deixa as subclasses decidirem qual classe instanciar.
O Factory Method permite adiar a instanciação para as subclasses.
"""

from abc import ABC, abstractmethod


# Produto
class Veiculo(ABC):
    @abstractmethod
    def buscar_cliente(self) -> None: pass


# Produtos concretos
class CarroLuxo(Veiculo):
    def buscar_cliente(self) -> None:
        print('Carro de luxo está buscando o cliente...')


class CarroPopular(Veiculo):
    def buscar_cliente(self) -> None:
        print('Carro popular está buscando o cliente...')


class MotoLuxo(Veiculo):
    def buscar_cliente(self) -> None:
        print('Moto de luxo está buscando o cliente...')


class MotoPopular(Veiculo):
    def buscar_cliente(self) -> None:
        print('Moto popular está buscando o cliente...')


# Criador (Creator)
class VeiculoFactory(ABC):
    def __init__(self, tipo_cliente):
        self.tipo_cliente = tipo_cliente
        self.veiculo = self.get_veiculo()

    @abstractmethod
    def get_veiculo(self) -> Veiculo: pass

    def buscar_cliente(self):
        veiculo = self.get_veiculo()
        veiculo.buscar_cliente()


# Criadores concretos
class CarroFactory(VeiculoFactory):
    def get_veiculo(self) -> Veiculo:
        if self.tipo_cliente == 'luxo':
            return CarroLuxo()
        return CarroPopular()


class MotoFactory(VeiculoFactory):
    def get_veiculo(self) -> Veiculo:
        if self.tipo_cliente == 'luxo':
            return MotoLuxo()
        return MotoPopular()


# Exemplo de uso personalizado
if __name__ == '__main__':
    # Cliente de luxo que precisa de um carro
    cliente_luxo_carro = CarroFactory('luxo')
    cliente_luxo_carro.veiculo.buscar_cliente()
    
    # Cliente normal que precisa de um carro
    cliente_popular_carro = CarroFactory('popular')
    cliente_popular_carro.veiculo.buscar_cliente()
    
    # Cliente de luxo que precisa de uma moto
    cliente_luxo_moto = MotoFactory('luxo')
    cliente_luxo_moto.veiculo.buscar_cliente()
    
    # Cliente normal que precisa de uma moto
    cliente_popular_moto = MotoFactory('popular')
    cliente_popular_moto.veiculo.buscar_cliente()
    
    print('\nExemplo de uso em um sistema de transporte por aplicativo:')
    
    # Simulando um sistema de transporte por aplicativo
    def solicitar_veiculo(tipo_veiculo, categoria_cliente):
        if tipo_veiculo == 'carro':
            factory = CarroFactory(categoria_cliente)
        else:
            factory = MotoFactory(categoria_cliente)
        
        print(f'\nSolicitação: {tipo_veiculo.capitalize()} {categoria_cliente}')
        factory.veiculo.buscar_cliente()
        print(f'Cliente embarcado no {tipo_veiculo} {categoria_cliente}')
    
    # Exemplos de solicitações
    solicitar_veiculo('carro', 'luxo')  # UberBlack
    solicitar_veiculo('carro', 'popular')  # UberX
    solicitar_veiculo('moto', 'popular')  # UberMoto