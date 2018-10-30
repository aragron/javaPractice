/**
 * @Author: Jakot
 * @Date: 2018/10/23 10:07
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        //获取可用内存
        long value = Runtime.getRuntime().freeMemory();
        System.out.println("可用内存为:"+value/1024/1024+"mb");
        //获取jvm的总数量，该值会不断的变化
        long  totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("全部内存为:"+totalMemory/1024/1024+"mb");
        //获取jvm 可以最大使用的内存数量，如果没有被限制 返回 Long.MAX_VALUE;
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("可用最大内存为:"+maxMemory/1024/1024+"mb");

        int value2 = Runtime.getRuntime().availableProcessors();
        System.out.println(value2);

        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("calc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
