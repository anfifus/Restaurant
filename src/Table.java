public class Table {

    private int clients;
    private static int MAX_CLIENTS = 6;
    private int waitingClients;

    public Table() {
    }

    public Table(int clients) throws Exception {
        checkClients(clients);
        if (checkClientsMoreThan6(clients))
            this.clients = clients;
        else {
            throw new Exception("You can't have a table with more than 6 clients");
        }

    }

    private boolean checkClientsMoreThan6(int clients) {
        return clients <= MAX_CLIENTS;
    }

    private void checkClients(int clients) throws Exception {
        if (clients == 0) throw new Exception("If we ask the number of clients is because we have");

    }

    public int getWaitingClients() {
        return waitingClients;
    }

    public int getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return clients + " persons";
    }

    public int addClient(int client) {
        this.clients = client;
        if (client > MAX_CLIENTS) {
            this.clients = MAX_CLIENTS;

        }

        return client - this.clients;
    }
}
