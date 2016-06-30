<%@ page import="gerenciadeequipamentos.Armazem" %>



<div class="fieldcontain ${hasErrors(bean: armazemInstance, field: 'areaUtil', 'error')} required">
	<label for="areaUtil">
		<g:message code="armazem.areaUtil.label" default="Area Util" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="areaUtil" type="number" value="${armazemInstance.areaUtil}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: armazemInstance, field: 'lotacao', 'error')} required">
	<label for="lotacao">
		<g:message code="armazem.lotacao.label" default="Lotacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lotacao" type="number" value="${armazemInstance.lotacao}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: armazemInstance, field: 'cheio', 'error')} ">
	<label for="cheio">
		<g:message code="armazem.cheio.label" default="Cheio" />
		
	</label>
	<g:checkBox name="cheio" value="${armazemInstance?.cheio}" />

</div>

<div class="fieldcontain ${hasErrors(bean: armazemInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="armazem.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${armazemInstance?.nome}"/>

</div>

