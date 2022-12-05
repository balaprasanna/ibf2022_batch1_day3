import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartDB {

    public static final List<String> VALID_COMMANDS = Arrays.asList(
        "login", "add", "list", "exit", "users");

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


}
