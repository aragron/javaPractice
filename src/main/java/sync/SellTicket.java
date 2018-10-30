package sync;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 10:02
 */
public class SellTicket implements Runnable{
    private int ticket = 10;
    public synchronized boolean sale () {
        if (this.ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket--);
            return true;
        } else {
            System.out.println("== 票已经卖光 ==");
            return false;
        }
    }
    @Override
    public void run() {
        while (this.sale()){;}
    }
}
