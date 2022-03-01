import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Restaurant restaurant = new Restaurant(askNameRestaurant());
            while (restaurant.howManyClientsWeHave() < restaurant.getCapacity()) {
                addClients(restaurant);
            }
            if (wantToCleanTable()) {
             cleanTable(restaurant);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void cleanTable(Restaurant restaurant) throws Exception {

            showClientsInRestaurant(restaurant);
            restaurant.cleanTable();
            showClientsInRestaurant(restaurant);

    }

    private static boolean wantToCleanTable() {
        System.out.println("Want to clean any table?");
        return new Scanner(System.in).nextLine().equalsIgnoreCase("S");
    }


    private static void showClientsInRestaurant(Restaurant restaurant) {
        for (Table currentTable : restaurant.getTables()) {
            System.out.println(currentTable);

        }
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
