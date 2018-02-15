package proje;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Proje {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String karakter=",";
        String adSoyad;
      
        
        try
        {
        File file = new File("rehber.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        
        CiftBagliListe liste=new CiftBagliListe();
        CiftBagliListe.CiftBagliİterator i = liste.iterator();
        String satir = reader.readLine();
        while(!"".equals(satir))
        {
            StringTokenizer st1 = new StringTokenizer(satir,karakter);
            adSoyad=st1.nextToken();
            ArrayList<String> list=new ArrayList<>();
            while (st1.hasMoreTokens())
            {
                list.add(st1.nextToken());
            }
             Bilgi yeniKisi=new Bilgi(adSoyad,list);
             i.add(yeniKisi); // dosyadan okunan kisiler listeye eklenir
             satir = reader.readLine();
           }
        
        
           pencere p=new pencere(liste,i);
           p.setVisible(true);
        }
        catch (FileNotFoundException error) {
            System.out.println("Dosya bulunamadı...");
         
        }
    }
}
