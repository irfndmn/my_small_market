package my_small_market;

public class Manav extends ShopService{
    @Override
    public void showMenu() {
        String yazi="    ========    Manav Reyonuna Yonlendiriliyorsunuz    ========  ";
        Entity.slowPrint(yazi,15);
        System.out.println("\n");

        System.out.printf("          %-6s     %-9s     %-12s\n","Urun Kodu","Urun Adi","Urun Fiyati");
        System.out.printf("          %-6s     %-9s     %-12s\n","---------","--------","------------");
        System.out.println();
        DataBase a=new DataBase();
        for(int i=0;i<a.kodsManav.length;i++){       ///Burda data type i database olan bir List olsuturulup tek tek cagirilabilir a
            // ama henuz listler islenmedigi icin array ile yapacam.
            System.out.printf("             %-6s     %-9s     %-6s %-2s\n",a.kodsManav[i],a.productManav[i],a.fiyatManav[i],"TRY");


        }
        a.countProduct=a.kodsManav.length;
        DataBase.hangisi="mnv";

    }

    @Override
    public void fiyatHesapla(int UrunKodu, double miktar, DataBase a) {

        Kasa.manavToplam+=(miktar*a.fiyatManav[UrunKodu-1]);  /// k.manavToplam+=(miktar*a.fiyatManav[UrunKodu-1]);
    }
}
