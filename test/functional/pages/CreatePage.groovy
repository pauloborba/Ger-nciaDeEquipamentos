package pages


import geb.Page
import gerenciadeequipamentos.Equipamento


class CreatePage extends Page{

    static url = "/GerenciaDeEquipamentos/equipamento/create"

    static at = {
        title ==~ /Criar Equipamento/
    }


    def boolean criarEquipamento(String nome){
        $("form").nome = nome
        $("form").status = "Funcionando"
        $("form").localizacao = "G4"
        $("input", name: "create").click()

    }


}



