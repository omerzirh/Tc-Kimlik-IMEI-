/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
* @since 05/04/2017
* <p>
*   Rastgele Kişi için rastgele isim üreten ve rastgele bir yaş üreten metodlar bulunan bir sınıf olusturuldu
* </p>
*/  
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class RastgeleKisi {
    private int totalLines; 
    private int randomInt;          
    private String icaocode;        //üye degiskenler atandi
    private int yas;
    int count;
    
    public RastgeleKisi(){
    
        
    
    }
    Random rand = new Random();         //random sınıfından gerektigi yerlerde kullanılma uzere rand nesnesi olusturulduı

    public String isimUret() throws Exception{

  
    File file = new File("random_isimler.txt");     
    BufferedReader br;

    try {
        br = new BufferedReader(new FileReader(file));

        while ((br.readLine()) != null) {               //dosya satır satır okunuyor ve satırlar sayılıyor. İkinci while döngüsünde deger random sayısına esit ise o satır alınarak string olarak donduruluyor.
            totalLines++;                               
        }
        br.close();
        br = new BufferedReader(new FileReader(file));
        randomInt = rand.nextInt(totalLines);
        count=0;
        
        while ( (icaocode = br.readLine()) != null) {               
            if (count == randomInt) {
                br.close();
                return icaocode;
            }
            count++;
        }
         br.close();


    } catch (FileNotFoundException e) {
        
        throw new Exception("Rastgele Kisiler Dosyası Bulunamadı"); //try-catch blogu sayesinde eger hata olursa yakalanıyor burdaki gibi istedigimiz hata mesajı verilerek
                                                                    //kullanıcıya yardımcı olunuyor ve yanlıs islemler yapması onleniyor.
    }

    return "";

} 
    public int yasUret(){
        
            yas=rand.nextInt(100);      //0 ile 100 arasında rastgele yas degeri donduren fonksiyon.
            return yas;
        }
    
   
     
    
      
      
      
      
}
