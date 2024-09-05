<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bus - Página de Cadastro de Cartão</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/user-register.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container ">
		<div class="center col-lg-6 offset-lg-3 col-sm-12">
			<c:if test="${result == 'registered'}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					Cartão salvo com sucesso.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>
			<c:if test="${result == 'notRegistered'}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					Cartão não salvo. Tente novamente.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>
				
			<form action="ControllerServlet" method="post" id="form1">
				
				<c:choose>
					<c:when test="${Card == null}">
						<h1 class="text-center">Novo Cartão</h1>
					</c:when>
					<c:when test="${Card != null}">
						<h1 class="text-center">Edição de Cartão</h1>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${Card == null}">
						<input type="hidden" name="id" value="0">
					</c:when>
					<c:when test="${Card != null}">
						<input type="hidden" name="id" value="${Card.id}">
					</c:when>
				</c:choose>
					
					<div class="mb-2">
					  <label for="NomeTitular">Nome Titular*</label>
					  <input type="text" class="form-control"  
					  	name="NomeTitular" id="NomeTitular" minlength="3" maxlength="50"
					  	required="required">
					  <span id="0"></span>
					</div>
					
					<div class="mb-2">
					  <label for="IdCartao">Nº do Cartão*</label>
					  <input type="text" class="form-control"  
					  	name="IdCartao" id="IdCartao"
					  	maxlength="19"
					  	required="required">
					  <span id="1"></span>
					</div>
					
					<div class="mb-2">
					  <label for="Saldo">Saldo</label>
					  <input type="number" class="form-control"  
					  	name="Saldo" id="Saldo">
					  <span id="2"></span>
					</div>
					
					<div class="mb-2">
						<label for="type">Tipo*</label> 
						<select class="form-select"
							name="Tipo" id="Tipo" required="required">
							<c:choose>
								<c:when test="${Card == null}">
									<option value="" selected>Selecione</option>
								</c:when>
							</c:choose>
							
							<c:choose>
								<c:when test="${Card.type != 'Escolar'}">
									<option value="Escolar">Escolar</option>
								</c:when>
								<c:when test="${Card.type == 'Escolar'}">
									<option value="Escolar" selected>Escolar</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${Card.type != 'Padrao'}">
									<option value="Padrão">Padrão</option>
								</c:when>
								<c:when test="${Card.type == 'Padrao'}">
									<option value="Padrão" selected>Padrão</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${Card.type != 'Empresarial'}">
									<option value="Empresarial">Empresarial</option>
								</c:when>
								<c:when test="${Card.type == 'Empresarial'}">
									<option value="Empresarial" selected>Empresarial</option>
								</c:when>
							</c:choose>
						</select>
					</div>

					<div class="col-12 mb-2">
						<button type="submit" class="btn btn-primary" name="action" value="saveCard">Salvar</button>
					</div>
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="js/card-register.js"></script>
</body>
</html>