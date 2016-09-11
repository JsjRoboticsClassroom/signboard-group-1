package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     *
     * @param board     The board on which to draw.
     * @param numCycles The number of cycles to draw for.
     */
    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;
                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "*");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "*");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "*");
                }
            }

            frame.finish(0.02);
        }
    }

    /**
     * Rafael's custom version of the ribbon scene. Places two
     * strings in independent, random positions on the screen,
     * while randomly cycling text color between White, Green,
     * Red, and Yellow.
     *
     * @param board       The board on which to draw.
     * @param numCycles   The number of cycles to draw for.
     * @param ribbonText1 First of two Strings to draw to the screen.
     * @param ribbonText2 Second of two Strings to draw to screen.
     */

    public static void ribbonSceneRafael(SignBoard board, int numCycles, String ribbonText1, String ribbonText2) {

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

    /**
     * Draws a scene with text scrolling across the screen..
     *
     * @param board The board on which to draw.
     * @param text  The text to scroll.
     */
    public static void scrollTextScene(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.02);
        }
    }

    //** Rafael's custom version of the scroll text scene

    public static void scrollTextSceneRafael(SignBoard board, String text1, String text2) {
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

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     *
     * @param board  The board on which to draw.
     * @param cycles The number of cycles to draw for.
     */
    public static void flashFreshHotScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 7;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 2, "FFFF RRR  EEEE  SSS H  H");
                frame.write(leftPosition, y - 1, "F    R RR E    SS   H  H");
                frame.write(leftPosition, y, "FFR  RRR  EEE   SS  HHHH");
                frame.write(leftPosition, y + 1, "F    R R  E      SS H  H");
                frame.write(leftPosition, y + 2, "F    R  R EEEE SSS  H  H");
            } else {
                frame.write(rightPosition, y - 2, "H  H  OO  TTTT");
                frame.write(rightPosition, y - 1, "H  H O  O  TT ");
                frame.write(rightPosition, y, "HHHH O  O  TT ");
                frame.write(rightPosition, y + 1, "H  H O  O  TT ");
                frame.write(rightPosition, y + 2, "H  H  OO   TT ");
            }

            frame.finish(0.25);
        }
    }


    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {

            scrollTextSceneRafael(signBoard, "$$$$$ C A S I N O $$$$$", "$$$$$    C.4.Q    $$$$$");
            ribbonSceneRafael(signBoard, 16, "Casino Night", "Win Big!!!");
//            scrollTextScene(signBoard, "###  F A L A F E L  ###");
//            ribbonScene(signBoard, 48);
//            flashFreshHotScene(signBoard, 8);
//            }
        }
    }
}
