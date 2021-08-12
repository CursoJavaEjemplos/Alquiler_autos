package conexion;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EditaClienteMySQL {
    public EditaClienteMySQL() {
        super();
    }
    
    
    private String ultimoMensajeMySQL="";
        public String editarCliente(String dni, String nombre) {
            //UPDATE `mydb`.`cliente` SET `Nombre` = 'juann' WHERE (`DNI` = '20');
            String sql = "UPDATE cliente SET nombre='" + nombre + "' " + "WHERE dni='" + dni + "';";
            try {
                Statement st = Conexion.getConexion().createStatement();
                int nRegBorrados = st.executeUpdate(sql);
                ultimoMensajeMySQL= nRegBorrados + " registro editado.";
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }

            return ultimoMensajeMySQL;
        }
}
