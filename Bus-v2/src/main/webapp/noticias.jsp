<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.util.List,Bus.model.entities.Card"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/home.css">
<title>StackOverBus - Notícias</title>
 
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/noticias.css">
<title>StackOverBus - Notícias</title>
 
</head>
<body>
	<div class="news-banner">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-2 text-center text-md-left">
					<h5 class="banner-title">Últimas Notícias</h5>
				</div>
				<div class="col-md-10">
					<div class="news-ticker">
						<ul>
							<li><a href="#">Todas as noticias aqui são completamente ficticias...</a></li>
							<li><a href="#">Qualquer semelhança com a realidade é pura coincidencia...</a></li>
							<li><a href="#">E não expressa opiniões ou a realidade desses que fizeram esse sistema...</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="vertical-news-banner">
		<div class="news-item">
			<img src="img/news1.png" alt="Notícia 1" class="news-image">
			<div class="news-content">
				<h5><a href="news1.html">Homem cai no Golpe de Travestis e perde 10 mil reais</a></h5>
				<p>"Fui enganado"... afirma o jovem...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news2.png" alt="Notícia 2" class="news-image">
			<div class="news-content">
				<h5><a href="news2.html">Araraquara tem o pior serviço publico de transporte do mundo, diz estudo</a></h5>
				<p>Pesquisa conduzida pela universidade de Harvard avaliou o serviço publico de transporte de mais de 2 mil cidades em mais de 100 países ao redor do mundo...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news3.jpe" alt="Notícia 3" class="news-image">
			<div class="news-content">
				<h5><a href="news3.html">Cabos de força do Instituto Federal de Araraquara são furtados de novo</a></h5>
				<p>"Não vi nada" Afirma o porteiro... Aulas estão suspensas por tempo indeterminado...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news5.webp" alt="Notícia 4" class="news-image">
			<div class="news-content">
				<h5><a href="news4.html">Chocolate e felicidade andam juntos, diz estudo
				</a></h5>
				<p>Cientistas Descobrem que Comer Chocolate no Café da Manhã Faz com que o Dia Seja 300% Mais Feliz...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news6.webp" alt="Notícia 5" class="news-image">
			<div class="news-content">
				<h5><a href="error.html">Caso do "chupa cu" de Araraquara tem desfecho inesperado
				</a></h5>
				<p>Juninho volta para tentar acertar as contas...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news7.webp" alt="Notícia 6" class="news-image">
			<div class="news-content">
				<h5><a href="error.html">Polystation é o console mais procurado em Araraquara
				</a></h5>
				<p>Diversão Retro a Preços Imbatíveis: Descubra Por Que o Polystation Continua a Ser a Escolha Favorita dos Gamers Econômicos!...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news8.webp" alt="Notícia 7" class="news-image">
			<div class="news-content">
				<h5><a href="error.html">PF descobre o porque de tantas queimadas em Araraquara
				</a></h5>
				<p>Segundo a Policia Federal, a quantidade enorme de "queima-roscas" na cidade pode ser o motivo da quantidade exorbitante de queimadas...</p>
			</div>
		</div>
		<div class="news-item">
			<img src="img/news9.webp" alt="Notícia 8" class="news-image">
			<div class="news-content">
				<h5><a href="error.html">Cristiano Ronaldo é o mais novo reforço do Corinthians para evitar o rebaixamento
				</a></h5>
				<p>Chances de rebaixamento continuam em 157,43%...</p>
			</div>
		</div>
	</div>	
	<div class="ad-section">
		<div class="ad-item">
			<img src="img/propaganda1.png" alt="Assassino de Aluguel">
			<h4>🔪 Contrate um Assassino de Aluguel!</h4>
			<p>Problemas com um vizinho barulhento? Temos a solução definitiva. Descontos especiais para alvos repetidos!</p>
			<a href="#" class="ad-link">Saiba mais</a>
		</div>
		<div class="ad-item">
			<img src="img/propaganda2.jfif" alt="Agiotagem Express">
			<h4>💸 Agiotagem Express</h4>
			<p>Dinheiro rápido, sem burocracia! Só não se esqueça de pagar... ou nós vamos lembrar você.</p>
			<a href="#" class="ad-link">Solicite já!</a>
		</div>
		<div class="ad-item">
			<img src="img/propaganda3.avif" alt="LavaJato Financeiro">
			<h4>🧼 LavaJato Financeiro</h4>
			<p>Dinheiro sujo? Nós o deixamos limpinho em minutos. Garantia de 100% de sigilo (ou seu dinheiro de volta!).</p>
			<a href="#" class="ad-link">Descubra como</a>
		</div>
		<div class="ad-item">
			<img src="img/propaganda4.jpg" alt="Happy Endings Sex Shop">
			<h4>🍑 Happy Endings Sex Shop</h4>
			<p>De brinquedos a fantasias, temos tudo para transformar sua noite em uma aventura. Frete grátis para pedidos discretos.</p>
			<a href="#" class="ad-link">Visite nossa loja</a>
		</div>
	</div>	
</body>
</html>
</body>
</html>