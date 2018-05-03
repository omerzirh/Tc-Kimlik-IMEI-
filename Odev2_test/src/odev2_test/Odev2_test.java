/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev2_test;

import RASTGELEKISIURET.IMEINo;
import RASTGELEKISIURET.KimlikNo;
import RASTGELEKISIURET.Kisi;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
* @since 05/04/2017
* <p>
*  
* </p>
*/  
public class Odev2_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {

        Kisi kisi = new Kisi();
        KimlikNo tc = new KimlikNo();
        IMEINo imei = new IMEINo();
        Scanner input = new Scanner(System.in);
        int secim  = 0;
        int personNum;
        while(true){
         System.out.println("1- Rastgele Kişi Üret\n"+"2- Üretilmiş Dosya Kontrol Et\n"+"3- Çıkış\n");
         secim = input.nextInt();
         personNum=0;
        if(secim==1){
            System.out.println("İstenilen Kişi Sayısını Giriniz: ");
            personNum = input.nextInt();
            kisi.kisiOlustur(personNum);
            System.out.println("Kişi Oluşturuldu");
        }
        else if(secim==2){
            tc.kontrolEt();
            imei.kontrolEt();
            
        }
        else if(secim == 3){
                        break;
        }
    }       }
    
}
