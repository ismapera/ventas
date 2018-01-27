package ventas.modelo;

import java.sql.SQLException;
import java.util.List;
import ventas.utilidades.LeeParametros;

/**
 *
 * @author ismael
 */
public interface IGenerica {
	
	public void insertar(Object o) throws SQLException;
	
	public List consultar(String valor) throws SQLException;
	
	public int eliminar(Object o) throws SQLException;
	
	//public int actualizar(Object o) throws SQLException;
        
        public List consultarTodos();
	
	public LeeParametros parametros = new LeeParametros();

}
