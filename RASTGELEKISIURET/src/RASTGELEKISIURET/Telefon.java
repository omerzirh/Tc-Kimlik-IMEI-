/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
* @since 05/04/2017
* <p>
*  //Turkiye de gecerli telefonlar numaralarına uygun olarak telefon numarası ureten metod bulundururan sinif
* </p>
*/  
package RASTGELEKISIURET;

import java.util.Random;


public class Telefon {
    
    Random rand = new Random();  //random sınıfından gerektigi yerlerde kullanılma uzere rand nesnesi olusturuldu
     public String uret(){
        String telNo = "";
        int no_ilk = 0;         //ilk hane 0 olmalı
        int no_iki = 5;         //ikinci hane 5 olmali
        int no_uc = rand.nextInt(3)+3;  //ucuncu hane 3 ile 5 arasinda degerler olmali
        int [] no_diger = new int [8];  //geri kalanlar random oalrak olusuturuldu
        
        telNo = String.valueOf(no_ilk)+String.valueOf(no_iki)+String.valueOf(no_uc);    ///degerler stringe donusturulerek telNo degiskenine atandi
        int i;
        for(i=0;i<8;i++){
            
            no_diger[i]=rand.nextInt(10);          
            telNo += no_diger[i];
        }
        return telNo;       //telNo degeri donduruldu
    }
}
