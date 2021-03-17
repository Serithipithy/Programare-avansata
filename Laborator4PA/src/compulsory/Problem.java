package compulsory;

import java.util.List;
import java.util.Map;

public class Problem {
    Map<Student, List<School>> studentPrefMap;
    Map<School, List<Student>> schoolPrefMap;
    Solution problemSolution;

    //constructors
    public Problem(Map<Student, List<School>> studentPrefMap, Map<School, List<Student>> schoolPrefMap) {
        this.studentPrefMap = studentPrefMap;
        this.schoolPrefMap = schoolPrefMap;
    }

    public Problem() {
    }

    //setters and getters

    public Map<Student, List<School>> getStudentPrefMap() {
        return studentPrefMap;
    }

    public void setStudentPrefMap(Map<Student, List<School>> studentPrefMap) {
        this.studentPrefMap = studentPrefMap;
    }

    public Map<School, List<Student>> getSchoolPrefMap() {
        return schoolPrefMap;
    }

    public void setSchoolPrefMap(Map<School, List<Student>> schoolPrefMap) {
        this.schoolPrefMap = schoolPrefMap;
    }

    public Solution getProblemSolution() {
        return problemSolution;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "studentPrefMap=" + studentPrefMap +
                ", schoolPrefMap=" + schoolPrefMap +
                ", problemSolution=" + problemSolution +
                '}';
    }
}
