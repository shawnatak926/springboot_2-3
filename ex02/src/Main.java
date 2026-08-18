import java.util.Optional;

public class Main {
    public static Optional<String> getName() {
        return Optional.of("홍길동");
    }
    public static void main(String[] args) {
        System.out.println("ㅇㅏㄴ녕하세요 용인이에용");
        String name = null;
        try {
            if (name == null) {
                System.out.println("name의 length는" + name.length());
            }
        } catch (Exception e) {

        }
        System.out.println("실행");
        Optional<String> optional = getName();
        optional.ifPresent(S -> System.out.println(S));
    }
}