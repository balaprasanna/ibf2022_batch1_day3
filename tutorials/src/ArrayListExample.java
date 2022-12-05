import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        
        System.out.println("Array List Demo");

        // Create an ArrayList object
        ArrayList<String> mylist = new ArrayList<String>();
        
        // Add items to it
        mylist.add("apples");
        mylist.add("oranges");

        // Loop over and print the items
        for (String item : mylist) {
            System.out.println("Item -> " + item);
        }

        // Remove "apples" from this list
        mylist.remove("apples");
        
        // Print the no of item inside the list
        int count = mylist.size();
        System.out.println(count);
    }    
}