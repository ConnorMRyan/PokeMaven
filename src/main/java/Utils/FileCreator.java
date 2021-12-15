package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void printMoves(int begining, int ending) throws Exception {
        APIParser apiParser = new APIParser();
        for (int i = begining; i <= ending; i++) {
            FileWriter fw = new FileWriter(new File("MoveJSONs/" + i + ".json"));
            fw.write(apiParser.makeAMove("" + i));
            fw.flush();
            fw.close();
        }
    }
}
