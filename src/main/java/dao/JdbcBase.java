package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by wulvge on 2017/9/13.
 */
public abstract class JdbcBase {
    private final static ApplicationContext ctx;
    public static final JdbcTemplate jdbcTemplate;
    static {
        ctx = new ClassPathXmlApplicationContext("springbeans.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }
}