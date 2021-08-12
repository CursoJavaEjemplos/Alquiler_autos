package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private String ultimoMensajeMySQL = "";
    //Protocolos y Driver
    private String CONTROLADOR = "com.mysql.cj.jdbc.Driver";  //Conector Java
    private String URL_BASEDATOS = "jdbc:mysql://";

    //Objetos Java para la conexión
    
    private static Connection conexion = null; // Conexión al motor MySQL
    
    //SELECT, INSERT, DELETE. UPDATE
    ////private Statement instruccion = null; // SQL, instrucción de consulta
    ////private ResultSet conjuntoResultados = null; // Conjunto de registros, conjunto resultado

    //Datos de la conexión
    private String usuario = "";
    private String clave = "";
    private String nombreDB = "";
    private String servidorIP = "";
    private String puerto = "";

    
    public Conexion(String usuario, String clave, String nombreDB, String servidorIP, String puerto) {
            super();
            this.usuario=usuario;        //mydb
            this.clave=clave;            //***********
            this.nombreDB=nombreDB;      //mydb
            this.servidorIP=servidorIP;  //localhost
            this.puerto=puerto;          //3306
            URL_BASEDATOS = URL_BASEDATOS + servidorIP + ":" + puerto + "/" + nombreDB;   
        }
    
    public String conectar() {
        try {
            
            Class.forName(CONTROLADOR);
            
            conexion = DriverManager.getConnection(URL_BASEDATOS, usuario, clave);
            
            ultimoMensajeMySQL = "Conexión realizada con éxito";
            
        } catch (ClassNotFoundException e) {
            ultimoMensajeMySQL = "Error al cargar el conector: " + e.getMessage();
        } catch (SQLException e) {
            ultimoMensajeMySQL = "Error al hacer la conexión " + e.getMessage();
        } catch (Exception e) {
          ultimoMensajeMySQL = "Error al hacer la conexión " + e.getMessage();      
        }

        return ultimoMensajeMySQL;
    }


    public static Connection getConexion() {
   
        
        return conexion;
    }
    
}
