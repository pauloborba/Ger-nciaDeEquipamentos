package pages
import geb.Page
/**
 * Created by Walber on 20/06/2016.
 */

class ShowPage extends Page {
    static url = "/GerenciaDeEquipamentos/armazem/show/1"

    static at =  {
        title ==~ /Ver Armazem/
    }

}