package nyc.c4q.ac21.signboard;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     * @param board
     *   The board on which to draw.
     * @param numCycles
     *   The number of cycles to draw for.
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
                    frame.write(x, y, "$");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "$");
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
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */
    public static void scrollTextScene(SignBoard board, int cycles) {
        int width = board.getWidth();
        int y = board.getHeight() / 2 - 4;
        Random random = new Random();
        for (int x = 0; x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();
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

            if (x >= width)
                break;

            if (((y + 6) <= 7) && (y >= 0) && ((x + 77) <= (width - 1)) && (x >= 0)) {
                //y++;
                x++;


                // Scrolling on to the left side.
                frame.write(0, y, "      ,''.-''| .---/ _`-._              \n");
                frame.write(0, y + 1, "    ,' \\ \\  ;| | ,/ / `-._`-. \n");
                frame.write(0, y + 2, "  ,' ,',\\ \\( | |// /,-._  / / \n");
//            else
//                // Scrolling off the board.
//                frame.write(x, y, "    ,' \\ \\  ;| | ,/ / `-._`-. \n".substring(0, width - x));
//
//            frame.finish(0.02);
            }
        }
    }

//"    ,' \\ \\  ;| | ,/ / `-._`-. \n" +
//        "  ,' ,',\\ \\( | |// /,-._  / / \n" +
//        "  ;.`. `,\\ \\`| |/ / |   )/ / \n" +
//        " / /`_`.\\_\\ \\| /_.-.'-''/ /  \n" +
//        "/ /_|_:.`. \\ |;'`..')  / /\n" +
//        "`-._`-._`.`.;`.\\  ,'  / / \n" +
//        "    `-._`.`/    ,'-._/ / \n" +
//        "      : `-/     \\`-.._/ \n");
    public static void rollingDice(SignBoard board, int cycles){
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < cycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = 2; x < width; ++x) {
                int y = 2;
                //int y = (2 * height - 2 + x + i) % (2 * height - 2);
//                if (y >= height)
//                    y = 2 * height - y - 2;
//                if (0 < x) {
//                    frame.setWhite();
//                    frame.write(x, y, "  $");
//                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x+1,y,"=-=-=-=-=-=");
//                    frame.write(x + 1, y, " _________\n" +
//                            " _ /_|_____|_\\ _\n" +
//                            "   '. \\   / .'\n" +
//                            "     '.\\ /.'\n" +
//                            "       '.'\n");
                }
