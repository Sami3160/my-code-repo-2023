import java.util.Arrays;
import java.util.List;

public class LambdaExample1 {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C#");

        // Traditional approach: Print each language in uppercase
        for (String language : languages) {
            System.out.println(language.toUpperCase());
        }

        // Lambda expression using streams: Print each language in uppercase
        languages.forEach(language -> System.out.println(language.toUpperCase()));
    }
}