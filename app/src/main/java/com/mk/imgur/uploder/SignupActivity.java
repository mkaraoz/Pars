package com.mk.imgur.uploder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.METValidator;

public class SignupActivity extends AppCompatActivity
{
    private final static int MIN_PASSWORD_CHAR_COUNT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupToolbar();
        setBackgroundImage();
        addPasswordBoxConstraints();
        addMainBoxConstraints();
    }

    private void addMainBoxConstraints()
    {
        final MaterialEditText mailBox = findViewById(R.id.et_email);

        mailBox.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    if (!TextUtils.isEmpty(mailBox.getText()))
                    {
                        mailBox.validateWith(new EmailValidator("Invalid email address"));
                    }
                }
            }
        });
    }

    private void addPasswordBoxConstraints()
    {
        final MaterialEditText passwordBox = findViewById(R.id.et_password);
        passwordBox.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence cs, int start, int before, int count)
            {

            }

            @Override
            public void onTextChanged(CharSequence cs, int start, int count, int after)
            {
                passwordBox.setHelperText(cs.toString());

            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });

        passwordBox.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    passwordBox.setMinCharacters(MIN_PASSWORD_CHAR_COUNT);
                }
            }
        });
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


    private class EmailValidator extends METValidator
    {
        EmailValidator(@NonNull String errorMessage)
        {
            super(errorMessage);
        }

        @Override
        public boolean isValid(@NonNull CharSequence text, boolean isEmpty)
        {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches();
        }
    }
}
