package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 21:12
 */
public class TicketRunnable implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int x = 0; x < 100; x ++){
            if (this.ticket > 0) {
                System.out.println("卖票，ticket = " + this.ticket--);
            }
        }
    }
}
