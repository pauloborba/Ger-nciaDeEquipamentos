Feature: Agendar o descarte de um equipamento
	Como um funcionário da gestão predial
	Eu gostaria de agendar o descarte de equipamentos que estão aramzenados no "cemitério" 

Scenario: Descarte de um equipamento com sucesso
	Given: O sistema possui o "5547/2012" cadastrado
	And: O equipamento "5547/2012" possui status "Pronto para descarte".
	When: Eu tento agendar o descarte do equipamento "5547/2012".
	Then: O status do equipamento "5547/2012" é alterado para "Descartado".
	
Scenario: Descarte de um equipamento sem sucesso
	Given: O sistema possui o "5547/2012" cadastrado
	And: O equipamento "5547/2012" possui o status "Não descartar".
	When: Eu tento agendar o descarte do equipamento "5547/2012".
	Then: O status do equipamento "5547/2012" não é alterado.

Scenario: Menagem de sucesso ao agendar o descarte de um equipamento
	Given: Eu estou na Pagina de Descarte de Equipamentos
	And: Eu vejo o equipamento "5547/2012" listado, com o estado de equipamento "Pronto para descarte"
	When: Eu seleciono o equipamento "5547/2012"
	Then: Uma mensgem de sucesso é exibida
	
Scenario: Menagem de erro ao agendar o descarte de um equipamento
	Given: Eu estou na Pagina de Descarte de Equipamentos
	And: Eu vejo o equipamento "5547/2012" listado, com o estado de equipamento "Não descartar"
	When: Eu seleciono o equipamento "5547/2012"
	Then: Uma mensgem de erro é exibida
