package com.example.a1810078.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab2 extends Activity {

    Button btn_Rename;
    EditText txt_Name;
    TextView lbl_Name;

    String currentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        btn_Rename = findViewById(R.id.btn_Rename);
        txt_Name = findViewById(R.id.txt_Name);
        lbl_Name = findViewById(R.id.lbl_Name);
        btn_Rename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = txt_Name.getText().toString();

                if(!value.equals("") && !value.equals(getString(R.string.txt_Default)))
                {
                    currentName = value;
                    lbl_Name.setText(getString(R.string.lbl_namedText) + " " + value);
                }
                else
                {
                    lbl_Name.setText(getString(R.string.lbl_defaultText));
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {

        super.onSaveInstanceState(outState);
        outState.putString("Name",currentName);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            currentName = savedInstanceState.getString("Name");
            lbl_Name.setText(getString(R.string.lbl_namedText) + " " + currentName);
        }
    }

}
