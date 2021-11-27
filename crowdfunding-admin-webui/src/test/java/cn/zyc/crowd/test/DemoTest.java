package cn.zyc.crowd.test;

import cn.zyc.crowd.entity.Admin;
import cn.zyc.crowd.mapper.AdminMapper;
import cn.zyc.crowd.service.api.AdminService;
import cn.zyc.crowd.util.CrowdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.util.calendar.LocalGregorianCalendar;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zyc
 * @date 2021/11/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class DemoTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test02(){
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

    @Test
    public void test03(){
        Logger logger = LoggerFactory.getLogger(DemoTest.class);
        logger.info("hello info logger~");
        logger.debug("hello debug logger~");
    }

    @Test
    public void test04(){
        for(int i = 1; i<100;i++){
            Admin admin = new Admin(null,"admin"+i,"123","admin"+i,"123@123",null);
            adminMapper.insert(admin);
        }
    }
}
