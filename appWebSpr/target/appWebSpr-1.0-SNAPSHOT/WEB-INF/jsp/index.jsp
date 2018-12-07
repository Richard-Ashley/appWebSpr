<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Programação OO Web I</title>

<link rel="stylesheet" href="recursos/css/bootstrap.min.css">

</head>
<body>
    
    <div class="jumbotron">
        <div class="text-center">
            <h1>Logar no sistema</h1>
        </div>        
    </div>
    
    <div class="container">
        <div class="row">
            <div class="col-3">
                
            </div>
            <div class="col-6">
                
               
	<br />
	<form action="usuarioLogar" method="post">
            <div class="form-group">
                <label for="login">LOGIN:</label>
		<input type="text" name="login" />		
            </div>
		
            <div class="form-group">
                <label for="senha">SENHA:</label>
		<input type="text" name="senha" />
            </div>
		
            <button class="btn btn-primary" type="submit">LOGAR</button>		
	</form>
                
            </div>
            <div class="col-3">
                
            </div>
        </div>                
    </div>
    
    
    
    
	
        
        <c:if test="${not empty retorno}">           
            <div class="alert alert-danger" role="alert">
                <h2>Usuário ou Senha incorretos</h2>
            </div>            
        </c:if>
        
</body>
</html>