package com.efimchick.ifmo.collections;

import java.util.*;

public class SortedByAbsoluteValueIntegerSet extends TreeSet<Integer> {
    public SortedByAbsoluteValueIntegerSet() {
        super(Comparator.comparingInt(Math::abs));
    }

}
