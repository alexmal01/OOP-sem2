package rtv_gr1.src.pw.mini.test;

import pw.mini.electronics.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main (String[] args){
        RtVDevice[] Tab = {new Radio(),new CrtTV(),new FlatTV()};
        for (RtVDevice device: Tab) {
            if (device instanceof CrtTV || device instanceof FlatTV){
                System.out.println(device);
            }
        }
        int date = LocalDate.of(1990,12,23).getYear();
        Radio radio = new Radio(LocalDate.of(1990,12,29),true,Frequency.MEDIUM);
        radio.setWavesLength(30);
        System.out.println(radio.getFrequency());
        radio.turnOff();
        radio.turnOn();
    }
}
