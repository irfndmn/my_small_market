package my_small_market;

import javax.management.MBeanRegistration;
import java.util.Scanner;

public class Entity {

    public void start(){

        Scanner sc= new Scanner(System.in);
        int select;
        String a="==============     OneCity Alisveris Merkezimize Hosgeldiniz     ================";
        Manav m=new Manav();
        Market mrk=new Market();
        Sarkuteri srk=new Sarkuteri();

        do{
            slowPrint(a,20);
            System.out.println();
            System.out.println();
            System.out.println("     ----  >      Lutfen Gitmek Istediginiz Reyonu Seciniz      < ----   ");
            System.out.println();
            System.out.println("   1 - Manav \n   2 - Market \n   3 - Sarkuteri  \n\n   0 - CIKIS\n");
            System.out.print(" Terchiniz : ");
            select=sc.nextInt();                                                       //  Burda karsilastigim problem bknz sona

            switch (select){
                case 1:
                    goShopping(m,sc);
                    break;
                case 2:
                    goShopping(mrk,sc);
                    break;
                case 3:
                    goShopping(srk,sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Secim Yapiniz...");
            }



        }while (select!=0);


        System.out.println("\nIyi Gunler Tekrar Bekleriz...");


    }


    public static void slowPrint(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void goShopping(ShopService a,Scanner sc){
        DataBase dt=new DataBase();

        a.showMenu();
        System.out.println();
        int selection;
        boolean isChecked;
        do {
            isChecked=false;
            System.out.print("\n Lutfen Almak Istediginiz Urunun Kodunu Giriniz  : ");
            selection= sc.nextInt();
            if(selection<1||selection>dt.countProduct){
                System.out.println("Hatali Urun Kodu Girisi Yaptiniz... ");
                isChecked=true;
            }
        }while(isChecked);

        System.out.println();
        System.out.print(" Lutfen Miktari Giriniz (Kg) : ");
        double miktar= sc.nextDouble();
        a.fiyatHesapla(selection,miktar,dt);
        Kasa ka=new Kasa();
        System.out.println();
        String yaz="=====>  Urununuz Sepete Eklenmistir...";


        Entity.slowPrint(yaz,15);
        System.out.println();
        System.out.println("\n\n");
        sepetiGetir(selection,miktar);      /// 6 adim
        System.out.println();


        String ust="Bir Ust Menuye Yonlendiriliyorsunuz...";

        boolean devamMi;


        do{
            devamMi=false;
            System.out.println(" 1 - Alisverise Devam \n 2 - Odeme Icin Kasaya Git \n 0 - CIKIS");
            System.out.println();
            System.out.print("Seciminiz : ");
            System.out.println();
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    start();
                   // devamMi=true;
                    break;
                case 2:
                    odemeIcinKasa(ka,sc);
                    break;
                case 0:
                    Entity.slowPrint(ust,15);
                    System.out.println("\n");
                    devamMi=false;
                    break;
            }



        }while(devamMi);


    }


    public void odemeIcinKasa(Kasa ks,Scanner sc){
        System.out.print("Toplam Borcunuz : "+Kasa.odenecekToplamBorc);
        System.out.println();
        boolean isOdem=false;
        do {
            System.out.print("Lutfen Vereceginiz Miktari Giriniz  : ");
            double musterininVerdigi = sc.nextDouble();
            if (musterininVerdigi < Kasa.odenecekToplamBorc) {
                System.out.println((Kasa.odenecekToplamBorc - musterininVerdigi) + " TL eksik odeme yaptiniz... " +
                        "Lutfen Borcunuz Kadar Odeme Yapiniz...");
                isOdem=true;
            }else {
                Kasa k=new Kasa(musterininVerdigi);
               isOdem=false;
            }
        }while (isOdem);








    }
    public void sepetiGetir(int urunKodu,double UrunMiktari){        /// 5. adim

        Sepet obj1=new Sepet(urunKodu,UrunMiktari);
        Sepet.mysepet.add(obj1);
        obj1.sepetiYazdir();

    }

    /*
    Soyle bir problemle karsilastim. Ben 0 a bastigim halde cikis yapmiyordu.  Manav m=new Manav(); tercihiniz satirindan sonra olusturdugum objelerden dolayi bu sorunu yasiyodum


    Cozum :
     */


}
