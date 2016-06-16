package steps

import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


def controlador = new EquipamentoController()
def equipamento

Given(~/^que o sistema possui o equipamento "([^"]*)" com localizacao "([^"]*)" e com status "([^"]*)"$/) { String nome, String localizacao, String status ->
    // Write code here that turns the phrase above into concrete actions

    TestDataAndOperations.createEquipamento(nome, status, localizacao, controlador)
    assert Equipamento.findByNome(nome).equals(Equipamento.findByStatus(status))
    assert Equipamento.findByNome(nome).equals(Equipamento.findByLocalizacao(localizacao))

}

When(~/^eu tento buscar o equipamento de nome "([^"]*)", localizacao "([^"]*)", status "([^"]*)" e lista "([^"]*)"$/) { String nome, String localizacao, String status, boolean lista ->
    // Write code here that turns the phrase above into concrete actions
    equipamento = TestDataAndOperations.buscarEquipamento(nome, controlador)

    assert equipamento.getLocalizacao().equals(localizacao)
    assert equipamento.getStatus().equals(status)

}

Then(~/^o equipamento "([^"]*)" tem a localizacao alterada para "([^"]*)"$/) { String nome, String novaLocalizacao ->
    // Write code here that turns the phrase above into concrete actions
    equipamento = TestDataAndOperations.buscarEquipamento(nome, controlador)
    TestDataAndOperations.modificarLocalizacao(equipamento, novaLocalizacao, controlador)

    assert Equipamento.findByNome(nome).getLocalizacao().equals(novaLocalizacao)
}

/*Given(~/^eu criei as vagas "([^"]*)" e "([^"]*)"$/) { String vaga1, vaga2 ->
    to CreatePage
    at CreatePage
    page.criarVaga(vaga1)
    at VerPage
    to CreatePage
    at CreatePage
    page.criarVaga(vaga2)
}
*/


Given(~/^eu criei os "([^"]*)" e "([^"]*)"$/) { String equipamento1, String equipamento2 ->
   // to CreatePage
  //  at CreatePage

}

And(~/^que estou na tela de "([^"]*)"$/) { String arg1 ->
  //  to Visualizacao
  //  at Visualizacao
}

When(~/^Seleciono a sala "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions

}
Then(~/^Eu consigo ver uma lista com todos os "([^"]*)" e "([^"]*)" que estao na localizacao "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions

}


