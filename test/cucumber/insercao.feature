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

   Scenario: Preenchimento de Armazem
     Given eu criei o armazem "grad" com apenas um espaco livre
     And eu estou na pagina de listagem de Armazens
     And eu vejo que "grad" está livre
     When eu navego ate a pagina de criacao de equipamentos
     And Eu crio um novo equipamento "monitor" com a localizacao "grad"
     Then eu navego ate a listagem de Armazens
     And Eu vejo que "grad" esta sendo sinalizado como cheio