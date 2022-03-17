package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc1Query01 {

    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
   
   // 1) ilgili driver i yuklemeliyiz. tv nin fisini tak mesela baska alet calismasin
    //ne calisacagini bilsin
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    
   //2)Baglanti olusturmaliyiz uydu sifrlerini girmeliyiz
    	
    	Connection con=DriverManager.
    	getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "Ofa302422");
    	
   //3)SQL komutlari icin statement nesnesi olustur.-- her kanal icin yer ayarlamak gibi 	
    	
    	 Statement st=con.createStatement();
    	
   //4)SQl ifadeleri yazabilir ve calistirabiliriz... kumanda da 1 e basarim trt 1 gelir	
    	 
   ResultSet veri=st.executeQuery("select isim,maas from personel where id=123456789");	//mysql deki sorguyu yaptik
    
   //5) sonuclari aldik ve isleyecez...
     
     while (veri.next()) {
		System.out.println(veri.getString("isim")+ " "+ veri.getInt("maas"));
		System.out.println("Personel Adi:" + veri.getString(1)+"\nMaas: "+ veri.getInt(2));
		//buda farkli bir yazim turu. getString(1)yazmamizin nedeni yukarida isim, maas olarak gosterdik 
		//onun numaralandirmasi sql tablosundaki degil.
	}
     
    //6) olusturan nesneleri bellekten kaldiralim sorulamalarimiz bitti. o yuzden kapatalim
     con.close();
     st.close();
     veri.close();  // sorgulari objeleri kapattik
     
 }   
}
