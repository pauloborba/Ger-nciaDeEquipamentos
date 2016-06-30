package support

import gerenciadeequipamentos.Equipamento
import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor

import static cucumber.api.groovy.Hooks.*

def bindingUpdater
def scenarioInterceptor

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()
}

After () {
    Equipamento.list().each { equipamento ->
        equipamento.delete(flush:true)
    }
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}