
package ex1;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    private static final String RESOURCES_PATH = "src/test/resources/";

    StringStackImpl<String> stackFalse = new StringStackImpl<String>();

    StringStackImpl<String> stackTrue = new StringStackImpl<String>();

    @Test public void checkHtmlFiles() {
        
        stackFalse.push("test1.html");
        stackFalse.push("test2.html");
        stackFalse.push("test5.html");
        stackFalse.push("test7.html");
        stackFalse.push("test8.html");
        
        stackTrue.push("test.html");
        stackTrue.push("test3.html");
        stackTrue.push("test4.html");

        // Testing the files
        TagChecking tagChecker = new TagChecking();

        while (!stackFalse.isEmpty()) {
            String item = stackFalse.pop();
            assertEquals(item, false, tagChecker.check(RESOURCES_PATH + item));
        }

        while (!stackTrue.isEmpty()) {
            String item = stackTrue.pop();
            assertEquals(item, true, tagChecker.check(RESOURCES_PATH + item));
        }

    }
}
