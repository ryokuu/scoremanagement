package com.ryokuu;

public class Menu {

    private static final String PATH_FOLDER = "/Users/ryokuu/Projects/scoremanagement/src/main/resources";

    private void printHeader(){
        System.out.println("\n==========================================================");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("\n==========================================================");

    }

    public void printMainMenu(){
        printHeader();
        System.out.println("Letakan file csv dengan nama file data_sekolah di direktori \nberikut :  " + PATH_FOLDER);

        System.out.println("\npilih menu:");
        System.out.println("1. Generate txt untuk menampilkan modus");
        System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Generate kedua file");
        System.out.println("0. Exit");

    }

    public void printSubMenu(){
        printHeader();
        System.out.println("File telah di generate di : \n "+PATH_FOLDER + "/generated");
        System.out.println("Silahkan cek\n");
        System.out.println("0. Exit");
        System.out.println("1. Menu utama");

    }

    public void printFileNotFound(){
        printHeader();
        System.out.println("File tidak ditemukan\n");
        System.out.println("0. Exit");
        System.out.println("1. Menu utama");
    }
    
}
