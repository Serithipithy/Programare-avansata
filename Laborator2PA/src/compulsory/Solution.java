package compulsory;

import java.util.LinkedList;

public class Solution {
    private int totalCost;
    public Problem p;
    LinkedList<Shipment> solution = new LinkedList<>();

    private static class Shipment {
        String to;
        String from;
        int cost;

        public Shipment(String from, String to, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        public String getTo() {
            return to;
        }

        public String getFrom() {
            return from;
        }

        public int getCost() {
            return cost;
        }

    } // a private class where we'll keep the source, destination and cost from every step

    public Solution(Problem p) {
        this.p = p;
        this.totalCost = 0;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void displaySteps() {
        for (Shipment shipment : this.solution) {

            System.out.print(shipment.getFrom() + " -> " + shipment.getTo() + " cost " + shipment.getCost() + '\n');
        }
    }

    public void solveProblem() {
        if (isPossible()) { // first we have to see if we can have a solution to our problem based on supply and demand
            int newCost;    // in this we'll keep the cost for every shipment we do
            int sumDemand = getDemandSum(); // keeps the amount of demand it has to be satisfied
            int transport;
            while (canMakeMoves()) // as long we didn't empty the demand we can go on
                for (int i = 0; i < this.p.getSources().length; i++) { // the search starts
                    if (this.p.getSupply()[i] > 0) {  // if there is supply for the current source then we can search if there is a demand that need to be satisfied
                        int destinationIndex = findBestFit(i); // will find the smallest cost for shipment if it has a demand > 0
                        if (destinationIndex >= 0) { // if there is no best fit, then it will not a new shipment
                            transport = Math.min(this.p.getDemand()[destinationIndex], this.p.getSupply()[i]); // the amount of supply we can transfer
                            newCost = this.p.getCost()[i][destinationIndex] * transport; // gives us the cost for the current shipment
                            sumDemand -= transport;
                            if (this.p.getDemand()[destinationIndex] >= this.p.getSupply()[i]) { // if the demand found is greater or equal with the source's supply then it gives all the supply
                                this.p.getDemand()[destinationIndex] = this.p.getDemand()[destinationIndex] - this.p.getSupply()[i];
                                this.p.getSupply()[i] = 0;
                            } else { // if the demand found is less than the source's supply then it will give the supply needed
                                this.p.getSupply()[i] -= this.p.getDemand()[destinationIndex];
                                this.p.getDemand()[destinationIndex] = 0;
                            }
                            Shipment s = new Shipment(this.p.getSources()[i].getName(), this.p.getDestinations()[destinationIndex].getName(), newCost); // the new shipment to be added in solution
                            this.totalCost += newCost; // the current cost is added to the total cost
                            this.solution.add(s); // the current shipment is add to the solution LinkedList
                            if (sumDemand == 0)
                                break; // in case there is no demand to be satisfied there is no need to search more
                        }
                    }
                }
        } else System.out.println("Can't have a solution.");
    }

    private int getDemandSum() {
        int sum = 0;
        for (int j = 0; j < this.p.getDemand().length; j++) {
            sum += this.p.getDemand()[j];
        }
        return sum;
    }


    private boolean isPossible() { // Verifies if there is a feasible solution for the problem ( demand sum <= supply sum )
        int sum1 = 0;
        int sum2 = getDemandSum();
        for (int i = 0; i < this.p.getSupply().length; i++) {
            sum1 += this.p.getSupply()[i];
        }

        return (sum1 >= sum2);
    }

    private boolean canMakeMoves() { // Verifies if there is demand that needs to be satisfied
        int isTrue = 0;

        for (int i = 0; i < this.p.getDemand().length; i++) {
            if (this.p.getDemand()[i] > 0) {
                isTrue = 1;
                break;
            }
        }

        return isTrue != 0;
    }

    private int findBestFit(int index) { // returns the destination index of the smallest cost if there is a demand > 0 for a source index give
        int min = -1;
        int cost;
        int retIndex = -1;
        for (int i = 0; i < this.p.getDestinations().length; i++) {
            cost = this.p.getCost()[index][i];
            if ((min == -1 || min > cost) && this.p.getDemand()[i] > 0) {
                min = cost;
                retIndex = i;
            }
        }
        return retIndex;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "totalCost=" + totalCost +
                ", p=" + p +
                ", solution=" + solution +
                '}';
    }
}
