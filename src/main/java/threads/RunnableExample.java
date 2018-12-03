package threads;

class MyThread implements Runnable {

    private Thread thread;

    MyThread() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println(count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Thread getThread() {
        return this.thread;
    }
}


public class RunnableExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
//        try {
//            thread.getThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("End");
    }
}
