interface DoA {
    void doA();
    default void doB() {
        System.out.println("doB");
    }
}

public class Ex01 {
    public static void main(String[] args) {
        DoA doA = new DoA() {
            public void doA() {
                System.out.println("test1111");
            }
        };
        DoA d1 = ()->{
            System.out.println("test2222");
        };
        doA.doA();
        d1.doA();
    }
}
