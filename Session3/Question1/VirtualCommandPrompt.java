package Session3.Question1; 

import java.util.*;

class VirtualCommandPrompt {
    private static final String ROOT = System.getProperty("user.dir");
    private static Directory currentDirectory = new Directory(ROOT, null);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        while (true) {
            System.out.print(currentDirectory.getPath() + ">");
            // take input
            String input = scanner.nextLine().trim();
            String[] commandParts = input.split(" ", 2);
            String command = commandParts[0].toLowerCase();
            String argument = commandParts.length > 1 ? commandParts[1] : null;

            try {
                switch (command) {
                    case "mkdir":
                        if (argument != null) {
                            currentDirectory.addSubDirectory(argument);
                        } else {
                            System.out.println("Invalid command. Usage: mkdir <directory_name>");
                        }
                        break;
                    case "cd":
                        if (argument != null) {
                            currentDirectory = currentDirectory.changeDirectory(argument);
                        } else {
                            System.out.println("Invalid command. Usage: cd <directory_name>");
                        }
                        break;
                    case "bk":
                        currentDirectory = currentDirectory.moveToParent();
                        break;
                    case "ls":
                        currentDirectory.listDirectories();
                        break;
                    case "find":
                        if (argument != null) {
                            currentDirectory.findDirectory(argument);
                        } else {
                            System.out.println("Invalid command. Usage: find <directory_name>");
                        }
                        break;
                    case "tree":
                        currentDirectory.displayTree("");
                        break;
                    case "exit":
                        System.out.println("Exiting Virtual Command Prompt.");
                        return;
                    default:
                        System.out.println("Command does not exist.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
