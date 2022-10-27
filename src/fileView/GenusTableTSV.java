package fileView;

import data.InfoList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenusTableTSV {
    Scanner scanner;

    public GenusTableTSV(File file) throws IOException, InvalidFormatException {
        scanner = new Scanner(file);
    }

    public void getClose() throws IOException {
        scanner.close();
    }

    public void getGenusTable(InfoList infoList){
        scanner.nextLine();
        for(int k = 0;scanner.hasNextLine();k++){
            String line;
            line = scanner.nextLine();
            String[] elements = line.split("\t");
            for (int i = 0; i < elements.length; i++){
                infoList.genusTable.add(new ArrayList<>());
                infoList.genusTable.get(k).add(elements[i]);
            }
        }
    }

}