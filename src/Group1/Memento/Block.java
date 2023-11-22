package Group1.Memento;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private List<String> lines = new ArrayList<>();
    private String title;

    public String getTitle() {
        return title;
    }


    public Block(String title){
        this.title = title;
    }

    public void addLine(String line){
        if(!line.isBlank())
           this.lines.add(line);
    }

    public void changeLine(int num, String newLine){
        if(this.lines.size() > num)
           this.lines.set(num, newLine);
        else
            System.out.println("Wrong Line");
    }

    public void getBlock(){
        System.out.println("------" + this.title + "-------");
        this.lines.forEach(System.out::println);
        System.out.println("\n------End Of Text-------");
    }
}
