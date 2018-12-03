package algorythms;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumber {

    private List<Integer> getPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if(primes.isEmpty()) {
                primes.add(i);
            } else {
                boolean prime = true;
                for (Integer ex : primes) {
                    if((i % ex) == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    primes.add(i);
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        SimpleNumber sn = new SimpleNumber();
        System.out.println(sn.getPrimes(100));
    }
}
