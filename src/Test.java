/**
 * Created by Кот on 09.11.2016.
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        AddressBook addressBook= new AddressBook();
        addressBook.addRecord(1,"Pete","88005552525");
        addressBook.addRecord(2,"Ivan","9087-23732312");
        System.out.println(addressBook.allRecords());
        while (true) {
            addressBook.search();
        }


            }
}
