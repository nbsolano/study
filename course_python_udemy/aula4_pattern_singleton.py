# Aula 4 - Design Patterns: Singleton
# Personalizado por: Nathan Solano
# Data: 2023

# Author: Nathan Solano

"""
Singleton - É um padrão de projeto que garante a existência de apenas uma instância de uma classe.
Este padrão é útil quando precisamos ter certeza que existe apenas uma instância de uma classe no sistema.
"""


class Singleton:
    _instance = None

    def __new__(cls, *args, **kwargs):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self, nome=None):
        # O init será chamado todas as vezes
        self.nome = nome


# Exemplo de uso personalizado
if __name__ == "__main__":
    configuracao1 = Singleton('Config App')
    configuracao2 = Singleton('Config Banco de Dados')
    
    # As duas variáveis apontam para o mesmo objeto
    print(configuracao1)
    print(configuracao2)
    
    # A configuração2 sobrescreve o nome da configuração1
    print(configuracao1.nome)  # Vai mostrar 'Config Banco de Dados'
    print(configuracao2.nome)  # Vai mostrar 'Config Banco de Dados'
    
    # Comprovando que são o mesmo objeto
    print(id(configuracao1))
    print(id(configuracao2))
    print(configuracao1 == configuracao2)  # True
    
    # Exemplo prático: configuração do sistema
    configuracao1.host = 'localhost'
    configuracao1.porta = 3306
    configuracao1.usuario = 'nathan'
    
    # Acessando as configurações através da configuracao2
    print(f'Conectando ao banco de dados: {configuracao2.host}:{configuracao2.porta}')
    print(f'Usuário: {configuracao2.usuario}')