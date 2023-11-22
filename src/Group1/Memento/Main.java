package Group1.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Block> blocks = new ArrayList<>();
        boolean exit = false;

        while (!exit){
            System.out.println("""
                    Menu:
                    1-Create new block
                    2-Change existing block
                    3-Exit
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Please provide the title -> ");
                    String title = scanner.nextLine();
                    Block newBlock = new Block(title);
                    blocks.add(newBlock);
                    System.out.println("The block has been created!");
                }
                case "2" -> {
                    System.out.println("Input the title of the block you wish to change-> ");
                    String title = scanner.nextLine();
                    for (int i = 0; i < blocks.size(); i++) {
                        if (blocks.get(i).getTitle().equals(title)) {
                            TextEditor editor = new TextEditor(blocks.get(i));
                            Memento memento = editor.createMemento();

                            System.out.println("""
                                    Choose 1 or 2:
                                    1-Edit existing text
                                    2-Add a new line
                                    """);
                            String option = scanner.nextLine();
                            if (option.equals("1")) {
                                blocks.set(i, editor.changeBlock());

                                System.out.println("This is your block now:");
                                blocks.get(i).getBlock();

                                System.out.println("Do you wish to go back to how it was before? Yes/No");
                                String answer = scanner.nextLine();

                                if (answer.equals("No")) {
                                    System.out.println("Great, changes saved!");
                                } else if (answer.equals("Yes")) {
                                    editor.restore(memento);
                                    blocks.set(i, editor.getBlock());
                                } else System.out.println("Wrong answer");
                            } else if (option.equals("2")) {
                                blocks.set(i, editor.addLine());

                                System.out.println("This is your block now:");
                                blocks.get(i).getBlock();

                                System.out.println("Do you wish to go back to how it was before? Yes/No");
                                String answer = scanner.nextLine();

                                if (answer.equals("No")) {
                                    System.out.println("Great, changes saved!");
                                } else if (answer.equals("Yes")) {
                                    editor.restore(memento);
                                    blocks.set(i, editor.getBlock());
                                } else System.out.println("Wrong answer");
                            } else
                                System.out.println("Wrong choice");
                        }
                    }
                }
                case "3" -> {
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
