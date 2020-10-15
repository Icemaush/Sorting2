package at2.q3;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Integer>{
    public int salary;

    @Override
    public int compare(Integer a, Integer b) {
        if (a.equals(b)) {
            return 0;
        } else if (a > b) {
            return 1;
        } else {
            return -1;
        }
    }
}
