import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {

    private static final String ALL_CHARACTERS_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static final Set<Character> ALL_CHARACTERS =
            ALL_CHARACTERS_STRING.chars().mapToObj(x -> (char) x).collect(Collectors.toSet());

    private Set<Character> answers = new HashSet<>();

    public Group() {
        answers.addAll(ALL_CHARACTERS);
    }

    @Override
    public String toString() {
        return answers.toString();
    }

    public void addAnswer(Character character) {
        answers.add(character);
    }

    public void addAnswers(Collection<Character> characters) {
        answers.addAll(characters);
    }

    public void retainAnswers(Collection<Character> characters) {
        answers.retainAll(characters);
    }

    public int getNumberOfAnswers() {
        return answers.size();
    }
}
