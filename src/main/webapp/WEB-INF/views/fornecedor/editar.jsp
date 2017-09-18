<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tags:pageTemplate titulo="Editar Fornecedor">
	<form:form commandName="fornecedor" method="post" action="${s:mvcUrl('FC#alterar').build()}">
	<form:hidden path="id"/>
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
		<form:label path="CI">CI</form:label>
		<form:input path="CI"/>
	</div>
	<div>
		<form:label path="Ativo">Ativo</form:label>
		<form:checkbox path="ativo"/>
	</div>
	<div>
		<form:label path="dataFundacao">Data de fundação</form:label>
		<form:input path="dataFundacao"/>
	</div>
	<div>
		<form:label path="endereco.rua">Rua</form:label>
		<form:input path="endereco.rua"/>
	</div>
	<div>
		<form:label path="endereco.numero">Número</form:label>
		<form:input path="endereco.numero"/>
	</div>
	<div>
		<form:label path="endereco.CEP">CEP</form:label>
		<form:input path="endereco.CEP"/>
	</div>
	<div>
		<form:label path="endereco.obs">Observação</form:label>
		<form:textarea path="endereco.obs"/>
	</div>
	<div>
		<form:label path="endereco.cidade.nome">Nome da cidade</form:label>
		<form:input path="endereco.cidade.nome"/>
	</div>
	<div>
		<form:label path="endereco.cidade.estado.nome">Nome do estado</form:label>
		<form:input path="endereco.cidade.estado.nome"/>
	</div>
	<div>
		<form:label path="endereco.cidade.estado.pais.nome">Nome do Pais</form:label>
		<form:input path="endereco.cidade.estado.pais.nome"/>
	</div>
	<div>
		<form:label path="categoria.id">Categoria</form:label>
		<form:select path="categoria.id">
			<c:forEach items="${listaCategoria}" var="categoria">
				<form:option value="${categoria.id}">${categoria.nome}</form:option>
			</c:forEach>
		</form:select>
	</div>
	<input type="submit" value="Alterar" name="alterar"/>
</form:form>
</tags:pageTemplate>