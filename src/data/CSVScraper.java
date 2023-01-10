package data;


import java.io.*;
import java.util.*;


public class CSVScraper  {
    List<DataPoint> data;

    public CSVScraper() {
         //create buffered reader for stats file
         try {
            BufferedReader br = new BufferedReader(new FileReader("src\\data\\stats.csv"));
            String line =  null;
   
            //ArrayList used for containing data
            List<DataPoint> data = new ArrayList<DataPoint>();
   
            //while there are more rows to go through
            while((line = br.readLine()) != null){
               //split the given line by the commas that separate them
               String[] str = line.split(",");
   
               //convert array into an arraylist
               DataPoint datapoint = new DataPoint();
               for(int i = 0; i < str.length; i++) {
                   datapoint.add(str[i]);
               }
   
               //add arraylist into arraylist
               data.add(datapoint);
            }
   
            this.data = data;
         } catch (Exception e) {

         }
         
        
   }

   public DataPoint get(int i) {
      return data.get(i);
   }

   
   
 

   
}


