package com.example.herotruth.rjt_hw_7_login_regex;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class InputValidation
{


    boolean match = false;

    private Pattern pattern;

    ArrayList<String> TextViewStrings;

    ArrayList<String> PatternStrings;

    public InputValidation()
    {
        PatternStrings = new ArrayList<>();

    }



    private static final String USERNAME_PATTERN = "^[ A-Za-z0-9._-]{3,15}$";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9.-_!]{6,18}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$";
    private static final String DOB_PATTERN = "^(\\d{2}-?\\d{2}-?\\d{4})$";

    public void addPatternString(final String input)
    {
        Log.d("ERROR01",PatternStrings.size()+" size");
        PatternStrings.add(input);
    }
//    public void addPatternString(final String input)
//    {
//        if (TextViewStrings != null) {
//            if (TextViewStrings.size() < 0) {
//
//                ArrayList<String> arrli = new ArrayList<String>(TextViewStrings.size() + 1);
//                arrli.add(input);
//                PatternStrings = arrli;
//            }
//        }
//        else {
//            ArrayList<String> arrli = new ArrayList<String>();
//            arrli.add(input);
//            PatternStrings = arrli;
//        }
//
//
//
//        for (String E : PatternStrings)
//            System.out.println("Patterns added: " + E);
//
//    }

    public void addTextViewString(String input)
    {



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

        for  (int i = 0;  i < PatternStrings.size(); i++)
        {
            Log.d("PAT01", "Pattern ["+PatternStrings.size()+"]");
            if (TextViewStrings != null)
            {
                pattern = Pattern.compile(PatternStrings.get(i));
                match = pattern.matcher(TextViewStrings.get(i)).matches();

                if (!match) {
                    Toast.makeText(context, "["+TextViewStrings.get(i)+"]"+ " is invalid.", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(context, "Error: Field ("+(i+1)+")" + " is empty", Toast.LENGTH_SHORT).show();
            }
            //System.out.println("Match: " + match);

        }
    }

    public boolean isMatch() {
        return match;
    }
}
