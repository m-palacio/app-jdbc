/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author 1495567
 */
public class ConfigDB {

    public ConfigDB() {
    }

    public static Connection getConnection(String infoconnexion) throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();
        URL urlFichierProp = ConfigDB.class.getResource(infoconnexion);
        BufferedInputStream bis = null;

        try {

            bis = new BufferedInputStream(urlFichierProp.openStream());
            props.load(bis);
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String identifiant = props.getProperty("identifiant");
            String motdepasse = props.getProperty("motdepasse");
            Class.forName(driver);
            return DriverManager.getConnection(url, identifiant, motdepasse);



        } finally {

            if (bis != null) {
                bis.close();
            }

        }

    }
    
     public static Connection getConnection(String nomFichierProp,
            String identifiant,String motdepasse)throws IOException, ClassNotFoundException,
            SQLException{
         
         Properties props = new Properties();
         URL urlFichierProp = ConfigDB.class.getResource(nomFichierProp);
         BufferedInputStream bis = null;
         
         try{

             bis = new BufferedInputStream(urlFichierProp.openStream());
             props.load(bis);
             String driver = props.getProperty("driver");
             String url = props.getProperty("url");
             Class.forName(driver);
             return DriverManager.getConnection(url,identifiant, motdepasse);

         }finally{
             if(bis!=null){
                 bis.close();
             }
         }

         
         
        
    }
}
