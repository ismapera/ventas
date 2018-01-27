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
            $("#frminsertararticulo").validate({
                rules: {
                    nombArt: {
                        required: true,
                        maxlength: 50
                    },
                    precioArt: {
                        required: true
                    }
                },
                messages: {
                    nombArt: {
                    required: "Debe ingresar Nombre",
                    maxlength: "Debe tener maximo 50 caracteres."
                    },
                    precioArt: {
                    required: "Debe ingresar Precio"
                    }
                }
             }); 
        });
         
     </script>

     <form action="insertararticulo" id="frminsertararticulo" method="post">
        <h1>Registrar Articulo</h1>
        
        <div class="form-group">
            <label class="col-lg-2 control-label">Nombre Articulo</label>
            <div class="col-lg-10">
                <input type="text" value="" name="nombArt">
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label">Precio Articulo</label>
            <div class="col-lg-10">
                <input type="text" value="" name="precioArt">
            </div>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Guardar" name="insertararticulo">
            <button type="button" onclick="location.href = 'index.jsp'"class="btn btn-primary" value="Inicio">Inicio</button>
        </div>
    </form>          
   </body>
</html>