//                if (x + 2 < width) {
//                    frame.setRed();
//                    frame.write(x + 2, y, " .........\n");
//                            "\" +\n" +
//                            "\"  :~, *   * ~,\\n\" +\n" +
//                            "\"  : ~, *   * ~.\\n\" +\n" +
//                            "\"  :  ~........~\\n\" +\n" +
//                            "\"  : *:         :      ~'~,\\n\" +\n" +
//                            "\"  :  :         :    ~' *  ~,\\n\" +\n" +
//                            "\"  ~* :    *    : ,~' *    * ~,\\n\" +\n" +
//                            "\"   ~,:         :.~,*    *  ,~ :\\n\" +\n" +
//                            "\"    ~:.........::  ~, *  ,~   :\\n\" +\n" +
//                            "\"                : *  ~,,~  *  :\\n\" +\n" +
//                            "\"                :* * * :  *   :\\n\" +\n" +
//                            "\"                 ~, *  : *  ,~\\n\" +\n" +
//                            "\"                     ~,  :  ,~\\n\" +\n" +
//                            "\"                     ~,:,~");
                //}
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
    public static void flashingTextWesnie(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = 110;
        int rightPosition = 5;
        int monteCarloposition = 40;
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
            else if(i%2==0) {
                frame.write(rightPosition, y - 4, "|  \\  |  \\                              |  \\    /  \\                  |  \\      ");
                frame.write(rightPosition, y - 3, "| $$\\ | $$  ______   __   __   __        \\$$\\  /  $$______    ______  | $$   __ ");
                frame.write(rightPosition, y - 2, "| $$$\\| $$ /      \\ |  \\ |  \\ |  \\        \\$$\\/  $$/      \\  /      \\ | $$  /  \\");
                frame.write(rightPosition, y - 1, "| $$$$\\ $$|  $$$$$$\\| $$ | $$ | $$         \\$$  $$|  $$$$$$\\|  $$$$$$\\| $$_/  $$");
                frame.write(rightPosition, y    , "| $$\\$$ $$| $$    $$| $$ | $$ | $$          \\$$$$ | $$  | $$| $$   \\$$| $$   $$ ");
                frame.write(rightPosition, y + 1, "| $$ \\$$$$| $$$$$$$$| $$_/ $$_/ $$          | $$  | $$__/ $$| $$      | $$$$$$\\ ");
                frame.write(rightPosition, y + 2, "| $$  \\$$$ \\$$     \\ \\$$   $$   $$          | $$   \\$$    $$| $$      | $$  \\$$\\");
                frame.write(rightPosition, y + 3, " \\$$   \\$$  \\$$$$$$$  \\$$$$$\\$$$$            \\$$    \\$$$$$$  \\$$       \\$$   \\$$");

            }

            if (i % 7==0) {
                    frame.write(monteCarloposition, y - 4, " ___ ___  ___  ____  ______   ___         __  ____ ____  _      ___  ");
                    frame.write(monteCarloposition, y - 3, "|   |   |/   \\|    \\|      | /  _]       /  ]/    |    \\| |    /   \\ ");
                    frame.write(monteCarloposition, y - 2, "\\| |\\/| |/  | | | <|  \\| |>   | |   |  _|\"      \\| | u  \\/ _ \\/ \\|");
                    frame.write(monteCarloposition, y - 1, "|  \\_/  |  O  |  |  |_|  |_|    _]     /  / |     |    /| |___|  O  |");
                    frame.write(monteCarloposition, y,     "|   |   |     |  |  | |  | |   [_     /   \\_|  _  |    \\|     |     |");
                    frame.write(monteCarloposition, y + 1, "|   |   |     |  |  | |  | |     |    \\     |  |  |  .  |     |     |");
                    frame.write(monteCarloposition, y + 2, "|___|___|\\___/|__|__| |__| |_____|     \\____|__|__|__|\\_|_____|\\___/ ");
            }

            frame.finish(0.23);
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






//                    frame.write(monteCarloposition, y - 4, "  __  __    U  ___ u  _   _     _____  U _____ u       ____     _       ____      _       U  ___ u ");
//                    frame.write(monteCarloposition, y - 3, "U|' \\/ '|u  \\/\"_ \\/| \\ |\"|   |_ \" _| \\| ___\"|/    U /\"___|U  /\"\\  uU |  _\"\\ u  |\"|       \\/\"_ \\/ ");
//                    frame.write(monteCarloposition, y - 2, "\\| |\\/| |/  | | | <|  \\| |>   | |   |  _|\"      \\| | u  \\/ _ \\/ \\| |_) |U | | u    | | | | ");
//                    frame.write(monteCarloposition, y - 1, " | |  | |.-,_| |_| |U| |\\  |u   /| |\\  | |___       | |/__  / ___ \\   |  _ <   \\| |/__.-,_| |_| | ");
//                    frame.write(monteCarloposition, y, " |_|  |_| \\_)-\\___/  |_| \\_|   u |_|U   |_____|       \\____|/_/   \\_\\  |_| \\_\\   |_____|\\_)-\\___/  ");
//                    frame.write(monteCarloposition, y + 1, "<<,-,,-.       \\\\    ||   \\\\,-._// \\\\_  <<   >>      _// \\\\  \\\\    >>  //   \\\\_  //  \\\\      \\\\    ");
//                    frame.write(monteCarloposition, y + 2, " (./  \\.)     (__)   (_\")  (_/(__) (__)(__) (__)    (__)(__)(__)  (__)(__)  (__)(_\")(\"_)    (__)   ");
                }
            }

            frame.finish(0.20);
        }
    }

    public static void printCasino(SignBoard board, int cycles) {
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

                frame.write(x+70, y+0, "   _________\n");
                frame.write(x+70, y+1, " _ /_|_____|_\\ _\n");
                frame.write(x+70,y+ 2, "   '. \\   / .'\n");
                frame.write(x+70, y+3, "     '.\\ /.'\n");
                frame.write(x+70, y+4, "       '.'\n");


                frame.finish(0.03);

                if (((y+6)<= 7) && (y >=0) && ((x+77)<=(width-1)) && (x>=0)) {
                    //y++;
                    x++;

                }
//                if ((x+77)<=(width-1) && x>=0){
//                    x++;
//                }
                //else if ()

            }
        }
    }
    public static void printImages(SignBoard board, int cycles) {
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
                frame.write(3, y,"       _..-''--'----_.                                        \n");
                   frame.write(3,y+1,"      ,''.-''| .---/ _`-._              \n");
                        frame.write(3, y+2,"    ,' \\ \\  ;| | ,/ / `-._`-. \n");
                        frame.write(3,y+3,"  ,' ,',\\ \\( | |// /,-._  / / \n");
                        frame.write(3,y+4,"  ;.`. `,\\ \\`| |/ / |   )/ / \n");
                        frame.write(3,y+5," / /`_`.\\_\\ \\| /_.-.'-''/ /  \n");
                        frame.write(3,y+6,"/ /_|_:.`. \\ |;'`..')  / /\n");
                        frame.write(3,y+7,"`-._`-._`.`.;`.\\  ,'  / / \n");




                //Rainbow Cards
                        frame.write(35,y,"                    _____  |K  WW|                      \n");
                        frame.write(35,y+1,"              _____  |Q  ww| |   {)|                      \n");
                        frame.write(35,y+2,"       _____ |J  ww| |   {(| |(v)%%| _____                \n");
                        frame.write(35,y+3,"      |10 v ||   {)| |(v)%%| | v%%%||A_ _ |               \n");
                        frame.write(35,y+4,"      |v v v||(v)% | | v%%%| |_%%%>||( v )|               \n");
                        frame.write(35,y+5,"      |v v v|| v % | |_%%%O|        | \\ / |               \n");
                        frame.write(35,y+6,"      |v v v||__%%[|                |  .  |               \n");
                        frame.write(35,y+7,"      |___0I|                       |____V|   ");


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

                frame.write(150,y,"|  _ _   MMMMM   |\n");
                frame.write( 150,y+1,"| (  ) | o o |  |\n");
                frame.write(150,y+2,"|  `.'   | - /   |\n");
                frame.write(150,y+3,"|  |/  ---`W'--. |\n");
                frame.write(150,y+4,"|  | |     .-') |\n");
                frame.write( 150,y+5,"| |    |  .-'   ) |\n");
                frame.write(150,y+6,"|     .-'      ) |\n");
                frame.write(150,y+7,"|  .-'      .-'  |\n");
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

            printCasino(signBoard,90);
            ribbonScene(signBoard, 40);
            flashDiceWesnie(signBoard,10);
            //flashingTextWesnie(signBoard, 20);
            printImages(signBoard, 50);
            scrollTextScene(signBoard, 90);
            //rollingDice(signBoard,5);
            //ribbonScene(signBoard, 48);
            //flashDiceWesnie(signBoard,30);

        }
    }
    }
