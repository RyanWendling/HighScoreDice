package ryanwendling.highscoredice;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    ImageView dice_picture;     //reference to dice picture
    Random rng=new Random();    //generate random numbers
    Handler handler;            //Post message to start roll
    Timer timer=new Timer();    //Used to implement feedback to user
    boolean rolling=false;      //Is die rolling?
    Button rollButton;
    WebView wv;
    CheckBox oneButt;
    CheckBox twoButt;
    CheckBox threeButt;
    CheckBox fourButt;
    CheckBox fiveButt;
    CheckBox sixButt;
    CheckBox evenButt;
    CheckBox oddButt;
    TextView value;
    static int cumulativeVal =0;
    String stringVal;

    //When pause completed message sent to callback
    class Roll extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ResultActivity.finalScore = 0;

        //WebView wv = (WebView) findViewById(R.id.webView);
        wv = (WebView) findViewById(R.id.webView);
        wv.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        wv.loadDataWithBaseURL("file:///android_asset/", "<html>\n" +
                "<body bgcolor=\"white\">\n" +
                "    <table width=\"100%\" height=\"100%\">\n" +
                "        <tr>\n" +
                "            <td align=\"center\" valign=\"center\">\n" +
                "                <img src=\"dicrol.gif\">\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>", "text/html", "utf-8", "");


        rollButton = (Button) findViewById(R.id.rollinButton);
        value = (TextView) findViewById(R.id.scoreView);
        stringVal = Integer.toString(cumulativeVal);
        value.setText("Score: " + stringVal);

        oneButt = (CheckBox) findViewById(R.id.radioOne);
        twoButt = (CheckBox) findViewById(R.id.radioTwo);
        threeButt = (CheckBox) findViewById(R.id.radioThree);
        fourButt = (CheckBox) findViewById(R.id.radioFour);
        fiveButt = (CheckBox) findViewById(R.id.radioFive);
        sixButt = (CheckBox) findViewById(R.id.radioSix);
        evenButt = (CheckBox) findViewById(R.id.radioEven);
        oddButt = (CheckBox) findViewById(R.id.radioOdd);

        oneButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (oneButt.isChecked()) {
                    twoButt.setChecked(false);
                    threeButt.setChecked(false);
                    fourButt.setChecked(false);
                    fiveButt.setChecked(false);
                    sixButt.setChecked(false);
                    evenButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        twoButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (twoButt.isChecked()) {
                    oneButt.setChecked(false);
                    threeButt.setChecked(false);
                    fourButt.setChecked(false);
                    fiveButt.setChecked(false);
                    sixButt.setChecked(false);
                    evenButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        threeButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (threeButt.isChecked()) {
                    oneButt.setChecked(false);
                    twoButt.setChecked(false);
                    fourButt.setChecked(false);
                    fiveButt.setChecked(false);
                    sixButt.setChecked(false);
                    evenButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        fourButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (fourButt.isChecked()) {
                    oneButt.setChecked(false);
                    threeButt.setChecked(false);
                    twoButt.setChecked(false);
                    fiveButt.setChecked(false);
                    sixButt.setChecked(false);
                    evenButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        fiveButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (fiveButt.isChecked()) {
                    oneButt.setChecked(false);
                    threeButt.setChecked(false);
                    fourButt.setChecked(false);
                    twoButt.setChecked(false);
                    sixButt.setChecked(false);
                    evenButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        sixButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (sixButt.isChecked()) {
                    oneButt.setChecked(false);
                    threeButt.setChecked(false);
                    fourButt.setChecked(false);
                    fiveButt.setChecked(false);
                    twoButt.setChecked(false);
                    evenButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        evenButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (evenButt.isChecked()) {
                    oneButt.setChecked(false);
                    threeButt.setChecked(false);
                    fourButt.setChecked(false);
                    fiveButt.setChecked(false);
                    sixButt.setChecked(false);
                    twoButt.setChecked(false);
                    oddButt.setChecked(false);
                }
            }
        });
        oddButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (oddButt.isChecked()) {
                    oneButt.setChecked(false);
                    threeButt.setChecked(false);
                    fourButt.setChecked(false);
                    fiveButt.setChecked(false);
                    sixButt.setChecked(false);
                    evenButt.setChecked(false);
                    twoButt.setChecked(false);
                }
            }
        });

        //Get a reference to image widget
        dice_picture = (ImageView) findViewById(R.id.imageView);
        //dice_picture.setOnClickListener(new HandleClick());
        rollButton.setOnClickListener(new HandleClick());
        //link handler to callback
        handler=new Handler(callback);
    }

    //User pressed dice, lets start
    private class HandleClick implements View.OnClickListener {
        public void onClick(View arg0) {
            if (!rolling) {
                rolling = true;
                //Show rolling image
                dice_picture.setImageResource(R.drawable.dice3droll);

                wv.setVisibility(View.VISIBLE);

                wv.postDelayed(new Runnable() {
                    public void run() {
                        wv.setVisibility(View.INVISIBLE);
                    }
                }, 4000);

                //Pause to allow image to update
                timer.schedule(new Roll(), 4000);


            }
        }
    }

    //Receives message from timer to start dice roll
    Handler.Callback callback = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            switch(rng.nextInt(6)+1) {
                case 1:
                    dice_picture.setImageResource(R.drawable.one);
                    if (oneButt.isChecked()) {
                        cumulativeVal += 600;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);

                    }
                    else if (oddButt.isChecked()) {
                        cumulativeVal += 200;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);
                    }
                    else {
                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("score", cumulativeVal);
                        extras.putInt("roll", 1);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    break;

                case 2:
                    dice_picture.setImageResource(R.drawable.two);
                    if (twoButt.isChecked()) {
                        cumulativeVal += 600;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);

                    }
                    else if (evenButt.isChecked()) {
                        cumulativeVal += 200;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);
                    } else {
                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("score", cumulativeVal);
                        extras.putInt("roll", 2);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    break;
                case 3:
                    dice_picture.setImageResource(R.drawable.three);
                    if (threeButt.isChecked()) {
                        cumulativeVal += 600;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);

                    }
                    else if (oddButt.isChecked()) {
                        cumulativeVal += 200;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);
                    } else {
                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("score", cumulativeVal);
                        extras.putInt("roll", 3);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    break;
                case 4:
                    dice_picture.setImageResource(R.drawable.four);
                    if (fourButt.isChecked()) {
                        cumulativeVal += 600;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);

                    }
                    else if (evenButt.isChecked()) {
                        cumulativeVal += 200;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);
                    } else {
                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("score", cumulativeVal);
                        extras.putInt("roll", 4);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    break;
                case 5:
                    dice_picture.setImageResource(R.drawable.five);
                    if (fiveButt.isChecked()) {
                        cumulativeVal += 600;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);

                    }
                    else if (oddButt.isChecked()) {
                        cumulativeVal += 200;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);
                    } else{
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    Bundle extras = new Bundle();
                    extras.putInt("score", cumulativeVal);
                    extras.putInt("roll", 5);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                    break;
                case 6:
                    dice_picture.setImageResource(R.drawable.six);
                    if (sixButt.isChecked()) {
                        cumulativeVal += 600;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);

                    }
                    else if (evenButt.isChecked()) {
                        cumulativeVal += 200;
                        stringVal = Integer.toString(cumulativeVal);
                        value.setText("Score: " + stringVal);
                    } else {
                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("score", cumulativeVal);
                        extras.putInt("roll", 6);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    break;
                default:
            }
            rolling=false;  //user can press again
            return true;
        }
    };

    protected  void onResume() {
        super.onResume();
        stringVal = Integer.toString(cumulativeVal);
        value.setText("Score: " + stringVal);
    }
    //Clean up
    protected void onPause() {
        super.onPause();
    }
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
