
package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class pencere extends JFrame 
                        implements ActionListener
{
    public static final int WIDTH = 700;
    public static final int HEIGHT = 400;
    private JTextField adSoyadText; 
    private JTextField telText;
    private JTextArea icerik; 
    
    CiftBagliListe liste;
    CiftBagliListe.CiftBagliİterator i;
   
    
    pencere(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {  
         super( );
         this.liste=liste;
         this.i=i;
        setTitle("REHBER UYGULAMASI");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout( ));
        
        JPanel panel = new JPanel( );
        panel.setBackground(Color.pink);
        panel.setLayout(null);
        
        
        JButton ekleButon = new JButton("KİŞİ EKLE");
        ekleButon.addActionListener(this);
        ekleButon.setBounds(20,150,150,50);
        panel.add(ekleButon);
        
        JButton bilgiButon = new JButton("BİLGİ GÖRÜNTÜLE");
        bilgiButon.addActionListener(this);
        bilgiButon.setBounds(200,150,150,50);
        panel.add(bilgiButon);
        
        JButton silButon = new JButton("KİŞİ SİL");
        silButon.addActionListener(this);
        silButon.setBounds(20,225,150,50);
        panel.add(silButon);
        
        JButton sıralaButon = new JButton("A-Z'YE SIRALA");
        sıralaButon.addActionListener(this);
        sıralaButon.setBounds(200,225,150,50);
        panel.add(sıralaButon );
        
        JButton sıralaButon2 = new JButton("Z-A'YA SIRALA");
        sıralaButon2.addActionListener(this);
        sıralaButon2.setBounds(20,300,150,50);
        panel.add(sıralaButon2);
        
        JButton cıkısButon = new JButton("ÇIKIŞ YAP");
        cıkısButon.addActionListener(this);
        cıkısButon.setBounds(200,300,150,50);
        panel.add(cıkısButon );
        
        JLabel label=new JLabel("AD SOYAD:" );
        label.setBounds(20,30,200,30);
        panel.add(label);
        adSoyadText=new JTextField();
        adSoyadText.setBounds(150,30,200,30);
        panel.add(adSoyadText);
        
        JLabel label2=new JLabel("TELEFON NUMARASI:");
        label2.setBounds(20,80,200,30);
        panel.add(label2);
        telText=new JTextField();
        telText.setBounds(150,80,200,30);
        panel.add(telText);
        
        icerik=new JTextArea("\n !!!  Numaraların arasına virgül (,) koyarak"+ "\n\n"+"  birden fazla numara ekleyebilirsiniz.  !!!" ); 
                               
        icerik.setBounds(400,30,250,320);
        panel.add(icerik);
        
        add(panel,BorderLayout.CENTER);
           
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String buttonString = e.getActionCommand( );
      
         if (buttonString.equals("KİŞİ EKLE"))
        {
            if(ekliMi()==1)
           {
             icerik.setText("Rehberde bu isme ait bir kayıt var!");
           }
            else if(ekliMi()==2)  
           {
               icerik.setText("Ad ve soyad kısmı boş bırakılamaz.");
           }else
            {kisiEkle(liste,i);
            icerik.setText("Kişi Rehbere Eklendi");
            }
        }
    
        else if(buttonString.equals("BİLGİ GÖRÜNTÜLE"))
        {
           if(ekliMi()==0)
           {
               icerik.setText("Bu kişi rehberde kayıtlı değildir!");
           }else if(ekliMi()==2)
           {
             icerik.setText("Ad ve soyad kısmı boş bırakılamaz.");
           }else
           {    
           icerik.setText(null);
           ArrayList<String> bilgi= goruntule(liste,i);
           for(int x=0;x<bilgi.size();x++)
           {
               icerik.append(bilgi.get(x)+"\n");
           }
           }
        } 
             
        else if(buttonString.equals("KİŞİ SİL"))
        {
           if(ekliMi()==0)
           {
             icerik.setText("Bu kişi rehberde kayıtlı değildir!");
           }else if(ekliMi()==2)
           {
             icerik.setText("Ad ve soyad kısmı boş bırakılamaz.");
           }else
           {    
           kisiSil(liste,i); 
           icerik.setText("Kişi Silindi");
           }
        }
      
        else if(buttonString.equals("A-Z'YE SIRALA"))
        { 
           icerik.setText(null);
           ArrayList<String> artanSıra=liste.artanKayıtDondur(liste, i);
           for(int x=0;x<artanSıra.size();x++)
           {
               icerik.append(artanSıra.get(x)+"\n");
           }
           
        }
        else if(buttonString.equals("Z-A'YA SIRALA"))
        {
           icerik.setText(null);
           ArrayList<String> azalanSıra=liste.azalanKayıtDondur(liste, i);
           for(int x=0;x<azalanSıra.size();x++)
           {
               icerik.append(azalanSıra.get(x)+"\n");
           }
        }
        else if(buttonString.equals("ÇIKIŞ YAP"))
        {   
          liste.dosyayaYaz(liste, i);
          System.exit(0);
        }
    }
    public void kisiEkle(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {
        String adSoyad=adSoyadText.getText();
        
        String TelNum1=telText.getText();
   
        
        ArrayList<String> list=new ArrayList<>();
        
        String [] dizi = TelNum1.split(","); //Aralarında virgül konularak girilen 
        for (String a : dizi)                //tel num stringini ayırabilmek için kullanıldı
        {  list.add(a);
        }
         Bilgi yeniKisi=new Bilgi(adSoyad,list); 
         i.add(yeniKisi);
         
      
     } 
    public ArrayList goruntule(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {   
        String adSoyad=adSoyadText.getText();
        String adSoyad2=null;
        ArrayList<String> telNum = null;
        
        
        i.restart();
        do
        {   adSoyad2=i.adSoyadDondur();
            if(adSoyad2.equalsIgnoreCase(adSoyad))
            {
                telNum=i.bilgiDondur();
                break;
            }
            i.next();
            
        }while(!adSoyad2.equalsIgnoreCase(adSoyad));
        
     
         return telNum;
        
    }
     public void kisiSil(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {
        String adSoyad=adSoyadText.getText();
        String adSoyad2=null;
         i.restart();
        do
        {   
            adSoyad2=i.adSoyadDondur();
            if(adSoyad2.equalsIgnoreCase(adSoyad))
            {
                i.delete();
                break;
            }
            i.next();
           
        }while(!adSoyad2.equalsIgnoreCase(adSoyad));
        
         
     } 
     
     public int ekliMi()
     {
         String adSoyad=adSoyadText.getText();
         int deger=0;
         ArrayList<String> kayıtlar=liste.artanKayıtDondur(liste, i);
         
         for(int x=0;x<kayıtlar.size();x++)
         {   
            if("".equals(adSoyad)) //ad soyad girişi yoksa 
            {   
                deger=2;
                break;
            }
            else if(kayıtlar.get(x).equalsIgnoreCase(adSoyad)) 
             {
                 deger=1;
                 break;
             }
             else 
 
             {
                 deger=0;
             }
             
         }
         return deger;
     }
     
    
}
