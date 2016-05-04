<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
</head>
<body>
  
  <script type="text/javascript">
  
  function finalizaAgora(id) {
    $.post("finalizaTarefa", {'id' : id}, function(resposta) {
      $("#tarefa_"+id).html(resposta);
    });
  }
</script>
  
   <script type="text/javascript">
    function removeTarefa(id) {
      $.post("removeTarefa", {'id' : id}, function() {
    	  
    	
        // selecionando o elemento html através da 
        // ID e alterando o HTML dele 
        $("#tarefa_"+id).closest("tr").hide();
      });
    }
  </script>

  <a href="novaTarefa">Criar nova tarefa</a>

  <br /> <br />        

  <table>
  <tr>
    <th>Id</th>
    <th>Descrição</th>
    <th>Finalizado?</th>
    <th>Data de finalização</th>
  </tr>
  
  <c:forEach items="${tarefas}" var="tarefa">
    <tr id="tarefa_${tarefa.id}">
      <td>${tarefa.id}</td>
      
      <td>${tarefa.descricao}</td>
      
      <c:if test="${tarefa.finalizado eq false}">
  		<td id="tarefa_${tarefa.id}">
      <a href="#" onClick="finalizaAgora(${tarefa.id})">
      Finaliza agora!
      </a>
  </td>
</c:if>
      <c:if test="${tarefa.finalizado eq true}">
        <td>Finalizado</td>
      </c:if>
      <td>
        <fmt:formatDate 
          value="${tarefa.dataFinalizacao.time}" 
          pattern="dd/MM/yyyy"/>
      </td>
      <td>
     	 	<a href="removeTarefa?id=${tarefa.id}">Remover</a>
      </td>
      
       <td>
     	 	<a href="#" onClick="removeTarefa(${tarefa.id})" >Excluir</a>
      </td>
      
      <td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
      
    </tr>
  </c:forEach>
  </table>
</body>
</html>