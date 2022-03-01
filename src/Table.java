public class Table {

    private int clients;
    private int counter;

    public Table(int counter, int clients) throws Exception{
        this.counter = counter;
        this.clients = clients;
    }


    public int getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Table " + counter +": " +
                clients + " persons";
    }
}
