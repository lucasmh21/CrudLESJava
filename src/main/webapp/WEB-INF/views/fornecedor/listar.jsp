<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<tags:pageTemplate titulo="Listar Fornecedores">
	${mensagem}
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>CNPJ</th>
			<th>Data de fundação</th>
			<th>Ativo?</th>
		</tr>	
		<c:forEach items="${listaFornecedor}" var="fornecedor">
			<tr>
				<td><a href="${s:mvcUrl('FC#editar').arg(0, fornecedor.id).build()}">${fornecedor.id}</a></td>
				<td>${fornecedor.nome}</td>
				<td>${fornecedor.cnpj}</td>
				<fmt:formatDate value="${fornecedor.dataFundacao.time}" pattern="dd/MM/yyyy" var="data" />
				<td>${data}</td>
				<td>${fornecedor.ativo}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${s:mvcUrl('FC#novo').build()}">Novo Fornecedor</a>
	<a href="${s:mvcUrl('FC#pesquisar').build()}">Pesquisar Fornecedor</a>
</tags:pageTemplate>