package com.mk.imgur.uploder;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.rengwuxian.materialedittext.MaterialEditText;

import mehdi.sakout.fancybuttons.FancyButton;

public class LoginActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupToolbar();
        setBackgroundImage();
        addLoginBoxConstraints();
        addPasswordBoxConstraints();

        FancyButton loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            }
        });
    }

    private void addPasswordBoxConstraints()
    {
        final MaterialEditText password = findViewById(R.id.et_password);
        password.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                password.setHelperText(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });
        password.setOnTouchListener(new TextBoxOnTouchListener());
        password.setOnFocusChangeListener(new TextBoxFocusChangeListener("Password"));
    }

    private void addLoginBoxConstraints()
    {
        final MaterialEditText username = findViewById(R.id.et_user_name);
        username.setOnTouchListener(new TextBoxOnTouchListener());
        username.setOnFocusChangeListener(new TextBoxFocusChangeListener("Username"));
    }

    private void setBackgroundImage()
    {
        int blurryImageId = R.drawable.a1b;
        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            blurryImageId = b.getInt(AppConstants.PASSING_IMAGE_ID);
        }

        final ImageView backgroundImage = findViewById(R.id.iv_background_image);
        backgroundImage.setAlpha(0.4f);
        backgroundImage.setBackgroundResource(blurryImageId);
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

    class TextBoxOnTouchListener implements View.OnTouchListener
    {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            ((EditText) view).setHint("");
            return false;
        }
    }

    class TextBoxFocusChangeListener implements View.OnFocusChangeListener
    {
        private String hint;

        TextBoxFocusChangeListener(final String hint)
        {
            this.hint = hint;
        }

        @Override
        public void onFocusChange(View view, boolean hasFocus)
        {
            if (!hasFocus)
            {
                ((EditText) view).setHint(hint);
            }
        }
    }
}
