package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TriesContacts {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int n = scan.nextInt();
        final ContactDirectory contactDirectory = new ContactDirectory();
        for (int i = 0; i < n; i++) {
            final String operation = scan.next();
            final String contact = scan.next();
            if (operation.equals("add")) {
                contactDirectory.add(contact);
            } else if (operation.equals("find")) {
                contactDirectory.find(contact);
            }
        }
        scan.close();
    }

    private static class ContactDirectory {
        Map<String, Integer> contacts;

        ContactDirectory() {
            this.contacts = new HashMap<>();
        }

        void add(String contact) {
            String partialString;
            for (int i = 1; i <= contact.length(); i++) {
                partialString = contact.substring(0, i);
                if (this.contacts.containsKey(partialString)) {
                    this.contacts.put(partialString, this.contacts.get(partialString) + 1);
                } else {
                    this.contacts.put(partialString, 1);
                }
            }
        }

        void find(String partial) {
            if (this.contacts.containsKey(partial)) {
                System.out.println(this.contacts.get(partial));
            } else {
                System.out.println(0);
            }
        }
    }
}
