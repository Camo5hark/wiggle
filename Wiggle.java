import java.awt.*;
import java.awt.event.KeyEvent;

public class Wiggle {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Thread.sleep(3000L);

        long sample = 1000L;
        double frequency = 0.0003;
        double amplitude = 15.0;

        Robot robot = new Robot();
        long lastTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();

            if (currentTime - lastTime >= sample) {
                lastTime = currentTime;

                for (int i = 0; i < Math.ceil((Math.sin(currentTime * frequency) + 1.0) * amplitude); i++) {
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                }

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        }
    }
}
