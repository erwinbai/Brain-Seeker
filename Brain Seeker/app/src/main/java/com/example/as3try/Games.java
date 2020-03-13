package com.example.as3try;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Games extends AppCompatActivity {

    private static final String PLAY = "play";
    private static int NUM_ROWS;
    private static int NUM_COLS;
    private static int NUM_BRAIN;

    private int play;
    
    Button buttons[][];
    int open[][];
    Toast m_currentToast;
    private GameLogic myGame = new GameLogic();
    private static int brain_count = 0;
    private static int click_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        NUM_BRAIN = Options.getNumPanelsInstalled(this);
        NUM_COLS = Options.getNumPanelsInstalled2(this);
        NUM_ROWS = Options.getNumPanelsInstalled1(this);

        buttons = new Button[NUM_ROWS][NUM_COLS];
        open = new int[NUM_ROWS][NUM_COLS];

        myGame.setBrainMap(NUM_ROWS, NUM_COLS, NUM_BRAIN);
        brain_count = 0;
        click_count = 0;
        extractDataFromIntent();
        TextView tv4 = (TextView)findViewById(R.id.textView5);
        tv4.setText(""+play);
        
        populateButtons();



    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        play = intent.getIntExtra(PLAY,0);
    }



    private void populateButtons(){
//



        TextView tv = (TextView)findViewById(R.id.find_number2);
        tv.setText(""+NUM_BRAIN);

        TextView tv2 = (TextView)findViewById(R.id.find_number1);
        tv2.setText(""+0);

        TextView tv3 = (TextView)findViewById(R.id.scan_number);
        tv3.setText(""+click_count);

        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);

        for(int row = 0; row < NUM_ROWS; row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < NUM_COLS; col++){
                final int FINAL_COL = col;
                final int FINAL_ROW = row;
                final int FINAL_BRAIN = NUM_BRAIN;


                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        gridButtonClicked(FINAL_COL, FINAL_ROW);
                    }
                });

                tableRow.addView(button);
                buttons[row][col] = button;

            }
        }
    }



    private void gridButtonClicked(int col, int row){

        MediaPlayer mp = MediaPlayer.create(Games.this,R.raw.sample);
        mp.start();

        
        if(brain_count == NUM_BRAIN){
//            startActivity(new Intent(Games.this, Pop.class));

            FragmentManager manager = getSupportFragmentManager();
            alert dialog = new alert();
            dialog.show(manager, "MessageDialog");

            return;
        }

        click_count++;
        
        Button button = buttons[row][col];

        //Lock Button Sizes:
        lockButtonSizes();

//        button.setClickable(false);

        TextView tv = (TextView)findViewById(R.id.scan_number);
        tv.setText(""+click_count);


        if (myGame.checkBrain(row, col) && open[row][col] == 0) {
            brain_count++;

            //Scale image to button:
            int newWidth = button.getWidth();
            int newHeight = button.getHeight();
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_brain);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaledBitmap));

//            showToast("You find "+brain_count+" brain(s)");

            TextView tv2 = (TextView)findViewById(R.id.find_number1);
            tv2.setText(""+brain_count);

            myGame.update(row, col);

            for (int i = 0; i<NUM_ROWS; i++){
                for(int j = 0; j< NUM_COLS; j++){
                    if((myGame.checkBrain(i, j)&&open[i][j]>=2) || (!myGame.checkBrain(i, j)&&open[i][j]>=1)){
                        Button tmp_button = buttons[i][j];
                        tmp_button.setText(""+myGame.checkNumber(i,j));
                    }
                }
            }
        }

        else {
            //Set text to button:
//            button.setText("" + (col + 1) + " " + (row + 1));
            int tmp_number = myGame.checkNumber(row, col);
            button.setText(""+tmp_number);
//            showToast("This button is"+(col+1) + (row+1) );
            button.setClickable(false);
        }

        if(brain_count == NUM_BRAIN){

            for (int i = 0; i<NUM_ROWS; i++){
                for(int j = 0; j< NUM_COLS; j++){
                    Button tmp_button = buttons[i][j];
                    tmp_button.setClickable(true);
                }
            }

//            startActivity(new Intent(Games.this, Pop.class));

            FragmentManager manager = getSupportFragmentManager();
            alert dialog = new alert();
            dialog.show(manager, "MessageDialog");

            return;
        }

        open[row][col]++;

    }

    private void lockButtonSizes() {
//        int NUM_ROW = Options.getNumPanelsInstalledrow(this);
//        int NUM_COL = Options.getNumPanelsInstalledcol(this);
        for(int row = 0; row<NUM_ROWS; row++){
            for(int col = 0; col<NUM_COLS; col++){
                Button button = buttons[row][col];
                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }

    void showToast(String text)
    {
        if(m_currentToast != null)
        {
            m_currentToast.cancel();
        }
        m_currentToast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        m_currentToast.show();

    }

    public static Intent makeIntent(Context context,int play){
        Intent intent = new Intent(context, Games.class);
        intent.putExtra(PLAY, play);
        return intent;
    };

}


