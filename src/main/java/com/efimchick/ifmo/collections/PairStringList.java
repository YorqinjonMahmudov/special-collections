package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;

public class PairStringList extends ArrayList<String> {
    public boolean add(String s) {
        super.add(s);
        return super.add(s);
    }

    public void add(int index, String element) {
        index = indexRight(index);
        super.add(index, element);
        super.add(index, element);
    }

    public String remove(int index) {
        index = indexLeft(index);
        super.remove(index);
        return super.remove(index);
    }

    public boolean remove(Object o) {
        super.remove(o);
        return super.remove(o);
    }
    public String set(int index, String element) {
        index = indexLeft(index);
        super.set(index, element);
        return super.set(index + 1, element);
    }
    public boolean addAll(Collection<? extends String> c) {
        for (String s : c)
            this.add(s);
        return true;
    }
    public boolean addAll(int index, Collection<? extends String> c) {
        index-=2;
        for (String s : c)
            this.add(index+=2,s);
        return true;
    }




    private static int indexLeft(int index) {
        return index % 2 == 0 ? index : index - 1;//((index + 1) / 2) * 2;//0/1    /2/3    /4/5
    }

    private static int indexRight(int index) {
        return index % 2 == 0 ? index : index + 1;//((index + 1) / 2) * 2;//0/1    /2/3    /4/5
    }

}
