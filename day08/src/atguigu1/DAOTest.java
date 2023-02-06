package atguigu1;

import org.junit.Test;

import java.util.List;

/**
 * @author SHJ
 * @create 2023-01-03 10:02
 */
public class DAOTest {

    @Test
    public void test1() {
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);
    }

}
