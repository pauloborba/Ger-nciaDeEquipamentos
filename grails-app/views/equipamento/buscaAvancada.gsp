<%@ page import="gerenciadeequipamentos.EquipamentoController" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'equipamento.label', default: 'Equipamento')}" />
    <title>Busca Avançada</title>
</head>
<body>
<a href="#list-equipamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        <li><g:link class="buscaAvancada" action="buscaAvancada"><g:message code="Busca Avançada" args="[entityName]" /></g:link></li>
    </ul>
</div>

<form >
    <fieldset class="form">

        Nome: <input type="text" name="nome"><br><br>

        Status:<br>
        <input type="radio" name="status" value="" checked> Nenhum<br>
        <input type="radio" name="status" value="funcionando" checked> Funcionando<br>
        <input type="radio" name="status" value="defeituoso"> Defeituoso<br>
        <input type="radio" name="status" value="expirado"> Expirado<br>
        <input type="radio" name="status" value="descartado"> Descartado<br><br>

        Localização:<br>
        <select name="localizacao">
            <option value=""></option>
            <option value="grad1">Grad1</option>
            <option value="grad2">Grad2</option>
            <option value="grad3">Grad3</option>
            <option value="grad4">Grad4</option>
        </select>

    </fieldset>
    <fieldset class="buttons">
        <input type="submit" value="Buscar">

    </fieldset>
    <fieldset class="form">
        <textarea rows="1" cols="50" name="resultado">

        </textarea>
    </fieldset>

</form>
</body>
</html>