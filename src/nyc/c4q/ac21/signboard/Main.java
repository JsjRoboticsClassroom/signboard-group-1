package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {

    public static void ribbonSceneCustom(SignBoard board, int numCycles, String ribbonText1, String ribbonText2) {

        int width = board.getWidth();
        int height = board.getHeight();

        Random random = new Random(width);

        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            int color1 = random.nextInt(4);
            switch (color1) {
                case 0:
                    frame.setGreen();
                    break;
                case 1:
                    frame.setRed();
                    break;
                case 2:
                    frame.setWhite();
                    break;
                case 3:
                    frame.setYellow();
                    break;
            }
            int x = random.nextInt(width);
            if ((x + ribbonText1.length()) > width) {
                x -= (ribbonText1.length());
            }

            int y = random.nextInt(height);

            frame.write(x, y, ribbonText1);

            x = random.nextInt(width);
            if ((x + ribbonText2.length()) > width) {
                x -= (ribbonText2.length());
            }
            y = random.nextInt(height);

            frame.write(x, y, ribbonText2);


            frame.finish(0.25);
        }
    }

    public static void scrollTextSceneCustom(SignBoard board, String text1, String text2) {
        Random random = new Random();
        String text = text1;
        int frameSwitchRate = 10;
        int frameCount = 0;
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {

            SignBoard.Frame frame = board.newFrame();

            frameCount++;

            if (frameCount % frameSwitchRate == 0) {

                if (text.equalsIgnoreCase(text1)) {
                    text = text2;
                } else if (text.equalsIgnoreCase(text2)) {
                    text = text1;
                }
            }

            int color = random.nextInt(4);

            if (color == 0) {
                for (int i = 0; i < 10; i++) {
                    frame.setGreen();
                }
            } else if (color == 1) {
                for (int i = 0; i < 10; i++) {
                    frame.setRed();
                }
            } else if (color == 2) {
                for (int i = 0; i < 10; i++) {
                    frame.setWhite();
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    frame.setYellow();
                }
            }

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width) {
                // Fully on the board.
                frame.write(x, y, text);
            } else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));
            frame.finish(0.05);
        }
    }

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {

            scrollTextSceneCustom(signBoard, "$$$$$ C A S I N O $$$$$", "$$$$$    C.4.Q    $$$$$");
            ribbonSceneCustom(signBoard, 16, "Casino Night", "Win Big!!!");
        }
    }
}
