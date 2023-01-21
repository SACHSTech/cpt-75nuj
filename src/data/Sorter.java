package data;

import javafx.scene.chart.XYChart;
import java.util.*;

public class Sorter {
    ArrayList<DataPoint> sortingArray;
    GraphType sortingBy; 

    public Sorter() {

    }

    public double addSort(GraphType graphtype, DataPoint datapoint) {
        this.sortingArray.add(datapoint);
        if(graphtype == GraphType.BYPOINTS) {
            this.sortingBy = GraphType.BYPOINTS;
            return datapoint.getPpg();
        } else if (graphtype == GraphType.BYASSISTS) {
            this.sortingBy = GraphType.BYASSISTS;
            return datapoint.getPpg();
        } else if (graphtype == GraphType.BYREBOUNDS) {
            this.sortingBy = GraphType.BYREBOUNDS;
            return datapoint.getPpg();
        } else if (graphtype == GraphType.BYWINSHARES) {
            this.sortingBy = GraphType.BYWINSHARES;
            return datapoint.getPpg();
        } else {
            return 0.0;
        }
        
    }

    public double getValue(DataPoint dataPoint) {
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

    public ArrayList<DataPoint> sort() {
        this.sorter();
        return sortingArray;
    }

   

    public void sorter() {
       DataPoint[] temp = new DataPoint[sortingArray.size()];
       mergeSortHelper(0, sortingArray.size() - 1, temp);
   }
  
   private void mergeSortHelper(int from, int to, DataPoint[] temp) {
       if(to - from >= 1) {
           int mid = (from + to) / 2;   // split the list in half
           mergeSortHelper(from, mid, temp);  //mergesort the first half
           mergeSortHelper(mid + 1, to, temp); // mergesort the second half
           merge(from, mid, to, temp); //merge
       }
   }
  
   private void merge(int from, int mid, int to, DataPoint[] temp) {
       int i = from;       // track left array position
       int j = mid + 1;    // track right array position
       int k = from;       // track temp position
      
       while(i <= mid && j <= to) {
           if(getValue(sortingArray.get(i)) < getValue(sortingArray.get(i))) {
               temp[k] = sortingArray.get(i);
               i++;

           } else {
               temp[k] = sortingArray.get(j);
               j++;

           }
           
           k++;
       }
      
       // We may left over elements from either list
       while(i <= mid)
       {
           temp[k] = sortingArray.get(i);
           i++;
           k++;
       }
      
       while(j <= to)
       {
           temp[k] = sortingArray.get(j);
           j++;
           k++;
       }
      
       // Copy over elements from temp to arr
       for(k = from; k <= to; k++)
       {
           sortingArray.add(k, temp[k]);
       }
   }
}

