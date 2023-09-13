import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda04 {


    /*

    Bir sürü üniversite
    her üniversite içinde Üniversite ismi, Bölüm, öğrenci sayısı, notOrtalaması,
    bir pojo classı oluşturacağız, bu classtan objeler(üniversiteler) üreteceğiz
    pojo class içinde : constructor, variables, getter setter, toString()

     */

    public static void main(String[] args) {

        //Universite u1 = new Universite();
        Universite u1 = new Universite("Ktu","MakineMuh",571,93);
        Universite u2 = new Universite("Bilkent","matematik",785,65);
        Universite u3 = new Universite("İstanbul","hukuk",1445,71);
        Universite u4 = new Universite("Marmara","Bilgisayar",1324,78);
        Universite u5 = new Universite("yildiz","gemi",345,65);

        List<Universite> unis = new ArrayList<>(Arrays.asList(u1,u2,u3,u4,u5));

        // not ortalaması 74'ten büyük olan universiteleri yazdır
        notOrt74BuyukUniversiteler(unis);

        // bütün üniversitelerin not ortalaması 60'tan büyük mü
        butunUniversitelerNotOrtalamasiBuyuk60Mi(unis);

        // bütün üniversitelerin öğrenci sayısı 300 den fazla olmalı
        System.out.println(btnUniOgrSayisiMin300(unis));

        // üniversitelerimizde hukuk bölümü var mı
        System.out.println(universitlerdeHukukBolumuVarMi(unis));


    }

    public static String universitlerdeHukukBolumuVarMi(List<Universite> unis) {
        System.out.println("\nÜniversitelerimizde hukuk bölümü var mı?");
        return unis.stream().anyMatch(t -> t.getBolum().toLowerCase().contains("hukuk"))
                ?
                "Hukuk bolumu mevcut"
                :
                "Hukuk bolümü mevcut değil "
                ;

    }

    public static String btnUniOgrSayisiMin300(List<Universite> unis) {
        System.out.println("\nBütün üniversitelerin öğrenci sayısı 300 den fazla olmalı :");
//        String veri = unis.stream().allMatch(t -> t.getOgrSayisi()>300)
//                ?
//                "Bütün üniversiteler beklentinin üstünde öğrenci sayısına sahip"
//                :
//                "Hayal kırıklığı"
//                ;
//
//           return veri;


        return unis.stream().allMatch(t -> t.getOgrSayisi()>300)
                ?
                "Bütün üniversiteler beklentinin üstünde öğrenci sayısına sahip"
                :
                "Hayal kırıklığı"
                ;

    }

    public static void butunUniversitelerNotOrtalamasiBuyuk60Mi(List<Universite> unis) {
        System.out.println("\nBütün üniversiteler not ortalaması kontrolu :");
        System.out.println(
                unis
                .stream()
                .allMatch(t -> t.getNotOrtalama() > 60)
                ?
                "Bütün üniversitelerin notu beklentinin üstünde"
                :
                "Hayal kırıklığı");

    }

    public static void notOrt74BuyukUniversiteler(List<Universite> unis) {
        System.out.println("\nNot ortalaması 74'ten büyük olan üniversite bilgileri");
        unis
                .stream()
                .filter(t -> t.getNotOrtalama()>74)
                .map(t -> t.getUniName())
                .forEach(t -> System.out.print(t + " "));
    }
}
