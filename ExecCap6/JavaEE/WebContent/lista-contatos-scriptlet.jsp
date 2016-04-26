<%@page import="java.text.SimpleDateFormat"%>
<%@page import="CDG.Contato"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
      	<td>Nome</td>
      	<td>Email</td>
      	<td>Endereco</td>
      	<td>DataNascimento</td>
      	</tr>
      <%
      ContatoDao dao = new ContatoDao();
      List<Contato> contatos = dao.ListaContato();
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      
      for (Contato contato : contatos ) {
      %>
      	
        <tr>
          <td><%=contato.getNome() %></td> 
          <td><%=contato.getEmail() %></td>
          <td><%=contato.getEndereco() %></td>
          <td><%=sdf.format(contato.getDataNascimento().getTime()) %></td>
        </tr>
      <% } %>
    </table>



</body>
</html>