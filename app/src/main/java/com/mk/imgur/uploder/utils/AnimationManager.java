package com.mk.imgur.uploder.utils;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by mk on 29.01.2018.
 */

public class AnimationManager
{
    public static Animation getFadeOutAnimation(int time)
    {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(time);
        return fadeOut;
    }

    public static Animation getFadeInAnimation(int time)
    {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(time);
        return fadeIn;
    }
}
