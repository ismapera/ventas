/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.utilidades;

/**
 *
 * @author ismael
 */
import java.util.ResourceBundle;

public class LeeParametros {

	
    //Cargamos las variables estaticas de que vienen de inicio
    private String manejadorBD;
    private String driverBD;
    private String hostBD;
    private String puertoBD;
    private String nombreBD;
    private String usuarioBD;
    private String contrasenaBD;
    private String url;
    
    
    
    public String leerpara() throws Exception{

       String ARCHIVO_CONFIGURACION = "ventas.propiedades.inicio";
       ResourceBundle rb = ResourceBundle.getBundle(ARCHIVO_CONFIGURACION);
       
       try{
           manejadorBD  =rb.getString("manejadorBD");
           driverBD     =rb.getString("driverBD");
           hostBD       =rb.getString("hostBD");
           puertoBD     =rb.getString("puertoBD");
           nombreBD     =rb.getString("nombreBD");
           usuarioBD    =rb.getString("usuarioBD");
           contrasenaBD =rb.getString("contrasenaBD");     
       	   
            url="jdbc:oracle:thin:@" + hostBD + ":" + puertoBD + ":XE";        	   

       }
       catch (Exception e){
    	   throw e;
       }
       return url;
   }
    
    
	public String getContrasenaBD() {
		return contrasenaBD;
	}
	public void setContrasenaBD(String contrasenaBD) {
		this.contrasenaBD = contrasenaBD;
	}
	public String getDriverBD() {
		return driverBD;
	}
	public void setDriverBD(String driverBD) {
		this.driverBD = driverBD;
	}
	public String getHostBD() {
		return hostBD;
	}
	public void setHostBD(String hostBD) {
		this.hostBD = hostBD;
	}
	public String getManejadorBD() {
		return manejadorBD;
	}
	public void setManejadorBD(String manejadorBD) {
		this.manejadorBD = manejadorBD;
	}
	public String getNombreBD() {
		return nombreBD;
	}
	public void setNombreBD(String nombreBD) {
		this.nombreBD = nombreBD;
	}
	public String getPuertoBD() {
		return puertoBD;
	}
	public void setPuertoBD(String puertoBD) {
		this.puertoBD = puertoBD;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsuarioBD() {
		return usuarioBD;
	}
	public void setUsuarioBD(String usuarioBD) {
		this.usuarioBD = usuarioBD;
	}

}
