import data.InfoList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainLoader extends JFrame {
    Workbook workbook;
    String fileName;
    public MainLoader(File file) throws IOException, InvalidFormatException {
        String filePath = file.getPath().replace(".tsv", ".xlsx");
        this.fileName = file.getName().replace(".tsv", ".xlsx");
        workbook = new XSSFWorkbook(new FileInputStream(filePath));
    }

    public void setBacteriaFamily(InfoList infoList){
        workbook.createSheet("Семейства");
        for (int i = 0; i < infoList.bacteriaFamily.size();i++){
            workbook.getSheet("Семейства").createRow(i).createCell(0).setCellValue(infoList.bacteriaFamily.get(i).get(0));
            workbook.getSheet("Семейства").setColumnWidth(0, 10000);
            workbook.getSheet("Семейства").getRow(i).createCell(1).setCellValue(infoList.bacteriaFamily.get(i).get(1));
            workbook.getSheet("Семейства").getRow(i).createCell(2).setCellValue(infoList.bacteriaFamily.get(i).get(2));
        }
    }

    public void getClose() throws IOException {
        workbook.close();
    }

    public void saveFile(String dirUnloadPath) throws IOException {
        workbook.write(new FileOutputStream(dirUnloadPath + "\\" + fileName));
    }
}

