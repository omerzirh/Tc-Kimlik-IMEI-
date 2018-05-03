/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
* @since 05/04/2017
* <p>
*  olusturdugumuz siniflardan nesneler olusturularak metodlar kullanilarak kisi olusturan metod bulunduran sinif
* </p>
*/  
package RASTGELEKISIURET;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;



public class Kisi {
    
    IMEINo imei = new IMEINo();
    KimlikNo kimlik = new KimlikNo();
    RastgeleKisi kisi = new RastgeleKisi();     //kisi icin gerekli olan siniflardan olusturulan nesneler 
    Telefon tel = new Telefon();
    
    public void kisiOlustur(int index){
         for(int i=0;i<index;i++){  //kullanicin istedigi sayida parametre ile alinan index degeri kadar donduruluyor
           
             try{
                  File dosya = new File("Kisiler.txt");                         
                  FileWriter yazici = new FileWriter(dosya,true);       //dosya olusturuluyor, varsa yazmaya devam ediliyor
                  BufferedWriter yaz = new BufferedWriter(yazici);
                  yaz.write(kimlik.uret()+" "+kisi.isimUret()+" "+kisi.yasUret()+" "+tel.uret()+" "+"("+imei.uret()+")");  //her bir eleman icin fonksiyon kullanilarak dosyaya yaziliyor
                  yaz.newLine();        //her yazimdan sonra yeni satira geciliyor
                  yaz.close();
                  
                 
            }
            catch (Exception e){            //try - catch blogu sayesinde hatalar yakalniyor
                  e.printStackTrace();
            }
         }
      }
   
}
