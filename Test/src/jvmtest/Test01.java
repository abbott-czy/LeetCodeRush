package jvmtest;

public class Test01 {
    private static int a = 1;
    public static void main(String[] args) {
        System.out.println(a);
        a++;
        main(args);

    }
}
