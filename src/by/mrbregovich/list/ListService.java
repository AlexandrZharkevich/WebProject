package by.mrbregovich.list;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private static List<Person> groupList = new ArrayList<>();

    static {
        groupList.add(new Person("Anna", "+375291234567", "anna1.19@gmail.com"));
        groupList.add(new Person("Ivan", "+375331114534", "ivan1.19@gmail.com"));
        groupList.add(new Person("Alex", "+375446664578", "alex1.19@gmail.com"));
    }

    public static List<Person> retrieveList() {
        return groupList;
    }

    public static void addPerson(Person person) {
        groupList.add(new Person(person));
    }
}
