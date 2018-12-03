package FunctionalProgramming;

interface MyValueInt {
    int getInt();
}

public class Lambda {


    public static void main(String[] args) {
        MyValueInt mi = () -> 1;
        System.out.println(mi.getInt());
    }

}
