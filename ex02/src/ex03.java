import java.util.Optional;

public class ex03 {
    public static void main(String[] args) {
        Optional.ofNullable(getExamScore("수학")).orElse(0);
    }

    private static int getExamScore(String subject) {
        if(subject.equals("수학"))
            return 100;
        else
            return 20;
    }

}