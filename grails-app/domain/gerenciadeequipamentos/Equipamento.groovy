package gerenciadeequipamentos

//-Dgeb.env=chrome test-app

class Equipamento {
    String nome
    String status
    String localizacao

    public Equipamento(String nome, String status, String localizacao){
        this.nome = nome;
        this.status = status;
        this.localizacao = localizacao;
    }

    static constraints = {

        status blank: false
        localizacao blank: false
        nome blank: false

    }

}
