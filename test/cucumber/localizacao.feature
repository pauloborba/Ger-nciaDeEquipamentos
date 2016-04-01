Feature: Como um usu�rio do sistema, quero gerenciar a localiza��o e o descarte de aparelhos

  Scenario: 1. Equipamento encaminhado
  Given: O equipamento "Modem 2012/5547" esta com status de localiza��o  "Armaz�m"
  And: Estado do aparelho "Funcionando"
  When: "Laborat�rio2" solicita equipamento "Modem 2012/5547"
  And: Equipamento "Modem 2012/5547" � encaminhado para o "Laborat�rio2"
  Then: Status de localiza��o do equipamento "Modem 2012/5547" � alterada para "Laborat�rio2"

  Scenario: 2. Equipamento devolvido ao armaz�m
  Given: O equipamento "Microfone 2013/8432" esta na sala de aula "B-04"
  And: Estado do aparelho "Funcionando"
  When: O equipamento "Microfone 2013/8432" � encaminhado para o "Suporte"
  Then: Status de localiza��o do equipamento "Microfone 2013/8432" � alterado para "Armaz�m"

  Scenario 3. Equipamento necessita de reparo
  Given: O equipamento "Monitor 2011/5233", localizado no "Laborat�rio2",
  And: Estado do aparelho "N�o Funcionando"
  When: � solicitado reparo para o equipamento "Monitor 2011/5233"
  And: Equipamento "Monitor 2011/5233" � encaminhado para o "Suporte"
  Then: Status de localiza��o do equipamento "Laborat�rio2" � alterada para "Suporte"
  
  Scenario: 4. Altera��o de status de localiza��o
  Given: Estou na tela de "Equipamentos"
  When: Busco pelo equipamento "Microfone 2013/8432"
  Then: Eu consigo ver C�digo "Microfone 2013/8432", Status de localiza��o "B-04" e Estado do aparelho "Funcionando" na tela
  And: Eu altero o Status de localiza��o para "Armaz�m"
  
  Scenario: 5. Busca de aparelhos por sala
  Given: Estou na tela de "Equipamentos"
  When: Seleciono a sala "Laborat�rio2"
  Then: Eu consigo ver uma lista com todos os "C�digos" e "Estado do aparelho" que est�o na sala "Laborat�rio2"