package rtv_gr1.src.pw.mini.electronics;

public interface Viewable {
    public default void turnOnPicture() {
        System.out.println("Picture turned on");
    }

    public default void turnOffPicture() {
        System.out.println("Picture turned off");
    }
}
