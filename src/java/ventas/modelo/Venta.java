/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ventas.modelo.IGenerica.parametros;

/**
 *
 * @author ismael
 */
public class Venta implements IGenerica{


    
    private String nroVenta;

    private String cliente;

    private Articulo articulo;

    private Double precioVenta;

    private Double cantidad;

    private Double importe;
    

    @Override
    public void insertar(Object o) {
        Venta venta = (Venta)o;
        PreparedStatement pr=null;
        Connection con = null;
        String sql="Insert into venta(cliente,precioventa,cantidad,importe,codart) values(?,?,?,?,?)";

        try
        {
            parametros.leerpara();
            Class.forName(parametros.getDriverBD());
            con = DriverManager.getConnection(parametros.getUrl(), parametros.getUsuarioBD(), parametros.getContrasenaBD());


            pr=con.prepareStatement(sql);
            pr.setString(1, venta.getCliente());
            pr.setDouble(2, venta.getPrecioVenta());
            pr.setDouble(3, venta.getCantidad());
            pr.setDouble(4, venta.getImporte());
            pr.setString(5, venta.getArticulo().getCodArt());
        
            pr.executeUpdate();

        }
        catch(Exception ev)
        {
            try {
                pr.close();
            } catch (SQLException ex) {
                Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public List consultar(String valor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Object o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List consultarPorArticulo(String codArt){
        
        Statement stmt = null;
        Connection con= null;
        ResultSet rs = null;
        List<Venta> listVenta = new ArrayList<Venta>();

        
        try{
        	//Obtiene parametros para la conexion
            parametros.leerpara();
            Class.forName(parametros.getDriverBD());
            con = DriverManager.getConnection(parametros.getUrl(),parametros.getUsuarioBD(),parametros.getContrasenaBD()); 
            stmt = con.createStatement();
            
            //Prepara y ejecuta la consulta
            String queryConsulta = "select * from venta where codart='"+codArt+"'";
            rs= stmt.executeQuery(queryConsulta);

            while(rs.next()){
                Articulo articulo = new Articulo();

            	Venta venta = new Venta();
            	venta.setNroVenta(rs.getString("nroVenta"));
                venta.setCliente(rs.getString("cliente"));
                venta.setPrecioVenta(rs.getDouble("precioVenta"));
                venta.setCantidad(rs.getDouble("cantidad"));
                venta.setImporte(rs.getDouble("importe"));
                venta.setArticulo((Articulo)articulo.consultar(rs.getString("codArt")).get(0));

            	
            	listVenta.add(venta);
            }
            
        }
        catch (Exception ex){
             ex.printStackTrace();
        }finally { 
                    try {
                        stmt.close();
                        con.close();
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
                    }

        }
		
		
	return listVenta;
    }
    
    
    public String getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(String nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
