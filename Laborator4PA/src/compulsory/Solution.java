package compulsory;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Student, School> pairings = new HashMap<>();

    // constructors

    public Solution(Map<Student, School> pairings) {
        this.pairings = pairings;
    }

    public Solution() {
    }

    // setters and getters

    public Map<Student, School> getPairings() {
        return pairings;
    }

    public void setPairings(Map<Student, School> pairings) {
        this.pairings = pairings;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "pairings=" + pairings +
                '}';
    }
}
