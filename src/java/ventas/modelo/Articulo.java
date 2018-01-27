package ventas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class Articulo implements IGenerica{


    
    private String codArt;

    private String nombArt;

    private Double precioArt;
    
    private List<Venta> venta;

    @Override
    public void insertar(Object o)  {

        Articulo arti = (Articulo)o;
        PreparedStatement pr=null;
        Connection con = null;
        String sql="Insert into articulo(nombArt,precioArt) values(?,?)";

        try
        {
            parametros.leerpara();
            Class.forName(parametros.getDriverBD());
            con = DriverManager.getConnection(parametros.getUrl(), parametros.getUsuarioBD(), parametros.getContrasenaBD());


            pr=con.prepareStatement(sql);
            pr.setString(1, arti.getNombArt());
            pr.setDouble(2, arti.getPrecioArt());
        
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update articulo set nombart=?, precioart=? where codart=?";
            try
            {
            parametros.leerpara();
            Class.forName(parametros.getDriverBD());
            con = DriverManager.getConnection(parametros.getUrl(), parametros.getUsuarioBD(), parametros.getContrasenaBD());
        
            pr=con.prepareStatement(sql);   
            pr.setString(1, arti.getNombArt());
            pr.setDouble(2, arti.getPrecioArt());
        
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {
            }
        }
    }

    @Override
    public List consultar(String valor) {
        Statement stmt = null;
        Connection con= null;
        ResultSet rs = null;
        List<Articulo> arregloArti = new ArrayList<Articulo>();
        
        try{
        	//Obtiene parametros para la conexion
            parametros.leerpara();
            Class.forName(parametros.getDriverBD());
            con = DriverManager.getConnection(parametros.getUrl(),parametros.getUsuarioBD(),parametros.getContrasenaBD()); 
            stmt = con.createStatement();
            
            //Prepara y ejecuta la consulta
            String queryConsulta = "select * from articulo where codart='"+valor+"'";
            rs= stmt.executeQuery(queryConsulta);

            while(rs.next()){
            	Articulo arti = new Articulo();
            	arti.setCodArt(rs.getString("codart"));
            	arti.setNombArt(rs.getString("nombart"));
            	arti.setPrecioArt(Double.parseDouble(rs.getString("precioart")));
            	
            	arregloArti.add(arti);
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
		
		
	return arregloArti;
    }

    @Override
    public int eliminar(Object o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public String getNombArt() {
        return nombArt;
    }

    public void setNombArt(String nombArt) {
        this.nombArt = nombArt;
    }

    public Double getPrecioArt() {
        return precioArt;
    }

    public void setPrecioArt(Double precioArt) {
        this.precioArt = precioArt;
    }
    
    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }

    @Override
    public List consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
