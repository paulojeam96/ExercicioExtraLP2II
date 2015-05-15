<%-- 
    Document   : Usuario
    Created on : 15/05/2015, 10:17:39
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        
        <fieldset>
            <h2>Criar Usuario</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome" required/>
                <input type="text" name="email" placeholder="E-Mail" required/>
                <input type="hidden" name="command" value="CriarUsuario"/>
                <input type="submit" value="Criar Usuario"/>
            </form>
        </fieldset>
        
        
        <fieldset>
            <h2>Deletar Usuario</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome" required/>
                <input type="hidden" name="command" value="DeletarUsuario"/>
                <input type="submit" value="Deletar Usuario"/>
            </form>
        </fieldset>
        
        
    </body>
</html>
