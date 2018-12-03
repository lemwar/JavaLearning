package threads;

class TickTock {

    String state;

    synchronized public void tick() throws InterruptedException {

        System.out.println("Tick");
        state = "ticked";

        notify();
        wait();
    }

    synchronized public void tock() throws InterruptedException {
        System.out.println("Tock");
        state = "tocked";

        notify();
        wait();
    }

}


class ThreadTick implements Runnable{

    private TickTock tt = new TickTock();
    Thread thread;

    ThreadTick() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                tt.tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadTock implements Runnable{

    private TickTock tt = new TickTock();
    Thread thread;

    ThreadTock() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                tt.tock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestTickTock {
    public static void main(String[] args) {
        ThreadTick tick = new ThreadTick();
        ThreadTock tock = new ThreadTock( );

        try {
            tick.thread.join();
            tock.thread.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}



