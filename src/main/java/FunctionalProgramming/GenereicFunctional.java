package FunctionalProgramming;

interface IGenericFunctional<T> {
    T test(T a, T b);
}

public class GenereicFunctional {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        IGenericFunctional<Integer> m = (c, d) -> c + d;

        System.out.println(m.test(a, b));

    }

}
