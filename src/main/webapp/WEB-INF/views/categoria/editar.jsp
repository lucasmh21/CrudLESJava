<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<tags:pageTemplate titulo="Editar categoria">
	<form:form commandName="categoria" method="post" action="/categoria/editar/acao">
		<form:hidden path="id"/>
		<form:label path="nome">Nome</form:label>
		<form:input path="nome"/>
		<input type="submit" value="Alterar" name="alterar"/>
		<input type="submit" value="Excluir" name="excluir"/>
	</form:form>
</tags:pageTemplate>