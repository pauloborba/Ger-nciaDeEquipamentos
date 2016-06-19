Feature: Como um usuario do sistema eu ao adicionar novos equipamentos eu consigo saber
  se posso ou nao aloca lo para determinado armazem baseando se na sua lotacao

  Scenario: Insercao de novo equipamento em armazem semi completo ou vazio
    Given O sistema possui o armazem "grad" com lotacao incompleta
    And O sistema nao possui o equipamento "monitor"
    When Eu tento adicionar o equipamento "monitor" com a localizacao "grad"
    Then O sistema Armazena o equipamento "monitor"
    And Atualiza a lotacao do "grad"

  Scenario: Insercao de equipamento em armazem cuja lotacao esta completa
    Given O sistema possui o armazem "grad" com lotacao completa
    And O sistema nao possui o equipamento "Monitor"
    When Eu tento adicionar o equipamento "Monitor" com a localizacao "grad"
    Then O sistema nao armazena o equipamento "Monitor"