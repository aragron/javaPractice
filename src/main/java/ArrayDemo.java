import java.util.Arrays;
import java.util.List;

/**
 * @Author: Jakot
 * @Date: 2018/10/22 16:48
 */
public class ArrayDemo {
    public static void main(String[] args) {
        String[] array = new String[6];
        array[0] = "黄渤";
        array[1] = "张艺兴";
        array[2] = "孙红雷";
        array[3] = "小猪";
        array[4] = "牙哥";
        array[5] = "黄磊";
        System.out.println(Arrays.toString(array));
        System.out.println("length：" + array.length);

        int index = Arrays.binarySearch(array,1,5,"牙哥");
        System.out.print(index);
        System.out.println();
        boolean flag = Arrays.equals(array,new String[] {"黄渤", "张艺兴", "孙红雷", "小猪", "牙哥", "黄磊", "何炅"});
        System.out.println(flag);
        Arrays.fill(array,5,6,"谢娜");
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        //将数组转换为列表
        List<String> stooges = Arrays.asList(array);
        System.out.println(stooges);

        System.out.println(stooges.getClass().getName());

        //将列表转化为数组
        String[] array2 = (String[])stooges.toArray(new String[9]);
//        for(int i=0;i<array2.length;i++){
//            System.out.println(array2[i]);
//        }
        System.out.println(Arrays.toString(array2));

        String[] array3 = new String[] {"a","b","c"};
        System.out.println(Arrays.toString(array3));
    }
}
