package com.ryokuu;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

import com.ryokuu.util.CSVReader;
import com.ryokuu.util.FileGenerator;

public class Main {

    private static final String FILE_PATH = "/Users/ryokuu/Projects/scoremanagement/src/main/resources/data_sekolah.csv";
    private static final String GENERATED_PATH = "scoremanagement/src/main/resources/generated/";

    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class.getName());

        Menu menu = new Menu();
        FileGenerator fileGenerator = new FileGenerator();
        CSVReader csvReader = new CSVReader(fileGenerator);

        File fileModus = new File(GENERATED_PATH+"data_sekolah_modus.txt");
        File fileMedian = new File(GENERATED_PATH+"data_sekolah_modus_median.txt");


        try (Scanner inputScanner = new Scanner(System.in)) {
            int input;
            do {
                menu.printMainMenu();
                input = inputScanner.nextInt();

                switch (input) {
                    case 1:
                        if (fileModus.exists()) {
                            System.out.println("file "+ fileModus.getName()+" already been created!");
                            break;
                        }
                        csvReader.readFile(FILE_PATH);
                        fileGenerator.writeModus(GENERATED_PATH);
                        menu.printSubMenu();
                        input = inputScanner.nextInt();

                        break;
                    case 2:
                        if (fileMedian.exists()) {
                            System.out.println("file "+ fileMedian.getName()+" already been created!");
                            break;
                        }

                        break;
                    case 3:
                        if (fileModus.exists() && fileMedian.exists()) {
                            System.out.println("both file already been created!");
                            break;
                        }

                        
                    break;

                    default:
                        break;
                }
            } while (input != 0);


        }catch(Exception  e){
            log.info("error: "+ e.getMessage());
        }

        
        
    }
}