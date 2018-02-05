package com.mk.imgur.uploder;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mk.imgur.uploder.unsplash.Image;

import java.io.InputStream;
import java.io.InputStreamReader;

import mehdi.sakout.fancybuttons.FancyButton;


public class PhotoFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener
{

    private MyRecyclerViewAdapter adapter;

    public interface SearchActionListener
    {
        void searchActive();

        void searchCancelled();
    }

    private SearchActionListener mListener;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof SearchActionListener)
        {
            mListener = (SearchActionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement SearchActionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public PhotoFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // read from raw json file
        InputStream in = this.getResources().openRawResource(this.getResources().getIdentifier("api_response", "raw", getActivity().getPackageName()));
        JsonReader reader = new JsonReader(new InputStreamReader(in));
        Image[] response0 = new Gson().fromJson(reader, Image[].class);
        Image[] response = new Image[response0.length * 2];
        for (int i = 0; i < response0.length; i++)
            response[i] = response0[i];

        for (int i = 0; i < response0.length; i++)
            response[response0.length + i] = response0[i];

        View rootView = inflater.inflate(R.layout.fragment_photo, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rvNumbers);
        int spanCount = 2;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyRecyclerViewAdapter(getActivity(), response);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        final FancyButton cancelSearchButton = rootView.findViewById(R.id.btn_cancel);
        cancelSearchButton.setVisibility(View.GONE);
        cancelSearchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mListener.searchCancelled();
            }
        });

        final EditText searchBox = rootView.findViewById(R.id.text_search_box);
        searchBox.setMaxLines(1);
        searchBox.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean hasFocus)
            {
                if (hasFocus)
                {
                    mListener.searchActive();
                    cancelSearchButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    cancelSearchButton.setVisibility(View.GONE);
                }
            }
        });



        return rootView;
    }

    @Override
    public void onItemClick(View view, int position)
    {
        StaggeredGridLayoutManager.LayoutParams rlp = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        Log.i("TAG", "You clicked number " + rlp.width + ", which is at cell position " + position);
    }

}
