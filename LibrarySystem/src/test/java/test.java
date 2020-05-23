import dao.BookDao;
import dao.BorrowDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BookDao bookDao = sqlSession.getMapper(BookDao.class);
//        System.out.println(bookDao.count());
        BorrowDao borrowDao = sqlSession.getMapper(BorrowDao.class);
//        borrowDao.insert(1,1,"a","b");
//        sqlSession.commit();
        System.out.println(borrowDao.findAllByReaderId(3,0,10));

    }
}
