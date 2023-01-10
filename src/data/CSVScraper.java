package data;


import java.io.*;
import java.util.*;


public class CSVScraper  {
    List<List<String>> data;

    public CSVScraper() {
         //create buffered reader for stats file
         try {
            BufferedReader br = new BufferedReader(new FileReader("src\\data\\stats.csv"));
            String line =  null;
   
            //ArrayList used for containing data
            List<List<String>> data = new ArrayList<List<String>>();
   
            //while there are more rows to go through
            while((line = br.readLine()) != null){
               //split the given line by the commas that separate them
               String[] str = line.split(",");
   
               //convert array into an arraylist
               List<String> arrayOne = new ArrayList<>();
               for(int i = 0; i < str.length; i++) {
                   arrayOne.add(str[i]);
               }
   
               //add arraylist into arraylist
               data.add(arrayOne);
            }
   
            this.data = data;
         } catch (Exception e) {
            
         }
         
        
   }

   /**
    * Retrieve Cell from List Object 
    * @param i index
    * @param j index
    * @return value in cell
    */
   public String getCell(int i, int j) {
      return data.get(i).get(j);
   }
   

   /*

   public HashMap<Integer, Double> getPoints() {
      return ; 
   } 
  
   public HashMap<Integer, Double> getAssists() {
  
      return ; 
   }

   */

 

   
}


