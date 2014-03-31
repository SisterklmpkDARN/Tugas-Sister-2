/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclientcuaca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.CuacaInterfaces;
/**
 *
 * @author hades
 */
public class RmiClientCuaca {

    /**
     * @param args the command line arguments
     */
      static String inputan;
    static int pil=0;

    static String inputan(){
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        try{
            inputan = dataIn.readLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return inputan;
    }
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        // TODO code application logic here
     
         String respond="";
         String url="";
         CuacaInterfaces cInterface = (CuacaInterfaces) Naming.lookup("rmi://localhost:1099/rmi");
         System.out.println("Client berhasil terkoneksi");
          do{
     System.out.println("<<<Menu>>");
     System.out.println("1. Cek cuaca Dunia");
     System.out.println("2. Cek cuaca Indonesia");
     System.out.println("3. Cek cuaca Jabodetabek");
     System.out.println("4. Cek cuaca Harian");
     System.out.println("5. Cek cuaca Wisata");
     System.out.println("6. Exit");
     System.out.print("Masukan pilihan anda: ");
     String pilihan = inputan();
      pil = Integer.parseInt(pilihan);
    
     switch(pil){
         case 1: url="http://data.bmkg.go.id/cuaca_dunia_1.xml";
                 respond = cInterface.cekCuacaDunia(url);
                 System.out.println(respond);
                 break;
         case 2: 
                 url="http://data.bmkg.go.id/cuaca_indo_1.xml";
                 respond = cInterface.cekCuacaIndo(url);
                 System.out.println(respond);
                 break;
         case 3: url="http://data.bmkg.go.id/cuaca_jabodetabek_1.xml";
                 respond = cInterface.cekCuacaJabodetabek(url);
                 System.out.println(respond);
                 break;
         case 4: url="http://data.bmkg.go.id/cuaca_harian_id.xml";
                 respond = cInterface.cekCuacaHarian(url);
                 System.out.println(respond);
                 break;
         case 5: url="http://data.bmkg.go.id/cuaca_wisata.xml";
                 respond = cInterface.cekCuacaHarian(url);
                 System.out.println(respond);
                 break;
         default: System.out.println("Harap pilih dengan benar: "); break;
         
     }
     }while(pil!=6);
    }
}
