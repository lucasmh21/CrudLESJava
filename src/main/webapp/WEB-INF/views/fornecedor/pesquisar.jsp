<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tags:pageTemplate titulo="Novo Fornecedor">
<form:form commandName="fornecedor" method="post" action="${s:mvcUrl('FC#listarComFiltro').build()}">
	<div>
		<form:label path="nome">Nome:</form:label>
		<form:input path="nome"/>
	</div>
	<div>
		<form:label path="cnpj">CNPJ</form:label>
		<form:input path="cnpj"/>
	</div>
	<div>
		<form:label path="IE">IE</form:label>
		<form:input path="IE"/>
	</div>
	<div>
		<form:label path="endereco.cidade.nome">Nome da cidade</form:label>
		<form:input path="endereco.cidade.nome"/>
	</div>
	<div>
		<form:label path="categoria.id">Categoria</form:label>
		<form:select path="categoria.id">
			<c:forEach items="${listaCategoria}" var="categoria">
				<form:option value="${categoria.id}">${categoria.nome}</form:option>
			</c:forEach>
		</form:select>
	</div>
	<input type="submit" value="Pesquisar"/>
</form:form>
</tags:pageTemplate>