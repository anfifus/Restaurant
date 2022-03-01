import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private static int LIMIT_CAPACITY = 24;
    private String name;
    private int capacity;
    private List<Table> tables = new ArrayList<>();
    private int clients;

    public Restaurant(String name) throws Exception {
        checkName(name);
        this.name = name;
        this.capacity = LIMIT_CAPACITY;
    }

    private void checkName(String nameRestaurant) throws Exception{
        if (nameRestaurant == null || nameRestaurant.equals("")) {
            throw new Exception("The name of the restaurant is null or don't have any name");
        }

    }
    public void addUser(int users) throws  Exception{
        if (hasSpace(users)) {
            tables.add(new Table(tables.size(),users));
        }
        else {
            throw new Exception("Max capacity reached");
        }
    }

    public boolean hasSpace(int client) {
        return  LIMIT_CAPACITY >= (howManyClientsWeHave() +client);
    }
    public int getCapacity() {
        return capacity;
    }

    public int howManyClientsWeHave() {
        int totalClients = 0;
        if(tables != null){
            for (Table currentTable : this.tables) {
                totalClients +=currentTable.getClients();
            }
        }

        return totalClients;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void cleanTable() throws Exception{
        int numTable = whichTableWantToClean();
        if(!tables.isEmpty() && numTable < tables.size())
            tables.remove(numTable);
        else
            throw new Exception("Error the table doesn't exist");
    }
    private int whichTableWantToClean() {
        System.out.println("Which table want to clean?");
        return new Scanner(System.in).nextInt();
    }
}
