package my_small_market;

public class Market extends ShopService{


    @Override
    public void fiyatHesapla(int UrunKodu, double miktar,DataBase a) {

        Kasa.marketToplam+=(miktar*a.fiyatMarket[UrunKodu-1]);
    }
}
