package com.example.taskchecklist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare all variables
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    private TextView textView;
    private EditText checklistName1, checklistName2, checklistName3, checklistName4, checklistName5;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize checkboxes
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);

        // Initialize text-boxes
        checklistName1 = findViewById(R.id.EditTextItem1);
        checklistName2 = findViewById(R.id.EditTextItem2);
        checklistName3 = findViewById(R.id.EditTextItem3);
        checklistName4 = findViewById(R.id.EditTextItem4);
        checklistName5 = findViewById(R.id.EditTextItem5);

        // Initialize button
        button = findViewById(R.id.button);

        // Initialize congratulations text
        textView = findViewById(R.id.textView);

        // Set TextView to initially be invisible
        textView.setVisibility(View.INVISIBLE);

        // Set button to initially be invisible
        button.setVisibility(View.INVISIBLE);
    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.checkBox1:
                String editChecklistName1 = checklistName1.getText().toString();
                if (checked && editChecklistName1.isEmpty())
                {
                    Toast.makeText(this, "Please enter the name of the task in the text box to check it off the list.", Toast.LENGTH_LONG).show();
                    checkBox1.setChecked(false);
                }
                break;

            case R.id.checkBox2:
                String editChecklistName2 = checklistName2.getText().toString();
                if (checked && editChecklistName2.isEmpty())
                {
                    Toast.makeText(this, "Please enter the name of the task in the text box to check it off the list.", Toast.LENGTH_LONG).show();
                    checkBox2.setChecked(false);
                }
                break;

            case R.id.checkBox3:
                String editChecklistName3 = checklistName3.getText().toString();
                if (checked && editChecklistName3.isEmpty())
                {
                    Toast.makeText(this, "Please enter the name of the task in the text box to check it off the list.", Toast.LENGTH_LONG).show();
                    checkBox3.setChecked(false);
                }
                break;

            case R.id.checkBox4:
                String editChecklistName4 = checklistName4.getText().toString();
                if (checked && editChecklistName4.isEmpty())
                {
                    Toast.makeText(this, "Please enter the name of the task in the text box to check it off the list.", Toast.LENGTH_LONG).show();
                    checkBox4.setChecked(false);
                }
                break;

            case R.id.checkBox5:
                String editChecklistName5 = checklistName5.getText().toString();
                if (checked && editChecklistName5.isEmpty())
                {
                    Toast.makeText(this, "Please enter the name of the task in the text box to check it off the list.", Toast.LENGTH_LONG).show();
                    checkBox5.setChecked(false);
                }
                break;
        }

        // Check if all checkboxes are checked
        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked())
        {
            textView.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
        }
        else
        {
            textView.setVisibility(View.INVISIBLE);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked())
                {
                    checklistName1.getText().clear();
                    checklistName2.getText().clear();
                    checklistName3.getText().clear();
                    checklistName4.getText().clear();
                    checklistName5.getText().clear();

                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);

                    textView.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "All tasks haven't been completed yet.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
