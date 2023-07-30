import java.util.Stack;

public class BalancedBrackets {

  public static boolean isBalanced(String inputString) {

    Stack<String> stack = new Stack<String>();

    String openingBrackets = "([{";
    String closingBrackets = ")]}";

    for (char ch : inputString.toCharArray()) {
      
      String element = Character.toString(ch);
      
      if (openingBrackets.contains(element))
        stack.push(element);
      
      else if (closingBrackets.contains(element)) {
        if (stack.isEmpty())
          return false;

        if (openingBrackets.indexOf(stack.pop()) != closingBrackets.indexOf(element))
          return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String sampleInput1 = "( [ [ { } ] ] )";
    
    System.out.println(isBalanced(sampleInput1)? "Balanced Brackets" : "Unbalanced Brackets");
  }
}
