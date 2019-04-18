<<!-- Redirige vers la page controller dans laquelle il y a le request mapping "/init" -->
<%
	request.getRequestDispatcher("user/init").forward(request, response);
%>