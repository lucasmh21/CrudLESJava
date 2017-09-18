<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<tags:pageTemplate titulo="Nova categoria">
	<form:form commandName="categoria" method="post" action="${s:mvcUrl('CC#criar').build()}">
		<form:label path="nome">Nome</form:label>
		<form:input path="nome"/>
		<input type="submit" value="Salvar"/>
	</form:form>
</tags:pageTemplate>