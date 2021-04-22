package Task2.src.mini.promy;

import Task2.src.mini.obsluga.WyjatekBiznesowy;
import Task2.src.mini.obsluga.WyjatekTransportu;

public final class PromKosmiczny extends Rakieta{

    private int maxLadownosc;
    private int zaladowanie;

    public int getMaxLadownosc() {
        return maxLadownosc;
    }

    public int getZaladowanie() {
        return zaladowanie;
    }

    public PromKosmiczny(int iloscTlenu, int iloscZalogi, String miejscePrzylotu, int maxLadownosc, int zaladowanie) throws WyjatekTransportu {
        super(iloscTlenu, iloscZalogi, miejscePrzylotu);
        this.maxLadownosc = maxLadownosc;
        this.zaladowanie = zaladowanie;
        if (zaladowanie < maxLadownosc/2) throw new WyjatekBiznesowy("Dorzuccie jeszcze towaru");
    }

    @Override
    public String toString() {
        return super.toString() +
                " Na pokładzie promu mamy " + zaladowanie +
                " ton ładunku.";
    }
}
