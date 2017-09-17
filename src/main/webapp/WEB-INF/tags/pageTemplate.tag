<%@ attribute name="titulo" required="true" %>
<!DOCTYPE>
<html>
<head>
<title>${titulo} - LES</title>
</head>
<body>
	<%@ tag language="java" pageEncoding="UTF-8"%>	
	<%@include file="/WEB-INF/views/cabecalho.jsp" %>
	<jsp:doBody/>
	<%@include file="/WEB-INF/views/rodape.jsp" %>		
</body>
</html>