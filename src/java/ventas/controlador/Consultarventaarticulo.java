/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ventas.modelo.Articulo;
import ventas.modelo.Venta;

/**
 *
 * @author fabi
 */
@WebServlet(name = "consultarrventaarticulo", urlPatterns = {"/consultarrventaarticulo"})
public class Consultarventaarticulo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            
            String codart = request.getParameter("codart").toUpperCase();
            response.sendRedirect("indexConsultarVentaArticulo.jsp");
    /*        Articulo arti=new Articulo();      

            List<Articulo> listArt =  arti.consultar(request.getParameter("codart").toUpperCase());
            if(listArt.size()>0){

                Articulo artiAux=listArt.get(0);
                Venta venta = new Venta();
                venta.setCliente(request.getParameter("cliente").toUpperCase());
                venta.setPrecioVenta(artiAux.getPrecioArt());
                venta.setCantidad(Double.parseDouble(request.getParameter("cantidad").toUpperCase()));
                venta.setImporte(artiAux.getPrecioArt()*Double.parseDouble(request.getParameter("cantidad").toUpperCase()));
                venta.setArticulo(artiAux);
                
                venta.insertar(venta);
                
                response.sendRedirect("indexVenta.jsp");
                
            }else{
                    response.sendRedirect("errorNoEncontroArticulo.jsp");
            }   */       
            
            
            
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
