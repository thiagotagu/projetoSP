<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro Game :D</title>

<link rel="stylesheet" type="text/css" href="./css/main.css" />
<link rel="stylesheet" href="./jquery/themes/blue/style.css" type="text/css" id="" media="print, projection, screen" />

<script src="./angular/angular.min.js"></script>
<script src="./jquery/jquery-1.11.3.min.js"></script>
<script src="./jquery/jquery.tablesorter.js"></script>
<script src="./jquery/jquery.tablesorter.min.js"></script>
</head>



<body>
	<header id="header">
		<p>Desenvolvido por: Thiago Rodrigues de Morais</p>
	</header>

	<div id="container">

		<main id="center" class="column">
		<article ng-controller="ListaComprasController" id="centroAngular">
			<%@include file="/WEB-INF/jsp/conteudoCentroAngular.jspf"%>
		</article>
		<article id="centroJstl">
			<%@include file="/WEB-INF/jsp/conteudoCentroJstl.jspf"%>
		</article>
		<article id="centroDetalhadoPartida">
			<%@include file="/WEB-INF/jsp/conteudoDetalhadoPartida.jspf"%>
		</article>
		
		</main>

		<nav id="left" class="column">
			<h3>Menu</h3>
			<ul>
				<li><a href="#">Visualizar Angular</a></li>
				<li><a href="#">Visualizar JSP</a></li>
				<li><a href="#">Detalhamento por Partida</a></li>
			</ul>
		</nav>

		<div id="right" class="column">
			<%@include file="/WEB-INF/jsp/conteudoListaTop.jspf"%>
		</div>

	</div>

	<div id="footer-wrapper">
		<footer id="footer">
			<p>Desenvolvido por: Thiago Rodrigues de Morais</p>
		</footer>
	</div>


</body>
<script src="./angular/controller/controllerPartida.js"></script>
<script src="./jquery/main.js"></script>
<script src="./js/main.js"></script>

</html>










