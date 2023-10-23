package com.ryokuu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.ryokuu.Menu;

public class CSVReader {
    
    FileGenerator fileGenerator;

    public CSVReader(FileGenerator fileGenerator) {
        this.fileGenerator = fileGenerator;

    }

    public void readFile(String filePath){

        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {

                String val = scanner.next().trim();

                if(val.matches("\\d+")){
                    fileGenerator.storeData(Integer.valueOf(val));
                    
                }

            }

        } catch (FileNotFoundException e) {

            Menu menu = new Menu();
            menu.printFileNotFound();
        } catch (Exception e){
            e.printStackTrace();
        }

    }



}
