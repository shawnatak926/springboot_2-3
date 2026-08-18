import java.util.Optional;

public class ex02 {

    static void main() {
        Optional<String> qq = Optional.of("Hello");
        System.out.println(qq.get());

        Optional<String> empty = Optional.empty();
        System.out.println(empty.orElse("빈 값"));
    }
}
