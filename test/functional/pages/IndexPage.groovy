package pages

import geb.Page
import gerenciadeequipamentos.Equipamento


class IndexPage extends Page {

    static url = "/GerenciaDeEquipamentos/equipamento/index"

    static at = {
        title ==~ /Equipamento Listagem/
    }

    def selectButton(String nome){
        $("form").input1 = nome
        $("input", name: "Busca").click()
    }

    def boolean readFlashMessage() {
        def message = $('.message')

        if (!message) {
            return false
        } else {
            return true
        }
    }



}
