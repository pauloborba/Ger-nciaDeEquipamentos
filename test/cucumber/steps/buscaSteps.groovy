package steps

import cucumber.api.PendingException
import gerenciadeequipamentos.ArmazemController

/**
 * Created by Matheus on 31/05/2016.
 */
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController
import pages.*
import static cucumber.api.groovy.EN.*



def controlador = new EquipamentoController()
def retorno = []
def controladorArmazem = new ArmazemController()

Given(~/^exista cadastrados equipamentos "([^"]*)","([^"]*)" e "([^"]*)"$/) {
    String equipamento1, String equipamento2, String equipamento3 ->
        TestDataAndOperations.createArmazem("g1",0, 10, controladorArmazem)
    TestDataAndOperations.createEquipamento(equipamento1,"funcionando","g1", Date.parse("dd-MM-yyyy","06-07-2016"),controlador)
    TestDataAndOperations.createEquipamento(equipamento2,"funcionando","g1",Date.parse("dd-MM-yyyy","06-07-2016"),controlador)
    TestDataAndOperations.createEquipamento(equipamento3,"funcionando","g1",Date.parse("dd-MM-yyyy","06-07-2016"),controlador)
    TestDataAndOperations.checkIfEquipamentoDoesExists(equipamento1)
    TestDataAndOperations.checkIfEquipamentoDoesExists(equipamento2)
    TestDataAndOperations.checkIfEquipamentoDoesExists(equipamento3)
}

When(~/^solicito uma busca por "([^"]*)"$/) { String nomeCompleto->
   retorno = TestDataAndOperations.EquipamentoBusca(nomeCompleto)

}

Then(~/^o nome "([^"]*)" esta contido na lista$/) { String nomeCompleto ->
    assert retorno.first().nome== nomeCompleto
    //o nome esta contido na lista
}


Given(~/^eu criei os equipamentos "([^"]*)" e "([^"]*)"$/) { String Equipamento1, String Equipamento2 ->
    to CreatePage
    at CreatePage
    page.criarEquipamento(Equipamento1)
    to CreatePage
    at CreatePage
    page.criarEquipamento(Equipamento2)
}

And(~/^eu estou na página de index$/) { ->
 to IndexPage
 at IndexPage
}


When(~/^preencho o campo de busca com o nome "([^"]*)" e seleciono o buscar$/) { String nome ->
    page.selectButton(nome)
}

Then(~/^a página de busca será reedericionada para uma página de resultado$/) { ->
    at ResultadosPage
}


Given(~/^não exista nenhum equipamento cadastrado com nome "([^"]*)"$/) { String equipamento1 ->
    assert Equipamento.findByNome(equipamento1)==null
}
Then(~/^na página de index uma mensagem é exibida$/) { ->
    at IndexPage
    assert page.readFlashMessage()
}
