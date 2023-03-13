package my_small_market;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sepet {
    public static List<Sepet> mysepet=new ArrayList<>();
    public int urunKodu;
    public String urunIsmi;
    public double urunMiktari;

    public double urunFiyati;
    public Sepet(){

    }

    public Sepet(int urunKodu, double urunMiktari) {         // 1 adim
        this.urunKodu = urunKodu;
        this.urunMiktari = urunMiktari;
        DataBase ak=new DataBase();
        findUrun(ak);
    }


    private void findUrun(DataBase a){                 // 2 adim
        switch (DataBase.hangisi){
            case "mrk":
                setForMrkt(a);
                break;
            case "mnv":
                setForMnv(a);
                break;
            case "srk":
                setForSrk(a);
                break;
        }
    }

    private void setForMrkt(DataBase a){

        this.urunFiyati=a.fiyatMarket[this.urunKodu-1];
        this.urunIsmi=a.productMarket[this.urunKodu-1];

    }
    private void setForMnv(DataBase a){                  // 3 adim

        this.urunFiyati=a.fiyatManav[this.urunKodu-1];
        this.urunIsmi=a.productManav[this.urunKodu-1];

    }


    private void setForSrk(DataBase a){                  // 3 adim

        this.urunFiyati=a.fiyatSarkuteri[this.urunKodu-1];
        this.urunIsmi=a.productSarkuteri[this.urunKodu-1];

    }

    public void sepetiYazdir(){                                            // 4 adim
        System.out.printf("          %-6s     %-9s     %-10s   %-10s  %-10s\n","Urun Kodu","Urun Adi","Urun Miktari","Urun Fiyati","  Toplam");
        System.out.printf("          %-6s     %-9s     %-10s   %-10s  %-10s\n","=========","========","============","===========","==========");
        System.out.println();
        for(Sepet a:this.mysepet){
            System.out.printf("             %-6s     %-9s     %-4s %-2s %-5s  %-3s %-9s %-4s %-3s\n",a.urunKodu,a.urunIsmi,a.urunMiktari,"Kg","",a.urunFiyati,"TRY",toplamUrunFiyati(a.urunMiktari,a.urunFiyati),"TRY");
        }
    }

    private String toplamUrunFiyati(double urunMiktari,double urunFiyati){
        DecimalFormat frm=new DecimalFormat("00.00");
        double toplam=urunMiktari*urunFiyati;
        return frm.format(toplam);
    }




    @Override
    public String toString() {
        return "urunKodu=" + urunKodu +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", urunMiktari=" + urunMiktari +
                ", urunFiyati=" + urunFiyati;
    }
}
