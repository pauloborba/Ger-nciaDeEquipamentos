package steps

import cucumber.api.PendingException
import gerenciadeequipamentos.ArmazemController
import gerenciadeequipamentos.Armazem
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.EquipamentoController
import pages.CreateEquipamentoPage
import pages.InsercaoPage
import pages.ListagemArmazemPage
import pages.ShowEquipamentoPage

/**
 * Created by Walber on 19/06/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def controladorEquipamento = new EquipamentoController();
def controladorArmazem = new ArmazemController();


Given(~/^O sistema possui o armazem "([^"]*)" com lotacao incompleta$/) { String armazem ->
    TestDataAndOperations.createArmazem(armazem,0, 10, controladorArmazem)
    assert !Armazem.findByNome(armazem).cheio
}
And(~/^O sistema nao possui o equipamento "([^"]*)"$/) { String equipamento ->
    assert !Equipamento.findByNome(equipamento)
}
When(~/^Eu tento adicionar o equipamento "([^"]*)" com a localizacao "([^"]*)"$/) { String equipamento, String localizacao ->
    TestDataAndOperations.createEquipamento(equipamento,"status", localizacao, Date.parse("dd-MM-yyyy","06-07-2016"),controladorEquipamento)
}
Then(~/^O sistema Armazena o equipamento "([^"]*)"$/) { String equipamento ->
    assert Equipamento.findByNome(equipamento)
}
And(~/^Atualiza a lotacao do "([^"]*)"$/) { String armazem ->
    assert Armazem.findByNome(armazem).getLotacao() != 0
}
Given(~/^O sistema possui o armazem "([^"]*)" com lotacao completa$/) { String armazem ->
    TestDataAndOperations.createArmazemCheio(armazem,10, 10, controladorArmazem)
    assert Armazem.findByNome(armazem).getCheio()
}
Then(~/^O sistema nao armazena o equipamento "([^"]*)"$/) { String equipamento->
    assert !Equipamento.findByNome(equipamento)
}

//teste de gui :D
Given(~/^eu criei o armazem "([^"]*)" com apenas um espaco livre$/) { String armazem ->
    to InsercaoPage
    at InsercaoPage
    TestDataAndOperations.createArmazem(armazem,0,1,controladorArmazem)

}
And(~/^eu estou na pagina de listagem de Armazens$/) { ->
    to ListagemArmazemPage
    at ListagemArmazemPage
}
And(~/^eu vejo que "([^"]*)" está livre$/) { String armazem ->
    at ListagemArmazemPage
    assert page.armazemTemVaga(armazem)
}
When(~/^eu navego ate a pagina de criacao de equipamentos$/) { ->
    to CreateEquipamentoPage
    at CreateEquipamentoPage
}
And(~/^Eu crio um novo equipamento "([^"]*)" com a localizacao "([^"]*)"$/) { String equipamento, localizacao ->
    at CreateEquipamentoPage
    assert page.criarEquipamento(equipamento, localizacao)

}
Then(~/^eu navego ate a listagem de Armazens$/) { ->
    to ListagemArmazemPage
    at ListagemArmazemPage
}
And(~/^Eu vejo que "([^"]*)" esta sendo sinalizado como cheio$/) { String armazem ->
    at ListagemArmazemPage
    assert page.armazemCheio(armazem)
}