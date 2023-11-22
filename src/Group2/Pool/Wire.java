package Group2.Pool;

public class Wire {
    private static int counter = 0;
    private int id;
    public int getId() {
        return id;
    }



    public Wire() {
        this.id = ++counter;
        System.out.println("Created wire num" + id);
    }

    public void sendTelegram(String telegram) {
        System.out.println("Sedning:  '" + telegram + "' on wire num" + id);
    }

    public void close() {
        System.out.println("Closed connection num" + id);
    }
}
