Feature:
As a: funcion�rio no setor administrativo
I want to: buscar equipamentos pelos nomes
So that: posso saber informa��es sobre os equipamentos cadastrados

Scenario 1.Busca nome incompleto
  Given:exista cadastrados �monitor 1�,"monitor 3" e "tv led"
  When: solicito uma busca por �monit�
  Then: na lista de busca o nome �monitor 1 e monitor 3� ser�o adicionado
  and:"tv led" n�o ser� adicionado a lista

Scenario 2. Busca por data mais recente usando nome incompleto
   Given:exista dois equipamentos cadastrados �monitor 2� e �monitor 1�
   and: �monitor 2� cadastrado na data �10/02/12�
   and:�monitor 1� cadastrado na data �12/03/13�
   When: solicito uma busca ordenada por data mais recente por �monitor�
   Then:na lista ser� adicionada "monitor 1" e "monitor 2"

 Scenario 3.Interface listar busca por grupo
     Given:estou na p�gina de �busca�
     and:observo uma lista "monitor 1" e "monitor 2"
     and:visualizo �monitor 1� descrito como "funcionando"
     and: "monitor 2" descrito como "n�o funcionado"
     When:eu seleciono a op��o na categoria �funcionando� na p�gina de busca
     and: requisito o �buscar�
     Then: visualizo uma lista com "monitor 1" na p�gina de "busca"

Scenario 4.Interface Busca retorno ordenado de nomes
   Given: Estou na p�gina de �busca�
   and: Visualizo na p�gina uma lista desordenada �mouse� ,�cpu� e �monitor�
   When: eu marco a op��o �ordenar equipamentos� na p�gina de �busca�
   and: requisito o "buscar"
   Then: uma lista na p�gina de �busca� � exibida na ordem �cpu�,�monitor� e "mouse"

