package compulsory;


public class Main {

    public static void main(String[] args) {
        Source s1 = new Source();
        Source s2 = new Source();
        Source s3 = new Source();

        s1.setName("S1");
        s1.setType(Source.SourceType.FACTORY);
        s2.setName("S2");
        s2.setType(Source.SourceType.WAREHOUSE);
        s3.setName("S3");
        s3.setType(Source.SourceType.WAREHOUSE);

        Source[] sources = new Source[]{s1, s2, s3};

        Destination d1 = new Destination();
        d1.setName("D1");
        Destination d2 = new Destination();
        d2.setName("D2");
        Destination d3 = new Destination();
        d3.setName("D3");

        Destination[] destinations = new Destination[]{d1, d2, d3};

        int[] supply = new int[3];
        supply[0] = 10;
        supply[1] = 35;
        supply[2] = 25;

        int[] demand = new int[3];
        demand[0] = 20;
        demand[1] = 25;
        demand[2] = 25;

        int[][] cost = new int[][]{{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        Problem p = new Problem();
        p.setSources(sources);
        p.setDestinations(destinations);
        p.setSupply(supply);
        p.setDemand(demand);
        p.setCost(cost);

        System.out.println(p.toString());

    }
}