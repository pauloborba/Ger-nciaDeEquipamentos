You can implement missing steps with the snippets below:
Given(~/^O sistema não tem nenhum equipamento "([^"]*)"$/) { String arg1 ->
	equipamento = Equipamento.findByTitle(arg1)
	assert equipamento == null
}
When(~/^Eu tento cadastrar o equipamento "([^"]*)" no sistema$/) { String arg2 ->
    TestDataAndOperations.createEquipamento(arg2)
}
Then(~/^O sistema cadastra "([^"]*)"$/) { String arg3 ->
    equipamento = Equipamnto.findByTitle(arg3)
	assert TestDataAndOperations.compatibleTo(arg3, equipamento)

article, title)
}


Given(~/^Eu estou no MenuInicial $/) {->
    to LoginPage
	at LoginPage
	page.add("admin","admin")
	at MenuInicial
}	

When(~/^Eu seleciono a opcao "([^"]*)"$/) { String arg4 ->
   at MenuInicial
   page.select(arg4)
}
When(~/^eu seciono a opcao do status "([^"]*)"$/) { String arg5 ->
   at MenuInicial
   page.select(arg5)
}
Then(~/^Eu vejo A lista de Equipamentos com status "([^"]*)"$/) { String arg6 ->
   at MenuInicial
   page.showView(arg6)
}
   
def showView(String arg){
}