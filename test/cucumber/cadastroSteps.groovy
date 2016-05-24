package steps
import gerenciadeequipamentos.Equipamento
import cucumber.api.PendingException
import gerenciadeequipamentos.EquipamentoController
import steps.TestDataAndOperations



/**
 * Created by Walber on 23/05/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def controlador = new EquipamentoController()

Given(~/^O sistema não tem nenhum equipamento “([^"]*)”$/) { String nome->
    Equipamento equipamento = Equipamento.findByNome(nome)
    assert equipamento == null
}
When(~/^Eu tento cadastrar o equipamento “([^"]*)” no sistema$/) {String nome ->
    TestDataAndOperations.createEquipamento(nome, controlador)
}
Then(~/^O sistema cadastra “([^"]*)”$/) { String nome ->
    assert Equipamento.findByNome(nome) != null
}

Given(~/^Eu estou no menu principal$/) { ->
    at menuPage
    to menuPage
}
When(~/^Eu seleciono a opcao "([^"]*)"$/) { String opcao ->
    at menuPage
    page.selectOption(opcao)
}

Then(~/^Eu vejo A lista de Equipamentos com status "([^"]*)"$/) { String opcao ->
    at menuPage
    page.showView(opcao)

}
