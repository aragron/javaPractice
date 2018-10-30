import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: Jakot
 * @Date: 2018/10/23 11:11
 */
public class SystemDemo {
    public static void main(String[] args) {
        Properties props = System.getProperties();
        System.out.println(props.getClass().getName());

        Set<Map.Entry<Object, Object>> entrySet =  props.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }

        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
    }
}
