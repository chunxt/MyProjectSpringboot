package com.tcx.mybatis_plus_druid;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tcx.mybatis_plus_druid.DAO.BookDao;
import com.tcx.mybatis_plus_druid.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @Author Cxt
 * @Date 2022-02-2022/2/17-10:51
 */
@SpringBootTest
public class serviceTest {
    @Autowired
    private BookDao bookDao;
    @Test
    void test(){
        /*IPage<Book> page = bookService.getPage(1, 3, null);
        System.out.println(page.getCurrent());*/
        bookDao.selectById(2);
    }

}
