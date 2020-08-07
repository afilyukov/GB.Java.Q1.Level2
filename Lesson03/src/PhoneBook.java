import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> records;

    public PhoneBook() {
        this.records = new HashMap<>();
    }

<<<<<<< HEAD
    public void add(String surname, String number) {
        if (records.containsKey(surname)) {
            records.get(surname).add(number);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(number);
            records.put(surname, numbers);
        }
    }

    public Set<String> get(String surname) {
        if (records.containsKey(surname)) {
            return records.get(surname);
=======
    public void add(String name, String number) {
        if (records.containsKey(name)) {
            records.get(name).add(number);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(number);
            records.put(name, numbers);
        }
    }

    public Set<String> get(String name) {
        if (records.containsKey(name)) {
            return records.get(name);
>>>>>>> origin/master
        }
        return new HashSet<>();
    }

}
