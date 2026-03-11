package ex02;
import java.io.*;

public class Main {
    protected View view;
    public Main(View view) { this.view = view; }

    public void menu() {
        String s = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Enter command q-quit, v-view, g-generate, s-save, r-restore: ");
            try {
                s = in.readLine();
            } catch (IOException e) {
                System.out.println("Input Error");
            }
            if (s == null || s.length() == 0) continue;

            char command = s.charAt(0);
            if (command == 'q') {
                System.out.println("Exit.");
            } else if (command == 'v') {
                view.viewShow();
            } else if (command == 'g') {
                view.viewInit();
                view.viewShow();
            } else if (command == 's') {
                try {
                    view.viewSave();
                    System.out.println("Serialization successful");
                } catch (IOException e) {
                    System.out.println("Serialization error");
                }
            } else if (command == 'r') {
                try {
                    view.viewRestore();
                    view.viewShow();
                    System.out.println("Deserialization successful");
                } catch (Exception e) {
                    System.out.println("Deserialization error");
                }
            } else {
                System.out.println("Unknown command");
            }
        } while (s.charAt(0) != 'q');
    }

    public static void main(String[] args) {
        Main app = new Main(new ViewableResult().getView());
        app.menu();
    }
}
