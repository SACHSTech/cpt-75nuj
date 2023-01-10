package data;


import java.io.*;
import java.util.*;


public class CSVScraper {
    List<List<String>> data;

    public CSVScraper() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src\\data\\CSVScraper.java"));
        String line =  null;

        List<List<String>> data = new ArrayList<List<String>>();
        
        while((line = br.readLine()) != null){
            String[] str = line.split(",");

            List<String> arrayOne = new ArrayList<>();

            for(int i = 0; i < str.length; i++) {
                arrayOne.add(str[i]);
            }


            data.add(arrayOne);
        }

        this.data = data;
        
     }

     
}


