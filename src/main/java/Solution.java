import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(malesOnly(Person.persons()));
    }
        //Filter the list of person to include only males.

        static List<String> malesOnly(List<Person> people){
            List<String> males = people.stream()
                    .filter(Person::isMale)
                    .map(Person::getName)
                    .toList();
            return males;

        }
    }
}
