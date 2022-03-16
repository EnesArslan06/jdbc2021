package techproed_deneme.jdbcdeneme;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
   
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "Ofa302422");
    	
    	Statement st=con.createStatement();
    	
    	/*=======================================================================
//		ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
//		  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa 
//		  bile bolum ismi gosterilmelidir.
//		========================================================================*/ 
    	String sorgu1= "SELECT b.bolum_isim, p.isim, p.maas"
				 + " FROM personel p"
				 + " left JOIN bolumler b"
				 + " ON b.bolum_id = p.bolum_id"
				 + " ORDER BY p.maas DESC"
				 + " limit 10";
    			
    			
    			
    			
    	ResultSet sonuc=st.executeQuery(sorgu1);
    	while (sonuc.next()) {
			System.out.println(sonuc.getString(1)+" "+sonuc.getString(2)+" "+sonuc.getInt(3));
		}
    	con.close();
		st.close();
		sonuc.close();
		
    }
    
    
}
