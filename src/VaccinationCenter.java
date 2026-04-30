
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private int age;
    private String vaccine;

    public Person(String name, int age, String vaccine) {
        this.name = name;
        this.age = age;
        this.vaccine = vaccine;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getVaccine() { return vaccine; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Vaccine: " + vaccine;
    }
}

class VaccinationCenter {
    private ArrayList<Person> people;

    public VaccinationCenter() {
        people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public void listPeople() {
        if(people.isEmpty()) {
            System.out.println("No vaccinated individuals yet.");
        } else {
            for(Person p : people) {
                System.out.println(p);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VaccinationCenter center = new VaccinationCenter();
        System.out.println("Welcome to the Vaccination Center");

        while(true) {
            System.out.println("\n1. Add Person\n2. List People\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            if(choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.print("Enter vaccine type: ");
                String vaccine = sc.nextLine();
                center.addPerson(new Person(name, age, vaccine));
            } else if(choice == 2) {
                center.listPeople();
            } else if(choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
