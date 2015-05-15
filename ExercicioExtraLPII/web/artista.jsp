<%-- 
    Document   : artista
    Created on : 15/05/2015, 10:09:19
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artista</title>
    </head>
    <body>
        
        <fieldset>
            <h2>Inserir Artista</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome do Artista" required/>
                <input type="hidden" name="command" value="InserirArtista"/>
                <input type="submit" value="Inserir"/>
            </form> 
        </fieldset>
        
        
        <fieldset>
            <h2>Deletar Artista</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome do Artista" required/>
                <input type="hidden" name="command" value="DeletarArtista"/>
                <input type="submit" value="Deletar"/>
            </form> 
        </fieldset>
    </body>
</html>
