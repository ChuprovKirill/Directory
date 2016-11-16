/**
 * Created by Кот on 09.11.2016.
 */

import java.io.InputStreamReader;
import java.util.*;

import org.w3c.dom.ranges.RangeException;
class AddressBook {
    private Map<Long, Person> records = new HashMap<Long, Person>();
    private long nextId;

    private long getNextId() {
        if (nextId < Long.MAX_VALUE && !records.containsKey(nextId))
            return nextId++;
        nextId = 0;
        while (nextId < Long.MAX_VALUE) {
            if (!records.containsKey(nextId))
                return nextId;
            ++nextId;
        }
        throw new RangeException((short) 111, "No more IDs availiable");
    }

    public Person addRecord(long id, String phone, String name)
            throws CloneNotSupportedException {
        long recordId = getNextId();
        Person record = new Person(id, phone, name);
        records.put(id, record);
        return (Person) record.clone();
    }

    public Person getRecord(long id) throws CloneNotSupportedException {
        if (records.containsKey(id))
            return (Person) records.get(id).clone();
        return null;
    }

    public Person getName(String name) {
        if (records.containsValue(name))
            return (Person) records.get(name);

        return null;
    }

    public Person updateRecord(long id, String phone, String name)
            throws CloneNotSupportedException {
        Person record = new Person(id, phone, name);
        records.put(id, record);
        return getRecord(id);
    }

    public void removeRecord(long id) {
        records.remove(id);
    }

    public List<Person> allRecords() {
        List<Person> result = new ArrayList<Person>();
        for (Person record : this.records.values())
            result.add(record);
        return result;
    }

    public String search() {


        System.out.println("Enter a name");
        Scanner in = new Scanner(System.in);
        String finding = in.next();
        for (Person person : records.values())
            if (person.getName().equals(finding)) System.out.println("Found" + " " + person);




        return finding;
    }

    }







