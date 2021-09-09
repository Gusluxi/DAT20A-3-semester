import java.util.Arrays;
import java.util.List;

public class MethodReference {

  public MethodReference(String content) {
    System.out.println(content);
  }

  public void out(String content) {
    System.out.println(content);
  }

  public static void outStatic(String content) {
    System.out.println(content);
  }

  public static void main(String[] args) {
    List<String> greetings = Arrays.asList("Hi", "Hello", "Hey");
    //Lambda
    //greetings.forEach((greeting) -> System.out.println(greeting));

    //Method reference
    //greetings.forEach(MethodReference::outStatic);
    //greetings.forEach(new MethodReference()::out);
    greetings.forEach(MethodReference::new);



  }
}
