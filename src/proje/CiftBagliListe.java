package proje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class CiftBagliListe {

private class Dugum 
   {
    private Bilgi bilgiler;
    private Dugum previous;
    private Dugum next;
   
    
public Dugum()
{   
    bilgiler=null;
    previous=null;
    next=null;
   
}
public Dugum(Bilgi newBilgiler,Dugum newOnceki,Dugum newSonraki)
{
    bilgiler=newBilgiler;
    previous=newOnceki;
    next=newSonraki;
    
}
         /**
         * @return the bilgiler
         */
        public Bilgi getBilgiler() {
            return bilgiler;
        }

        /**
         * @param bilgiler the bilgiler to set
         */
        public void setBilgiler(Bilgi bilgiler) {
            this.bilgiler = bilgiler;
        }

        /**
         * @return the previous
         */
        public Dugum getPrevious() {
            return previous;
        }

        /**
         * @param previous the previous to set
         */
        public void setPrevious(Dugum previous) {
            this.previous = previous;
        }

        /**
         * @return the next
         */
        public Dugum getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Dugum next) {
            this.next = next;
        }

  
}
    public class CiftBagliİterator
	{
		private Dugum position;

		public CiftBagliİterator()
		{
			position = head;
		}
		public void restart()
		{
			position = head;
		}
                public void next()
		{
			if (!hasNext())
				throw new IllegalStateException();
			
			position = position.next;
			
		}
                public boolean hasNext()
		{
			return (position != null);
		}
                 public void previous()
                {
                    if (!hasPrevious())
				throw new IllegalStateException();
			
			position = position.previous;
                }
                 public boolean hasPrevious()
		{
			return (position != null);
		}
               
                public String adSoyadDondur()
                {
                    return position.bilgiler.getAdSoyad();
                   
                }
                
                public ArrayList bilgiDondur()
                {
                    return position.bilgiler.getList();
                }
                public void add(Bilgi bilgiler)
		{ int x=0,y=0,z=0;
                  
                if(head!=null) 
                { x=bilgiler.getAdSoyad().compareToIgnoreCase(head.bilgiler.getAdSoyad());}
                if(tail!=null)
                { y=bilgiler.getAdSoyad().compareToIgnoreCase(tail.bilgiler.getAdSoyad());}
			if (y>0)
			{ 
			CiftBagliListe.this.addToEnd(bilgiler);
			
			}
			else if ((head == null && tail==null)|| x<0)
                        {
                           
                            CiftBagliListe.this.addToStart(bilgiler);
                           
                        }   
                        else 
			{      position=head;
                              
                               while(position!=tail)
                               {   position=position.next;
                                   z=bilgiler.getAdSoyad().compareToIgnoreCase(position.bilgiler.getAdSoyad());
                                   
                                   if(z<0)
                                   {break;}   
                               }
				
                                Dugum temp = new Dugum(bilgiler, position.previous, position);
				position.previous.next = temp;
				position.previous = temp;
                   	
		}

            }
                public void delete()
		{
			if (position == null)
				throw new IllegalStateException();
                        else if(head==tail)       // rehberde tek kalan düğümü silmek için
                        {
                             position=null;
                             head=null;
                             tail=null;
                        }
			else if (position.previous == null)  // listedeki head düğümünü silmek için
			{
		    position.next.previous = null;
                                position = null;
                                head=head.next;
			}
			else if (position.next == null)  //listedeki tail düğümünü silmek için
			{
                                
		  position.previous.next = null;
                                position = null;
                                tail=tail.previous;
                                
			}
                        
			else
			{
				position.previous.next = position.next;
				position.next.previous = position.previous;
				position = position.next;
			}
		}

	}
     private Dugum head;
     private Dugum tail;

	public CiftBagliİterator iterator()
	{
		return new CiftBagliİterator();
	}
        
    public CiftBagliListe( )
    {
        head = null;
        tail=null;
    }
    public void addToStart(Bilgi bilgiler)
    {
        Dugum newHead = new Dugum(bilgiler, null, head);
        if (head != null)
        {  
            head.previous = newHead;
        }
        if(head==null)
        {
            tail=newHead;
        }
        head = newHead;
              
    }
    public void addToEnd(Bilgi bilgiler)
    {
        Dugum newTail=new Dugum(bilgiler,tail,null);
        if(tail!=null)
        {
            tail.next=newTail;
        }
        if(tail==null)
        {
            head=newTail;
        }
        tail=newTail;
        
    }
    public ArrayList artanKayıtDondur(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {
        Dugum position = head;
        ArrayList<String> list=new ArrayList<>();
        while (position != null)
        {
           list.add(position.bilgiler.getAdSoyad());
           position = position.getNext();
        }
       return list;
    } 
    
    public ArrayList azalanKayıtDondur(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {
        Dugum position = tail;
        ArrayList<String> list2=new ArrayList<>();
        while (position != null)
        {
           list2.add(position.bilgiler.getAdSoyad());
           position = position.getPrevious();
        }
       return list2;
    }
    public  void dosyayaYaz(CiftBagliListe liste, CiftBagliListe.CiftBagliİterator i)
    {       
             try{
                  File dosya = new File("sakla.txt");
                  FileWriter yazici = new FileWriter(dosya);
                  BufferedWriter yaz = new BufferedWriter(yazici);
                  
                  Dugum position = head;
                  ArrayList<String> list=new ArrayList<>();
                  while (position != null)
                  {
                    yaz.write(position.bilgiler.getAdSoyad());
                    for(int x=0;x<position.bilgiler.getList().size();x++)
                    {
                        yaz.write(", "+position.bilgiler.getList().get(x));
                    }
                    yaz.newLine();
                    position = position.getNext();
                    
                  }
                
                  yaz.close();
                  System.out.println("Rehber dosyaya yazıldı");
            }
            catch (Exception hata){
                  hata.printStackTrace();
            }
      }
    
}
