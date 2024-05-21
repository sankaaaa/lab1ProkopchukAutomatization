import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class ThirdTask {
    static class IncorrectFunctions {
        private int number;
        private String text;

        public IncorrectFunctions(int number, String text) {
            this.number = number;
            this.text = text;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int hashCode() {
            return new Random().nextInt();
        }

        @Override
        public String toString() {
            return "Incorrect functions: number = " + number + ", text = " + text;
        }
    }

    static class CorrectFunctions {
        private int number;
        private String text;

        public CorrectFunctions(int number, String text) {
            this.number = number;
            this.text = text;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (getClass() != obj.getClass() || obj == null)
                return false;

            CorrectFunctions other = (CorrectFunctions) obj;
            return number == other.number && text.equals(other.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, text);
        }

        @Override
        public String toString() {
            return "Correct Functions: number = " + number + ", text = " + text;
        }
    }

    public static void main(String[] args) {
        Map<CorrectFunctions, String> correctMap = new HashMap<>();
        CorrectFunctions correct1 = new CorrectFunctions(1, "apple");
        correctMap.put(correct1, "correct1");

        CorrectFunctions correct2 = new CorrectFunctions(2, "banana");
        correctMap.put(correct2, "correct2");

        System.out.println("---Testing correct class with HashMap---");
        System.out.println("HashMap with CorrectClassObjects:");
        correctMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        CorrectFunctions doubleCorrect = new CorrectFunctions(1, "apple");
        System.out.println("Is doubleCorrect: " + (correctMap.containsKey(doubleCorrect) ? "yes" : "no"));
        correctMap.put(doubleCorrect, "doubleCorrect");

        System.out.println("\nHashMap with correct objects after adding doubleCorrect:");
        correctMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        Map<IncorrectFunctions, String> incorrectMap = new HashMap<>();
        IncorrectFunctions incorrect1 = new IncorrectFunctions(1, "math");
        IncorrectFunctions incorrect2 = new IncorrectFunctions(2, "english");

        incorrectMap.put(incorrect1, "incorrect1");
        incorrectMap.put(incorrect2, "incorrect2");

        System.out.println("\n---Testing incorrect class with HashMap---");
        System.out.println("HashMap with IncorrectClassObjects:");
        incorrectMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        IncorrectFunctions doubleIncorrect = new IncorrectFunctions(1, "math");
        incorrectMap.put(doubleIncorrect, "doubleIncorrect");

        System.out.println("\nHashMap with correct objects after adding doubleIncorrect:");
        incorrectMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.out.println("Is doubleIncorrect: " + (incorrectMap.containsKey(doubleIncorrect) ? "yes" : "no"));
        System.out.println("Contains incorrect1: " + (incorrectMap.containsKey(incorrect1) ? "yes" : "no"));

        System.out.println("\nIncorrect updating:");
        incorrectMap.put(incorrect1, "updatedIncorrect1");
        System.out.println("After updating incorrect1:");
        incorrectMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.out.println("Contains incorrect1: " + (incorrectMap.containsKey(incorrect1) ? "yes" : "no"));
    }
}
