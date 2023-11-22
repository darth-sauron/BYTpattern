package Group1.Mediator;

import java.util.Scanner;

public class Client {
    private String userName;
    private Mediator mediator;

    public Client(String userName, Mediator mediator){
        this.userName = userName;
        this.mediator = mediator;
    }

    public void sendText(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        mediator.sendText(text, this);
    }

    public void getText(Client sender, String text){
        System.out.println("I am " + this.userName + " and I've got a message from " +
                sender.getUserName() + " :[" + text + "]");
    }

    public String getUserName(){
        return this.userName;
    }
}
