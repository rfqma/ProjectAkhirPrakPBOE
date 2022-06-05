package PembayaranParkir;

public class Main {
    public static void main(String[] args) {
        ViewParkir vp = new ViewParkir();
        ModelParkir mp = new ModelParkir();
        ControllerParkir cp = new ControllerParkir(mp, vp);
    }
}
