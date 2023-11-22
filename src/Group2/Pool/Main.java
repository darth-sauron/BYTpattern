package Group2.Pool;

public class Main {
    public static void main(String[] args) {

        Pool wires = new Pool();


        Wire connection1 = wires.askForConnection();
        connection1.sendTelegram("I am using connection1 wire");

        Wire connection2 = wires.askForConnection();
        connection2.sendTelegram("I am using connection2 wire");


        wires.printStatus();
        wires.releaseConnection(connection1);


        Wire connection3 = wires.askForConnection();
        connection3.sendTelegram("I am using connection3 wire");


        wires.printStatus();
    }
}
