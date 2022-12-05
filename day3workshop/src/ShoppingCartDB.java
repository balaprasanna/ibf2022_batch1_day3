import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartDB {

    public static final String LOGIN = "login";
    public static final String ADD = "add";
    public static final String LIST = "list";
    public static final String SAVE = "save";
    public static final String EXIT = "exit";
    public static final String USERS = "users";

    public static final List<String> VALID_COMMANDS = Arrays.asList(
        LOGIN, SAVE, ADD, LIST, USERS, EXIT);
    
    private CartDBInMemroy db;
    private String currentUser;
    private String baseFolder;

    public ShoppingCartDB() {
        this.baseFolder = "db"; // default
        this.setup();
        this.db = new CartDBInMemroy(this.baseFolder);
    }

    public ShoppingCartDB(String baseFolder) {
        this.baseFolder = baseFolder;
        this.setup();
        this.db = new CartDBInMemroy(this.baseFolder);
    }

    public void setup(){
        Path p = Paths.get(this.baseFolder);
        if (Files.isDirectory(p)) {
            // SKIP if directory already exits
        } else {
            try {
            Files.createDirectory(p);
            } catch (IOException e) {
                System.out.println("Error :" + e.getMessage());
            }
        }
    }

    public void startShell() {
        System.out.println("Welcome to MultiUser Shopping Cart >> ");
        Scanner sc =  new Scanner(System.in);
        String line;
        boolean stop = false;

        while (!stop) {
            line = sc.nextLine();
            line = line.trim();
            System.out.println("=> " + line);
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Exiting !!!");
                stop = true;
            }
            // Validate Command
            if (!this.ValidateInput(line)) {
                System.out.println("Invalid Input: ^^");
            } else {
                System.out.println("Processing : " + line);
                this.ProcessInput(line);
            }
            
        }
        sc.close();
    }
    public boolean ValidateInput(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].trim();
        // Scanner lsc = new Scanner(input);
        // String commad = lsc.next().trim()
        return VALID_COMMANDS.contains(command);
    }

    // Process command
    public void ProcessInput(String input) {
        Scanner sc  = new Scanner(input);
        String command = sc.next().trim();

        switch (command) {
            case LOGIN:
                String username = sc.nextLine().trim();
                this.LoginAction(username);
                System.out.println("Print - current logged in user" + this.currentUser);
                break;

            case LIST:
                this.ListAction();
                break;

            case ADD:
                String[] items = sc.nextLine().trim().split(",");
                this.AddAction(items);
                break;

            case SAVE:
                this.SaveAction();
                break;

            case USERS:
                break;

            default:
                break;
        }

        sc.close();
    }

    public void LoginAction(String username) {
        if (!this.db.userMap.containsKey(username)) {
            this.db.userMap.put(username, new ArrayList<String>());
        }
        this.currentUser = username;
    }

    public void AddAction(String[] items) {
        for (String item : items) {
            this.db.userMap.get(this.currentUser).add(item.trim());
        }
    }

    public void ListAction() {
        for (String item : this.db.userMap.get(this.currentUser)) {
            System.out.println("Item -> " + item);
        }
    }

    public void SaveAction() {        
        // Prepare the filePath = "db/<username>.db"
        String outputFilename = String.format("%s/%s.db", 
        this.baseFolder, this.currentUser);

        try {
            FileWriter fw = new FileWriter(outputFilename);
            // Save the contents for this user in Map to a file.
            for (String item : this.db.userMap.get(this.currentUser)) {
                fw.write(item +"\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
    }

}
