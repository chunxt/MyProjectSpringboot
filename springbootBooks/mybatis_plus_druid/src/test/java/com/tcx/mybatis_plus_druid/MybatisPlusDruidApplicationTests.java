package com.tcx.mybatis_plus_druid;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcx.mybatis_plus_druid.DAO.BookDao;
import com.tcx.mybatis_plus_druid.pojo.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class MybatisPlusDruidApplicationTests {
@Autowired
BookDao bookDao;
    @Test
    void contextLoads() {
        IPage page=new Page(1,3);
        bookDao.selectPage(page,null);
    }
    @Test
    void select(){
        String name="计算机";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(name),Book::getType,name);//查询语句
        IPage page=new Page(1,3);
        bookDao.selectPage(page,lqw);//分页查询+条件查询
    }

}
