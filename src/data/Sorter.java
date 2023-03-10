package data;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.NumberAxis;

import java.util.*;

public class Sorter {
    private ArrayList<DataPoint> sortingArray;
    private GraphType sortingBy;
    private double currentLowest;
    private double currentHighest; 

    
    public Sorter() {
        sortingArray = new ArrayList<>();
        currentHighest = 15;
        currentLowest = 15;
    }


    /**
     * adds datapoint to arraylist and returns its values
     * @param graphtype
     * @param datapoint
     * @return double stat values of stat is returned 
     */
    public double addSort(GraphType graphtype, DataPoint datapoint) {
        //adds value to object's arraylist, then returns value inputted back 
        this.sortingArray.add(datapoint);
        if(graphtype == GraphType.BYPOINTS) {
            this.sortingBy = GraphType.BYPOINTS;
            return datapoint.getPpg();
        } else if (graphtype == GraphType.BYASSISTS) {
            this.sortingBy = GraphType.BYASSISTS;
            return datapoint.getApg();
        } else if (graphtype == GraphType.BYREBOUNDS) {
            this.sortingBy = GraphType.BYREBOUNDS;
            return datapoint.getRpg();
        } else if (graphtype == GraphType.BYWINSHARES) {
            this.sortingBy = GraphType.BYWINSHARES;
            return datapoint.getCareerWinShares();
        } else {
            return 0.0;
        }
        
    }

    /**
     * allows sorting algorithm to get appropriate value from datapoint
     * @param DataPoint datapoint 
     * @return double 
     */

    public double getValue(DataPoint dataPoint) {
        //returns appropriate value depending on what the user asks for 
        if(sortingBy == GraphType.BYPOINTS) {
            return dataPoint.getPpg();
        } else if(sortingBy == GraphType.BYASSISTS) {
            return dataPoint.getApg();
        } else if(sortingBy == GraphType.BYREBOUNDS) {
            return dataPoint.getRpg();
        } else if(sortingBy == GraphType.BYWINSHARES) {
            return dataPoint.getCareerWinShares();
        } else {
            return 0.0;
        }


    }


   
    /**
     * sorts then retuns datapoint arraylist
     * @return sortingArray
     */
    public ArrayList<DataPoint> sort() {
       DataPoint[] temp = new DataPoint[sortingArray.size()];
       mergeSortHelper(0, sortingArray.size() - 1, temp);

       return sortingArray;
   }

   /**
    * splits arraylist in half as many times as possible, then sorts each section
    * @param int from 
    * @param int to
    * @param DataPoint[] temp
    */
  
   private void mergeSortHelper(int from, int to, DataPoint[] temp) {
       if(to - from >= 1) {
           int mid = (from + to) / 2;   // split the list in half
           mergeSortHelper(from, mid, temp);  //mergesort the first half
           mergeSortHelper(mid + 1, to, temp); // mergesort the second half
           merge(from, mid, to, temp); //merge
       }
   }
   

   /**
    * takes splitted arrays and orders then
    * @param int from 
    * @param int mid
    * @param int to
    * @param DataPoint[] temp
    */
  
   private void merge(int from, int mid, int to, DataPoint[] temp) {
       int i = from;       // track left array position
       int j = mid + 1;    // track right array position
       int k = from;       // track temp position
      
       while(i <= mid && j <= to) {
           if(getValue(sortingArray.get(i)) < getValue(sortingArray.get(j))) {
               temp[k] = sortingArray.get(i);
               i++;

           } else {
               temp[k] = sortingArray.get(j);
               j++;

           }
           
           k++;
       }
      
       // We may left over elements from either list
       while(i <= mid) {
           temp[k] = sortingArray.get(i);
           i++;
           k++;
       }
      
       while(j <= to){
           temp[k] = sortingArray.get(j);
           j++;
           k++;
       }
      
       // Copy over elements from temp to arr
       for(k = from; k <= to; k++) {

           sortingArray.set(k, temp[k]);
       }
   }


   /**
    * changes axis based on values from LineChart Series to ensure all values are included
    * @param String axisName
    * @return NumberAxis newAxis
    */
   public NumberAxis axis(String axisName) {
        this.sort();
        
        if(this.getValue(this.sortingArray.get(0)) < this.currentLowest) {
            this.currentLowest = this.getValue(this.sortingArray.get(0));
            
        } 

        if(this.getValue(this.sortingArray.get(sortingArray.size() - 1)) + 5 > this.currentHighest) {
            this.currentHighest = this.getValue(this.sortingArray.get(sortingArray.size() - 1)) + 5;
            
        }

        NumberAxis newAxis = new NumberAxis(axisName, this.currentLowest, this.currentHighest, (this.currentHighest - this.currentLowest)/25);
        


        return newAxis;


   }

   /**
    * gets sorted array and returns it
    * @return ArrayList<DataPoint> returnArray
    */

   public ArrayList<DataPoint> getArray() {
        this.sort();

        ArrayList<DataPoint> returnArray = (ArrayList<DataPoint>) sortingArray.clone();
        sortingArray = new ArrayList<>();

        return returnArray;
   }
   
}

