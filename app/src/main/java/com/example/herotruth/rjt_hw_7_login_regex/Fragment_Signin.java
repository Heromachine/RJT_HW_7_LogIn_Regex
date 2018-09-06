package com.example.herotruth.rjt_hw_7_login_regex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment_Signin extends Fragment {
    private static final String TAG = "Fragment_Signin";

    Button btnSignIn;
    String [] sTextViews ;

    EditText username;
    EditText password;
    EditText email;
    EditText dob;

    private static final String USERNAME_PATTERN = "^[ A-Za-z0-9._-]{3,15}$";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9.-_!]{6,18}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$";
    private static final String DOB_PATTERN = "^(\\d{2}-?\\d{2}-?\\d{4})$";
    InputValidation IV = new InputValidation();

    @Override
    public void onAttachFragment(Fragment childFragment)
    {
        super.onAttachFragment(childFragment);



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signin, container, false);
        btnSignIn = view.findViewById(R.id.btn_signin_signin);

        IV.addPatternString(USERNAME_PATTERN);
        IV.addPatternString(PASSWORD_PATTERN);
        IV.addPatternString(EMAIL_PATTERN);
        IV.addPatternString(DOB_PATTERN);

        username = view.findViewById(R.id.edtx_signin_username);
        password = view.findViewById(R.id.edtx_signin_password);
        email = view.findViewById(R.id.edtx_signin_email);
        dob = view.findViewById(R.id.edtx_signin_dob);





        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "onClick: USERNAME= "+ username.getText().toString());
                Log.d(TAG, "onClick: DATE = "+ dob.getText().toString());
                IV.addTextViewString(username.getText().toString());
                IV.addTextViewString(password.getText().toString());
                IV.addTextViewString(email.getText().toString());
                IV.addTextViewString(dob.getText().toString());
                System.out.println(username.getText().toString());



                IV.validation(getActivity());

            }
        });


        return view;


    }




}
