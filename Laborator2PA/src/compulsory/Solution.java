package compulsory;

import java.util.LinkedList;

public class Solution {
    private int totalCost;
    public Problem p;
    LinkedList<Shipment> solution;

    private static class Shipment {
        String to;
        String from;
        int cost;
    }

    public Solution(Problem p) {
        this.p = p;
        this.totalCost=0;
        this.solution=null;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
