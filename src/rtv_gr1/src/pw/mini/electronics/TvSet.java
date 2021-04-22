package rtv_gr1.src.pw.mini.electronics;

import java.util.Random;
import java.time.LocalDate;

public abstract class TvSet extends RtVDevice implements Soundable, Viewable{
    double diagonal;
    SignalType signalType;
    int channel;

    public TvSet() {
    }

    public TvSet(double diagonal, SignalType signalType, int channel) {
        super();
        this.diagonal = diagonal;
        this.signalType = signalType;
        this.channel = channel;
    }

    public TvSet(LocalDate productionDate, boolean on, double diagonal, SignalType signalType, int channel) {
        super(productionDate, on);
        this.diagonal = diagonal;
        this.signalType = signalType;
        this.channel = channel;
    }

    @Override
    public void setWavesLength(int channelNumber) {
        if (channelNumber >= 0 && channelNumber < 100)  channel = channelNumber;
    }
    @Override
    public void turnOn(){
        if (this.turnOnNumber == 0){
            System.out.println("Device is broken!");
        }
        this.on = true;
        turnOnPicture();
        turnOnSound();
        channel = new Random().nextInt(99);
    }

    @Override
    public void turnOff() {
        super.turnOff();
        turnOffSound();
        turnOffPicture();
    }
}

