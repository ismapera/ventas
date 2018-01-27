<%-- 
    Document   : index
    Created on : 26-ene-2018, 22:21:45
    Author     : ismael
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ventas.modelo.Articulo"%>
<%@page import="ventas.modelo.Venta"%>
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

     <form action="indexConsultarVentaArticulo.jsp" id="frmconsultarventaarticulo" method="post">
        <h1>Consultar Articulo</h1>
        <div class="form-group">
            <label class="col-lg-2 control-label">Código Articulo</label>
            <div class="col-lg-10">
                <input type="text" value="" name="codart" id="codart">
            </div>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Consultar" name="consultarventaarticulo">
            <button type="button" onclick="location.href = 'index.jsp'"class="btn btn-primary" value="Inicio">Inicio</button>
        </div>        
    </form>
        
    <div class="table-responsive">
        <table class="table">
             <thead>
                 <tr>
                     <td>Nro Venta</td>
                     <td>Cliente</td>
                     <td>Cod. Art</td>
                     <td>Precio</td>
                     <td>Cantidad</td>
                     <td>Importe</td>
                 </tr>
                 <% Venta venta = new Venta();
                    List listv = venta.consultarPorArticulo(request.getParameter("codart"));
                    if(listv.size()>0){
                        for (Iterator<Venta> iterator = listv.iterator(); iterator.hasNext();) {
                        Venta next = iterator.next();     
                 %>
                 <tr>
                     <td><%= next.getNroVenta() %></td>
                     <td><%= next.getCliente() %></td>
                     <td><%= next.getArticulo().getCodArt() %></td>
                     <td><%= next.getPrecioVenta() %></td>
                     <td><%= next.getCantidad() %></td>
                     <td><%= next.getImporte() %></td>
                 </tr>
                 <% }
                    }else{ 
                 %>
                 No se encontró resultados
                 <%}%>
             </thead>
         </table>
    </div>
    </body>
</html>
