package com.mk.imgur.uploder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;

import com.github.clans.fab.FloatingActionButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import mehdi.sakout.fancybuttons.FancyButton;

public class EditProfileActivity extends AppCompatActivity
{
    private FancyButton mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        setupToolbar();

        FloatingActionButton editUserPhoto = findViewById(R.id.fab_edit_user_photo);
        editUserPhoto.setAlpha(0.6f);

        mSaveButton = findViewById(R.id.btn_save);
        mSaveButton.setEnabled(false);
        mSaveButton.setAlpha(0.2f);

        MaterialEditText metName, metUsername;
        metName = findViewById(R.id.input_met_name);
        metName.addTextChangedListener(new EditTextChangeListener());
        metUsername = findViewById(R.id.input_met_username);
        metUsername.addTextChangedListener(new EditTextChangeListener());
    }

    private class EditTextChangeListener implements TextWatcher
    {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count)
        {

        }

        @Override
        public void afterTextChanged(Editable editable)
        {
            mSaveButton.setEnabled(true);
            mSaveButton.setAlpha(1f);
        }
    }

    private void setupToolbar()
    {
        Toolbar myChildToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        setTitle("");

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }


}
