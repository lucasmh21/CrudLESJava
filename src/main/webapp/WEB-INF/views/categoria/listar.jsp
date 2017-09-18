<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<tags:pageTemplate titulo="Listar categoria">
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Nome</th>
		</tr>
		<c:forEach items="${listaCategoria}" var="categoria">
			<tr>
				<td><a href="${s:mvcUrl('CC#editar').arg(0, categoria.id).build()}">${categoria.id}</a></td>
				<td>${categoria.nome}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${s:mvcUrl('CC#novo').build()}">Nova categoria</a>
</tags:pageTemplate>