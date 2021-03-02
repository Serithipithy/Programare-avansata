package compulsory;

import java.util.Arrays;

public class Problem {
    private Source[] sources;
    private Destination[] destinations;
    private int[] supply;
    private int[] demand;
    private int[][] cost;

    public Problem(Source[] sources, Destination[] destinations, int[] supply, int[] demand, int[][] cost) {
        try {
            verSource(sources);
            verDestination(destinations);
            this.sources = sources;
            this.destinations = destinations;
            this.supply = supply;
            this.demand = demand;
            this.cost = cost;
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    public Problem() {
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        try{
            verSource(sources);
            this.sources = sources;
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
        try{
            verDestination(destinations);
            this.destinations = destinations;
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }
    public void verDestination(Destination[] destinations){
        for(int i = 0 ; i < destinations.length ; i++ ){
            for (int j = i+1 ; j < destinations.length ; j++ ) {
                if (destinations[i].equals(destinations[j])) {
                    throw new IllegalArgumentException("Cannot have two sources with the same name!");
                }
            }
        }
    }

    public void verSource(Source[] src){
        for(int i = 0 ; i < src.length ; i++ ){
            for (int j = i+1 ; j < src.length ; j++ ) {
                if (src[i].equals(src[j])) {
                    throw new IllegalArgumentException("Cannot have two sources with the same name!");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ",\n destinations=" + Arrays.toString(destinations) +
                ",\n supply=" + Arrays.toString(supply) +
                ",\n demand=" + Arrays.toString(demand) +
                ",\n cost=" + Arrays.deepToString(cost) +
                '}';
    }

}
