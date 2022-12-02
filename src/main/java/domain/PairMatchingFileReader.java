package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatchingFileReader {

    private BufferedReader bufferedReader;

    public BufferedReader createBufferedReader(FileReader fileReader) {
        bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    public List<String> backEndReader() throws IOException {
        List<String> backEndGroup = new ArrayList<>();
        FileReader fileReader = new FileReader("src/main/resources/backend-crew.md");
        BufferedReader bufferedReader = createBufferedReader(fileReader);
        addGroup(backEndGroup, bufferedReader);
        return backEndGroup;
    }

    public List<String> frontEndReader() throws IOException {
        List<String> frontEndGroup = new ArrayList<>();
        FileReader fileReader = new FileReader("src/main/resources/frontend-crew.md");
        BufferedReader bufferedReader = createBufferedReader(fileReader);
        addGroup(frontEndGroup, bufferedReader);
        return frontEndGroup;
    }

    private static void addGroup(List<String> group, BufferedReader bufferedReader) throws IOException {
        while (true) {
            String name = bufferedReader.readLine();
            if (name == null) {
                break;
            }
            group.add(name);
        }
        bufferedReader.close();
    }

}
