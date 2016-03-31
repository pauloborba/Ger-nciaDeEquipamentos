Feature: Agendar o descarte de um equipamento
	Como um funcionário da gestão predial
	Eu gostariua de agendar o descarte de equipamentos que estão aramzenados no "cemitério" 

Scenario: Descarte de um equipamento com sucesso
	Given: O sistema possui o "5547/2012" cadastrado
	And: O equipamento "5547/2012" cumpriu o prazo de armazenamento antes de poder ser descartado.
	When: Eu tento agendar o descarte do equipamento "5547/2012".
	Then: O descarte do equipamento é agendado.
	
Scenario: Descarte de um equipamento sem sucesso
	Given: O sistema possui o "5547/2012" cadastrado
	And: O equipamento "5547/2012" cumpriu o prazo de armazenamento antes de poder ser descartado.
	When: Eu tento agendar o descarte do equipamento "5547/2012".
	Then: O descarte do equipamento não é agendado.

Scenario: Menagem de sucesso ao agendar o descarte de um equipamento
	Given: Eu estou na Pagina de Descarte de Equipamentos
	And: Eu vejo o equipamento "5547/2012" listado, com o estado de equipamento "Descartar"
	When: Eu seleciono o equipamento "5547/2012"
	Then: Uma mensgem de sucesso é exibida
	
Scenario: Menagem de erro ao agendar o descarte de um equipamento
	Given: Eu estou na Pagina de Descarte de Equipamentos
	And: Eu vejo o equipamento "5547/2012" listado, com o estado de equipamento "Não Descartar"
	When: Eu seleciono o equipamento "5547/2012"
	Then: Uma mensgem de erro é exibida