package com.example.android.frenchquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    boolean trueAnswer1;
    boolean trueAnswer2;
    boolean trueAnswer3;
    boolean trueAnswer4;
    boolean trueAnswer5;
    boolean trueAnswer6;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void findAnswersRadio() {

        RadioButton answer1 = (RadioButton) findViewById(R.id.answer1b);
        trueAnswer1 = answer1.isChecked();
        sumAnswers(trueAnswer1);

        RadioButton answer2 = (RadioButton) findViewById(R.id.answer2d);
        trueAnswer2 = answer2.isChecked();
        sumAnswers(trueAnswer2);

    }


    public void findAnswersCheckbox() {

        CheckBox answer3a = (CheckBox) findViewById(R.id.answer3a);
        CheckBox answer3b = (CheckBox) findViewById(R.id.answer3b);
        CheckBox answer3c = (CheckBox) findViewById(R.id.answer3c);

        trueAnswer3 = answer3a.isChecked() == true && answer3b.isChecked() == false && answer3c.isChecked() == true;
        sumAnswers(trueAnswer3);

        CheckBox answer4a = (CheckBox) findViewById(R.id.answer4a);
        CheckBox answer4b = (CheckBox) findViewById(R.id.answer4b);
        CheckBox answer4c = (CheckBox) findViewById(R.id.answer4c);

        trueAnswer4 = answer4a.isChecked() == true && answer4b.isChecked() == false && answer4c.isChecked() == true;
        sumAnswers(trueAnswer4);

        CheckBox answer5a = (CheckBox) findViewById(R.id.answer5a);
        CheckBox answer5b = (CheckBox) findViewById(R.id.answer5b);
        CheckBox answer5c = (CheckBox) findViewById(R.id.answer5c);

        trueAnswer5 = answer5a.isChecked() == true && answer5b.isChecked() == true && answer5c.isChecked() == false;
        sumAnswers(trueAnswer5);

    }

    public void findAnswersFreeFormat() {
        EditText answer6 = (EditText) findViewById(R.id.answer6);
        String answerString6 = answer6.getText().toString();
        String answer6a = getResources().getString(R.string.a6a);

        if (answerString6.equals(answer6a)) {
            trueAnswer6 = true;
            sumAnswers(trueAnswer6);
        }

    }

    public void submitQuiz(View view) {
        sum = 0;
        findAnswersRadio();
        findAnswersCheckbox();
        findAnswersFreeFormat();

        EditText nameField = (EditText) findViewById(R.id.name);
        String name = nameField.getText().toString();

        if (sum == 0) {
            String message = "Dear " + name + ", You have no right questions. :( Try again s'il vous plait!";
            displayText(message);
        }

        if (sum == 6) {
            String message = "Félicitations " + name + "!!! You have answered all the questions right!";
            displayText(message);
        } else {
            String message = "Dear " + name + ", You have " + sum + " true questions. Try again s'il vous plait!";
            displayText(message);

        }

    }

    public void displayText(String message) {
        TextView submitAnswersTextView = (TextView) findViewById(R.id.summary_view);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    public void sumAnswers(boolean checkAnswers) {
        if (checkAnswers == true) {
            sum++;
        }
    }

}