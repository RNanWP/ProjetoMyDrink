<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mydrinkStyle.css">

<meta charset="ISO-8859-1">
<title>MyDrink</title>
</head>
<body>
	<nav class="mydrinkNav">
		<ul>
			<li><span style="color: yellow">MyDrink</span></li>
			<li><img src="img/bebida-hero-1.png" height="20px"></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="consultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>
	<main class="mydrinkMain">
		<form action="cadastrarProduto" method="post" class="mydrinkForm">
			<div>
				<label><strong>Descrição:</strong></label><input type="text"
					name="descricao">
			</div>
			<div>
				<label><strong>Quantidade:</strong></label><input type="text"
					name="quantidade">
			</div>
			<div>
				<label><strong>Preço:</strong></label><input type="text"
					name="preco">
			</div>

			<label><strong>Disponível On-Line:</strong></label><input
				type="checkbox" name="online">
			<br>
			<div>
				<input id="mydrinkButton" type="submit" name="salvar"
					value="Cadastrar Produto">
			</div>
		
			<div>
			<%
			String mensagem = (String) request.getAttribute("mensagem");
			if (mensagem != null)
				out.print(mensagem);
			%>
			</div>
		</form>
	</main>
</body>
</html>