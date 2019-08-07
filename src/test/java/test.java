import com.zz.util.Md5Util;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    @Test
    public void test1() throws ParseException {
        String string = "2016-10-24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(string);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

    }

    @Test
    public void test2() {
        try {
            System.out.println(Md5Util.encodeByMd5("admin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
