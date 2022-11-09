package func;

import java.util.ArrayList;
import java.util.List;

public class Test01 {


    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>();
        num1.add(1);
        num1.add(2);
        num1.add(3);
        num1.remove(-1);
        System.out.println(num1);
    }
}
