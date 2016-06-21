package pages


import geb.Page
import gerenciadeequipamentos.Equipamento

class buscaAvancada extends Page {
    static url = "/GerenciaDeEquipamentos/equipamento/buscaAvancada/"

    static at =  {
        title ==~ /Busca Avançada/
    }

    def buscar(String nome, String status, String localizacao){

        $("form").nome = nome
        $("form").status = status
        $("form").localizacao = localizacao
        $("input", name: "buscaAvancada").click()
        //$("input", name: "create").click()
    }

    def resultado(Equipamento resultado){
        $("form").resultado = resultado
    }
}
