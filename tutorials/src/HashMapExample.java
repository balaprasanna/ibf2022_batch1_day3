import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        
        HashMap<String, ArrayList<String>> usermap = new HashMap<String , ArrayList<String>>();

        usermap.put("bala", new ArrayList<String>(Arrays.asList("item1", "item2")));
        usermap.put("fred", new ArrayList<String>());
        usermap.put("ken", new ArrayList<String>());


        // Key / Value type
        // String, Interger
        HashMap<String, Integer> mymap = new 
        HashMap<String, Integer>();

        // add a key, value pair to it
        mymap.put("bala", 30);
        mymap.put("ken", 40);
        
        String key = "bala";
        System.out.println("Value for key = " + key + " -> " + mymap.get(key));

        mymap.put("bala", 31);
        System.out.println("New Value for key = " + key + " -> " + mymap.get(key));

        // check if a key exisits in map
        System.out.println("check if fred exits: " + mymap.containsKey("fred"));

        // usermap.get("bala").remove("item1");
    }
}
