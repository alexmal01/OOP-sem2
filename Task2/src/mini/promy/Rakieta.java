package Task2.src.mini.promy;

import Task2.src.mini.obsluga.PojazdKosmiczny;
import Task2.src.mini.obsluga.WyjatekBrakTlenu;
import Task2.src.mini.obsluga.WyjatekTransportu;

public abstract class Rakieta implements PojazdKosmiczny{

    private int iloscTlenu;
    private int iloscZalogi;
    private String miejscePrzylotu;
    private int dniPozaZiemia;
    final int utrataTlenu = 70;

    public Rakieta(int iloscTlenu, int iloscZalogi, String miejscePrzylotu) throws WyjatekTransportu {
        this.iloscTlenu = iloscTlenu;
        this.iloscZalogi = iloscZalogi;
        this.miejscePrzylotu = miejscePrzylotu;
        this.dniPozaZiemia = 0;
        if(iloscZalogi < 5) throw new WyjatekTransportu("Wczoraj kapitan mial urodziny, nie polecimy");
        if(iloscTlenu < 500) throw new WyjatekBrakTlenu("Mamy wyciek tlenu, polecimy, gdy tylko znajdzie sie tasma klejaca");
    }

    public int getIloscZalogi() {
        return iloscZalogi;
    }

    public String getMiejscePrzylotu() {
        return miejscePrzylotu;
    }

    public int getDniPozaZiemia() {
        return dniPozaZiemia;
    }

    public void setDniPozaZiemia(int dniPozaZiemia) {
        this.dniPozaZiemia = dniPozaZiemia;
    }

    public int getUtrataTlenu() {
        return utrataTlenu;
    }

    @Override
    public String toString() {
        return "Lecimy na " + miejscePrzylotu + " już " + dniPozaZiemia +
                " dzień. Pozostało " + iloscTlenu + " jednostek tlenu na " +
                iloscZalogi + " czlonków załogi.";
    }

    public void kolejnyDzien(){
        dniPozaZiemia++;
    }

    @Override
    public int getIloscTlenu() throws WyjatekBrakTlenu {
        if(iloscTlenu <= 100) throw new WyjatekBrakTlenu("Rakieta rozpoczęła przyspieszony powrót na Ziemię");
        return iloscTlenu;
    }

    @Override
    public void zuzycieTlenu(int zuzytyTlen) {
        iloscTlenu -= zuzytyTlen;
    }
}
