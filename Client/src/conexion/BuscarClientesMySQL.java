package conexion;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarClientesMySQL {
    public BuscarClientesMySQL() {
        super();
    }
    private String ultimoMensajeMySQL="";
        public String buscarCliente(String queBuscar) {
            
            Statement st = null;
            ResultSet conjuntoResultados = null;
            
            //SELECT * FROM bdalquiler02.clientes;	     
            //SELECT * FROM cliente, correos WHERE cliente.DNI = correos.DNI;
            //SELECT * FROM cliente, correo WHERE cliente.DNI = correo.DNI and Nombre LIKE '%Juan%';
            String SQL01 = "SELECT * FROM cliente, correo WHERE cliente.DNI = correo.DNI;";
            String SQL02 = "SELECT * FROM cliente, correo WHERE cliente.DNI = correo.DNI AND Nombre " +
                "LIKE '%" + queBuscar + "%';";
            String SQL = "";
            if(queBuscar.isEmpty()==true) {
                SQL = SQL01; 
            }else {
                SQL = SQL02;        
            }
         
         //SQL de prueba explicado en clase. Ver el archivo de teoría de conjuntos y 
         //   practicar con cada sentencia SQL 
            
        //   SQL = "SELECT * FROM cliente INNER JOIN correo ON cliente.dni = correo.dni WHERE cliente.dni = '20' LIMIT 0 , 30";
            
            try {
                st = Conexion.getConexion().createStatement(); //Investigar prepareStatement() 
                conjuntoResultados = st.executeQuery(SQL);
                
                ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
                int numeroDeColumnas = metaDatos.getColumnCount();
                ultimoMensajeMySQL = "Columnas recuperadas = " + numeroDeColumnas + "\n";
                
                for ( int i = 1; i <= numeroDeColumnas; i++ ) {
                  ultimoMensajeMySQL = ultimoMensajeMySQL + metaDatos.getColumnName(i) + "\t";
                }    
                ultimoMensajeMySQL = ultimoMensajeMySQL + "\n";
                
                while ( conjuntoResultados.next() ) {
                  for ( int i = 1; i <= numeroDeColumnas; i++ ) {
                    ultimoMensajeMySQL = ultimoMensajeMySQL + conjuntoResultados.getObject( i ) + "\t";
                  }
                  ultimoMensajeMySQL = ultimoMensajeMySQL + "\n";  
                }
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }
            return ultimoMensajeMySQL;
        }
}
