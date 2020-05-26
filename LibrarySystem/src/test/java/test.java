import com.jason.entity.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvc-config.xml");
        Reader reader = (Reader)applicationContext.getBean("reader");
        reader.setId(123);
        System.out.println(reader.getId());
    }
}
