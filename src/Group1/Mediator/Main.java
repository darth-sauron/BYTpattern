package Group1.Mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ChatBox chatBox = new ChatBox();
        boolean exit = false;

        Map<String, Client> clientMap = new HashMap<>();

        Client client1;
        Client client2;
        Client client3;

        System.out.println("Please choose one client you want to be");
        System.out.println("-1");
        System.out.println("-2");
        System.out.println("-3\n");

        String choice = scanner.nextLine();
        System.out.println("Choose username:\n");
        String name = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                client1 = new Client(name, chatBox);
                chatBox.addClients(client1);
                clientMap.put("preferred", client1);

                client2 = new Client("client 2", chatBox);
                client3 = new Client("client 3", chatBox);
                chatBox.addClients(client2);
                chatBox.addClients(client3);
            }
            case "2" -> {
                client2 = new Client(name, chatBox);
                chatBox.addClients(client2);
                clientMap.put("preferred", client2);

                client1 = new Client("client 1", chatBox);
                client3 = new Client("client 3", chatBox);
                chatBox.addClients(client1);
                chatBox.addClients(client3);
            }
            case "3" -> {
                client3 = new Client(name, chatBox);
                chatBox.addClients(client3);
                clientMap.put("preferred", client3);

                client2 = new Client("client 2", chatBox);
                client1= new Client("client 1", chatBox);
                chatBox.addClients(client2);
                chatBox.addClients(client1);
            }
            default -> {
                System.out.println("Wrong choice");
                System.exit(0);
            }
        }

        while (!exit){
            System.out.println("""
                    Menu:
                    -1: Send message
                    -2: Exit""");

           String action = scanner.nextLine();
            switch (action) {
                case "1" -> {
                    System.out.println("Please input your message");
                    clientMap.get("preferred").sendText();
                }
                case "2" -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Wrong choice");
                    System.exit(0);
                }
            }
        }
    }
}
