package my_small_market;

import java.text.DecimalFormat;

public abstract class ShopService {
    public  void showMenu(){
        String yz="    ========    Market Reyonuna Yonlendiriliyorsunuz    ========  ";
        Entity.slowPrint(yz,15);
        System.out.println();


        System.out.printf("          %-6s     %-9s     %-12s\n","Urun Kodu","Urun Adi","Urun Fiyati");
        System.out.printf("          %-6s     %-9s     %-12s\n","---------","--------","------------");
        System.out.println();
        DataBase a=new DataBase();
        for(int i=0;i<a.kodsMarket.length;i++){       ///Burda data type i database olan bir List olsuturulup tek tek cagirilabilir a
                                                       // ama henuz listler islenmedigi icin array ile yapacam.
            System.out.printf("             %-6s     %-9s     %-6s %-2s \n",a.kodsMarket[i],a.productMarket[i],a.fiyatMarket[i],"TRY");

        }
        a.countProduct=a.kodsMarket.length;
        DataBase.hangisi="mrk";

    }

    public abstract void fiyatHesapla(int UrunKodu,double miktar,Kasa k,DataBase a);



}
