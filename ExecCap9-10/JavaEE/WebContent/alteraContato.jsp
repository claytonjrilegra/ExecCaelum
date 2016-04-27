<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="ilg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

<title>Altera</title>
</head>
<body>



	<h1>Altera Contatos</h1>
    <hr />
    
    <c:forEach var="contato" items="${contatos}">
    <form action="Altera-Contato" var="contato" items="${contatos}">
      id: <input type="hidden" name="id" value="${contato.id}" />${contato.id} <br/>
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      Data Nascimento: <ilg:campoData id="dataNascimento"/><br />
      
      <input type="submit" value="Gravar" />
    </form>
 	 </c:forEach>   
 

</body>
</html>