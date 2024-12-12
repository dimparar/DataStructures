package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagChecking {

    public boolean check(String fileName) {
        
        StringStackImpl<String> stack = new StringStackImpl<String>();

        /*
        * Exclude these tags:
        *   - <br>
        *   - <img>
        *   - <!-- comment --->
        */ 
        String openTagRegex = "<((?!br|img|![a-zA-Z])[a-zA-Z0-9]+)[^>]*>";
        String closeTagRegex = "</([a-zA-Z0-9]+)>";
        Pattern openPattern = Pattern.compile(openTagRegex);
        Pattern closePattern = Pattern.compile(closeTagRegex);
        Matcher matcher;


        File file = new File(fileName);
        // System.out.println(file.getAbsolutePath());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                
                String line = scanner.nextLine();

                int lastEnd = 0;
                matcher = openPattern.matcher(line);
                while (matcher.find(lastEnd))
                {
                    lastEnd = matcher.end();


                    stack.push(matcher.group(1));
                    stack.printStack(System.out);
                }

                matcher = closePattern.matcher(line);
                while (matcher.find(lastEnd))
                {
                    if (stack.peek().equals(matcher.group(1)))
                    {
                        lastEnd = matcher.end();

                        stack.pop();
                        stack.printStack(System.out);
                    }
                    else
                    {
                        return false;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }


}
