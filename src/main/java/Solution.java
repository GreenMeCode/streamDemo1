import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortByIncome().forEach(System.out::println);
        System.out.println("Distinct Genders " + distinctGenders());
        System.out.println("First 3 people on the list ");
        firstThreePeople().forEach(System.out::println);
        System.out.println("List of people on the list skipped first two people");
        skippedPeople().forEach(System.out::println);
        System.out.println("Person's income is greater than 8k"+anyPersonWithHighIncome());
        System.out.println("Person with highest income is " );
        System.out.println(personWithHighestIncome());//THIS WILL PRINT OUT OPTIONAL ON THE LINE ITEM
        if(personWithHighestIncome().isPresent()){
            Person p = personWithHighestIncome().get();
            System.out.println("Person with highest income is "+ p );
        }
    }
        //Filter the list of person to include only males.

        static List<String> malesOnly(List<Person> people){
            List<String> males = people.stream()
                    .filter(Person::isMale)
                    .map(Person::getName)
                    .toList();
            return males;

        }

        //Map the list of persons to their names
        static List<String> names(List<Person> people){
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        return names;
        }

        // Sort the list of persons by their income in descending order.
    static List<Person> sortByIncome(){
        List<Person> sortedList = Person.persons()
                .stream()
                .sorted(Comparator.comparing(Person::getIncome))
                .toList();
        return sortedList;
    }

    //Find the disctinct genders in the list of people

    static List<Person.Gender> distinctGenders (){
        List<Person.Gender> genders = Person.persons()
                .stream()
                .map(Person::getGender)
                .distinct()
                .toList();
        return genders;
    }

    //- Limit the list of persons to the first 3.
    static List<Person>  firstThreePeople(){

        List<Person> top3 = Person.persons()
                .stream()
                .limit(3)
                .toList();
        return top3;
    }

    //Skip the first 2 persons in the list.

    static List<Person> skippedPeople(){
        List<Person>skipped = Person.persons()
        .stream()
                .skip(2)
                .toList();
        return skipped;
    }

    //To use peek() to print the names of all persons in the list
    static void displayNames(){
        Person.persons()
                .stream()
                .peek(person -> System.out.println("Person name"+person))
                .forEach(System.out::println);

    }

    //To check if any person's income is greater than 8K

    static boolean anyPersonWithHighIncome(){
       return Person.persons()
                .stream()
                .anyMatch(p->p.getIncome()>8000);
    }
    //CHECK IF ALL PERSONS ARE MALE
    static boolean isAllPeopleAreMale(){
       return Person.persons()
                .stream()
                .allMatch(Person::isMale);//Person::isMale SAME AS p->p.getGender() == Person.Gender.MALE

    }

//    **NoneMatch (Terminal Operation):**
    static boolean noneHaveZeroincome(){
       return Person.persons()
                .stream()
                .noneMatch(p->p.getIncome()==0);
    }
    //To count the number of persons

    static long countFemale(){
     return    Person.persons()
                .stream()
             .filter(Person::isFemale)
                .count();
    }
//To find the person with the highest income
    static Optional<Person> personWithHighestIncome(){
       return Person.persons()
                .stream()
                .max(Comparator.comparingDouble(Person::getIncome));

    }
}

