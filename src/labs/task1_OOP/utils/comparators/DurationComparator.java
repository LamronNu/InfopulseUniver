package labs.task1_OOP.utils.comparators;

import labs.task1_OOP.services.Transfer;

import java.util.Comparator;

public class DurationComparator implements Comparator<Transfer> {
    @Override
    public int compare(Transfer o1, Transfer o2) {
        return (int)(o1.getDuration() - o2.getDuration());
    }
}
