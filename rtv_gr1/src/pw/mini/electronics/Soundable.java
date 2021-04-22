package rtv_gr1.src.pw.mini.electronics;

public interface Soundable {

    public default void turnOnSound() {
        System.out.println("Sound turned on");
    }

    public default void turnOffSound() {
        System.out.println("Sound turned off");
    }

}
