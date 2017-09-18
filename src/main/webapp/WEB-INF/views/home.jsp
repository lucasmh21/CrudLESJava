<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<tags:pageTemplate titulo="Home">
	<a href="${s:mvcUrl('FC#listar').build()}">Fornecedor</a><br>
	<a href="${s:mvcUrl('CC#listar').build()}">Categoria</a>
</tags:pageTemplate>