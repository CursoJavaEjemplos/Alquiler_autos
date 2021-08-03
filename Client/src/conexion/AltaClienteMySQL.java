package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class AltaClienteMySQL {
    
    public AltaClienteMySQL() {
        super();
    }
    
    private String ultimoMensajeMySQL="";
    
   public String altaCliente(String dni, String nombre) {
            
            //INSERT INTO table_name (Column1, Column 2....) VALUES (value1, value2, ...);
       
            String sql = "INSERT INTO cliente (DNI, Nombre) VALUES ('" + dni + "', '" + nombre + "');"  ;
            
            Statement st=null;



        try {
               st = Conexion.getConexion().createStatement();
               st.executeUpdate(sql);
               ultimoMensajeMySQL="Registro guardado.";
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }

            return ultimoMensajeMySQL;
        }

    
    
}
