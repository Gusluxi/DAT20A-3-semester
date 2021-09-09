import java.util.Random;

public class Octopus extends Animal {

  static final Random random = new Random();
  static final int min = 1;
  static final int max = 10;

  static final GameOfOctopus gameThread = new GameOfOctopus();

  public void makeDoActivity() {
    for (;;) {
      //Pause for 4 seconds
      try {
        String activity = selectActivity();
        System.out.println(activity);
        GameOfOctopus gameThread = new GameOfOctopus();
        if (activity.equals("Mate")) {
          gameThread.start();
        }
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //Print a message
      System.out.println(selectActivity());
    }
  }

  public String selectActivity() {
    String activity;

    int activityNumber = random.nextInt(max)+min;

    switch (activityNumber) {
      case 1: activity = "Eat";
        break;
      case 2: activity = "Mate";
        break;
      case 3: activity = "Sleep";
        break;
      case 4, 5: activity = "Jet Ink";
        break;
      default: activity = move();
    }

    return activity;

  }

  @Override
  public String move() {
    return "Swish Swosh";
  }

}