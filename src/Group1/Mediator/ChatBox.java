package Group1.Mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatBox implements Mediator{
    private List<Client> clientList = new ArrayList<>();
    public void addClients(Client client){
       this.clientList.add(client);
        System.out.println("A client has been added to the chat");
    }
    @Override
    public void sendText(String text, Client client) {
        for (Client participant : clientList)
            if(participant != client)
                participant.getText(client, text);
    }
}
