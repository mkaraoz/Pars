package com.mk.imgur.uploder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mk.imgur.uploder.secrettextview.SecretTextView;
import com.mk.imgur.uploder.utils.AnimationManager;
import com.mk.imgur.uploder.utils.CircularList;
import com.mk.imgur.uploder.utils.DrawableMap;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity
{
    private static final int SECRET_TEXT_ANIMATION_TIME = 3000;
    private static final int WAIT_BEFORE_SECRET_TEXT = 500;
    private static final int WAIT_BEFORE_BACKGROUND_IMAGE_CHANGE = 20000;
    private static final int FADE_OUT_ANIMATION_TIME = 1000;
    private static final int FADE_IN_ANIMATION_TIME = 2000;

    private ImageView mBackground;
    private FancyButton mLoginButton, mSignButton;
    private CircularList<Integer> mCircularImageList = new CircularList<>();
    private int mCurrentImageIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCircularImageIdList();
        initUI();
    }

    private void fillCircularImageIdList()
    {
        List<Integer> shuffledList = new ArrayList<>();
        for (int i = 1; i <= 11; i++)
        {
            shuffledList.add(i);
        }
        Collections.shuffle(shuffledList);

        for (int i : shuffledList)
        {
            mCircularImageList.add(i);
        }
    }

    class ImageViewOnClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            Log.d("_MK3", "CLICKED");
            swapImage();
        }
    }

    private void initUI()
    {
        // Sharing is caring
        SecretTextView stv = findViewById(R.id.label_sharing);
        new SecretTextViewAnimationTask(stv).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        // Background image
        mBackground = findViewById(R.id.ivBackground);
        mBackground.setOnClickListener(new ImageViewOnClickListener());
        setBackgroundImage();
        // new BackgroundImageChangeTask().execute();

        // top buttons
        mLoginButton = findViewById(R.id.btn_login);
        mLoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                i.putExtra(AppConstants.PASSING_IMAGE_ID, DrawableMap.getBlurryImageResId(mCurrentImageIndex));
                startActivity(i);
            }
        });

        mSignButton = findViewById(R.id.btn_signup);
        mSignButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                i.putExtra(AppConstants.PASSING_IMAGE_ID, DrawableMap.getBlurryImageResId(mCurrentImageIndex));
                startActivity(i);
            }
        });
    }

    private void swapImage()
    {
        // disable clicking until the fade out animation ends
        mBackground.setOnClickListener(null);

        Animation fadeOutBackgroundImageAnimation = AnimationManager.getFadeOutAnimation(FADE_OUT_ANIMATION_TIME);
        fadeOutBackgroundImageAnimation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation animation)
            {
                setBackgroundImage();
                // enable clicking after the fade out animation ends
                mBackground.setOnClickListener(new ImageViewOnClickListener());
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {
            }

            @Override
            public void onAnimationStart(Animation animation)
            {
            }
        });

        final Animation fadeInButtonAnimation = AnimationManager.getFadeInAnimation(FADE_IN_ANIMATION_TIME);

        Animation fadeOutButtonAnimation = AnimationManager.getFadeOutAnimation(FADE_OUT_ANIMATION_TIME);
        fadeOutButtonAnimation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation animation)
            {
                mLoginButton.setAnimation(fadeInButtonAnimation);
                mSignButton.setAnimation(fadeInButtonAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {
            }

            @Override
            public void onAnimationStart(Animation animation)
            {
            }
        });

        mBackground.startAnimation(fadeOutBackgroundImageAnimation);
        mLoginButton.startAnimation(fadeOutButtonAnimation);
        mSignButton.startAnimation(fadeOutButtonAnimation);
    }

    private void setBackgroundImage()
    {
        int backgroundNumber = mCircularImageList.next();
        mCurrentImageIndex = backgroundNumber;
        glideChangeImage(DrawableMap.getImageResId(backgroundNumber), FADE_IN_ANIMATION_TIME);
        updateButtonColors(DrawableMap.getButtonColorId(backgroundNumber));

        // Needed for animation. Glide does not animate if the image is in memory
        clearCache();
        Glide.get(MainActivity.this).clearMemory();
    }

    @SuppressLint("StaticFieldLeak")
    private void clearCache()
    {
        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void... voids)
            {
                Glide.get(MainActivity.this).clearDiskCache();
                return null;
            }
        }.execute();
    }

    private void glideChangeImage(int resourceId, int fadeAnimDuration)
    {
        Glide.with(this).load(resourceId).transition(withCrossFade(fadeAnimDuration)).into(mBackground);
    }

    private void updateButtonColors(int colorResourceId)
    {
        mehdi.sakout.fancybuttons.FancyButton login = findViewById(R.id.btn_login);
        mehdi.sakout.fancybuttons.FancyButton signup = findViewById(R.id.btn_signup);
        int color = getResources().getColor(colorResourceId);
        login.setBorderColor(color);
        login.setTextColor(color);
        login.setFocusBackgroundColor(color);
        signup.setBorderColor(color);
        signup.setTextColor(color);
        signup.setFocusBackgroundColor(color);
    }

    // Animates the text at bottom
    static class SecretTextViewAnimationTask extends AsyncTask<Void, Void, Void>
    {
        private WeakReference<SecretTextView> weakSTV;

        SecretTextViewAnimationTask(SecretTextView stv)
        {
            weakSTV = new WeakReference<>(stv);
            weakSTV.get().setDuration(SECRET_TEXT_ANIMATION_TIME);
            weakSTV.get().setIsVisible(false);
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            try
            {
                Thread.sleep(WAIT_BEFORE_SECRET_TEXT);
            }
            catch (InterruptedException e)
            {
                Log.e("_MK", "Thread sleep error.", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            weakSTV.get().toggle();
        }
    }

    // changes background image periodically
    @SuppressLint("StaticFieldLeak")
    class BackgroundImageChangeTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            boolean shuffle = true;
            while (shuffle)
            {
                try
                {
                    Thread.sleep(WAIT_BEFORE_BACKGROUND_IMAGE_CHANGE);
                }
                catch (InterruptedException e)
                {
                    Log.e("_MK", "Thread sleep error.", e);
                }
                publishProgress();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
            swapImage();
        }
    }
}
