package pages

import geb.Page

class ResultadosPage extends Page {
    static url = "/GerenciaDeEquipamentos/equipamento/resultados"

    static at =  {
        title ==~ /Equipamento Listagem/
    }

}
