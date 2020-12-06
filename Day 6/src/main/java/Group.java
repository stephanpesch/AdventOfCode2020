import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Group {

    private Set<Character> answers = new HashSet<>();

    public Group() {

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

    public int getNumberOfAnswers() {
        return answers.size();
    }
}
