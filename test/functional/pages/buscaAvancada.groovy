package pages

import geb.Page

class buscaAvancada extends Page {
    static url = "/GerenciaDeEquipamentos/equipamento/buscaAvancada/"

    static at =  {
        title ==~ /Busca Avançada/
    }

    boolean busca(equipamento) {
        $("form").nome = vaga
        $("input", name: "buscar").click()
    }
}