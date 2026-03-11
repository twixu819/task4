package ex03;
import ex02.Item2d;
import ex02.ViewResult;
import java.util.Formatter;

public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 50;
    private int width;

    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    private void outLine() {
        for (int i = width; i > 0; i--) System.out.print("-");
        System.out.println();
    }

    public void init(int width) {
        this.width = width;
        viewInit();
    }

    public void viewHeader() {
        outLine();
        System.out.printf("| %-10s | %-10s | %-15s |\n", "Voltage", "Resistance", "Current");
        outLine();
    }

    public void viewBody() {
        for (Item2d item : items) {
            System.out.printf("| %-10.1f | %-10.1f | %-15s |\n",
                    item.u, item.r, item.binaryI);
        }
    }

    public void viewFooter() {
        outLine();
    }
}
