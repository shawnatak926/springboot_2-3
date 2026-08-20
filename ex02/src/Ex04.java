interface BB {
    String doA(int a);
}
class AAAA{}
public class Ex04 {
    public static void method1(BB bb, AAAA aaaa){
        String test = bb.doA(100);
        System.out.println(test);
    }
    public static void main(String[] args) {
        method1((int num)-> String.valueOf(num), new AAAA());
    }
}
