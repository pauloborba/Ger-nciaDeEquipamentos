package gerenciadeequipamentos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArmazemController {

    static allowedMethods = [update: "PUT", delete: "DELETE"]

    def createArmazem(String nome,int areaUtil, int lotacao, boolean cheio) {
        def armazem = new Armazem(nome: nome, areaUtil: areaUtil, lotacao:lotacao, cheio: cheio )
        armazem.properties = params
        armazem.save()

    }

    //metoro para delecao de equipamento
    static def diminuiLotacao(String localizacao){
        Armazem armazem = Armazem.findByNome(localizacao)
        //pega o tamanho de lotacao e decrementa em 1
        armazem.setLotacao(armazem.getLotacao()-1)
        armazem.setCheio(false)
    }

    //metodo para verificar se o deposito dado esta cheio
    static def boolean verificaVagas(String localizacao){
        //se o equipamento existir, entre no laco abaixo
        if(Armazem.findByNome(localizacao)) {
            //o metodo atualizaLotacao alem de adicionar mais 1 a lotacao do deposito, ele tbm conserta
            // os possiveis erros de validacao da entrada :D

            return incrementaLotacao(localizacao)
        }else { //se não entrou no laco, o local nao existe, portanto o sistema agira
            // da mesma forma caso estivesse cheio, nao armazenando o equipamento
            return true
        }
    }
    static def boolean incrementaLotacao(String nome){
        Armazem armazem = Armazem.findByNome(nome)
        //se a area util for menor que a lotacao, sinal que ja esta cheio e o problema vem desde a insercao do armazem
        //eu nao consegui produzir o validator na Domain sem bugar o sistema como na documentacao do grails por isso este passo eh necessario D:
        if(armazem.getAreaUtil()<= armazem.getLotacao()) {
            //resolvemos aqui o erro da insercao e deixamos tudo nos conformes para referencias futuras ao armazem :D
            armazem.setLotacao(armazem.getAreaUtil())
            armazem.setCheio(true)
            return true
        }
        //caso a lotacao seja menor que a area util, simplesmente adicionamos
        else {
            armazem.setLotacao(armazem.getLotacao() + 1)
            verificaLotacao(armazem)
            return false
        }
    }
    static def void verificaLotacao(Armazem armazem){

        //se seta o cheio pra true caso o ultimo equipamento tenha enchido o armazem
        if(armazem.getAreaUtil()== armazem.getLotacao()) {
           armazem.setCheio(true)
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Armazem.list(params), model:[armazemInstanceCount: Armazem.count()]
    }

    def show(Armazem armazemInstance) {
        respond armazemInstance
    }

    def create() {
        respond new Armazem(params)
    }

    @Transactional
    def save() {
        Armazem armazemInstance = new Armazem(params)
        if (!armazemInstance.save(flush: true)) {
            render(view: "create", model: [armazemInstance: armazemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'Armazem.label', default: 'Armazem'), armazemInstance.id])
        redirect(action: "show", id: armazemInstance.id)
        //armazemInstance.save flush:true


    }

    def edit(Armazem armazemInstance) {
        respond armazemInstance
    }

    @Transactional
    def update(Armazem armazemInstance) {
        if (armazemInstance == null) {
            notFound()
            return
        }

        if (armazemInstance.hasErrors()) {
            respond armazemInstance.errors, view:'edit'
            return
        }

        armazemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Armazem.label', default: 'Armazem'), armazemInstance.id])
                redirect armazemInstance
            }
            '*'{ respond armazemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Armazem armazemInstance) {

        if (armazemInstance == null) {
            notFound()
            return
        }

        armazemInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Armazem.label', default: 'Armazem'), armazemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'armazem.label', default: 'Armazem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
