package Attacks;

//DO NOT MODIFY THIS CLASS
//This class will read N names and call addFirst, then it will read M names and call addLast
//After it will read one name and call findFirst. Lastly, it will read another name and call findLast


import java.util.Scanner;

public class Lab6Runner {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        LinkedList names = new LinkedList();

        int addFirstQuantity = kb.nextInt();
        for (int i = 0; i < addFirstQuantity; i++) {
            names.addFirst(kb.next());
        }

        System.out.println("List after calling add first");
        System.out.println(names);

        int addLastQuantity = kb.nextInt();
        for (int i = 0; i < addLastQuantity; i++) {
            names.addLast(kb.next());
        }

        System.out.println("List after calling add last");
        System.out.println(names);

        String firstOccurrence = kb.next();
        System.out.printf("First occurrence of %s is at index %d\n", firstOccurrence,names.findFirst(firstOccurrence));

        String lastOccurrence = kb.next();
        System.out.printf("First occurrence of %s is at index %d\n", lastOccurrence,names.findLast(lastOccurrence));

    }
}
