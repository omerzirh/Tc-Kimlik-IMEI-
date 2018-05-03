/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
* @since 05/04/2017
* <p>
* Gecerli Algoritmaya gore TC Kimlik no ureten ve uretilmis olanları kontrol eden metodları iceren sinif
* </p>
*/
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Random;


public class KimlikNo {            
   
    private int gecerli;
    private int gecersiz;       //uye degiskenler atandi
    private int [] ilkDokuz;            
    private String tckn="";
    Random rand = new Random(); //random sınıfından gerektigi yerlerde kullanılma uzere rand nesnesi olusturuldu
    
    
     public String uret(){
           String tcno="";
        ilkDokuz = new int [9];
        
        int i;                  //Tc Kimlik nu icin ilk dokuz rakama rasgele degerler atanıyor
        for(i=0;i<9;i++){
            
            ilkDokuz[i]=rand.nextInt(9)+1;
        }                                           //10. ve 11. rakamlar asagidaki gibi gerekli hesaplamalar yapılarak bulunuyor
        
        int t10 = (((ilkDokuz[0]+ilkDokuz[2]+ilkDokuz[4]+ilkDokuz[6]+ilkDokuz[8])*7)-(ilkDokuz[1]+ilkDokuz[3]+ilkDokuz[5]+ilkDokuz[7]))%10;
        int t11 = (ilkDokuz[1]+ilkDokuz[3]+ilkDokuz[5]+ilkDokuz[7]+ilkDokuz[0]+ilkDokuz[2]+ilkDokuz[4]+ilkDokuz[6]+ilkDokuz[8]+t10)%10;
        
        for(i=0;i<9;i++){                       //dongu once 9 kez dondurulerek her bir stringe donusturulerek tcno degiskenine ataniyor         
           tcno += String.valueOf(ilkDokuz[i]); 
        }
        tcno = tcno+String.valueOf(t10)+String.valueOf(t11);    //son iki rakam ise ayri ayri tcno'ya ataniyor ve deger Donduruluyor.
        return tcno;
    }
       
     public void kontrolEt() throws Exception{
         gecerli = 0;
         gecersiz = 0;                  //gecerli ve gecersiz sayilarini tutan iki tane degiskene 0 degeri ataniyor
        
	try { 
           
            Reader read = new FileReader(new File("Kisiler.txt"));        
            BufferedReader buff = new BufferedReader(read);
            String line;
		
        
        while((line=buff.readLine())!=null){                
            tckn = line.substring(0, line.indexOf(" ")).trim();        //dosya satir satir okunuyor ve ilk bosluga kadar olan kisim bosluksuz olarak cekiliyor
         if (tckn.length() == 11) {                             //eger deger 11 e esitse if bloguna giriliyor
			int tekTop = 0;
			int  ciftTop= 0;        //cift ve tek toplamlarını tutan lokal degiskenler
 
			for (int i = 0; i < 9; i++) {
				int val = Integer.valueOf(tckn.substring(i,i+1)); 
 
				if (i % 2 == 0) {           //her bir sayinin int olarak degeri alınıyor 
					tekTop += val;      //index eger cift ise ve tek ise diye kosullanarak  toplaniyor
				} else {
					ciftTop += val;
				}
			}
                        
                        
			int tenth=Integer.valueOf(tckn.substring(9,10));        //10. ve 11. sayinin degerleri ayrica aliniyor
                        int lastDigit=Integer.valueOf(tckn.substring(10,11));
                        if(tenth ==(tekTop*7 - ciftTop)%10)     //10 sayi dogru ise 11 e geciliyor
                        {
                            if(lastDigit ==(tekTop+ciftTop+tenth)%10 ){ // 11 de dogru ise gecerli bir artiriliyor
                                gecerli++;
                            }
                            else 
                                gecersiz++; //10 dogru 11 yanlis ise gecersiz artiriliyor
                        }
                        else 
                            gecersiz++; //10. yanlis ise gecersiz artiriliyor
 
		}
        else 
            gecersiz++;     //eger uzunluk 11 degilse bir artiriliyor
        }
            System.out.println("TC Kimlik Kontrol");
            System.out.println(gecerli + "    Geçerli");        //gecerli ve gecersiz sayilari yazdiriliyor
            System.out.println(gecersiz + "    Geçersiz");
            
	} catch (FileNotFoundException e) {                     
		throw new Exception("Kisiler Dosyası bulunamadı.");
	}
                                 
	
}
}
