import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String menuPrompt = "A - Add D - Delete I - Insert P - Print Q - Quit";
        boolean running = true;
        String item = "";
        String cmd = "";
        String quitYN = "";
        int userSelection;

        do {
            displayList();
            displayMenu();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdIiPpQq]");

            switch (cmd) {
                case "A":
                case "a":
                    addItem(in);
                    break;

                case "D":
                case "d":
                    deleteItem(in);
                    break;

                case "I":
                case "i":
                    insertItem(in);
                    break;

                case "P":
                case "p":
                    printList();
                    break;

                case "Q":
                case "q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        running = false;
                    }
                    break;
            }
        } while (running);

        System.out.println("Program exited.");
    }

    public static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    public static void displayList() {
        System.out.println("\nCurrent List:");
        if (myArrList.size() == 0) {
            System.out.println("[The list is empty]");
        } else {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.printf("%3d. %s\n", i + 1, myArrList.get(i));
            }
        }
    }

    private static void addItem(Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add:");
        myArrList.add(item);
    }

    private static void deleteItem(Scanner in) {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        int itemNum = SafeInput.getRangeInt(in, "Enter the item number to delete", 1, myArrList.size());
        myArrList.remove(itemNum - 1);
        System.out.println("Item deleted.");
    }

    private static void insertItem(Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert:");
        int position = SafeInput.getRangeInt(in, "Enter the position to insert at", 1, myArrList.size() + 1);
        myArrList.add(position - 1, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        System.out.println("\nPrinting the list:");
        if (myArrList.isEmpty()) {
            System.out.println("[The list is empty]");
        } else {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.printf("%3d. %s\n", i + 1, myArrList.get(i));
            }
        }
    }
}
