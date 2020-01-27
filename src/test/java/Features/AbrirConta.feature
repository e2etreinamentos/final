#Author: anderson.barbosa@e2etreinamentos.com.br
@tag
Feature: Abertura de conta online
  Eu como usuario quero abrir uma conta

  @tag1
  Scenario: Abertura de conta com dados válidos
    Given que eu acesse o site 
    And acesse abertura de conta
    When informar o nome
    And informar o celular
    And informar o email
    And informar o cpf
    And enviar os dados
    Then eu recebo confirmaçao
    
