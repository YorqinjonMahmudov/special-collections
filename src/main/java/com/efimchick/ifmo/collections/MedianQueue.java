package com.efimchick.ifmo.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MedianQueue extends ArrayDeque<Integer> {
    public PriorityQueue<Int> values = new PriorityQueue<>(Int::compareTo);
    public final Int middle = new Int(7, null);
    public final ArrayList<Integer> list = new ArrayList<>(13);


    public int size() {
        return values.size();
    }

    public Integer peekFirst() {
        check();
        return values.peek().val;
    }

    public Integer pollFirst() {
        check();
        list.remove((Integer) middle.val);
        setMid();
        return values.poll().val;
    }

    public void addLast(Integer integer) {
        list.add(integer);
        setMid();
        values.add(new Int(integer, middle));
    }


    private void check() {
        Int peek = values.peek();
        if (peek == null || peek.val == middle.val)
            return;
        PriorityQueue<Int> newQ = new PriorityQueue<>(Int::compareTo);
        newQ.addAll(values);
        values = newQ;
    }

    private void setMid() {
        if (list.size() == 0)
            return;
        list.sort(Integer::compareTo);
        middle.val = list.get(midIndex(list.size()));
    }

    private int midIndex(int size) {
        return (size - 1) / 2;
    }

    static class Int implements Comparable<Int> {
        public int val;
        private final Int middle;

        public Int(int val, Int middle) {
            this.val = val;
            this.middle = middle;
        }

        public int compareTo(Int that) {
            return Math.abs(middle.val - this.val) <
                    Math.abs(middle.val - that.val) ?
                    -1 : 1;
        }

        public String toString() {
            return Integer.toString(val);
        }

    }
}
