<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link href="css/user-register.css" rel="stylesheet">
	
    <title>StackOverBus - Cadastro</title>
  </head>
  <body>
  	<div class="container">
  		<div class="col-lg-6 offset-lg-3 col-sm-12">
  			<c:if test="${result == 'notRegistered'}">
  				<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  E-mail já cadastrado. Tente novamente.
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
  			</c:if>
  			<form action="ControllerServlet" method="post" id="form1">
  				<h1 class="text-center">Cadastre-se</h1>
  				
  				<div class="mb-2">
				  <label for="CPF">CPF*</label>
				  <input type="int" class="form-control"  
				  	name="CPF" id="CPF" minlenght="11" maxlenght="11"
				  	required="required">
				  <span id="0"></span>
				</div>
				
				<div class="mb-2">
				  <label for="RG">RG*</label>
				  <input type="text" class="form-control"  
				  	name="RG" id="RG" minlenght="9" maxlenght="9"
				  	required="required">
				  <span id="1"></span>
				</div>
  				
  				<div class="mb-2">
				  <label for="Nome">Nome completo*</label>
				  <input type="text" class="form-control"  
				  	name="Nome" id="Nome" minlength="3" maxlength="50"
				  	required="required">
				  <span id="2"></span>
				</div>
				
				<div class="mb-2">
				  <label for="Email">E-mail*</label>
				  <input type="email" class="form-control"  
				  	name="Email" id="Email" required="required">
				  <span id="3"></span>
				</div>
				
				<div class="mb-2">
				  <label for="Senha">Senha*</label>
				  <input type="password" class="form-control"  
				  	name="Senha" id="Senha"
				  	minlength="6" maxlength="12"
				  	 required="required">
				  <span id="4"></span>
				</div>
				
				<div class="mb-2">
				  <label for="confirmPassword">Confirmação de Senha*</label>
				  <input type="password" class="form-control"  
				  	name="confirmPassword" id="confirmPassword"
				  	minlength="6" maxlength="12"
				  	 required="required">
				  <span id="5"></span>
				</div>
				
				<div class="mb-2">
				  <label for="dateOfBirth">Data de Nascimento*</label>
				  <input type="date" class="form-control"  
				  	name="dateOfBirth" id="dateOfBirth"
				  	required="required">
				  <span id="6"></span>
				</div>
				
				<div class="col-12 mb-2">
						<button type="submit" class="btn btn-primary" name="action" value="addUser">Salvar</button>
					</div>
  			</form>
  		</div>
  	</div>
    
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="js/user-register.js"></script>
  </body>
</html>