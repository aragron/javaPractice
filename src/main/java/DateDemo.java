import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: Jakot
 * @Date: 2018/10/23 11:37
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        DateDemo nowDate = new DateDemo();
        nowDate.getSystemCurrentTime();
        nowDate.getCurrentDate();

        //TestSimpleDateFormat test = new TestSimpleDateFormat();
        nowDate.testDateFormat();
    }

    public void getSystemCurrentTime() {
        System.out.println("----获取系统当前时间----");
        System.out.println("系统当前时间 = " + System.currentTimeMillis());
    }

    public void getCurrentDate() {
        System.out.println("----获取系统当前日期----");
        //创建并初始化一个日期（初始值为当前日期）
        Date date = new Date();
        System.out.println("现在的日期是 = " + date.toString());
        System.out.println("自1970年1月1日0时0分0秒开始至今所经历的毫秒数 = " + date.getTime());
    }

    public void testDateFormat() throws ParseException {
        //创建日期
        Date date = new Date();
        //创建不同的日期格式
        DateFormat df1 = DateFormat.getInstance();
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE");
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);     //产生一个指定国家指定长度的日期格式，长度不同，显示的日期完整性也不同
        DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA);
        DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EEEEEE", Locale.US);
        DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df7 = new SimpleDateFormat("yyyy年MM月dd日");

        //将日期按照不同格式进行输出
        System.out.println("-------将日期按照不同格式进行输出------");
        System.out.println("按照Java默认的日期格式，默认的区域                      : " + df1.format(date));
        System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，系统默认区域      :" + df2.format(date));
        System.out.println("按照日期的FULL模式，区域设置为中文                      : " + df3.format(date));
        System.out.println("按照指定格式 yyyy年MM月dd日 hh时mm分ss秒 EE ，区域为中文 : " + df4.format(date));
        System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，区域为美国        : " + df5.format(date));
        System.out.println("按照指定格式 yyyy-MM-dd ，系统默认区域                  : " + df6.format(date));

        //将符合该格式的字符串转换为日期，若格式不相配，则会出错
        Date date1 = df1.parse("2007/11/30 下午2:32");
        Date date2 = df2.parse("2007-11-30 02:51:07 星期五");
        Date date3 = df3.parse("2007年11月30日星期五");
        Date date4 = df4.parse("2007年11月30日 02时51分18秒 星期五");
        Date date5 = df5.parse("2007-11-30 02:51:18 Friday");
        Date date6 = df6.parse("2007-11-30");

        System.out.println("-------输出将字符串转换为日期的结果------");
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        System.out.println(date6);
    }
}
