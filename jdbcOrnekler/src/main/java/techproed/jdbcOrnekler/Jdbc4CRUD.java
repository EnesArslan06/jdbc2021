package techproed.jdbcOrnekler;

import java.sql.*;
import java.util.*;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Jdbc4CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root","Ofa302422");
	       
		 Statement st = (Statement) con.createStatement();

		 
		 /*=======================================================================
		  ORNEK1: urunler adinda bir tablo olusturalim id int, 
		  isim VARCHAR(10) fiyat int 
		========================================================================*/ 
		 
		 
		/*st.execute("CREATE TABLE urunler("
		 + "id int,"
		 + "isim VARCHAR(10),"
		 + " fiyat double)");
		System.out.println("Tablo olusturuldu...");*/ 
		 //asagida kodu bir kez daha calistirdigimiz icin buralari calistiktan 
		//sonra yoruma aliyoruz
		
		/*=======================================================================
		  ORNEK2: urunler tablosuna asagidaki kayitlari toplu bir sekilde ekleyelim
		========================================================================*/ 
		// Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir. 
		// PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir. 
		// Bunun icin; 
		// 	1) Veri girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
		// 	2) POJO Class nesnelerini saklayacak bir collection olusturulur
		// 	3) bir dongu ile kayitlar eklenir. 
		
//		List<Urun> kayitlar=new ArrayList<>();
//		
//		//urunler classimiza verilerimjizi bu sekilde ekledik.....
//		kayitlar.add(new Urun(101,"laptop", 6500));
//		kayitlar.add(new Urun(102,"PC", 4500));
//		kayitlar.add(new Urun(103,"Telefon", 4500));
//		kayitlar.add(new Urun(104,"Anakart", 1500));
//		kayitlar.add(new Urun(105,"Klavye", 200));
//		kayitlar.add(new Urun(106,"Fare", 100));
		
		//bu con. olan kisim ile sadece sql ile iritibata gectip oradan alan ayirdik dah gondermedik verileri..
		//con.prepareStatement("INSERT İNTO urunler VALUES(?,?,?)"); //sql baglantimiza korunakli bir alan actık st. yi kullanmiyoruz
									//3 adet veri girisi yapilacak diyoruz ? isareti ile gonderdigimiz yere..
									//3 adet olan 101, "laptop", 6500 diye belirttigimiz sutunlar...
		
		//yukaridaki con. bir isime atiyoruz kullanimini kolaylastirmak icin
//		PreparedStatement veri= con.prepareStatement("INSERT INTO urunler VALUES(?,?,?)");
//		
//		for(Urun each : kayitlar) {
//			
//				//set methodunu kullanmamizin nedeni degisikli yapacagimiz icin yani veri girisi yapacaz.
//			veri.setInt(1,each.getId()); //urun classinda olusturdugumuz get id methodunu getiriyoruz
//			veri.setString(2,each.getIsim());//urun classinda olusturdugumuz get isim methodunu getiriyoruz
//			veri.setDouble(3,each.getFiyat());//urun classinda olusturdugumuz get fiyat methodunu getiriyoruz
//			
//			veri.addBatch();//yukaridakilerin hepsini topla tek veri haline getir
			
		
	
//			veri.executeBatch(); //data base e yolla
//			System.out.println(" urunler tablosu database gonderildi");
			
			/*=======================================================================
			  ORNEK3: urunler tablosundaki PC'nin fiyatini %10 zam yapiniz
			========================================================================*/
			
			
//			int s1=st.executeUpdate("UPDATE urunler SET fiyat=fiyat*1.1 WHERE isim='PC'   ");
//			
//			System.out.println(s1+ " fiyat  guncellendi");
	
	
			/*=======================================================================
			  ORNEK4: urunler tablosuna Marka adinda ve Default degeri ASUS olan yeni 
			  bir sutun ekleyiniz.
			========================================================================*/
	
//		 	st.executeUpdate("ALTER TABLE urunler ADD marka VARCHAR(10) DEFAULT 'ASUS'    ");
//		 
//		 	System.out.println("yeni sutun eklendi");
		 
		 /*=======================================================================
		  ORNEK5: urunler tablosunu siliniz.
		========================================================================*/ 
		 
		 st.executeUpdate("DROP TABLE urunler");
		 System.out.println("tablo silindi...");
		 
		 
		 st.close();
		 con.close();
		 
	}

}
