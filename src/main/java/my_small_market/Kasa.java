package my_small_market;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Kasa {
    static double  manavToplam=0.00;

    static  double sarkuteriToplam=0.00;

    static double marketToplam=0.00;

    private int fisNo=1000;
    private String fisZamani;

     static double odenecekToplamBorc;

    public double musterininOdedigi;

    public double paraUstu;


    public Kasa(){
        setToplam();

    }


    public void setToplam(){
        odenecekToplamBorc=(manavToplam+ sarkuteriToplam+marketToplam);
    }




    public Kasa(double musterininOdedigi) {

        this.musterininOdedigi = musterininOdedigi;
        this.paraUstu=(this.musterininOdedigi-odenecekToplamBorc);
        setFisZamaniandFisNo();
        fisiYazdir();
    }



    private void setFisZamaniandFisNo(){

        DateTimeFormatter ka = DateTimeFormatter.ofPattern("dd/MMM/yyyy hh:mm:ss a");

        LocalDateTime a=LocalDateTime.now();

        this.fisZamani=ka.format(a);
        this.fisNo++;

    }

    public double getOdenecekToplamBorc() {
        return odenecekToplamBorc;
    }

    private  void fisiYazdir(){

        System.out.println("=================================================================");
        System.out.println("        ------- > OneCity Market A.S. < --------");
        System.out.println();
        System.out.println(" Fis No                  : "+this.fisNo);
        System.out.println(" Fis Tarihi              : "+this.fisZamani);
        System.out.printf(" Sarkuteri Toplam         : %-5s %-3s",this.sarkuteriToplam," TRY\n");
        System.out.printf(" Manav     Toplam         :  %-5s %-3s",this.manavToplam," TRY\n");
        System.out.printf(" Market    Toplam         : %-5s %-3s",this.marketToplam," TRY\n");
        System.out.printf(" Odemeniz Gereken Borc    : %-5s %-3s",this.odenecekToplamBorc," TRY\n");
        System.out.printf(" Yapmis Oldugunuz Odeme   : %-5s %-3s",this.musterininOdedigi," TRY\n");
        System.out.printf(" Para Ustu                : %-5s %-3s",this.paraUstu," TRY\n");
        System.out.println();
        System.out.println("=================================================================\n");
        System.out.println("Bizi Tercih Ettiginiz Icin Tesekkur Ederiz... Tekrar Bekleriz...\n\n");



        /// En son fisi yazdirinca tekrar basa gelmek icin sepeti bosaltmak gerekiyor o yuzden sonradan ekledim bu kismi

        Sepet.mysepet.clear();                /// Sepeti nosaltmis oluyoz her fis yazildiginda
        odenecekToplamBorc=0.0;
        manavToplam=0.0;
        marketToplam=0.0;
        sarkuteriToplam=0.0;



    }



}
