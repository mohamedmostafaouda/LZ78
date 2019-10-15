package com.company;

import java.io.File;
import java.util.Scanner;

public class console {

    private int choice;
    Scanner key = new Scanner(System.in);

    public void screen(){
        System.out.println("Please Choose Input");
        System.out.println("1-Compression");
        System.out.println("2-Decompression");
        System.out.println("3-Files Compression");
        System.out.println("4-Files Decompression");
        Scanner key = new Scanner(System.in);
        int x = key.nextInt();
        setChoice(x);

    }

    public void setChoice(int ch){
        choice = ch;
    }

    public void optionImplementer(){


        if (choice == 1){

            System.out.println("Enter String Please");

            Scanner key = new Scanner(System.in);

            String s = key.nextLine();

            Compression x = new Compression();

            x.setInput(s);

            x.Compress();

            System.out.println("Compressed String: "+x.getOutput());

            System.out.println("Size AC: " + x.getSize() + "bits");

            System.out.println("Compression Table: " + x.getTable());

            screen();

        }else if (choice == 2){

            System.out.println("Enter String Please");

            Scanner key = new Scanner(System.in);

            String s = key.nextLine();

            Decompression x = new Decompression();

            x.set(s);

            System.out.println("Decompressed String: "+x.deCompress());

            System.out.println("Size ADC: " + x.size() + "bits");

            System.out.println("Compression Table: " + x.tableOut());

            screen();
        }
        else if(choice == 3){

            System.out.println("Enter File Name Please");

            Scanner key = new Scanner(System.in);

            String s = key.nextLine();

            Files x = new Files();

            Compression y = new Compression();

            y.setInput(x.readFile(s));

            y.Compress();

            x.writeFile(s,y.getOutput());

            System.out.println("File Compressed Successfully");

        }else if(choice == 4){

            System.out.println("Enter File Name Please");

            Scanner key = new Scanner(System.in);

            String s = key.nextLine();

            Files x = new Files();

            Decompression y = new Decompression();

            y.set(x.readFile(s));

            x.writeFile(s,y.deCompress());

            System.out.println("File Compressed Successfully");

        }
    }


}
