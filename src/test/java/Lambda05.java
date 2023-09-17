import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        // birden yüze kadar olan sayıların toplamını bulunuz// liste yok, liste oluşturmalıyız

        forLoopIleToplama(100);
        lambdaIleToplama(100);

        // birden yüze kadar olan sayilardan çift olanları toplayın
        ciftSayilariTopla(100);

    }

    public static void ciftSayilariTopla(int sinir) {
        System.out.println("Birden yüze kadar olan sayilardan çift olanların toplamı:");
        System.out.println(IntStream
                .range(1, sinir + 1)
                .filter(Lambda01::ciftMi)
                .sum());
    }

    public static void lambdaIleToplama(int sinir) {
        System.out.println("Birden yüze kadar olan sayıların Lambda ile toplamı");
        System.out.println(IntStream // intigerlardan oluşan bir stream oluştur
                .range(1, sinir + 1) // sınırın toplama (akış) içinde olmasını istiyorsak +1 yazmamzı gerekiyor
                .sum());
    }

    public static void forLoopIleToplama(int sinir) {
        System.out.println("Birden yüze kadar olan sayıların Java ile toplamı");
        int toplam = 0;

        for (int i = 1; i <= sinir; i++) {

            toplam+=i;
        }
        System.out.println(toplam);

    }
}
