package proje;

import java.util.ArrayList;

public class Bilgi
{
        private String adSoyad;
        private ArrayList<String> list;    //Telefon numaralarını tutmak için
       
        public Bilgi( )
        {
             adSoyad = null;
             list=null;

        }

        public Bilgi(String newAdSoyad,ArrayList<String> newList)
        {
            adSoyad = newAdSoyad;
            list=newList;
        }

        /**
         * @return the adSoyad
         */
        public String getAdSoyad() {
            return adSoyad;
        }

        /**
         * @param adSoyad the adSoyad to set
         */
        public void setAdSoyad(String adSoyad) {
            this.adSoyad = adSoyad;
        }

    /**
     * @return the list
     */
    public ArrayList<String> getList() {
        return list;
    }
    /**
     * @param list the list to set
     */
    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
        
