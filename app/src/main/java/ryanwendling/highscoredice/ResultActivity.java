package ryanwendling.highscoredice;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import ryanwendling.highscoredice.database.ScoreBaseHelper;

public class ResultActivity extends AppCompatActivity {
    static int finalScore;
    int lastDiceRoll;
    String stringVal;
    ImageView dice_picture2;     //reference to dice picture
    TextView value;
    Button againButton;

    //DATABASE STUFF
    EditText nameBox;
    TextView idView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        GameActivity.cumulativeVal = 0;

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                finalScore= extras.getInt("score");
                lastDiceRoll = extras.getInt("roll");
            }
        } else {
            //finalScore = (Integer) savedInstanceState.getSerializable("score");
            //lastDiceRoll = (Integer) savedInstanceState.getSerializable("roll");
        }

        dice_picture2 = (ImageView) findViewById(R.id.imageView2);

        if (lastDiceRoll == 1) {
            dice_picture2.setImageResource(R.drawable.one);
        }
        if (lastDiceRoll == 2) {
            dice_picture2.setImageResource(R.drawable.two);
        }
        if (lastDiceRoll == 3) {
            dice_picture2.setImageResource(R.drawable.three);
        }
        if (lastDiceRoll == 4) {
            dice_picture2.setImageResource(R.drawable.four);
        }
        if (lastDiceRoll == 5) {
            dice_picture2.setImageResource(R.drawable.five);
        }
        if (lastDiceRoll == 6) {
            dice_picture2.setImageResource(R.drawable.six);
        }

        value = (TextView) findViewById(R.id.scoreView2);
        stringVal = Integer.toString(finalScore);
        value.setText("Score: " + stringVal);


        againButton = (Button)findViewById(R.id.againButton);
        againButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


        //DATABASE STUFF HERE
        nameBox = (EditText) findViewById(R.id.username);
        idView = (TextView) findViewById(R.id.idText);
    }

    public void newUser (View view) {
        ScoreBaseHelper dbHandler = new ScoreBaseHelper(this, null, null, 1);

        int score = finalScore;

        User user =
                new User(nameBox.getText().toString(), score);

        dbHandler.addUser(user);
        idView.setText("User Added!");
        nameBox.setText("");
    }

    public void lookupUser (View view) {
        ScoreBaseHelper dbHandler = new ScoreBaseHelper(this, null, null, 1);

        User user =
                dbHandler.findUser(nameBox.getText().toString());

        if (user != null) {
            idView.setText( "their score: " + String.valueOf(user.getScore()));

        } else {
            idView.setText("User not Found");
        }
    }

    public void removeUser (View view) {
        ScoreBaseHelper dbHandler = new ScoreBaseHelper(this, null,
                null, 1);

        boolean result = dbHandler.deleteUser(
                nameBox.getText().toString());

        if (result)
        {
            idView.setText("Record Deleted");
            nameBox.setText("");
        }
        else
            idView.setText("No Match Found");
    }

    protected  void onResume() {
        super.onResume();
        stringVal = Integer.toString(finalScore);
        value.setText("Score: " + stringVal);
    }
}
