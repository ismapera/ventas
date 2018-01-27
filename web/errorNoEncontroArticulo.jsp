<%-- 
    Document   : index
    Created on : 26-ene-2018, 23:40:02
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
     <script src="js/jquery-1.4.2.js"></script>
     <script src="js/jquery.validate.js"></script>
        <h1>El Articulo Que Ingresó No Existe</h1>
        <table>
            <tr>
                <td>
                         <form action="indexArticulo.jsp" method="post">
                            <input class="btn btn-primary" type="submit" value="Registrar Articulo" name="registrararticulo">
     
                        </form>
                </td>
                <td>
                         <form action="indexVenta.jsp" method="post">
                            <input class="btn btn-primary" type="submit" value="Registrar Venta" name="registrarventa">
                        </form>
                </td>
            </tr>
        </table>
    </body>
</html>
