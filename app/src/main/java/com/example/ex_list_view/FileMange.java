package com.example.ex_list_view;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMange {

    FileReader fileReader;
    BufferedReader bufferedReader;

    String path;
    FileMange(String p){
        this.path = p;
        try {
            File file = new File(this.path);
            if(file.createNewFile()){

            }
        }catch (IOException er){

        }
    }
    public void addData(String data){
        try {
//            bufferedReader = new BufferedReader(new FileReader(this.path));
            FileWriter fileWriter = new FileWriter(this.path, true);
            fileWriter.write(data);
            fileWriter.close();
        }catch (IOException e){
        }
    }

    public  String getData(){
        String data = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(this.path));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                data += line+"\n";
            }
            bufferedReader.close();
        }catch (IOException e){
        }
        return  data;
    }

    public  int getId(){
        try {
            bufferedReader = new BufferedReader(new FileReader(this.path));
            String line;
            String last = null;
            while ((line = bufferedReader.readLine()) != null){
                last=line;
            }
            bufferedReader.close();
            if(last == null){
                return  1;
            }else{
                String row[] = last.split(",");
                return  Integer.valueOf(row[0])+1;
            }
        }catch (IOException e){
        }
        return  0;
    }
}
