<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jakarta.tags.core -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!-- jakarta.tags.functions -->
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>StackOverBus - Página de Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
  <!-- Banner de Notícias -->
  <div class="news-banner">
    <div class="container">
      <span>🚀 Novidades: Novo recurso de segurança adicionado! <a href="#">Saiba mais</a></span>
    </div>
  </div>
	<div class="container">
		<div class="col-lg-4 offset-lg-4 col-sm-12">
			<c:choose>
				<c:when test="${result == 'registered'}">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						Usuário cadastrado com sucesso.
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:when>
				<c:when test="${result == 'loginError'}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						E-mail ou senha inválidos.
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:when>
			</c:choose>
			<form action="ControllerServlet" method="post">

				<div class="col-12">
					<h1 class="text-center">Login</h1>
				</div>


				<div class="input-group mb-3">
					<span class="input-group-text"> <img src="img/envelope.svg"
						alt="E-mail" width="32" height="32">
					</span> <input type="email" name="email" placeholder="E-mail" id="email"
						class="form-control" required="required">
				</div>


				<div class="input-group mb-3">
					<span class="input-group-text"> <img src="img/file-lock.svg"
						alt="Senha" width="32" height="32">
					</span> <input type="password" name="password" placeholder="Senha"
						class="form-control" id="password" required="required">
				</div>


				<div class="col-12 mb-3">
					<button type="submit" class="btn btn-primary" name="action"
						value="login">Login</button>
				</div>

				<div class="col-12 mb-3">
					<a class="btn btn-secondary" href="User-register.jsp">Cadastrar</a>
				</div>

			</form>

		</div>
		
		<!-- Banner Informativo da Empresa -->
<!-- Banner Informativo da Empresa -->
<div class="info-banner">
    <div class="container">
    <!-- Imagem do Banner -->
        <div class="banner-image">
            <img src="Logo1.png" alt="Logo da StackOverBus">
        </div>
        <h2>Sobre a StackOverBus</h2>
        <p>
            A StackOverBus surgiu do sonho de quatro rapazes inovadores: Matheus, Rafael, Raul e Pietro. Com o objetivo de passar no DWS5 () e melhorar suas existências, eles fundaram a StackOverBus para criar uma plataforma que tem como unica e principal função, te ajudar com os terriveis cartões de onibus.
        </p>
        <p>
            Com dedicação e criatividade, a StackOverBus se empenha em fornecer recursos e ferramentas de última geração, apoiando o crescimento e desenvolvimento profissional de seus usuários.
        </p>
        <a href="about-us.jsp" class="btn btn-info">Saiba Mais</a>
    </div>
</div>
	</div>
	
	<!-- Rodapé -->
  <footer class="footer">
    <div class="container">
      <span>&copy; 2024 StackOverBus. Todos os direitos reservados.</span>
    </div>
  </footer>
  
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>