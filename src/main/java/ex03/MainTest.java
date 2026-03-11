package ex03;

import ex02.View;

public class MainTest {

    public static void main(String[] args) {
        ViewableTable factory = new ViewableTable();
        View view = factory.getView();

        System.out.println("Initialization");
        view.viewInit();
        view.viewShow();

        try {
            System.out.println("\nTest case: Serialization & Deserialization");
            view.viewSave();
            System.out.println("Save successful");

            view.viewRestore();
            System.out.println("Current state:");
            view.viewShow();

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }

        System.out.println("\nTesting finished.");
    }
}
