import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class phonebook {

    private static HashMap<String, ArrayList> contacts = new HashMap();

    public static void addContact(String name, String phoneNumber) {
        if(contacts.containsKey(name)){
            ArrayList phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        } else{
            ArrayList phoneNumbers = new ArrayList();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }
    public static void printContacts() {
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String,ArrayList> o1, Map.Entry<String, ArrayList> o2){
                return o2.getValue().size() - o1.getValue().size();
            }
        });

        for(Map.Entry<String, ArrayList> entry : list){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addContact("Иванов", "113-23-45");
        addContact("Баранов", "115-23-45");
        addContact("Козлов", "113-23-46");
        addContact("Петров", "223-23-45");
    }
}

