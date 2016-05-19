import gerenciadeequipamentos.Equipamento

/*
*   equipment(String name, String status, String location, boolean forwarding)
*
* */

Given(~'^O equipamento "([^"]*)" esta com localização  "([^"]*)"$') { String name, String location ->
    assert location == findByName(name).location
}

Given(~'^equipamento "([^"]*)" esta com status "([^"]*)"$') { String name, String status ->
    assert findByName(name).status == "Funcionando"
}

When(~'^ Usuário "([^"]*)" solicita equipamento "([^"]*)" para o laboratório "([^"]*)" $') { String user, Equipamento equipment, String location ->
    requestEquipment(user, equipment, location);
}

Then(~'^Localização do equipamento "([^"]*)" é alterada para "([^"]*)"$') { Equipamento equipment, String status ->
    modifyLocation(equipment, status)
}

Then(~'^Equipamento "([^"]*)" tem atributo encaminhamento alterado $') { Equipamento equipment ->
    modifyForwarding(equipment, true)
}


/*
Given(~/^Estou na tela de "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

When(~/^Busco pelo equipamento "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

Then(~/^Eu consigo ver Código "([^"]*)", Status de localização "([^"]*)" e Estado do aparelho "([^"]*)" na tela$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

Then(~/^Eu altero o Status de localização para "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

When(~/^Seleciono a sala "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

Then(~/^Eu consigo ver uma lista com todos os "([^"]*)" e "([^"]*)" que estão na sala "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

*/