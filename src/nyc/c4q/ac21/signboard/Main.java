package nyc.c4q.ac21.signboard;

import java.util.ArrayList;
import java.util.Random;

public class Main {


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



    public static void scrollTextSceneMila(SignBoard board, String text[]) {
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
            frame.finish(0.03);
        }
    }


    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void flashFreshHotSceneMila(SignBoard board, int cycles) {
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

    public static void ribbonSceneMila(SignBoard board, int numCycles, String ribbonText1, String ribbonText2) {

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

    public static void ribbonSceneWesnie(SignBoard board, int numCycles) {
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
                    frame.write(x, y, "$");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "$");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "$");
                }

            }

            frame.finish(0.02);
        }
    }

    public static void flashDiceWesnie(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = 10;
        int rightPosition = width / 4;
        int monteCarloposition = 80;
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
            if (i % 3 == 0) {
                frame.write(leftPosition, y - 4, " )\\ )                                           ");
                frame.write(leftPosition, y - 3, "(()/(     )       (   (    (   (  (      )      ");
                frame.write(leftPosition, y - 2  , " /(_)) ( /(  (    )\\  )\\  ))\\  )\\))(  ( /(  (   ");
                frame.write(leftPosition, y - 1, "(_))   )(_)) )\\  ((_)((_)/((_)((_))\\  )(_)) )\\  ");
                frame.write(leftPosition, y    , "| |   ((_)_ ((_) \\ \\ / /(_))   (()(_)((_)_ ((_) ");
                frame.write(leftPosition, y + 1, "| |__ / _` |(_-<  \\ V / / -_) / _` | / _` |(_-< ");
                frame.write(leftPosition, y + 2, "|____|\\__,_|/__/   \\_/  \\___| \\__, | \\__,_|/__/ ");
                frame.write(leftPosition, y + 3, "                              |___/             ");
            }
            else {
                if (i % 5 == 0) {
                    frame.write(rightPosition, y - 4, "|  \\  |  \\                              |  \\    /  \\                  |  \\      ");
                    frame.write(rightPosition, y - 3, "| $$\\ | $$  ______   __   __   __        \\$$\\  /  $$______    ______  | $$   __ ");
                    frame.write(rightPosition, y - 2, "| $$$\\| $$ /      \\ |  \\ |  \\ |  \\        \\$$\\/  $$/      \\  /      \\ | $$  /  \\");
                    frame.write(rightPosition, y - 1, "| $$$$\\ $$|  $$$$$$\\| $$ | $$ | $$         \\$$  $$|  $$$$$$\\|  $$$$$$\\| $$_/  $$");
                    frame.write(rightPosition, y, "| $$\\$$ $$| $$    $$| $$ | $$ | $$          \\$$$$ | $$  | $$| $$   \\$$| $$   $$ ");
                    frame.write(rightPosition, y + 1, "| $$ \\$$$$| $$$$$$$$| $$_/ $$_/ $$          | $$  | $$__/ $$| $$      | $$$$$$\\ ");
                    frame.write(rightPosition, y + 2, "| $$  \\$$$ \\$$     \\ \\$$   $$   $$          | $$   \\$$    $$| $$      | $$  \\$$\\");
                    frame.write(rightPosition, y + 3, " \\$$   \\$$  \\$$$$$$$  \\$$$$$\\$$$$            \\$$    \\$$$$$$  \\$$       \\$$   \\$$");

                }
                else if (i % 4 ==0) {
                    frame.write(monteCarloposition, y - 4, " ___ ___  ___  ____  ______   ___         __  ____ ____  _      ___  ");
                    frame.write(monteCarloposition, y - 3, "|   |   |/   \\|    \\|      | /  _]       /  ]/    |    \\| |    /   \\ ");
                    frame.write(monteCarloposition, y - 2, "\\| |\\/| |/  | | | <|  \\| |>   | |   |  _|\"      \\| | u  \\/ _ \\/ \\|");
                    frame.write(monteCarloposition, y - 1, "|  \\_/  |  O  |  |  |_|  |_|    _]     /  / |     |    /| |___|  O  |");
                    frame.write(monteCarloposition, y,     "|   |   |     |  |  | |  | |   [_     /   \\_|  _  |    \\|     |     |");
                    frame.write(monteCarloposition, y + 1, "|   |   |     |  |  | |  | |     |    \\     |  |  |  .  |     |     |");
                    frame.write(monteCarloposition, y + 2, "|___|___|\\___/|__|__| |__| |_____|     \\____|__|__|__|\\_|_____|\\___/ ");


                }
            }

            frame.finish(0.20);
        }
    }

    public static void printCasinoWesnie(SignBoard board, int cycles) {
        Random random = new Random();
        SignBoard.Frame frame = board.newFrame();
        frame.setWhite();
        frame.setGreen();
        int x = 0;
        int y = 0;
        int height = board.getHeight();
        int width = board.getWidth();
        ArrayList<String> casinoArr = new ArrayList<>();
        if ((y < (height-1)) && (x < (width-1))) {
            for (int i = 0; i < cycles; i++) {
                frame = board.newFrame();
                int color = random.nextInt(4);

                switch (color) {
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
                frame.write(x, y, "   ______        _         ______    _____   ____  _____     ___    \n");
                frame.write(x, y + 1, " .' ___  |      / \\      .' ____ \\  |_   _| |_   \\|_   _|  .'   `.  \n");
                frame.write(x, y + 2, "/ .'   \\_|     / _ \\     | (___ \\_|   | |     |   \\ | |   /  .-.  \\ \n");
                frame.write(x, y + 3, "| |           / ___ \\     _.____`.    | |     | |\\ \\| |  | |   | | \n");
                frame.write(x, y + 4, "\\ `.___.'\\  _/ /   \\ \\_  | \\____) |  _| |_   _| |_\\   |_  \\  `-'  / \n");
                frame.write(x, y + 5, " `.____ .' |____| |____|  \\______.' |_____| |_____|\\____|  `.___.'  ");



                //Diamond

                frame.write(x+70, y, "   _________\n");
                frame.write(x+70, y+1, " _ /_|_____|_\\ _\n");
                frame.write(x+70,y+ 2, "   '. \\   / .'\n");
                frame.write(x+70, y+3, "     '.\\ /.'\n");
                frame.write(x+70, y+4, "       '.'\n");


                frame.finish(0.03);

                if (((y+6)<= 7) && (y >=0) && ((x+77)<=(width-1)) && (x>=0)) {
                    //y++;
                    x++;

                }
            }
        }
    }

    public static void printImagesWesnie(SignBoard board, int cycles) {
        Random random = new Random();
        SignBoard.Frame frame = board.newFrame();
        int x = 0;
        int y = 0;
        int height = board.getHeight();
        int width = board.getWidth();
        if ((y < (height - 1)) && (x < (width - 1))) {
            for (int i = 0; i < cycles; i++) {
                frame = board.newFrame();
                int color = random.nextInt(4);

                switch (color) {
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
                frame.write(3, y, "       _..-''--'----_.                                        \n");
                frame.write(3, y + 1, "      ,''.-''| .---/ _`-._              \n");
                frame.write(3, y + 2, "    ,' \\ \\  ;| | ,/ / `-._`-. \n");
                frame.write(3, y + 3, "  ,' ,',\\ \\( | |// /,-._  / / \n");
                frame.write(3, y + 4, "  ;.`. `,\\ \\`| |/ / |   )/ / \n");
                frame.write(3, y + 5, " / /`_`.\\_\\ \\| /_.-.'-''/ /  \n");
                frame.write(3, y + 6, "/ /_|_:.`. \\ |;'`..')  / /\n");
                frame.write(3, y + 7, "`-._`-._`.`.;`.\\  ,'  / / \n");


                //Rainbow Cards
                frame.write(35, y, "                    _____  |K  WW|                      \n");
                frame.write(35, y + 1, "              _____  |Q  ww| |   {)|                      \n");
                frame.write(35, y + 2, "       _____ |J  ww| |   {(| |(v)%%| _____                \n");
                frame.write(35, y + 3, "      |10 v ||   {)| |(v)%%| | v%%%||A_ _ |               \n");
                frame.write(35, y + 4, "      |v v v||(v)% | | v%%%| |_%%%>||( v )|               \n");
                frame.write(35, y + 5, "      |v v v|| v % | |_%%%O|        | \\ / |               \n");
                frame.write(35, y + 6, "      |v v v||__%%[|                |  .  |               \n");
                frame.write(35, y + 7, "      |___0I|                       |____V|   ");


                //Slot Machine

                frame.write(86, y, "{-JACKPOT-}Oo \n");
                frame.write(86, y + 1, ".=============. __\n");
                frame.write(86, y + 2, "| [a] [X] [o] |(  )\n");
                frame.write(86, y + 3, "| [$] [$] [$] | ||\n");
                frame.write(86, y + 4, "| [X] [o] [$] | ||\n");
                frame.write(86, y + 5, "|             |_||\n");
                frame.write(86, y + 6, "| xxx ::::::: |--'\n");
                frame.write(86, y + 7, "| ooo ::::::: |\n");


                //Casino Building


                frame.write(110, y, "               | |\n");
                frame.write(110, y + 1, "          ,  _+|_|+_  ,\n");
                frame.write(110, y + 2, "         )A( |:|:|:| )A(\n");
                frame.write(110, y + 3, "         | |_||H|H||_| |\n");
                frame.write(110, y + 4, "    ,    | |:|:|:|:|:| |    ,\n");
                frame.write(110, y + 5, "   )A(_+_| ||H|H|H|H|| |_+_)A(\n");
                frame.write(110, y + 6, "   | |:|:| |:|:|:|:|:| |:|:| |\n");
                frame.write(110, y + 7, "   | ||H|| ||H|H|H|H|| ||H|| |\n");


                //King Card

                frame.write(150, y, "|  _ _   MMMMM   |\n");
                frame.write(150, y + 1, "| (  ) | o o |  |\n");
                frame.write(150, y + 2, "|  `.'   | - /   |\n");
                frame.write(150, y + 3, "|  |/  ---`W'--. |\n");
                frame.write(150, y + 4, "|  | |     .-') |\n");
                frame.write(150, y + 5, "| |    |  .-'   ) |\n");
                frame.write(150, y + 6, "|     .-'      ) |\n");
                frame.write(150, y + 7, "|  .-'      .-'  |\n");
//     | (      .-'     |
//                        | (   .-'  |     |
//                        | (.-'     | \|  |
//                        | '--.M.---  /|  |
//                        |   / - \   .^.  |
//     |  | o o | ( . ) |
//                VK  |   WWWWW   " "  |
//     `----------------'


                frame.finish(0.03);
            }

        }
    }

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            flashDiceWesnie(signBoard, 10);
            printCasinoWesnie(signBoard, 40);
            scrollTextSceneRafael(signBoard, "$$$$$ C A S I N O $$$$$", "$$$$$    C.4.Q    $$$$$");
            scrollTextSceneMila(signBoard, dollarSign1);
            scrollTextSceneMila(signBoard, dollarSign2);
            scrollTextSceneMila(signBoard, dollarSign3);
            ribbonSceneMila(signBoard, 16, "Casino Night", "Win Big!!!");
            flashFreshHotSceneMila(signBoard, 8);
            printImagesWesnie(signBoard, 50);
            scrollTextSceneRafael(signBoard, "$$$$$ C A S I N O $$$$$", "$$$$$    C.4.Q    $$$$$");
            ribbonSceneWesnie(signBoard, 40);
        }
    }
}
