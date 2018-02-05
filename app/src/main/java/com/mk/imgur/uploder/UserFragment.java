package com.mk.imgur.uploder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;


public class UserFragment extends Fragment {

    private UserFragmentActionListener mListener;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof UserFragmentActionListener) {
            mListener = (UserFragmentActionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement UserFragmentActionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        FloatingActionButton editProfileFab = rootView.findViewById(R.id.fab_edit_profile);
        editProfileFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
            }
        });
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface UserFragmentActionListener {
        void onUserFragmentInteraction(Uri uri);
    }
}
