package data;

import javafx.scene.chart.XYChart;
import java.util.*;

public class Sorter {
    ArrayList<DataPoint> sortingArray;
    GraphType sortingBy; 

    public Sorter() {

    }

    public double sort(GraphType graphtype, DataPoint datapoint) {
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
}
