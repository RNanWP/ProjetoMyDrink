<%@page import="com.mydrink.model.Produto"%>
<%@ page import="java.util.List" %>

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
			<li><img src="img/bebida-hero-1.png" height="40px"></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="consultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>
	<main class="mydrinkMain">
		<form action="buscarProduto" method="post" class="mydrinkForm">
			<div>
				<label><strong>Busca pela Descrição: </strong></label><input type="text"
					name="descricao">
			</div>
			<br>
			<div>
				<input id="mydrinkButton" type="submit" name="salvar"
					value="Consultar Produto">
			</div>
		</form>
			<%
			if(request.getAttribute("produtos") != null) {
				List<?> produtos = (List<?>) request.getAttribute("produtos");
				for(int contador = 0; contador <= (produtos.size() -1); contador++) {
					Produto produto = (Produto) produtos.get(contador);
			%>
		<form action="modificarProduto" method="post">
			<div class="mydrinkDivMother">
				<div class="mydrinkDivItem">
					<div class="mydrinkColumn">
						<span style="font-weight: bold">Id</span>
						<span><%out.print(produto.getProduto_id()); %></span>
						<input type="hidden" name="id" value="<%out.print(produto.getProduto_id()); %>">				</div>
					<div class="mydrinkColumn">
						<span style="font-weight: bold">Descrição</span>
						<span><%out.print(produto.getDescricao()); %></span>
					</div>
					<div class="mydrinkColumn">
						<span style="font-weight: bold">Quantidade</span>
						<span><%out.print(produto.getQuantidade()); %></span>
					</div>
					<div class="mydrinkColumn">
						<span style="font-weight: bold">Preço</span>
						<span><%out.print(produto.getPreco()); %></span>
					</div>
					<div class="mydrinkColumn">
						<input id="mydrinkItemButton" type="submit" name="alterar" value="Alterar">
						<input id="mydrinkItemButton" type="submit" name="apagar" value="Apagar">
					</div>
				</div>
			
			</div>
			
			<%
			}
			}
			%>
		
		</form>
	</main>
</body>
</html>