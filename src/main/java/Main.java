import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + (i + 1));
        }
        lock.unlock();
    }

    public static void main(String[] args) {
    }
}
