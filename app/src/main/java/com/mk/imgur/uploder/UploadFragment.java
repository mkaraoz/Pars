package com.mk.imgur.uploder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.github.clans.fab.FloatingActionMenu;


public class UploadFragment extends Fragment
{
    private FloatingActionMenu mFabMenu;
    private OnUploadFragmentActionListener mListener;

    public UploadFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnUploadFragmentActionListener)
        {
            mListener = (OnUploadFragmentActionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement OnUploadFragmentActionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_upload, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_uploaded_images);
        mFabMenu = rootView.findViewById(R.id.fab_menu);
        createCustomAnimation();
        mFabMenu.setClosedOnTouchOutside(true);

        return rootView;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnUploadFragmentActionListener
    {
        void onUploadFragmentInteraction(Uri uri);
    }


    private void createCustomAnimation()
    {
        AnimatorSet set = new AnimatorSet();

        ObjectAnimator scaleOutX = ObjectAnimator.ofFloat(mFabMenu.getMenuIconView(), "scaleX", 1.0f, 0.2f);
        ObjectAnimator scaleOutY = ObjectAnimator.ofFloat(mFabMenu.getMenuIconView(), "scaleY", 1.0f, 0.2f);

        ObjectAnimator scaleInX = ObjectAnimator.ofFloat(mFabMenu.getMenuIconView(), "scaleX", 0.2f, 1.0f);
        ObjectAnimator scaleInY = ObjectAnimator.ofFloat(mFabMenu.getMenuIconView(), "scaleY", 0.2f, 1.0f);

        scaleOutX.setDuration(50);
        scaleOutY.setDuration(50);

        scaleInX.setDuration(150);
        scaleInY.setDuration(150);

        scaleInX.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationStart(Animator animation)
            {
                mFabMenu.getMenuIconView().setImageResource(mFabMenu.isOpened() ? R.drawable.ic_cloud_upload_white_24dp : R.drawable.ic_close_white_24dp);
            }
        });

        set.play(scaleOutX).with(scaleOutY);
        set.play(scaleInX).with(scaleInY).after(scaleOutX);
        set.setInterpolator(new OvershootInterpolator(2));

        mFabMenu.setIconToggleAnimatorSet(set);
    }
}
