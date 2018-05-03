
/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
* @since 05/04/2017
* <p>
*  Gecerli Algoritmaya gore IMEI numarasi ureten ve uretilmis olani kontrol eden metodlari iceren sinif
* </p>
*/  
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class IMEINo {
    private int gecerli;        //uye degiskenler atandi
    private int gecersiz;
     
    public String uret() {
        int pos;
        int[] str = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int sum = 0;
        int final_digit;
        int t;
        int len_offset;
        int len = 15;
        String imei = "";

        String[] rbi = new String[]{"01", "10", "30", "33", "35", "44", "45", "49", "50", "51", "52", "53", "54", "86", "91", "98", "99"};
        String[] arr = rbi[(int) Math.floor(Math.random() * rbi.length)].split("");
        str[0] = Integer.parseInt(arr[0]);
        str[1] = Integer.parseInt(arr[1]);
        pos = 2;

        while (pos < len - 1) {
            str[pos++] = (int) (Math.floor(Math.random() * 10) % 10);
        }

        len_offset = (len + 1) % 2;
        for (pos = 0; pos < len - 1; pos++) {               //LUHN ALGORITMASI ile 15 haneli string IMEI numara donduren fonksiyon
            if ((pos + len_offset) % 2 != 0) {
                t = str[pos] * 2;
                if (t > 9) {
                    t -= 9;
                }
                sum += t;
            } else {
                sum += str[pos];    
            }
        }

        final_digit = (10 - (sum % 10)) % 10;
        str[len - 1] = final_digit;

        for (int d : str) {
            imei += String.valueOf(d);
        }

        return imei;
}
      public static int digitSum(int number) {
        int sum=0;      
        while(number > 0) {
            sum += number%10;
            number = number/10;
        }
        return sum;
    }
     public void kontrolEt()throws FileNotFoundException, Exception {
        int sum = 0;
        int digitLast;
          gecerli = 0;
          gecersiz = 0;
                    

	try { 
            
             
            Reader read = new FileReader(new File("Kisiler.txt"));
            BufferedReader buff = new BufferedReader(read);     //dosya satir satir okunuyor
            String line;
		String imeiCheckLine;
                String imei;
        while((line=buff.readLine())!=null){
              sum = 0;
            imeiCheckLine = line.substring(line.indexOf("(")+1, line.indexOf(")")-1).trim();   //her satirdaki parantez icindekilerin ilk 14 hanesi aliniyor
            imei = line.substring(line.indexOf("(")+1, line.indexOf(")")).trim(); //parantez icinin tumu aliniyor
            if(imei.length()==15){     //eger 15 e esitse devam kosula giriliyor
        for(int i = 13;i>=0;i=i-1) {
            String s_digit = imeiCheckLine.substring(i,i+1);    //dongu 14 kez donduruluyor 
            int i_digit = Integer.valueOf(s_digit);         //her dondugunde alinan deger ustte olusuturulan fonksiyona gonderilerek algoritmaya gore hesaplamalar yap,liyor
            if(i%2==0) {
                sum = sum + i_digit;                    //indeksler ciftse ve tekse diye kosullaniyor tek olanlar 2 kati ile fonksiyona gonderiliyor
            }else {
                sum = sum + digitSum(i_digit*2);
            }
        }
        sum = sum * 9;                              //en son toplam 9 ile carpilip mod 10 alinarak check digit bulunuyor
        digitLast = sum%10; // Return check digit    
            
        if( digitLast == Integer.valueOf(imei.substring(14))){  //eger check digit aldimiz imei numarasinin son hanesine esit ise gecerli bir artiriliyor
            gecerli++;
        }
        else {              //esit degilse gecersiz degeri bir artiriliyor
            gecersiz++;
            
        
        }
            }
            else{           //eger alinan imei 15 e esit degilse kosula girilmeden gecersiz bir artiriliyor 
                gecersiz++;
                continue;
            }      
        }
        System.out.println("IMEI No Kontrol");
            System.out.println(gecerli + "    Geçerli");        //gecerli ve gecersiz sayilari yazdiriliyor
            System.out.println(gecersiz + "    Geçersiz");}
        
       
        catch (FileNotFoundException e) {
        
        throw new Exception("Kisiler Dosyası Bulunamadı");      //try-catch blogu sayesinde eger hata olursa yakalanıyor burdaki gibi istedigimiz hata mesajı verilerek
                                                                    //kullanıcıya yardımcı olunuyor ve yanlıs islemler yapması onleniyor.
        }
        }
        
}
