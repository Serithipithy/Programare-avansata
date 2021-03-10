package extra;

import compulsory.Location;
import compulsory.TravelPlan;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    TravelPlan travelPlan;
    int noVertices;
    int graph[][];
    static final int INF = 9999;

    public Solution(TravelPlan travelPlan) {
        this.travelPlan = travelPlan;
        this.noVertices = travelPlan.getListPreferences().size();
        createGraph();
    }

    private void createGraph() { // creaza un graf si pastreaza intr-un map pozitia corespondenta fiecarei locatii in graful nostru
        Map<Location,Integer> corespondets = new HashMap<>();
        graph=new int [noVertices][noVertices];
        for( int i = 0; i < noVertices; i++){
            corespondets.put(travelPlan.getListPreferences().get(i),i);
            for (int j = 0; j < noVertices ; j++){
                graph[i][j]=INF;
            }
        }

        for (int i = 0; i < noVertices; i++){
            //corespondets.containsKey();
        }
    }

}
