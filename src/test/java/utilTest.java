import com.zz.util.DBUtil;
import org.junit.Test;

import java.sql.SQLException;

public class utilTest {

    @Test
    public void test1(){
        DBUtil util = new DBUtil();
        System.out.println(util.getConn());
    }
}
