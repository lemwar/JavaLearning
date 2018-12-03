package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementorThreads {

    private volatile boolean isFinished = false;
    private volatile int progress;
    private volatile List<Integer> result;
    private volatile List<Integer> list;

    void inc (List<Integer> list) {

        this.list = list;

        Thread thread = new Thread(this::process);
        thread.start();

    }

    private void process() {
        List<Integer> copyList = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            copyList.add((list.get(i) + 1));

            progress = (((i + 1) * 100) / list.size());


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = copyList;
        isFinished = true;
    }

    Integer getProgress() {
        return progress;
    }

    List<Integer> getResult() {
        return result;
    }

    boolean hasResult() {
        return isFinished;
    }


    public static void main(String[] args) {
        IncrementorThreads incrementor = new IncrementorThreads();

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        incrementor.inc(list);

        while(!incrementor.hasResult()) {
            System.out.println(incrementor.progress);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


//        incrementor.setProcessor(System.out::println);
//
//        List<Integer> copyList = incrementor.inc(Arrays.asList(1, 2, 3, 4));
//        for(Integer element : copyList) {
//            System.out.println(element);
//        }
    }
}
