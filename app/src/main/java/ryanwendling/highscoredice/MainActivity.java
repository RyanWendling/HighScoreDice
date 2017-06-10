package ryanwendling.highscoredice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button startPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameActivity.cumulativeVal = 0;
        ResultActivity.finalScore = 0;

        startPlayButton = (Button) findViewById(R.id.playButton);
        startPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });

    }

    protected  void onResume() {
        super.onResume();
        GameActivity.cumulativeVal = 0;
        ResultActivity.finalScore = 0;
    }

}
