# Author: Nathan Solano

from django.db import models
from django.utils import timezone
from django.contrib.auth.models import User


class Categoria(models.Model):
    nome = models.CharField(max_length=50)
    
    def __str__(self):
        return self.nome
    
    class Meta:
        verbose_name = 'Categoria'
        verbose_name_plural = 'Categorias'


class Contato(models.Model):
    nome = models.CharField(max_length=150)
    sobrenome = models.CharField(max_length=255, blank=True)
    telefone = models.CharField(max_length=50)
    email = models.EmailField(max_length=254, blank=True)
    data_criacao = models.DateTimeField(default=timezone.now)
    descricao = models.TextField(blank=True)
    categoria = models.ForeignKey(Categoria, on_delete=models.SET_NULL, blank=True, null=True)
    mostrar = models.BooleanField(default=True)
    foto = models.ImageField(blank=True, upload_to='pictures/%Y/%m/')
    usuario = models.ForeignKey(User, on_delete=models.CASCADE)
    # Campo personalizado por Nathan Solano
    favorito = models.BooleanField(default=False)

    def __str__(self):
        return f'{self.nome} {self.sobrenome}'

    class Meta:
        verbose_name = 'Contato'
        verbose_name_plural = 'Contatos'


# Classe personalizada por Nathan Solano
class Grupo(models.Model):
    nome = models.CharField(max_length=100)
    descricao = models.TextField(blank=True)
    contatos = models.ManyToManyField(Contato, blank=True)
    usuario = models.ForeignKey(User, on_delete=models.CASCADE)
    data_criacao = models.DateTimeField(default=timezone.now)
    
    def __str__(self):
        return self.nome
    
    class Meta:
        verbose_name = 'Grupo'
        verbose_name_plural = 'Grupos'