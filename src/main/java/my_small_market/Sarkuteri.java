package my_small_market;

public class Sarkuteri extends ShopService {

    @Override
    public void showMenu() {
        String yaz="    ========    Sarkuteri Reyonuna Yonlendiriliyorsunuz    ========   ";
        Entity.slowPrint(yaz,15);
        System.out.println("\n");

        System.out.printf("          %-6s     %-9s     %-12s\n","Urun Kodu","Urun Adi","Urun Fiyati");
        System.out.printf("          %-6s     %-9s     %-12s\n","---------","--------","------------");
        System.out.println();
        DataBase a=new DataBase();
        for(int i=0;i<a.kodsSarkuteri.length;i++){       ///Burda data type i database olan bir List olsuturulup tek tek cagirilabilir a
            // ama henuz listler islenmedigi icin array ile yapacam.
            System.out.printf("             %-6s     %-9s     %-6s %-2s \n",a.kodsSarkuteri[i],a.productSarkuteri[i],a.fiyatSarkuteri[i],"TRY");


        }
        a.countProduct=a.kodsSarkuteri.length;
        DataBase.hangisi="srk";

    }

    @Override
    public void fiyatHesapla(int UrunKodu, double miktar,DataBase a) {

        Kasa.sarkuteriToplam+=(miktar*a.fiyatSarkuteri[UrunKodu-1]);


    }
}
