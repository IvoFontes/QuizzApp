package com.example.fj.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Question 1
    RadioButton question1_choice2;
    // Question 2
    RadioButton question2_choice1;
    // Question 3
    CheckBox question3_choice1;
    CheckBox question3_choice2;
    CheckBox question3_choice3;
    CheckBox question3_choice4;
    // Question 4
    CheckBox question4_choice1;
    CheckBox question4_choice2;
    CheckBox question4_choice3;
    CheckBox question4_choice4;
    // Question 5
    EditText question5_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {
        CharSequence resultsDisplay;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;

        EditText editText=(EditText)findViewById(R.id.name_text_input);
        String textPersonName = editText.getText().toString();



        //------------------------------------------------------------------------------------------
        // Question 1 - Correct Answer is "Spain"
        //------------------------------------------------------------------------------------------
        Boolean answer1;

        question1_choice2 = (RadioButton) this.findViewById(R.id.question1_choice2);
        answer1 = question1_choice2.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 2 - Correct Answer is "Portuguese"
        //------------------------------------------------------------------------------------------
        Boolean answer2;

        question2_choice1 = (RadioButton) this.findViewById(R.id.question2_choice1);
        answer2 = question2_choice1.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 3  - Correct Answers are #2 (Lisboa) and #3 (Porto) and and #4 (Coimbra)
        //------------------------------------------------------------------------------------------
        Boolean answer3_choice1;
        Boolean answer3_choice2;
        Boolean answer3_choice3;
        Boolean answer3_choice4;
        question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
        question3_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
        question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
        question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
        answer3_choice1 = question3_choice1.isChecked();
        answer3_choice2 = question3_choice2.isChecked();
        answer3_choice3 = question3_choice3.isChecked();
        answer3_choice4 = question3_choice4.isChecked();
        if (!answer3_choice1 && answer3_choice2 && answer3_choice3 && answer3_choice4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question   - Correct Answers are #1 (Palácio da Pena) and #3 (Mosteiro dos Jerónimos)
        //------------------------------------------------------------------------------------------
        Boolean answer4_choice1;
        Boolean answer4_choice2;
        Boolean answer4_choice3;
        Boolean answer4_choice4;
        question4_choice1 = (CheckBox) this.findViewById(R.id.question4_choice1);
        question4_choice2 = (CheckBox) this.findViewById(R.id.question4_choice2);
        question4_choice3 = (CheckBox) this.findViewById(R.id.question4_choice3);
        question4_choice4 = (CheckBox) this.findViewById(R.id.question4_choice4);
        answer4_choice1 = question4_choice1.isChecked();
        answer4_choice2 = question4_choice2.isChecked();
        answer4_choice3 = question4_choice3.isChecked();
        answer4_choice4 = question4_choice4.isChecked();
        if (answer4_choice1 && !answer4_choice2 && answer4_choice3 && !answer4_choice4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 5  - Correct Answer is "Bom dia"
        //-----------------------------------------------------------------------------------------//
        String answer5;
        question5_answer = (EditText) this.findViewById(R.id.question5_answer);
        answer5 = question5_answer.getText().toString();
        if (answer5.equals("Obrigado")) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

        if (final_score == 5) {
            resultsDisplay = "Perfect " + textPersonName  + "! You scored 5 out of 5";
        } else {
            resultsDisplay = "Try again. You scored " + final_score + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TEXT, "QuizzApp result: " + resultsDisplay);
        startActivity(Intent.createChooser(intent2, "Share via"));

    }

}