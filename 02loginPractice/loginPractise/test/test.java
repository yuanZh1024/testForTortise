

import com.yuanzh.Entity.User;
import com.yuanzh.dao.UserDao;
import org.junit.Test;

public class test {
    @Test
    public void TestLogin() {
        User user = new User();
        user.setUsername("san");
        user.setPassword("23");
        UserDao userdao = new UserDao();
        User user1 = userdao.login(user);

        System.out.println(user1);
    }

    @Test
    public void TestRegister() {
        User user = new User();
        user.setUsername("er");
        user.setPassword("23");
        UserDao userdao = new UserDao();
        userdao.register(user);

        System.out.println(user);
    }

}
