  Feature: Gestao de equipamentos
  As um usuário do sistema de gestão predial
  I quero gerenciar a localizacao e o descarte de aparelhos
  so that eu possa controlar o tempo de vida e solicitações sobre os equipamentos

  Scenario: Alteracao de localizacao do equipamento
    Given que o sistema possui o equipamento "monitor" com localizacao "armazem" e com status "funcionando"
    When eu tento buscar o equipamento de nome "monitor", localizacao "armazem", status "funcionando" e lista "false"
    Then o equipamento "monitor" tem a localizacao alterada para "laboratorio"

  Scenario: Exibição de equipamentos por localizacao
    Given eu criei os "equipamento1" e "equipamento2"
    And que estou na tela de "Visualizar Equipamentos"
    When Seleciono a sala "laboratorio"
    Then Eu consigo ver uma lista com todos os "nomes" e "status" que estao na localizacao "laboratorio"

    @ignore
  Scenario: Equipamento encaminhado
    Given O equipamento "Modem 2012/5547" esta com localizacao  "Armazem"
    And equipamento "Modem 2012/5547" esta com status "Funcionando"
    When "Laboratorio2" solicita equipamento "Modem 2012/5547"
    Then Localizacao do equipamento "Modem 2012/5547" e alterada para "Laboratorio2"
    And Equipamento "Modem 2012/5547" e encaminhado para o "Laboratorio2"

    @ignore
  Scenario: Equipamento devolvido ao armazem
    Given O equipamento "Microfone 2013/8432" esta na sala de aula "B-04"
    And Estado do aparelho "Funcionando"
    When O equipamento "Microfone 2013/8432" e encaminhado para o "Suporte"
    Then Status de localizacao do equipamento "Microfone 2013/8432" e alterado para "Armazem"

    @ignore
  Scenario: Equipamento necessita de reparo
    Given O equipamento "Monitor 2011/5233", localizado no "Laboratorio2",
    And Estado do aparelho "Nao Funcionando"
    When e solicitado reparo para o equipamento "Monitor 2011/5233"
    And Equipamento "Monitor 2011/5233" e encaminhado para o "Suporte"
    Then Status de localizacao do equipamento "Laboratorio2" e alterada para "Suporte"

    @ignore
  Scenario: Alteracao de status de localizacao
    Given Estou na tela de "Equipamentos"
    When Busco pelo equipamento "Microfone 2013/8432"
    Then Eu consigo ver Codigo "Microfone 2013/8432", Status de localizacao "B-04" e Estado do aparelho "Funcionando" na tela
    And Eu altero o Status de localizacao para "Armazem"



