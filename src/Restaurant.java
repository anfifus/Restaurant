import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int LIMIT_CAPACITY = 24;
    private static int LIMIT_TABLE = 4;
    private final String name;
    private int capacity;
    private List<Table> tables = new ArrayList<>();

    public Restaurant(String name) throws Exception {
        checkName(name);
        this.name = name;
        this.capacity = LIMIT_CAPACITY;
    }

    private void checkName(String nameRestaurant) throws Exception {
        if (nameRestaurant == null || nameRestaurant.equals("")) {
            throw new Exception("The name of the restaurant is null or don't have any name");
        }

    }

    public void addUser(int clients) throws Exception {

        if (tables.size() <= LIMIT_TABLE - 1) {
            addClients(clients);
        } else {
            throw new Exception("Max capacity reached");
        }
    }

    private void addClients(int waitingClients) throws Exception {
        if (waitingClients != 0) {
            if (hasSpace(waitingClients)) {
                while (waitingClients > 0) {
                    if (haveEnoughTable())
                        waitingClients = addAsMuchClientsWeWant(waitingClients);
                    else
                        throw new Exception("Error we are using more tables than we have");
                }
            } else {
                throw new Exception("We don't have more space to get more people");
            }
        } else {
            throw new Exception("We didn't get any client");
        }
    }

    private boolean haveEnoughTable() {
        return LIMIT_TABLE > tables.size();
    }

    private int addAsMuchClientsWeWant(int waitingClients) throws Exception {
        Table table = new Table();
        waitingClients = table.addClient(waitingClients);
        tables.add(table);
        return waitingClients;
    }

    public boolean hasSpace(int client) {
        return LIMIT_CAPACITY >= (howManyClientsWeHave() + client);
    }

    public int getCapacity() {
        return capacity;
    }

    public int howManyClientsWeHave() {
        int totalClients = 0;
        if (tables != null) {
            for (Table currentTable : this.tables) {
                totalClients += currentTable.getClients();
            }
        }

        return totalClients;
    }

    public List<Table> getTables() {
        return tables;
    }

    public int cleanTable(int numTable) throws Exception {
        if (!tables.isEmpty() && numTable < tables.size())
            tables.remove(numTable);
        else
            throw new Exception("Error the table doesn't exist");
        return numTable;
    }


}
