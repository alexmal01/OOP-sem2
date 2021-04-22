package rtv_gr1.src.pw.mini.electronics;

public class CrtTV extends TvSet {
    IsColour colour;

    public CrtTV() {
    }

    public CrtTV(double diagonal, SignalType signalType, int channel, IsColour colour) {
        super(diagonal, signalType, channel);
        this.signalType = SignalType.ANALOGUE;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "CrtTV{" +
                "signalType=" + signalType +
                ", colour=" + colour +
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
    public void setWavesLength(int length) {
        System.out.println("No analogue signal!");
    }
}

enum IsColour {BLACK_AND_WHITE, COLOR}
