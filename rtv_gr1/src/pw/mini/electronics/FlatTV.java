package rtv_gr1.src.pw.mini.electronics;

import java.time.LocalDate;

public class FlatTV extends TvSet implements ExtendedReceiver {
    ScreenType screen;

    public FlatTV() {
        screen = null;
    }

    public FlatTV(double diagonal, SignalType signalType, int channel, ScreenType screen) {
        super(diagonal, signalType, channel);
        this.screen = screen;
    }

    public FlatTV(LocalDate productionDate, boolean on, double diagonal, SignalType signalType, int channel, ScreenType screen) {
        super(productionDate, on, diagonal, signalType, channel);
        this.screen = screen;
    }

    @Override
    public void receiveSignal(SignalType setSignal) {
        signalType = setSignal;
    }

    @Override
    public String toString() {
        return "FlatTV{" +
                "screen=" + screen +
                ", productionDate=" + productionDate +
                ", Name='" + Name + '\'' +
                ", on=" + on +
                ", gen=" + gen +
                ", turnOnNumber=" + turnOnNumber +
                ", diagonal=" + diagonal +
                ", signalType=" + signalType +
                ", channel=" + channel +
                '}';
    }

    @Override
    public void repair(){
        System.out.println("You can't repair flat TV's!");
    }
}

enum ScreenType{LCD,LED,PLASMA;}
