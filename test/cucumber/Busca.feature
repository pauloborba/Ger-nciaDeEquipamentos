  Feature: Busca de equipamentos cadastrados
  As um usuário do sistema de gestão predial
  I quero visualizar a localizacao e o status de aparelhos
  so that eu possa controlar o tempo de vida e solicitações sobre os equipamentos

    Scenario: Busca avancada
      Given que o sistema possui o equipamento1
      When eu tento buscar equipamentos pelo seu status "funcionando" e localizacao "grad2"
      Then eu recebo uma lista com todos os equipamentos que possuem o Status e a Localizacao selecionada

    Scenario: Exibição de equipamentos pela busca avancada
      Given que estou na tela de busca avancada
      When seleciono os atributos nos campos de nome, status e localizacao
      And solicito a busca
      Then consigo ver a lista com o resultado da busca