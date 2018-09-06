package com.example.herotruth.rjt_hw_7_login_regex;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class InputValidation
{
    private static final String TAG = "InputValidation";

    boolean match = false;

    private Pattern pattern;

    ArrayList<String> TextViewStrings;

    ArrayList<String> PatternStrings;

    int index = 0;

    public InputValidation()
    {
        PatternStrings = new ArrayList<>();
        TextViewStrings = new ArrayList<>();
    }

    private static final String USERNAME_PATTERN = "^[ A-Za-z0-9._-]{3,15}$";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9.-_!]{6,18}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$";
    private static final String DOB_PATTERN = "^(\\d{2}-?\\d{2}-?\\d{4})$";

    public void addPatternString(final String input) {
        PatternStrings.add(input);
    }

    public void addTextViewString(String input)
    {

        Log.d(TAG, "addTextViewString: INDEX = " + index);
        TextViewStrings.add(input);

        index++;

    }

    public void addTextViewStringOLD(String input)
    {

        Log.d(TAG, "addTextViewString: Started");
        Log.d(TAG, "addTextViewString: Input = " + input);
        if(input != null )
        {

            if(TextViewStrings != null && PatternStrings != null)
            {
                if (TextViewStrings.size() > 1 && PatternStrings.size() > 1) {
                    if (TextViewStrings.size() < PatternStrings.size()) {
                        ArrayList<String> arrli = new ArrayList<String>(TextViewStrings.size() + 1);
                        arrli.add(input);
                        TextViewStrings = arrli;
                    } else {
                        TextViewStrings.add(input);
                    }
                }
//                for (String E : TextViewStrings)
//                    System.out.println("Inputs added: " + E);
            }
        }
        else
        {
            TextViewStrings.add(" ");
        }
    }


    public void validation(Context context)
    {
        if (TextViewStrings == null) // || PatternStrings ==null )
        {
            Toast.makeText(context, "ERROR NULL FIELDS", Toast.LENGTH_LONG).show();
        }
        else   if (TextViewStrings.isEmpty() || PatternStrings.isEmpty())
        {
            Toast.makeText(context, "ERROR EMPTY Fields", Toast.LENGTH_LONG).show();
        } else if (TextViewStrings.size() != PatternStrings.size())
        {
            Toast.makeText(context, "ERROR INCORRECT SIZES", Toast.LENGTH_LONG).show();
        } else {
            for (int i = 0; i < PatternStrings.size(); i++) {
                Log.d(TAG, "validation: " + PatternStrings.size() + "= PatternStrings Size");
                Log.d(TAG, "validation: " + TextViewStrings.size() + "= TextViewStrings Size");
                if (TextViewStrings.get(i) != null) {
                    pattern = Pattern.compile(PatternStrings.get(i));
                    match = pattern.matcher(TextViewStrings.get(i)).matches();

                    if (!match) {
                        Toast.makeText(context, "[" + TextViewStrings.get(i) + "]" + " is invalid.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(context, "Error: Field (" + (i + 1) + ")" + " is empty", Toast.LENGTH_SHORT).show();
                }
            }

            TextViewStrings.clear();
        }
    }

    public boolean isMatch() {
        return match;
    }
}
