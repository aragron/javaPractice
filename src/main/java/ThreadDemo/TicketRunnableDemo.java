package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 21:13
 */
public class TicketRunnableDemo {
    public static void main(String[] args) {
        TicketRunnable th = new TicketRunnable();
        new Thread(th).start();
        new Thread(th).start();
        new Thread(th).start();
        new Thread(th).start();
        new Thread(th).start();
    }
}
