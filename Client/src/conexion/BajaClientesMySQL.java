package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class BajaClientesMySQL {
    public BajaClientesMySQL() {
        super();
    }
    
    
    
    private String ultimoMensajeMySQL="";
    
            public String bajaCliente(String dni) {
                //
                String sql = "Delete FROM cliente where dni='" + dni + "';"   ;
                
                try {
                    
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    
                    
                    ultimoMensajeMySQL= nRegBorrados + " registro borrado.";
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }

                return ultimoMensajeMySQL;
            }

    
    
    
}
