import java.util.Random;

public class RandomStreams {
  public static void main(String[] args) {
    Random random = new Random();
    //System.out.println(random.nextInt()); //Not a stream
    random.ints().limit(4).forEach((number) -> System.out.println(number)); //A stream
    //random er Source på stream ovenfor. limit(4).foreach( er intermidiate operations. sout delen er terminal operations.
  }
}
