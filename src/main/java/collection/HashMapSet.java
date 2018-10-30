package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 23:26
 */
public class HashMapSet {
    public static void main(String [] args){
        // 实例化Map接口
        Map<String, Integer> map = new HashMap<String, Integer>();
        // 添加数据
        map.put("张三", 20);
        map.put("李四", 23);
        map.put("王五", 19);
        map.put("赵六", 21);
        //　将Map集合变为Set集合
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        // 使用iterator()方法取得Iterator的实例化对象
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        // 进行key和value分离
        while(iterator.hasNext()){
            Map.Entry<String, Integer> me = iterator.next();
            System.out.println(me.getKey() + "-->" + me.getValue());
        }
    }

}
