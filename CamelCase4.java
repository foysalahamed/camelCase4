import javax.print.attribute.standard.PrinterResolution;
import java.util.Scanner;

public class CamelCase4 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String inputItem = scanner.nextLine();
            solution.camelCaseProcessing(inputItem);
        }
    }
}
class Solution{
    public void camelCaseProcessing(String input){

        String[] parts = input.split(";");
        String operation = parts[0]; // S (Split) or C (Combine)
        String type = parts[1];      // M (Method), C (Class), V (Variable)
        String text = parts[2];      // The actual string to process

        if (operation.equals("S")) {
            // Split camel case into words
            String result = text.replaceAll("([a-z])([A-Z])", "$1 $2").toLowerCase();
            if (type.equals("M")) {
                result = result.replace("()", ""); // Remove parentheses for methods
            }
            System.out.println(result);
        } else if (operation.equals("C")) {
            // Combine words into camel case
            String[] words = text.split(" ");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                if (i == 0 && !type.equals("C")) {
                    result.append(words[i].toLowerCase()); // Lowercase first word for variables/methods
                } else {
                    result.append(words[i].substring(0, 1).toUpperCase())
                            .append(words[i].substring(1).toLowerCase());
                }
            }

            if (type.equals("M")) {
                result.append("()"); // Append parentheses for methods
            }

            System.out.println(result.toString());
        }



    }
}
