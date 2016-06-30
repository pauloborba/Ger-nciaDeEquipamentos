
<%@ page import="gerenciadeequipamentos.Equipamento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'equipamento.label', default: 'Equipamento')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-equipamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-equipamento" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>

			<g:form name="testForm" controller="equipamento" action="buscaEquipamento">
				<g:textField name="input1" value="${input1}"> </g:textField>
				<g:submitButton name="Busca" value="Busca"></g:submitButton>
			</g:form>

			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="status" title="${message(code: 'equipamento.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="localizacao" title="${message(code: 'equipamento.localizacao.label', default: 'Localizacao')}" />
					
						<g:sortableColumn property="nome" title="${message(code: 'equipamento.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="data" title="${message(code: 'equipamento.data.label', default: 'Data')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${equipamentoInstanceList}" status="i" var="equipamentoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${equipamentoInstance.id}">${fieldValue(bean: equipamentoInstance, field: "status")}</g:link></td>
					
						<td>${fieldValue(bean: equipamentoInstance, field: "localizacao")}</td>
					
						<td>${fieldValue(bean: equipamentoInstance, field: "nome")}</td>
					
						<td><g:formatDate date="${equipamentoInstance.data}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${equipamentoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
