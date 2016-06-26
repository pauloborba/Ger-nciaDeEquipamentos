package steps
//
import gerenciadeequipamentos.EquipamentoController
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
import pages.*

def result = []

Given(~/^que o sistema possui equipamentos cadastrados$/) { ->
    def controlador = new EquipamentoController()

    controlador.params << [nome:"monitor", status:"funcionando", localizacao:"grad2"]
    controlador.save()
    controlador.response.reset()

    controlador.params << [nome:"mouse", status:"defeituoso", localizacao:"grad2"]
    controlador.save()
    controlador.response.reset()

    controlador.params << [nome:"mouse", status:"defeituoso", localizacao:"grad1"]
    controlador.save()
    controlador.response.reset()

    controlador.params << [nome:"monitor", status:"defeituoso", localizacao:"grad2"]
    controlador.save()
    controlador.response.reset()

}
When(~/^eu tento buscar equipamentos pelo seu status "([^"]*)" e localizacao "([^"]*)"$/) { String status, String localizacao ->
    def controlador = new EquipamentoController()
    controlador.params << [nome:"", status:status, localizacao:localizacao]
    result = controlador.buscaAvancada()

}

Then(~/^eu recebo uma lista com todos os equipamentos que possuem o Status e a Localizacao selecionada$/) { ->
    assert !result.isEmpty()
}

Given(~/^que estou na tela de busca avancada$/) {  ->

    to IndexPage
    at IndexPage

}
When(~/^seleciono os atributos nos campos de nome, status, localizacao e solicito a busca$/) { ->
    page.buscar("", "", "grad2")
}

Then(~/^consigo ver a lista com o resultado da busca$/) { ->
   at IndexPage
   //assert page.verify()
}
