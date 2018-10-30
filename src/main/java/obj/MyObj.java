package obj;

/**
 * @Author: Jakot
 * @Date: 2018/10/26 17:30
 */
public class MyObj {
    public MyObj() {
        System.out.println("对象" + this + "创建");
    }
    /**
     * 重写finalize方法，在对象被gc的时候打印日志
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this + " is gc");
    }
}
