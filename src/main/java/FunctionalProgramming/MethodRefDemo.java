package FunctionalProgramming;

interface IntPredicate {
    boolean test(int n);
}

class MyintPredicates {
    static boolean isEven(int n) {
        return (n % 2) == 0;
    }
}

public class MethodRefDemo {

    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String[] args) {
        boolean result = numTest(MyintPredicates::isEven, 17);
        System.out.println(result);
    }

}
