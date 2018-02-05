package com.mk.imgur.uploder;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by mk on 05.02.2018.
 */

public class WelcomeActivity extends AppCompatActivity implements MaterialTabListener, PhotoFragment.SearchActionListener, UploadFragment.OnUploadFragmentActionListener, UserFragment.UserFragmentActionListener
{
    private ViewPager mViewPager;
    private ViewPagerAdapter mPagerAdapter;
    private MaterialTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mTabHost = this.findViewById(R.id.tabHost);
        mViewPager = this.findViewById(R.id.pager);
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                // when user do a swipe the selected tab change
                mTabHost.setSelectedNavigationItem(position);
            }
        });

        // insert all tabs from mPagerAdapter data
        for (int i = 0; i < mPagerAdapter.getCount(); i++)
        {
            mTabHost.addTab(mTabHost.newTab().setIcon(getIcon(i)).setTabListener(this));
        }

    }

    private Drawable getIcon(int position)
    {
        switch (position)
        {
            case 0:
                return getResources().getDrawable(R.drawable.ic_insert_photo_white_24dp);
            case 1:
                return getResources().getDrawable(R.drawable.ic_cloud_upload_white_24dp);
            case 2:
                return getResources().getDrawable(R.drawable.ic_person_white_24dp);
        }
        return null;
    }

    @Override
    public void searchActive()
    {
        mTabHost.setVisibility(View.GONE);
    }

    @Override
    public void searchCancelled()
    {
        onBackPressed();
    }

    @Override
    public void onBackPressed()
    {
        // when search is cancelled display tab icons
        if (mTabHost.getVisibility() == View.GONE)
        {
            mTabHost.setVisibility(View.VISIBLE);
            mTabHost.requestFocus();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public void onTabSelected(MaterialTab tab)
    {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab)
    {

    }

    @Override
    public void onTabUnselected(MaterialTab tab)
    {

    }

    @Override
    public void onUserFragmentInteraction(Uri uri)
    {

    }

    @Override
    public void onUploadFragmentInteraction(Uri uri)
    {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        public ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        public Fragment getItem(int num)
        {

            if (num == 0)
            {
                return new PhotoFragment();
            }
            else if (num == 1)
            {
                return new UploadFragment();
            }
            else if (num == 2)
            {
                return new UserFragment();
            }
            return new FragmentText();
        }

        @Override
        public int getCount()
        {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return "tab 1";
                case 1:
                    return "tab 2";
                case 2:
                    return "tab 3";
                default:
                    return null;
            }
        }
    }
}
