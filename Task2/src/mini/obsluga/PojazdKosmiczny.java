package Task2.src.mini.obsluga;

public interface PojazdKosmiczny {
    int getIloscTlenu() throws WyjatekBrakTlenu;
    void zuzycieTlenu(int zuzytyTlen);
}
