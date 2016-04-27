<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="ilg" %>

<!DOCTYPE html>
<html>
<head>
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

<title>Insert title here</title>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp" />

	<h1>Adiciona Contatos</h1>
    <hr />
    <form action="addContato">
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      Data Nascimento: <ilg:campoData id="dataNascimento"/><br />
      
      <input type="submit" value="Gravar" />
    </form>
    
  <c:import url="/WEB-INF/jsp/rodape.jsp"/>
  
  
</body>
</html>