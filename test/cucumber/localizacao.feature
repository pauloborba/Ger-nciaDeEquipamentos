Feature: Como um usu�rio do sistema, quero gerenciar a localiza��o e o descarte de aparelhos

  Scenario 1. Equipamento encaminhado
    Given O equipamento "Modem 2012/5547" esta com localizacao  "Armazem"
    And equipamento "Modem 2012/5547" esta com status "Funcionando"
    When "Laboratorio2" solicita equipamento "Modem 2012/5547"
    Then Localizacao do equipamento "Modem 2012/5547" e alterada para "Laboratorio2"
    And Equipamento "Modem 2012/5547" e encaminhado para o "Laboratorio2"

  Scenario: 2. Equipamento devolvido ao armazem
    Given: O equipamento "Microfone 2013/8432" esta na sala de aula "B-04"
    And: Estado do aparelho "Funcionando"
    When: O equipamento "Microfone 2013/8432" e encaminhado para o "Suporte"
    Then: Status de localizacao do equipamento "Microfone 2013/8432" e alterado para "Armazem"

  Scenario 3. Equipamento necessita de reparo
    Given: O equipamento "Monitor 2011/5233", localizado no "Laboratorio2",
    And: Estado do aparelho "Nao Funcionando"
    When: e solicitado reparo para o equipamento "Monitor 2011/5233"
    And: Equipamento "Monitor 2011/5233" e encaminhado para o "Suporte"
    Then: Status de localizacao do equipamento "Laboratorio2" e alterada para "Suporte"

  Scenario: 4. Alteracao de status de localizacao
    Given: Estou na tela de "Equipamentos"
    When: Busco pelo equipamento "Microfone 2013/8432"
    Then: Eu consigo ver Codigo "Microfone 2013/8432", Status de localizacao "B-04" e Estado do aparelho "Funcionando" na tela
    And: Eu altero o Status de localizacao para "Armazem"

  Scenario: 5. Busca de aparelhos por sala
    Given: Estou na tela de "Equipamentos"
    When: Seleciono a sala "Laboratorio2"
    Then: Eu consigo ver uma lista com todos os "Codigos" e "Estado do aparelho" que estao na sala "Laboratorio2"