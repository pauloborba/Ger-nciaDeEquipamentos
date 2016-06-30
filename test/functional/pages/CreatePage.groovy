package pages


import geb.Page
import gerenciadeequipamentos.Equipamento


class CreatePage extends Page{

    static url = "/GerenciaDeEquipamentos/equipamento/create"

    static at = {
        title ==~ /Criar Equipamento/
    }


    def boolean criarEquipamento(String nome, String status, String localizacao){
        $("form").nome = nome
        $("form").status = "Funcionando"
        $("form").localizacao = "Grad4"
        $("input", name: "create").click()

    }


}