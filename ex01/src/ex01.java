import java.util.Optional;
import java.util.OptionalInt;

public class ex01 {
    public static void main(String[] args) {
        // Optinal 생성 방법 3가지
        int a = 10;
        Optional<Integer> intopt = Optional.of(10);
        // ofNullabe은 null 일수도 있고 값일 수도 있다.
        Optional<String> stropt = Optional.ofNullable(null);
        //empty는 null이다.
        Optional<Integer> stropt2 = Optional.empty();


        // Optinal get orElse ifpresent
        System.out.println(intopt.get());

        System.out.println(stropt.orElse("기본값설정"));
        if(stropt2.isPresent()) {
            System.out.println(stropt2.get());
        }else{
            System.out.println("값이 없음");
        }
    }
}
