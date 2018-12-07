<%-- 
    Document   : paginaRecomendacao
    Created on : Dec 7, 2018, 11:28:44 AM
    Author     : Sylvia Ashley pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    Bom vindo(a) ${usuarioLogado.login}

        <div class="row">
                <table>
                    <thead>                                                
                        <tr>
                            <th>Nome</th>
                            <th>NOta</th>
                        </tr>                        
                    </thead>
                    <tbody>
                        <c:forEach var="recomenda" items="${listaRecomendacao}">
                            <tr>
                                <td>${recomenda.titulo}</td>
                                <td> <button type="button" no-click="pegaItem(recomenda)" class="btn btn-info btn-lg glyphicon glyphicon-ok" data-toggle="modal" data-target="#myModal"> Avaliar</button></td>
                                <td>${tarefa.descricao}</td>
                                <td>
<a class="btn btn-danger" href="${contextPath}/tarefas/tarefasEditar?id=${tarefa.id}" >Alterar</a>
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
