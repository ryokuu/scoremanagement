package com.ryokuu.util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.ryokuu.Menu;

public class FileGenerator {
    

    Menu menu = new Menu();

    List<Integer> storedData = new ArrayList<>();
    int below6 = 0;
    int counter6 = 0;
    int counter7 = 0;
    int counter8 = 0;
    int counter9 = 0;
    int counter10 = 0;

    public void storeData(int val){

        storedData.add(val);

        switch (val) {
            case 6:
                counter6++;
                break;
            case 7:
                counter7++;
                break;            
            case 8:
                counter8++;
                break;
            case 9:
                counter9++;
                break;   
            case 10:
                counter10++;
                break;                     
            default:
                below6++;
                break;
        }
    }
    
    public void writeModus(String path){

        try (FileWriter fileWriter = new FileWriter(path+ "data_sekolah_modus.txt")){

            String content = "Berikut Hasil Pengolahan Nilai: \n\n";

            content+= "Nilai\t\t" + "|\t Frekuensi\n";
            content+= "=============================================\n";
            content+= "< 6\t\t" + "|\t "+ below6 + "\n";
            content+= "7\t\t\t" + "|\t "+ counter7 + "\n";
            content+= "8\t\t\t" + "|\t "+ counter8 + "\n";
            content+= "9\t\t\t" + "|\t "+ counter9 + "\n";
            content+= "10\t\t\t" + "|\t "+ counter10 + "\n";

            fileWriter.write(content);
            menu.printSubMenu();
            
        } catch (Exception e) {
            System.out.println("Error when generating modus txt file : " + e.getMessage());
        }

    }

    


}
