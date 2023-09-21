package Seminar5home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Phonebook {
    static Map<String, ArrayList<String>> phoneBook = new LinkedHashMap<>(); 
    public static void main(String[] args) {

        userForPhonebook();
        phoneUsers();
        printPhonebookNoSort();
        printPhonebookSotRevers();
        printSortPhonebookByQuantityPhone();
    }

    public static void userForPhonebook() {
        phoneBook.put("Иванов", new ArrayList<>());
        phoneBook.put("Петров", new ArrayList<>());
        phoneBook.put("Григорьев", new ArrayList<>());
        phoneBook.put("Васечкин", new ArrayList<>());
        phoneBook.put("Носов", new ArrayList<>());
    }

    public static void phoneUsers() {
        phoneBook.get("Иванов").add("+7900000000");
        phoneBook.get("Иванов").add("+7777000000");
        phoneBook.get("Петров").add("+8888000000");
        phoneBook.get("Петров").add("+8855555555");   
        phoneBook.get("Петров").add("+1111111111");     
        phoneBook.get("Григорьев").add("+3333333333");
        phoneBook.get("Носов").add("+11232416353");
        phoneBook.get("Носов").add("+34732416353");
        phoneBook.get("Васечкин").add("+22222222222");
    } 
    
    public static void printPhonebookNoSort() {
        System.out.println();
        System.out.println("Тел. справочник в порядке добавления имен:");
        for (Map.Entry<String, ArrayList<String>> element : phoneBook.entrySet()) {
            String key = element.getKey();
            ArrayList<String> value = element.getValue();
            System.out.println(key + " : " + value);
        }
        System.out.println();
    }
    
    public static void printPhonebookSotRevers() {
        System.out.println("Тел. справочник отсотированный в обратном порядке:");
        List<String> listAllKeyPhonebook = new ArrayList<>(phoneBook.keySet());
        Collections.reverse(listAllKeyPhonebook);
        for (String strPh : listAllKeyPhonebook) {
            System.out.println(strPh + ":" + phoneBook.get(strPh));
        }    
        System.out.println();   
    }

    public static void printSortPhonebookByQuantityPhone() {

        List<String> listAllKeyPhonebook = new ArrayList<>(phoneBook.keySet());
        Map<String, Integer> sumPhonesForKey = new LinkedHashMap<>();
        for (int i = 0; i < listAllKeyPhonebook.size(); i++) {
            String newKey = listAllKeyPhonebook.get(i);
            int sizePh = phoneBook.get(listAllKeyPhonebook.get(i)).size();
            sumPhonesForKey.put(newKey, sizePh);
        }
        // System.out.println(sumPhonesForKey);
        Map<String, Integer> sortedPhmap = sumPhonesForKey.entrySet().stream()
        .sorted(Comparator.comparingInt(e -> e.getValue()))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> { throw new AssertionError(); },
            LinkedHashMap::new));
            // sortedPhmap.entrySet().forEach(System.out::println);
        
        List<String> listAllKeySortedmap = new ArrayList<>(sortedPhmap.keySet());
        // System.out.println(listAllKeySortedmap);
        Map<String, ArrayList<String>> phonebookSortByQuantityPhone = new LinkedHashMap<>();
        for (int i = 0; i < listAllKeySortedmap.size(); i++) {
            phonebookSortByQuantityPhone.put(listAllKeySortedmap.get(i), phoneBook.get(listAllKeySortedmap.get(i)));
        }
        System.out.println("Тел. справочник отсортированный по количеству телефонов + имена:");
        // System.out.println(phonebookSortByQuantityPhone);

        for (Map.Entry<String, ArrayList<String>> element : phonebookSortByQuantityPhone.entrySet()) {
            String key = element.getKey();
            ArrayList<String> value = element.getValue();
            System.out.println(key + " : " + value);
        }
        System.out.println();
    }
}