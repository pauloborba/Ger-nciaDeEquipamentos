Feature: Cadastro, remocao, atualizacao de atributos e listagem de equipamentos Como um usuario do sistema Eu quero adicionar e remover equipamentos e listar
	Scenario: Novo equipamento
		Given O sistema não tem nenhum equipamento "Monitr"
		When  Eu tento cadastrar o equipamento "Monitr" no sistema
		Then O sistema cadastra "Monitr"


