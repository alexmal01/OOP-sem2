package rtv_gr1.src.pw.mini.electronics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class RtVDevice implements Receiver{
    LocalDate productionDate;
    String Name;
    static final int nameLength = 5;
    static int serialNumber = 1;
    boolean on;
    Random gen = new Random();
    int turnOnNumber;

    public RtVDevice(LocalDate productionDate, boolean on) {
        this.productionDate = productionDate;
        Name = nameGenerator(nameLength) + '_' + serialNumber;
        serialNumber = serialNumber + 1;
        this.on = on;
        this.turnOnNumber = gen.nextInt(10) + 1;
    }

    public RtVDevice() {
        productionDate = null;
        Name = "";
        on = false;
        turnOnNumber = 0;
    }

    /**
     * Generuje losową nazwę o podanej ilości znaków
     * @param numberOfLetters długość generowanej nazwy
     * @return String z losową nazwą
     */
    private String nameGenerator(int numberOfLetters){
        String letters = "ABCDEFGHIJKLMNOPQRSTUWYXZ";
        StringBuilder name = new StringBuilder("");
        Random rand = new Random();
        for (int i = 0; i < numberOfLetters; i++) {
            name.append(letters.charAt(rand.nextInt(letters.length())));
        }
        return name.toString();
    }

    public void turnOn(){
        if (this.turnOnNumber == 0){
            System.out.println("Device is broken!");
        }
        this.on = true;
    }

    public void turnOff(){
        this.on = false;
    }

    public void repair(){
        this.turnOnNumber = gen.nextInt(10) + 1;
    }
}
