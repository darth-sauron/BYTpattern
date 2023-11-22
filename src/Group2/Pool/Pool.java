package Group2.Pool;

import java.util.ArrayList;
import java.util.List;

public class Pool {
    private static final int POOL_SIZE = 3;
    private List<Wire> availableWires = new ArrayList<>();
    private List<Wire> inUseWires = new ArrayList<>();

    public Pool() {
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            availableWires.add(new Wire());
        }
    }

    public Wire askForConnection() {
        if (availableWires.isEmpty()) {

            Wire newWire = new Wire();
            inUseWires.add(newWire);
            return newWire;
        } else {

            Wire connection = availableWires.remove(availableWires.size() - 1);
            inUseWires.add(connection);
            return connection;
        }
    }

    public void releaseConnection(Wire connection) {
        inUseWires.remove(connection);
        availableWires.add(connection);
        System.out.println("released num " + connection.getId());
    }

    public void printStatus() {
        System.out.println("Available wires: " + availableWires.size());
        System.out.println("In-use connections: " + inUseWires.size());
    }
}
