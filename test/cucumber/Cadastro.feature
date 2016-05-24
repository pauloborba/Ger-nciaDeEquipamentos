Feature: Cadastro, remocao, atualizacao de atributos e listagem de equipamentos
  Como um usuario do sistema
  Eu quero adicionar e remover equipamentos e listar

  Scenario: Novo equipamento
    Given O sistema não tem nenhum equipamento “Monitor”
    When  Eu tento cadastrar o equipamento “Monitor” no sistema
    Then O sistema cadastra “Monitor”

  Scenario:  Listar equipamentos
    Given Eu estou no menu principal
    When Eu seleciono a opcao "listar Equipamentos"
    Then Eu vejo A lista de Equipamentos com status "Defeituoso"
@ignore
  Scenario: Remover equipamento
    Given o sistema possui o equipamento "Impressora 2213/2015"
    When Eu tento remover o equipamento "Impressora 2213/2015"
    Then O equipamento "Impressora 2213/2015" e removido do sistema
@ignore
  Scenario: Mudar status de equipamento
    Given Eu estou na tela com a lista todos os equipamentos cadastrados
    When eu seleciono o equipamento "impressora 2323/2015"
    And Eu preencho a opcao "status" com "Defeituoso"
    Then Eu vejo o "status" de "impressora 2323/2015" ser atualizado para "defeituoso"