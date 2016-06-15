Feature: como um usuario comum do sistema eu posso atualizar todos os dados do objeto equipamentos

  Scenario: update de dados de um dado equipamento
    Given o sistema possui o equipamento "monitor" cadastrado
    When eu tento alterar o status de "monitor" para "defeituoso"
    Then o sistema altera os dados de "monitor" para "defeituoso"
  @ignore
  Scenario: alteracao de dados de equipamento
    Given eu estou no menu "show"
    When eu seleciono a opcao "update"
    And eu preencho os formularios de atualizacao de "status"
    Then eu vejo o "status" ser atualizado
