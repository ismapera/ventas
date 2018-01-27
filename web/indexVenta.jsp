<%-- 
    Document   : index
    Created on : 26-ene-2018, 22:21:45
    Author     : ismael
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ventas.modelo.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page='jquery.jsp'>
  <jsp:param name='title' value='jquery' />
</jsp:include>
     <script>
         $(document).ready(function(){
            // Validacion del formulario de pais
            $("#frminsertarventa").validate({
                rules: {
                    cliente: {
                        required: true,
                        maxlength: 50
                    },
                    codart: {
                        required: true
                    },
                    cantidad: {
                        required: true
                    }
                },
                messages: {
                    cliente: {
                    required: "Debe ingresar Nombre",
                    maxlength: "Debe tener maximo 50 caracteres."
                    },
                    codart: {
                    required: "Debe ingresar Código De Articulo"
                    },
                    cantidad: {
                    required: "Debe ingresar Cantidad"
                    }
                }
             }); 
        });
         
     </script>

     <form action="insertarventa" id="frminsertarventa" method="post">
        <h1>Registrar Venta</h1>
        <div class="form-group">
            <label class="col-lg-2 control-label">Nombre Cliente</label>
            <div class="col-lg-10">
                <input type="text" value="" name="cliente">
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label">Código Articulo</label>
            <div class="col-lg-10">
                <input type="text" value="" name="codart">
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label">Cantidad</label>
            <div class="col-lg-10">
                <input type="text" value="" name="cantidad">
            </div>
        </div>
        <div class="form-group">
            <td colspan="2"><input class="btn btn-primary" type="submit" value="Guardar" name="insertarventa">
            <button type="button" onclick="location.href = 'index.jsp'"class="btn btn-primary" value="Inicio">Inicio</button>
        </div>
    </form>
 </body>
</html>

