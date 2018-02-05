package com.mk.imgur.uploder.utils;

import android.util.SparseArray;

import com.mk.imgur.uploder.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mk on 31.01.2018.
 */

public class DrawableMap
{
    private static final String IMAGE_KEY = "IMAGE_KEY";
    private static final String BLURRY_IMAGE_KEY = "BLURRY_IMAGE_KEY";
    private static final String COLOR_KEY = "COLOR_KEY";

    private static SparseArray<Map<String, Integer>> map = new SparseArray<>(11);

    static
    {
        Map<String, Integer> resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a1);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a1b);
        resourceMap.put(COLOR_KEY, R.color.md_black_1000);
        map.put(1, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a2);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a2b);
        resourceMap.put(COLOR_KEY, R.color.md_white_1000);
        map.put(2, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a3);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a3b);
        resourceMap.put(COLOR_KEY, R.color.md_blue_grey_100);
        map.put(3, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a4);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a4b);
        resourceMap.put(COLOR_KEY, R.color.md_grey_100);
        map.put(4, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a5);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a5b);
        resourceMap.put(COLOR_KEY, R.color.md_black_1000);
        map.put(5, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a6);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a6b);
        resourceMap.put(COLOR_KEY, R.color.md_white_1000);
        map.put(6, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a7);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a7b);
        resourceMap.put(COLOR_KEY, R.color.md_white_1000);
        map.put(7, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a8);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a8b);
        resourceMap.put(COLOR_KEY, R.color.md_black_1000);
        map.put(8, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a9);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a9b);
        resourceMap.put(COLOR_KEY, R.color.md_black_1000);
        map.put(9, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a10);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a10b);
        resourceMap.put(COLOR_KEY, R.color.md_black_1000);
        map.put(10, resourceMap);

        resourceMap = new HashMap<>();
        resourceMap.put(IMAGE_KEY, R.drawable.a11);
        resourceMap.put(BLURRY_IMAGE_KEY, R.drawable.a11b);
        resourceMap.put(COLOR_KEY, R.color.md_black_1000);
        map.put(11, resourceMap);
    }

    public static int getImageResId(int id)
    {
        return map.get(id).get(IMAGE_KEY);
    }

    public static int getBlurryImageResId(int id)
    {
        return map.get(id).get(BLURRY_IMAGE_KEY);
    }

    public static int getButtonColorId(int id)
    {
        return map.get(id).get(COLOR_KEY);
    }
}
