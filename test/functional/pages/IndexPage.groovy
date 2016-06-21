package pages

import geb.Page
import gerenciadeequipamentos.Equipamento


class IndexPage extends Page {

    static url = "/GerenciaDeEquipamentos/equipamento/index"

    static at = {
        title ==~ /Equipamento List/
    }

    def buscar(String nome, String status, String localizacao){
        $("form").nome = nome
        $("form").status = status
        $("form").localizacao = localizacao
        $("input", name: "buscaAvancada").click()
    }

    boolean verify(){
        $("tr", class: "clear").has("a",text: armazem)
    }


}