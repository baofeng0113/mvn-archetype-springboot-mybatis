package ${package}.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ${package}.${artifactId}.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTest extends DefaultUnitTest {

    @Test
    public void test() {
        System.out.println("This is a test case");
    }
}
