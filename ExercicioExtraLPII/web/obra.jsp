<%-- 
    Document   : obra
    Created on : 15/05/2015, 10:20:46
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obra</title>
    </head>
    <body>

        <fieldset>
            <h2>Inserir Obra</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="titulo" placeholder="Titulo da obra" required/>
                <input type="number" name="id_artista" placeholder="ID do Artista" required/>
                <input type="hidden" name="command" value="InserirObra"/>
                <input type="submit" value="Inserir Artista"/>
            </form>
        </fieldset>
        
        
        <fieldset>
            <h2>Deletar Obra</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="titulo" placeholder="Titulo da obra" required/>
                <input type="hidden" name="command" value="DeletarObra"/>
                <input type="submit" value="Deletar Artista"/>
            </form>
        </fieldset>
        
    </body>
</html>
