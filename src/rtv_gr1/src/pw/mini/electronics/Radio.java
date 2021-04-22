package rtv_gr1.src.pw.mini.electronics;

import java.time.LocalDate;
import java.util.Random;

public final class Radio extends RtVDevice implements Soundable, Receiver {
    public Radio(LocalDate productionDate, boolean on, Frequency frequency) {
        super(productionDate, on);
        this.frequency = frequency;
    }

    public Radio() {
    }

    public Frequency getFrequency() {
        return frequency;
    }

    Frequency frequency;
    @Override
    public void setWavesLength(int length) {
        if (length >= 1 && length <= 10){
            frequency = Frequency.UHF;
        }
        else if (length >= 10 && length <= 200){
            frequency = Frequency.SHORT;
        }
        else if (length >= 200 && length <= 1000){
            frequency = Frequency.MEDIUM;
        }
        else if (length >= 1000 && length <= 20000){
            frequency = Frequency.LONG;
        }
    }

    @Override
    public void turnOn(){
        if (this.turnOnNumber == 0){
            System.out.println("Device is broken!");
        }
        this.on = true;
        turnOnSound();
        setWavesLength(new Random().nextInt(20000));
    }

    @Override
    public void turnOff(){
        this.on = false;
        turnOffSound();
    }
}

