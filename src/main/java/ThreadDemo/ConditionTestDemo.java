package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/29 16:23
 */
public class ConditionTestDemo {
    public static void main(String[] args) throws InterruptedException
    {
        ConditionTest myService=new ConditionTest();
        Thread threadA=new Thread(){
            @Override
            public void run()
            {
                super.run();
                myService.awaitA();
            }
        };

        Thread threadB=new Thread(){
            @Override
            public void run()
            {
                super.run();
                myService.awaitB();
            }
        };

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        myService.signalA();
        Thread.sleep(1000);
        myService.signalB();

    }
}
