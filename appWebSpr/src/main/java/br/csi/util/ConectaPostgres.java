package br.csi.util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author aluno
 */
public class ConectaPostgres {

    
    public static Connection getConexao() throws Exception{
         Class.forName("org.postgresql.Driver");
             // abrir conexao
             String url = "jdbc:postgresql://localhost:5433/poow";
             String user = "postgres";
             String pass = "1234";
             Connection conn = 
                     DriverManager.getConnection(url, user, pass);
            return conn;
    }
    
    
     
    
    
    
    
    
   
    
}
