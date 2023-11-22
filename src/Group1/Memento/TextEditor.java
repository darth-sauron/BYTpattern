package Group1.Memento;

import java.util.Scanner;

public class TextEditor {


    private Block block;
    Scanner scanner = new Scanner(System.in);

    public TextEditor(Block block){
        this.block = block;
        System.out.println("You are now in editor mode");
    }
    public Block getBlock() {
        return block;
    }
    public Block changeBlock(){
        System.out.println("Below is the block, please choose the line you would like to change" +
                " starting with 0");
        this.block.getBlock();

        System.out.println("Input the number here -> ");
        int num = scanner.nextInt();
        System.out.println("Input the new line you wish to see there -> ");
        String newText = scanner.nextLine();

        this.block.changeLine(num, newText);
        return this.block;
    }
    public Block addLine(){
        System.out.println("Input the line you wish to appear at the end of the text-> ");
        String newLine = scanner.nextLine();
        this.block.addLine(newLine);
        return this.block;
    }
    public Memento createMemento() {
        System.out.println("Previous version has been saved");
        return new Memento(block);
    }
    public void restore(Memento memento) {
        block = memento.getSaved();
    }

}
