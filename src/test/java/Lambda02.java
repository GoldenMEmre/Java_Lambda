import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {


        List<Integer> sayilar = new ArrayList<>(Arrays.asList( 6, 5, 8, 7, 4, 5, 8, 4, 2, 6, 6, 5, 4, 7, 8));

        // listedeki her elemanın küpünü alıp bir ekleyip sonucu yazdırın
        sayilarinKupuArtiBir(sayilar);

        // listedeki tek sayiların küpünü alıp iki çıkartın
        tekSayilarinKupuEksiIki(sayilar);

        // listedeki çift sayiların karekökünü yazdırın
        ciftSayiKarakokPrnt(sayilar);

        // max sayiyi bul
        maxSayiBul(sayilar);

        // elemanların toplamı
        butunToplam(sayilar);

        // cift sayilarin hepsinin carpimi
        ciftSayilariCarp(sayilar);

        // liste içindeki min sayi
        listedeMinSayiBul(sayilar);



    }

    public static void listedeMinSayiBul(List<Integer> sayilar) {
        System.out.println("\nListedeki min elemen");
        // Integer classı kullanarak
        System.out.println(sayilar.stream().reduce(Integer::min));
        // Math classı kullanarak
        System.out.println(sayilar.stream().reduce(Math::min));

        // Lambda Expression ile çözüm
        int minSayiLambda = sayilar.stream().reduce(Integer.MAX_VALUE,(x,y) -> x<y ? x : y);
        System.out.println(minSayiLambda);



    }

    public static void ciftSayilariCarp(List<Integer> sayilar) {
        System.out.println("\nListedeki cift sayilarin carpimi");
//1. Yöntem
        System.out.println("bütün sayilarin carpimi : " + sayilar
                .stream()
                .filter(Lambda01::ciftMi)
                .reduce(Math::multiplyExact));//tek bir sonuç çıkacağı için 'reduce' kullanıyoruz.
//2. Yöntem
        System.out.println("function kullanarak : "+ sayilar
                .stream()
                .filter(Lambda01::ciftMi)
                .reduce(1,(a,b) -> (a*b)));//Paragraf 50 vd.'daki mantık.


    }

    public static void butunToplam(List<Integer> sayilar) {
        System.out.println("\nListedeki bütün sayilarin toplami");

        System.out.println(sayilar
                .stream()
                .reduce(0, (a, b) -> a + b));//İlk olarak a=0 oluyor. 0 ile sayilar listesinin ilk elemanı olan
        //6 toplanıyor.Bu sefer a=6 oluyor ve b listenin ikinci elemanı olan 5 oluyor. Bu defa a=6+5, b= 8 oluyor...vd
        Integer toplam = sayilar.stream().reduce(0, (a, b) -> a + b);//Bu şekilde yukarıda bulduğumuz sayıyı
        System.out.println("genel toplam :"+toplam);//bir yere kaydetmiş olduk.Data type (Integer) belirlendiği için
        //sonuç aşağıdakinden farklı olarak, optional gelmiyor.
        System.out.println(sayilar.stream().reduce(Integer::sum));//Burada yukarıdaki gibi lambda ile değil Math

    }//class'ından hazır bir metot kullanarak aynı işlemi yapmış olduk.

    public static void maxSayiBul(List<Integer> sayilar) {

        System.out.println("\nListedeki en büyük sayi");
        System.out.println(sayilar
                .stream()
                .reduce(Math::max));
        Optional<Integer> maxSayi = sayilar.stream().reduce(Math::max);//Optional farklı bir kaynaktan geliyor demek.

    }

    public static void ciftSayiKarakokPrnt(List<Integer> sayilar) {

        System.out.println("\nCift sayilarin karekoku");
        sayilar
                .stream()
                .filter(t-> t % 2 == 0)
                .map(Math::sqrt)//map bütün elemanların üzerinde değişiklik yapacağım anlamına geliyor. Java Map ile ilgisi yok.
                .forEach(t -> System.out.print(t + " "));//Burada Lamda01 classındaki yazdir metodunu kullanmadık. Çünkü
               //o metot int olarak tanımlanmış. Oysa burada sonuç tam kare olmayan sayıların karekökü alındığı için
                 //double olarak geliyor.
    /*
        reduce() ==> manası azaltmak olarak geçiyor. Sonucun tek tek elemamana inmesini istediğimiz durumlarda kullanılır
        mesela bütün sayıların toplamı
        bütün sayıların max, min, çarpımı
         */
    }

    public static void tekSayilarinKupuEksiIki(List<Integer> sayilar) {

        System.out.println("\nTek sayilarin kupu - 2");

        sayilar
                .stream()
                .filter(t-> t%2 !=0 )
                .map(t-> (t*t*t)-2)
                .forEach(Lambda01::yazdir);
    }

    public static void sayilarinKupuArtiBir(List<Integer> sayilar) {
        System.out.println("\nSayilarin kupu + 1");
        sayilar
                .stream()
                .map(t->(t*t*t)+1)
                .forEach(Lambda01::yazdir);

    }
}
