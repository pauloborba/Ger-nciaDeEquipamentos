Feature: Como um usuário do sistema, quero gerenciar a localização e o descarte de aparelhos

  Scenario: 1. Equipamento encaminhado
  Given: O equipamento "Modem 2012/5547" esta com status de localização  "Armazém"
  And: Estado do aparelho "Funcionando"
  When: "Laboratório2" solicita equipamento "Modem 2012/5547"
  And: Equipamento "Modem 2012/5547" é encaminhado para o "Laboratório2"
  Then: Status de localização do equipamento "Modem 2012/5547" é alterada para "Laboratório2"

  Scenario: 2. Equipamento devolvido ao armazém
  Given: O equipamento "Microfone 2013/8432" esta na sala de aula "B-04"
  And: Estado do aparelho "Funcionando"
  When: O equipamento "Microfone 2013/8432" é encaminhado para o "Suporte"
  Then: Status de localização do equipamento "Microfone 2013/8432" é alterado para "Armazém"

  Scenario 3. Equipamento necessita de reparo
  Given: O equipamento "Monitor 2011/5233", localizado no "Laboratório2",
  And: Estado do aparelho "Não Funcionando"
  When: É solicitado reparo para o equipamento "Monitor 2011/5233"
  And: Equipamento "Monitor 2011/5233" é encaminhado para o "Suporte"
  Then: Status de localização do equipamento "Laboratório2" é alterada para "Suporte"
  
  Scenario: 4. Alteração de status de localização
  Given: Estou na tela de "Equipamentos"
  When: Busco pelo equipamento "Microfone 2013/8432"
  Then: Eu consigo ver Código "Microfone 2013/8432", Status de localização "B-04" e Estado do aparelho "Funcionando" na tela
  And: Eu altero o Status de localização para "Armazém"
  
  Scenario: 5. Busca de aparelhos por sala
  Given: Estou na tela de "Equipamentos"
  When: Seleciono a sala "Laboratório2"
  Then: Eu consigo ver uma lista com todos os "Códigos" e "Estado do aparelho" que estão na sala "Laboratório2"