import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    /*


    1) Lambda "Functional programming" --> method (action) kullanarak programlama
     ** genellikle method create etmek yerine hazır methodlar kullanarak yazılır
     ** methodların çalışması için gerekli düzenekler önceden hazırlanmıştır
     ** çok az kod kullanarak, kompleks işlemler yapılabilir

    2) Nasıl yapabilirim den ziyade ne yapabilirim sorusunun cevabını lamda ile verebilirsiniz
    ** "Structured programing"  kodları kendimiz yazdığımız
    ** "Functional Programing"  hazır methodlar kullanarak, çok daha kısa ve öz, hatasız çalışma

    3) collectionlar kullanılır ( List, Queue, Set vs), maplar kullanılamaz

     */


    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList( 54,58,95,45,65,48,56,54,48,87,98,61,23,31,45,57,89,88,44,77,44,11,55,66));
        //Metodu sadece birşey yazdırmak için tasarlıyorsak, birşey döndürmesini beklemiyorsak return type'ı 'void' olmalı.
        elemanlariYazdirForEach(sayilar);

        elemanlariYazdirLambda(sayilar);

        elemanlariYazdirFunctionLambda(sayilar);

        System.out.println("\nlistemizdeki çift sayıları java ile yazdıralım");
        ciftSayilariYazdirStructured(sayilar);

        System.out.println("\nlistemizdeki çift sayıları lambda ile yazdıralım");
        ciftSayilariYazdirFunctional(sayilar);
        System.out.println();//-3-
        ciftSayilariYazdirFunctional2(sayilar);
        //[1]
        System.out.println("\n50 sayisindan kucuk cift sayilari yazdiralim");
        elliSayisindanKucukCiftSayilariYazdir(sayilar);
        //{1} Ben yaptım
        System.out.println("\n50 sayisindan buyuk cift sayilari yazdiralim");
        elliSayisindanBuyukCiftSayilariYazdir(sayilar);
    }
    //{2}
    public static void elliSayisindanBuyukCiftSayilariYazdir(List<Integer> sayilar) {
        //sayilar.stream().filter(Lambda01::ciftMi).filter(t-> t>50).forEach(Lambda01::yazdir);
        sayilar.stream().filter(Lambda01::ciftMi).filter(Lambda01::ellidenBuyukMu).forEach(Lambda01::yazdir);
    }
    //{3}Ben yaptım
    public static Boolean ellidenBuyukMu(Integer a){
        return a>50;
    }
    //[2]
    public static void elliSayisindanKucukCiftSayilariYazdir(List<Integer> sayilar) {

        //sayilar.stream().filter(Lambda01::ciftMi).filter(t-> t<50).forEach(Lambda01::yazdir);
        sayilar.stream().filter(Lambda01::ciftMi).filter(Lambda01::ellidenKucukMu).forEach(Lambda01::yazdir);

    }
    //[3]
    public static  Boolean ellidenKucukMu(Integer a){
//        boolean elledenKucukMu = true;
//
//        if(a<50){
//            elledenKucukMu = true;
//        }else {
//            elledenKucukMu = false;
//        }
        return a<50;
    }

    //-4-
    public static void ciftSayilariYazdirFunctional2(List<Integer> sayilar) {

        sayilar.stream().filter(Lambda01::ciftMi).forEach(Lambda01::yazdir);
    }

    //-2-
    public static Boolean ciftMi(Integer a){

        boolean ciftKontrolu = a % 2 == 0;

        return ciftKontrolu;

    }
    //-1-
    public static void ciftSayilariYazdirFunctional(List<Integer> sayilar) {

        sayilar.stream().filter(t -> t %2 == 0).forEach(Lambda01::yazdir);
    }

    public static void ciftSayilariYazdirStructured(List<Integer> sayilar) {
        for (Integer eachSayi: sayilar
             ) {

        if(eachSayi %2 == 0) {
            System.out.print(eachSayi+" ");
        }

        }
    }

    //(3)
    public static void elemanlariYazdirFunctionLambda(List<Integer> sayilar) {
        System.out.println("\nFunction olarak method kullanma");
        sayilar.stream().forEach(Lambda01::yazdir);

    }
    //(1)
    public static void elemanlariYazdirLambda(List<Integer> sayilar) {

        System.out.println("\nlambda");
        sayilar.stream().forEach((t) -> System.out.print(t+" "));

    }
    //(2)
    public static void yazdir(int t){

        System.out.print(t + " ");
    }

    public static void elemanlariYazdirForEach(List<Integer> sayilar) {

        System.out.println("foreach loop");
        // sayılar listesinin elemanlarını aralarında bir boşluk bırakarak yazdırın
        for (Integer eachSayi: sayilar
        ) {
            System.out.print(eachSayi+" ");

        }
    }
}
