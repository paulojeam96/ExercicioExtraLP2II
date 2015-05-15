<%-- 
    Document   : Emprestimo
    Created on : 15/05/2015, 10:13:31
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emprestimo</title>
    </head>
    <body>
        
        <fieldset>
            <h2>Criar Emprestimo</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="obra" placeholder="Obra" required/>
                <input type="text" name="usuario" placeholder="Nome do Usuario" required/>
                <input type="hidden" name="command" value="CriarEmprestimo"/>
                <input type="submit" value="Criar Emprestimo"/>
            </form>
        </fieldset>
        
        
        <fieldset>
            <h2>Deletar Emprestimo</h2>
            <form action="FrontController" method="POST">
                <input type="number" name="id" placeholder="Id do Emprestimo" required/>
                <input type="hidden" name="command" value="DeletarEmprestimo"/>
                <input type="submit" value="Deletar Emprestimo"/>
            </form>
        </fieldset>
        
        
    </body>
</html>
