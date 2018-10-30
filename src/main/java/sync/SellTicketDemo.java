package sync;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 10:26
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket st = new SellTicket();
        new Thread(st,"票贩子A").start();
        new Thread(st,"票贩子B").start();
        new Thread(st,"票贩子C").start();
    }
}
