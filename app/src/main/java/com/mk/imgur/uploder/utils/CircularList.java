package com.mk.imgur.uploder.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mk on 29.01.2018.
 */

public class CircularList<E>
{
    private List<E> list;
    private E head;
    private int nextIndex;

    public CircularList()
    {
        head = null;
        nextIndex = -1;
        list = new ArrayList<>();
    }

    public void add(E e)
    {
        list.add(e);
        if (head == null)
        {
            head = e;
            nextIndex = 0;
        }

        Log.d("_MK2", e + "");
    }

    public void clear()
    {
        list.clear();
        head = null;
        nextIndex = -1;
    }

    public E next()
    {
        if (nextIndex == list.size() - 1)
        {
            head = list.get(nextIndex);
            nextIndex = 0;
        }
        else
        {
            head = list.get(nextIndex);
            nextIndex = nextIndex + 1;
        }

        return head;
    }
}
