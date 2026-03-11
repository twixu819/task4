package ex02;
import java.io.Serializable;

public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    public double u;
    public double r;
    public transient String binaryI;

    public Item2d() { u = 0; r = 0; }
    public Item2d(double u, double r) {
        this.u = u;
        this.r = r;
    }
}
