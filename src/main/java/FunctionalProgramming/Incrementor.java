package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Incrementor {

    Consumer<Integer> processor;

    List<Integer> inc (List<Integer> list) {
        List<Integer> copyList = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            copyList.add((list.get(i) + 1));

            if(processor != null) {
                processor.accept(((i+1) * 100) / list.size());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return copyList;
    }

    void setProcessor(Consumer<Integer> cons) {
        processor = cons;
    }



    public static void main(String[] args) {
        Incrementor incrementor = new Incrementor();

        incrementor.setProcessor(System.out::println);

        List<Integer> copyList = incrementor.inc(Arrays.asList(1, 2, 3, 4));
        for(Integer element : copyList) {
            System.out.println(element);
        }
    }
}
