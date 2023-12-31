package com.ryokuu.util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
            
        } catch (Exception e) {
            System.out.println("Error when generating modus txt file : " + e.getMessage());
        }

    }

    private float countMean(){
        int sum =0;
        for (int val : storedData) {
            sum+=val;
        }

        return (float) sum/storedData.size();
    }

    private float findMedian(){
        int middle = storedData.size()/2;
        Collections.sort(storedData);

        if (middle%2==0) {
            float middle1 = storedData.get(middle-1);
            float middle2 = storedData.get(middle);
            return (middle1+middle2)/2.0f;
        }else{
            return middle/2.0f;
        }
    }

    private int findModus(){

        int max = below6;
        int val = 0;

        if (counter6 > max) {
            max = counter6;
            val = 6;
        }
        
        if (counter7 > max) {
            max = counter7;
            val = 7;            
        }
        
        if (counter8 > max) {
            max = counter8;
            val = 8;
        }
        
        if (counter9 > max) {
            max = counter9;
            val = 9;
        }
        
        if (counter10 > max) {
            max = counter10;
            val =10;
        }
        
        return val;

    }

    public void writMeanMedianModus(String path){
        try (FileWriter fileWriter = new FileWriter(path+ "data_sekolah_mean_median_modus.txt")){

            String content = "Berikut Hasil Pengolahan Nilai: \n\n";

            content+= "Sebaran data nilai\n";
            content+= "=============================================\n";
            content+= "Mean\t\t:" + "|\t "+ countMean() + "\n";
            content+= "Median\t\t:" + "|\t "+ findMedian() + "\n";
            content+= "Modus\t\t:" + "|\t "+ findModus() + "\n";


            fileWriter.write(content);
            
        } catch (Exception e) {
            System.out.println("Error when generating modus txt file : " + e.getMessage());
        }
    }


}
