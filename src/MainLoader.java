import data.InfoList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainLoader extends JFrame {
    Workbook workbook;
    String xlsxDirectoryPath;
    int numberFile;
    public MainLoader(String xlsxDirectoryPath, int numberFile) throws IOException, InvalidFormatException {
        this.xlsxDirectoryPath = xlsxDirectoryPath;
        this.numberFile = numberFile;
        workbook = new XSSFWorkbook(new FileInputStream(Application.rootDirPath + "//obrSamp.xlsx"));
    }

    public void setPhylum(InfoList infoList){
        ArrayList<CellStyle> cellStyles = new ArrayList<>();
        cellStyles.add(workbook.getSheet("Phylum").getRow(0).getCell(0).getCellStyle());
        cellStyles.add(workbook.getSheet("Phylum").getRow(0).getCell(1).getCellStyle());
        for (int i = 0; i < infoList.phylumTable.size();i++){
            workbook.getSheet("Phylum").createRow(i).createCell(0).setCellValue(infoList.phylumTable.get(i).get(0));
            workbook.getSheet("Phylum").setColumnWidth(0, 10000);
            workbook.getSheet("Phylum").getRow(i).createCell(1).setCellValue(infoList.phylumTable.get(i).get(numberFile+1));
            workbook.getSheet("Phylum").getRow(i).getCell(0).setCellStyle(cellStyles.get(0));
            workbook.getSheet("Phylum").getRow(i).getCell(1).setCellStyle(cellStyles.get(1));
        }
    }

    public void setClass(InfoList infoList){
        ArrayList<CellStyle> cellStyles = new ArrayList<>();
        cellStyles.add(workbook.getSheet("Class").getRow(0).getCell(0).getCellStyle());
        cellStyles.add(workbook.getSheet("Class").getRow(0).getCell(1).getCellStyle());
        for (int i = 0; i < infoList.classTable.size();i++){
            workbook.getSheet("Class").createRow(i).createCell(0).setCellValue(infoList.classTable.get(i).get(0));
            workbook.getSheet("Class").setColumnWidth(0, 10000);
            workbook.getSheet("Class").getRow(i).createCell(1).setCellValue(infoList.classTable.get(i).get(numberFile+1));
            workbook.getSheet("Class").getRow(i).getCell(0).setCellStyle(cellStyles.get(0));
            workbook.getSheet("Class").getRow(i).getCell(1).setCellStyle(cellStyles.get(1));
        }
    }

    public void setGenus(InfoList infoList){
        ArrayList<CellStyle> cellStyles = new ArrayList<>();
        cellStyles.add(workbook.getSheet("Genus").getRow(0).getCell(0).getCellStyle());
        cellStyles.add(workbook.getSheet("Genus").getRow(0).getCell(1).getCellStyle());
        for (int i = 0; i < infoList.genusTable.size();i++){
            workbook.getSheet("Genus").createRow(i).createCell(0).setCellValue(infoList.genusTable.get(i).get(0));
            workbook.getSheet("Genus").setColumnWidth(0, 10000);
            workbook.getSheet("Genus").getRow(i).createCell(1).setCellValue(infoList.genusTable.get(i).get(numberFile+1));
            workbook.getSheet("Genus").getRow(i).getCell(0).setCellStyle(cellStyles.get(0));
            workbook.getSheet("Genus").getRow(i).getCell(1).setCellStyle(cellStyles.get(1));
        }
    }

    public void setSpecies(InfoList infoList){
        ArrayList<CellStyle> cellStyles = new ArrayList<>();
        cellStyles.add(workbook.getSheet("Species").getRow(0).getCell(0).getCellStyle());
        cellStyles.add(workbook.getSheet("Species").getRow(0).getCell(1).getCellStyle());
        for (int i = 0; i < infoList.speciesTable.size();i++){
            workbook.getSheet("Species").createRow(i).createCell(0).setCellValue(infoList.speciesTable.get(i).get(0));
            workbook.getSheet("Species").setColumnWidth(0, 10000);
            workbook.getSheet("Species").getRow(i).createCell(1).setCellValue(infoList.speciesTable.get(i).get(numberFile+1));
            workbook.getSheet("Species").getRow(i).getCell(0).setCellStyle(cellStyles.get(0));
            workbook.getSheet("Species").getRow(i).getCell(1).setCellStyle(cellStyles.get(1));
        }
    }

    public void setFamily(InfoList infoList){
        ArrayList<CellStyle> cellStyles = new ArrayList<>();
        cellStyles.add(workbook.getSheet("Family").getRow(0).getCell(0).getCellStyle());
        cellStyles.add(workbook.getSheet("Family").getRow(0).getCell(1).getCellStyle());
        for (int i = 0; i < infoList.familyTable.size();i++){
            workbook.getSheet("Family").createRow(i).createCell(0).setCellValue(infoList.familyTable.get(i).get(0));
            workbook.getSheet("Family").setColumnWidth(0, 10000);
            workbook.getSheet("Family").getRow(i).createCell(1).setCellValue(infoList.familyTable.get(i).get(numberFile+1));
            workbook.getSheet("Family").getRow(i).getCell(0).setCellStyle(cellStyles.get(0));
            workbook.getSheet("Family").getRow(i).getCell(1).setCellStyle(cellStyles.get(1));
        }
    }

    public void setBioIndex(InfoList infoList){
        ArrayList<CellStyle> cellStyles = new ArrayList<>();
        cellStyles.add(workbook.getSheet("BioIndex").getRow(0).getCell(0).getCellStyle());
        cellStyles.add(workbook.getSheet("BioIndex").getRow(0).getCell(1).getCellStyle());
        cellStyles.add(workbook.getSheet("BioIndex").getRow(0).getCell(2).getCellStyle());
        workbook.getSheet("BioIndex").createRow(0).createCell(0).setCellValue("BioIndex");
        workbook.getSheet("BioIndex").getRow(0).createCell(1).setCellValue(infoList.bioIndexTable.get(numberFile));
        if(Double.parseDouble(infoList.bioIndexTable.get(numberFile)) < 3.1){
            workbook.getSheet("BioIndex").getRow(0).createCell(2).setCellValue("Низкое значение");
        } else if(Double.parseDouble(infoList.bioIndexTable.get(numberFile)) >= 3.1
                && Double.parseDouble(infoList.bioIndexTable.get(numberFile)) <= 4.2
        ) {
            workbook.getSheet("BioIndex").getRow(0).createCell(2).setCellValue("Среднее значение");
        } else {
            workbook.getSheet("BioIndex").getRow(0).createCell(2).setCellValue("Высокое значение");
        }
        workbook.getSheet("BioIndex").getRow(0).getCell(0).setCellStyle(cellStyles.get(0));
        workbook.getSheet("BioIndex").getRow(0).getCell(1).setCellStyle(cellStyles.get(1));
        workbook.getSheet("BioIndex").getRow(0).getCell(2).setCellStyle(cellStyles.get(2));
    }

    public void getClose() throws IOException {
        workbook.close();
    }

    public void saveFile(InfoList infoList) throws IOException {
        workbook.write(new FileOutputStream(xlsxDirectoryPath + "\\" + infoList.idFileName.get(numberFile) + ".xlsx"));
    }
}