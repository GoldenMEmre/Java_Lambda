import java.util.*;
import java.util.stream.Stream;

import static java.util.Arrays.stream;


public class Lambda03 {


    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokareç", "arabAşı", "güveç", "waffle", "welemen", "cacix", "adana"));

        // alfabetik sıralama ile tekrarsız olarak menüdeki yemekleri büyükHarf ile yazdırın
        alfabetikTekrarsizMenu(menu);

        // menüdeki yemekleri karakter sırasına göre sıraylayıp yazdırın
        karakterkSayilariniYazdir(menu);

        // listedeki elemenları son harflerine göre sıralayıp yazdırın
        elemanlariSonHarflarineGoreYazdir(menu);

        // KaracterSayisiCift olanların tekrarsız buyukten küçüğe sıralıcaz
        ciftKaracterliElemanlariSiraliYazdir(menu);

        // listede 7 karacterden az yemek ismi olmaması gerekiyor
        listede7denAzKaracterliYemekVarMi(menu);

        // w harfiyle başlayan yemek olmaması gerektiğini test et
        wHarfiyleBaslayanYemekOlmamali(menu);

        // x harfi ile başlayan yemek var mı kontrol edeceğiz
        xHarfiIleBaslayanYemekVarMi(menu);

        // menüde karakter sayısı en fazla olan yemeği yazdırın
        karacterSayisiEnFazlaOlanYemekYazdir(menu);

        // yemekleri son harfine göre sıralayıp ilk elemanı yazdırmayın
        sonHarfeGoreSiralaIlkYemegiAtla(menu);



    }

    public static void sonHarfeGoreSiralaIlkYemegiAtla(List<String> menu) {
        System.out.println("\nYemekler son harfine gore sıralandı, ilk yemek atlandı");
        menu
                .stream()
                .sorted(Comparator.comparing(t -> t.charAt(t.length()-1)))
                .skip(1)
                .forEach(t -> System.out.print(t + " "));


    }

    public static void karacterSayisiEnFazlaOlanYemekYazdir(List<String> menu) {
        System.out.println("\nEn çok harfli yemek : ");
        System.out.println(menu
                .stream()
                .sorted(Comparator.comparing(t -> t.toString().length()).reversed())
                //.findFirst()); birinci yemek değilde en uzun ilk üç yemeği görmek isteseydik
                .limit(3)); // limit() fonksiyonu bir Stream bize döndürdüğü için direk print yapamıyoruz


        Stream<String>ilkUcYemek= menu
                .stream()
                .sorted(Comparator.comparing(t -> t.toString().length()).reversed())
                //.findFirst()); birinci yemek değilde en uzun ilk üç yemeği görmek isteseydik
                .limit(3); // limit() fonksiyonu bir Stream bize döndürdüğü için direk print yapamıyoruz

        System.out.println(Arrays.toString(ilkUcYemek.toArray()));// bir Stream'ı arraya çevirip, Arrays classından yardım isteyip yazdırabiliyoruz

        System.out.println(Arrays.toString(menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(3).toArray()));

        // limit() eğer stream'den belli sayıdaki elemanları almak istersek kullanılır. Bize dönüş olarak bir stream döndürecektir. Bu yüzden direk yazdırılması
        // mümkün değildir. Bu streamın yazdırılması için ilk olarak toArray() method ile array'e çevrilmeli sonra Arrays.toString() methodu ile yazdırılmalı


    }

    public static void xHarfiIleBaslayanYemekVarMi(List<String> menu) {
        System.out.println("\nx harfiyle başlayan yemek var mı?");
        System.out.println(menu
                .stream()
                .anyMatch(t -> t.startsWith("x"))); // bir tane yemeğin x ile başlaması true döndürecektir

        System.out.println(menu
                .stream()
                .anyMatch(t -> t.startsWith("x")) ? "x ile başlayan en az bir yemek ismi var" : "x ile başlayan yemek yohtir");

    }

    public static void wHarfiyleBaslayanYemekOlmamali(List<String> menu) {
        System.out.println("\nw harfiyle başlayan yemek olmaması gerektiğini test et");
        System.out.println("w harfi ile baslayan hiç bir yemek ismi yok : "+

                menu
                        .stream()
                        .noneMatch(t -> t.startsWith("w")) // hiç birinin w harfi ile başlamaması gerekiyor, biri bile w harfi ile başlarsa false


        );
    }

    public static void listede7denAzKaracterliYemekVarMi(List<String> menu) {
        System.out.println("\nlistede 7 karacterden az yemek ismi olmaması gerekiyor");
        System.out.println(menu
                .stream()
                .allMatch(t -> t.length() >= 7)); // koşulun bütün elemanlar için doğru olduğu zaman true döner,

        boolean kontrol = menu
                .stream()
                .allMatch(t -> t.length() >= 7);
//        if (kontrol){
//            System.out.println("bütün yemek isimleri en az 7 karakterli");
//        }else {
//            System.out.println("En az bir yemek ismi 7'den daha az karaktere sahip");
//        }

        System.out.println((kontrol ? "bütün yemek isimleri en az 7 karakterli" : "En az bir yemek ismi 7'den daha az karaktere sahip"));


    }

    public static void ciftKaracterliElemanlariSiraliYazdir(List<String> menu) {
        System.out.println("\nKaracterSayisiCift olanların tekrarsız buyukten küçüğe sıralıcaz");
        menu
                .stream()
                .map(t->t.length())
                .filter(t -> t % 2 == 0)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(Lambda01::yazdir);


    }

    public static void elemanlariSonHarflarineGoreYazdir(List<String> menu) {

        System.out.println("\nElemanları son harflerine göre yazdır");
        menu
                .stream()
                .sorted(Comparator.comparing(t-> t.toString().charAt(t.toString().length()-1)).reversed())

                .forEach(t -> System.out.print(t +" "));
        // ascii table da türkçe karakterler sonda yer aldığı için sona yazıldı

    }

    public static void karakterkSayilariniYazdir(List<String> menu) {

        System.out.println("\nKarakter sayilarını yazdır");
        menu
                .stream()
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .forEach(Lambda01::yazdir);

    }


    public static void alfabetikTekrarsizMenu(List<String> menu) {

        System.out.println("Alfabetik sıralama ile tekrarsız olarak menüdeki yemekleri büyükHarf ile yazdır.");
        menu
                .stream()
                //.map(t -> t.toUpperCase()) // listedeki elemanların hepsine uygulanacak bir değişim "map"
                .map(String::toUpperCase)
                .sorted() // doğal sıraya koyar
                .distinct() // tekrarları siler
                .forEach(t-> System.out.print(t+" "));
    }
}
