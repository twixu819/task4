package ex02;
import java.util.ArrayList;
import java.io.*;

public class ViewResult implements View {
    private static final String FNAME = "items.bin";
    protected ArrayList<Item2d> items = new ArrayList<Item2d>();

    public ViewResult() { }

    public ArrayList<Item2d> getItems() {
        return items;
    }

    public void viewInit() {
        double u = 220.0;
        double[] rs = {10.0, 20.0, 50.0, 100.0};
        items.clear();
        for (double r : rs) {
            Item2d item = new Item2d(u, r);
            item.binaryI = Integer.toBinaryString((int)(u / r));
            items.add(item);
        }
    }

    public void viewSave() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FNAME));
        out.writeObject(items);
        out.close();
    }

    public void viewRestore() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) in.readObject();
        in.close();
    }

    public void viewHeader() { System.out.println("Results: "); }
    public void viewFooter() { System.out.println("End"); }
    public void viewBody() {
        for (Item2d item : items) {
            System.out.println("U=" + item.u + " R=" + item.r + " I=" + item.binaryI);
        }
    }
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
