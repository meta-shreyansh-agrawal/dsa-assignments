package Session3.Question1; 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Directory {
    private final String name;
    private final Directory parent;
    private final Map<String, Directory> subDirectories = new LinkedHashMap<>();
    private final LocalDateTime creationTime;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.creationTime = LocalDateTime.now();
    }

    public String getPath() {
        return parent == null ? name : parent.getPath() + "\\" + name;
    }

    public void addSubDirectory(String name) {
        if (subDirectories.containsKey(name)) {
            throw new RuntimeException("Directory already exists: " + name);
        }
        subDirectories.put(name, new Directory(name, this));
        System.out.println("Directory created: " + name);
    }

    public Directory changeDirectory(String name) {
        if (!subDirectories.containsKey(name)) {
            throw new RuntimeException("Directory does not exist: " + name);
        }
        return subDirectories.get(name);
    }

    public Directory moveToParent() {
        if (parent == null) {
            throw new RuntimeException("Already at the root directory.");
        }
        return parent;
    }

    public void listDirectories() {
        if (subDirectories.isEmpty()) {
            System.out.println("No subdirectories found.");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Map.Entry<String, Directory> entry : subDirectories.entrySet()) {
            System.out.println(entry.getKey() + " - Created at: " + entry.getValue().creationTime.format(formatter));
        }
        System.out.println("Total subdirectories: " + subDirectories.size());
    }

    public void findDirectory(String name) {
        if (subDirectories.containsKey(name)) {
            System.out.println("Directory found: " + getPath() + "\\" + name);
            return;
        }
        for (Directory dir : subDirectories.values()) {
            dir.findDirectory(name);
        }
    }

    public void displayTree(String prefix) {
        System.out.println(prefix + "\u2514\u2500 " + name);
        Iterator<Directory> iterator = subDirectories.values().iterator();
        while (iterator.hasNext()) {
            Directory dir = iterator.next();
            dir.displayTree(prefix + (iterator.hasNext() ? "\u251c\u2500 " : "\u2514\u2500 "));
        }
    }
}