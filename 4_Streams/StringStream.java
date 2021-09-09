import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {
  public static void main(String[] args) {
    List<String> bunchOStrings = Arrays.asList("Pixel", "kekw", "lol", "cool", "lol", "Pixel", "", "420", "", "i");

    List<String> onlyWords = bunchOStrings.stream().filter(words -> words.length() > 0).collect(Collectors.toList());

    System.out.println(onlyWords);

    long vocabulary = bunchOStrings.stream().distinct().filter(words -> !words.isEmpty()).count();
    System.out.println("Words known: "+vocabulary);

    String sentence = bunchOStrings
        .parallelStream()
        .filter(word -> !(word.equals("")))
        .map(words -> words + " ")
        .collect(Collectors.joining(","))+".";

    System.out.println(sentence);
  }
}
