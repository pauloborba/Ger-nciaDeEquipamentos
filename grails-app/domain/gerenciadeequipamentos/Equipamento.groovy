package gerenciadeequipamentos

//-Dgeb.env=chrome test-app

class Equipamento {

    String status
    String localizacao
    String nome

    static constraints = {

        status blank: false
        localizacao blank: false
        nome blank: false

    }





}
