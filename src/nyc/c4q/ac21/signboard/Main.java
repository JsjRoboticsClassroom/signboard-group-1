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



    public static String dollarSign3[]={



            "SSSSSSSSSs. SSSSSSSSSs. SSSSSSSSSs.\n",
            "SSSSSSSSSSS SSSSSSSSSSS SSSSSSSSSSS\n",
            "     S SSS       S SSS       S SSS \n",
            "   S  SS       S  SS       S  SS   \n",
            "  S..SS       S..SS       S..SS    \n",
            " S:::S       S:::S       S:::S     \n",
            "S;;;S       S;;;S       S;;;S      \n",
            "S%%%S       S%%%S       S%%%S      \n"




    };


    public static String dollarSign2[]={


            "SSSSSSSSSs. SSSSSSSSSs. \n",
            "SSSSSSSSSSS SSSSSSSSSSS \n",
            "     S SSS       S SSS  \n",
            "   S  SS       S  SS    \n",
            "  S..SS       S..SS     \n",
            " S:::S       S:::S      \n",
            "S;;;S       S;;;S       \n",
            "S%%%S       S%%%S       \n"






    };

    public static String dollar[]={
            "    A           A     \n",
            " .d8888.     .d8888.  \n",
            " 88'8 YP     88'8 YP  \n",
            " `8b8.       `8b8.    \n",
            "   `V8b.       `V8b.  \n",
            " db 8 8D     db 8 8D  \n",
            " `8888Y'     `8888Y'  \n",
            "    V           V     \n"



    };


    public static String dollarSign1[]={


            "SSSSSSSSSs.\n",
            "SSSSSSSSSSS\n",
            "     S SSS \n",
            "   S  SS   \n",
            "  S..SS    \n",
            " S:::S     \n",
            "S;;;S      \n",
            "S%%%S      \n"


    };



    public static void scrollTextSceneCustom(SignBoard board, String text[]) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;

        for (int x = -text[0].length()+6; x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0){
                boolean colorFlag = false;
                int delta=-text.length/2;
                // Scrolling on to the left side.
                for(int j=0;j<text.length;j++) {
                    frame.setRed();
                    if(colorFlag){
                        frame.setGreen();
                    }

                    frame.write(0, y+delta, text[j].substring(-x));
                    colorFlag=!colorFlag;
                    delta ++;
                }


            }

            else if (x + text[0].length()<= width){
                boolean colorFlag = false;
                int delta=-text.length/2;
                // Fully on the board.
                for(int j=0;j<text.length;j++) {
                    frame.setRed();
                    if(colorFlag){
                        frame.setWhite();
                    }
                    frame.write(x, y+delta, text[j]);
                    delta ++;
                    colorFlag=!colorFlag;
                }

            }
            else{
                // Scrolling off the board.
                boolean colorFlag = false;
                int delta=-text.length/2;
                for(int j=0;j<text.length;j++) {
                    frame.setGreen();
                    if(colorFlag){
                        frame.setWhite();
                    }
                    frame.write(x, y+delta, text[j].substring(0, width - x));
                    colorFlag=!colorFlag;
                    delta ++;

                }

            }

            frame.finish(0.02);
        }
    }

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void flashFreshHotSceneCustom(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 2 * width / 4 - 7;
        int y = board.getHeight() / 2;
        boolean colorFlag= false;
        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();



            // Write a word.
            if (i % 2 == 0) {
                frame.setRed();
                if(colorFlag){frame.setWhite();}
                frame.write(leftPosition, y - 4, "    /$$$$$                     /$$     ");
                frame.write(leftPosition, y - 3, "   |__  $$                    | $$     ");
                frame.write(leftPosition, y - 2, "      | $$  /$$$$$$   /$$$$$$$| $$   /$$");
                frame.write(leftPosition, y - 1, "      | $$ |____  $$ /$$_____/| $$  /$$/");
                frame.write(leftPosition, y    , " /$$  | $$  /$$$$$$$| $$      | $$$$$$/ ");
                frame.write(leftPosition, y + 1, "| $$  | $$ /$$__  $$| $$      | $$_  $$ ");
                frame.write(leftPosition, y + 2, "|  $$$$$$/|  $$$$$$$|  $$$$$$$| $$ \\  $$");
                frame.write(leftPosition, y + 3, "\\______/ \\_______/\\_______/|__/  \\__/");

                colorFlag=!colorFlag;
            }
            else {

                frame.setGreen();


                frame.write(rightPosition, y - 4, " /$$$$$$$             /$$");
                frame.write(rightPosition, y - 3, "| $$__  $$           | $$");
                frame.write(rightPosition, y - 2, "| $$ \\ $$ /$$$$$$  /$$$$$$");
                frame.write(rightPosition, y - 1, "| $$$$$$$//$$__  $$|_  $$_/");
                frame.write(rightPosition, y    , "| $$____/| $$ \\ $$  | $$ ");
                frame.write(rightPosition, y + 1, "| $$     | $$  | $$  | $$ /$$");
                frame.write(rightPosition, y + 2, "| $$     |  $$$$$$/  |  $$$$/");
                frame.write(rightPosition, y + 3, "|__/     \\______/   \\___/ ");

            }

            frame.finish(0.25);
        }
    }

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {

            scrollTextSceneCustom(signBoard, "$$$$$ C A S I N O $$$$$", "$$$$$    C.4.Q    $$$$$");
            scrollTextSceneCustom(signBoard, dollarSign1);
            scrollTextSceneCustom(signBoard, dollarSign2);
            scrollTextSceneCustom(signBoard, dollarSign3);
            ribbonSceneCustom(signBoard, 16, "Casino Night", "Win Big!!!");
            flashFreshHotSceneCustom(signBoard, 8);
            scrollTextSceneCustom(signBoard, "$$$$$ C A S I N O $$$$$", "$$$$$    C.4.Q    $$$$$");

        }
    }
}
