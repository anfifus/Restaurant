import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Restaurant restaurant = new Restaurant(askNameRestaurant());
            while (checkCapacity(restaurant)) {
                addClients(restaurant);
                if (wantToCleanTable()) {
                    onCostumerLeave(restaurant);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean checkCapacity(Restaurant restaurant) {
        return restaurant.howManyClientsWeHave() < restaurant.getCapacity();
    }

    private static void onCostumerLeave(Restaurant restaurant) throws Exception {
        showClientsInRestaurant(restaurant);
        int numTable = whichTableWantToClean();
        restaurant.cleanTable(numTable);
        showClientsInRestaurant(restaurant);
    }

    private static int whichTableWantToClean() {
        System.out.println("Which table want to clean?");
        return new Scanner(System.in).nextInt();
    }

    private static boolean wantToCleanTable() {
        System.out.println("Want to clean any table?");
        return new Scanner(System.in).nextLine().equalsIgnoreCase("S");
    }


    private static void showClientsInRestaurant(Restaurant restaurant) {
        int cont = 0;
        for (Table currentTable : restaurant.getTables()) {
            System.out.println("Table " + cont + ": " + currentTable);
            cont++;
        }
        System.out.println("\n");
    }

    private static void addClients(Restaurant restaurant) throws Exception {
        int clients = askHowManyClients();
        restaurant.addUser(clients);

    }


    private static String askNameRestaurant() {
        System.out.println("What is the name of the restaurant?");
        String nameRestaurant = new Scanner(System.in).nextLine();
        return nameRestaurant;

    }

    private static int askHowManyClients() {
        System.out.println("Put the number of clients we have");
        return new Scanner(System.in).nextInt();
    }
}
