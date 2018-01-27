<%-- 
    Document   : index
    Created on : 26-ene-2018, 23:40:02
    Author     : ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page='jquery.jsp'>
  <jsp:param name='title' value='jquery' />
</jsp:include>
        <h1>Seleccione Una Opción</h1>
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
                <td>
                         <form action="indexConsultarVentaArticulo.jsp" method="post">
                            <input class="btn btn-primary" type="submit" value="Consultar Venta de Art" name="consultarventaarticulo">
                        </form>
                </td>
            </tr>
        </table>
    </body>
</html>
