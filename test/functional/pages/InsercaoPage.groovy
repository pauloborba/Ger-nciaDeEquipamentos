package pages

/**
 * Created by Walber on 20/06/2016.
 */
import geb.Page

class InsercaoPage extends Page{
    static url = "/GerenciaDeEquipamentos/armazem/create"
    static at ={
        title ==~ /Criar Armazem/
    }
}