<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TAREFAS</title>
        <link rel="stylesheet" href="recursos/css/bootstrap.min.css">
    </head>
    <body>
        <h1>GERENCIAMENTO DE TAREFAS!</h1>
        <div class="container">
            
            <div class="row">
                <c:choose>
                    <c:when test="${tarefa.id !=null}">
                        <h2>ALTERAR TAREFA</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>ADICIONAR TAREFA</h2>
                    </c:otherwise>
                </c:choose>
            </div>
            
            <div class="row">
                <form action="${contextPath}/tarefas" method="post">
                    <input type="hidden" name="id" 
                           value="${tarefa.id}" />
                    <div class="form-group">
                        <label for="nome">NOME:</label>
                        <input type="text" name="nome"
                               value="${tarefa.nome}"/>		
                    </div>

                    <div class="form-group">
                        <label for="descricao">DESCRIÇÃO:</label>
                            
                        <input type="text" name="descricao"
                               value="${tarefa.descricao}"/>
                        <form:errors path="tarefa.descricao" cssStyle="color:red"/>
                    </div>

                    <button class="btn btn-primary" type="submit">SALVAR</button>		
                </form>
            </div>
            <div class="row">
                <table>
                    <thead>                                                
                        <tr>
                            <th>ID</th>
                            <th>NOME</th>
                            <th>DESCRIÇÃO</th>
                            <th>Ações</th>
                        </tr>                        
                    </thead>
                    <tbody>
                        <c:forEach var="tarefa" items="${tarefas}">
                            <tr>
                                <td>${tarefa.id}</td>
                                <td>${tarefa.nome}</td>
                                <td>${tarefa.descricao}</td>
                                <td>
<a class="btn btn-danger" 
href="${contextPath}/tarefas/tarefasEditar?id=${tarefa.id}" >Alterar</a>
                                    <button>Excluir</button>
                                </td>
                            </tr>                  
                        </c:forEach>


                    </tbody>

                </table>
            </div>
        </div>
    </body>
</html>
