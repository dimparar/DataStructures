package ex1;

public class App {

    public static void main(String[] args) {
        
        String fileName = "";
        if (args.length != 0) {
            fileName = args[0];
            System.out.println("filePath: " + fileName);
        } else {    
            System.out.println("Please specify the HTML file path you want to examine");
        }
        
        TagChecking tagChecker = new TagChecking();
        if (tagChecker.check(fileName)) {
            System.out.println("This is a valid HTML file");
        } else {
            System.out.println("Invalid HTML file");
        }
    }
}
