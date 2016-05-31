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
    equipamento = controlador.busca(nome, localizacao, status, lista)
    // TestDataAndOperations.buscarEquipamento(nome, localizacao, status, lista, controlador)

    assert equipamento
}

Then(~/^o equipamento "([^"]*)" de localizacao "([^"]*)" tem a localizacao alterada para "([^"]*)"$/) { String nome, String localizacao, String novaLocalizacao ->
    // Write code here that turns the phrase above into concrete actions
    novaLocalizacao = "grad3"
    equipamento = Equipamento.findByNome(nome)
    TestDataAndOperations.modificarLocalizacao(equipamento, novaLocalizacao, controlador)
    assert Equipamento.findByNome(nome).equals(Equipamento.findByLocalizacao(novaLocalizacao))
}

