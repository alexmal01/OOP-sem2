package Task2.src.mini.spaceport;

import mini.obsluga.*; //wyjątki i interfejs
import mini.promy.PromKosmiczny;
import mini.promy.Rakieta;

import java.util.*;

public class KomputerKontrolny {
    public static void main(String[] args) {

        String[] planety = {"Mars", "Neptun", "Jowisz", "Alfa Centauri", "Kepler 17"};

        //todo pkt 2 i 3
        Map <Integer,PromKosmiczny> mapaRakiet = new TreeMap<>();
        List <PromKosmiczny> listaRakiet = new ArrayList<>();
        System.out.println("----------PRZYGOTOWANIE RAKIET----------------");
        //todo pkt 4 i 5
        int iloscTlenu,iloscZalogi,maxLadownosc,zaladowanie;
        String miejscePrzylotu;
        Random random = new Random();
        int i = 0;
        while (mapaRakiet.size() < 10){
            i++;
            iloscTlenu = 1000 + random.nextInt(1000);
            iloscZalogi = random.nextInt(10);
            miejscePrzylotu = planety[random.nextInt(planety.length)];
            maxLadownosc = 500;
            zaladowanie = random.nextInt(maxLadownosc);
            try {
                PromKosmiczny obyNieChallenger = new PromKosmiczny(iloscTlenu,iloscZalogi,miejscePrzylotu,maxLadownosc,zaladowanie);
                mapaRakiet.put(i,obyNieChallenger);
            } catch (WyjatekTransportu wyjatekTransportu) {
                wyjatekTransportu.printStackTrace();
                i--;
            }
        }
        System.out.println(mapaRakiet.keySet());
        for (int j:mapaRakiet.keySet()) {
            listaRakiet.add(mapaRakiet.get(j));
        }
        System.out.println(listaRakiet);
        System.out.println("----------W KOSMOSIE----------------");
        //todo pkt 6
        int dniPozaZiemia = 0;
        while(!listaRakiet.isEmpty()){
            Set <PromKosmiczny> doWyrzucenia = new HashSet<>();
            for(PromKosmiczny aktProm:listaRakiet){
                try {
                    aktProm.zuzycieTlenu(70);
                    int aktStanTlenu = aktProm.getIloscTlenu();
                } catch (WyjatekBrakTlenu wyjatekBrakTlenu) {
                    wyjatekBrakTlenu.printStackTrace();
                    doWyrzucenia.add(aktProm);
                }
                try {
                    losowyWypadek(10);
                } catch (WyjatekKolizja wyjatekKolizja) {
                    wyjatekKolizja.printStackTrace();
                } catch (WyjatekUsterka wyjatekUsterka) {
                    wyjatekUsterka.printStackTrace();
                }
                aktProm.setDniPozaZiemia(aktProm.getDniPozaZiemia()+1);
            }
            /*
            Może trochę wytłumaczę się z tego co poniżej.
            Początkowo próbowałem wyrzucać rakiety, którym skończył się tlen bezpośrednio podczas przechodzenia iteratorem, ale skutkowało to konfliktami i konkurentnymi modyfikacjami,
            w efekcie czego dostawałem błąd przy wykonywaniu.
            Uznałem więc, że lepiej będzie te rakiety, które trzeba wyrzucić z listy, wrzucić do seta a następnie usunąć je w oddzielnej pętli, unikając konfliktów.
             */
            System.out.println(doWyrzucenia);
            for (PromKosmiczny j:doWyrzucenia) {
                listaRakiet.remove(j);
            }
            System.out.println("---------" + ++dniPozaZiemia + " dzien poza Ziemia, raport pozostałych rakiet" +"---------");
            System.out.println(listaRakiet);
        }

    }

    static void losowyWypadek(int prawdopodobienstwo) throws WyjatekUsterka{
        Random rand = new Random();
        if (rand.nextInt(101) < prawdopodobienstwo) {
            switch (rand.nextInt(2)) {
                case 0 -> throw new WyjatekKolizja("Zderzenie z Marsjanami, bez paniki");
                case 1 -> throw new WyjatekUsterka("Problem z silnikiem grawitacyjnym, na zwykłym będziemy lecieć 1353 lata…");
            }
        }
    }
}
