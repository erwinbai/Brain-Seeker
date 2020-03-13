//package com.example.as3try;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//public class Options extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_options);
//        createRadioButtons();
//        createRadioButton2();
////        int savedValue = getNumPanelsInstalled(this);
////        Toast.makeText(this, "Saved value: " + savedValue, Toast.LENGTH_SHORT)
////                .show();
//
//        BackLaunchGame();
//    }
//
//
//    private void createRadioButtons() {
//        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_install_size);
//
//        int[] numPanels = getResources().getIntArray(R.array.num_solar_panels);
//
//        for (int i = 0; i < numPanels.length; i++){
//            final int numPanel = numPanels[i];
//
//            RadioButton button = new RadioButton(this);
//            button.setText(numPanel + " brain");
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    final MediaPlayer mp = MediaPlayer.create(Options.this, R.raw.sample);
////                    mp.start();
//                    Toast.makeText(Options.this, "You clicked" + numPanel, Toast.LENGTH_SHORT)
//                            .show();
//
//                    saveNumPanelsInstalled(numPanel);
//                }
//            });
//
//            group.addView(button);
//
//
//            if(numPanel == getNumPanelsInstalled(this)){
//                button.setChecked(true);
//            }
//
//        }
//    }
//
//
//
//    private void createRadioButton2() {
//        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_install_size2);
//
//        int[] cols = getResources().getIntArray(R.array.col);
//        int[] rows = getResources().getIntArray(R.array.row);
//
//        for (int i = 0; i < cols.length; i++){
//            final int col = cols[i];
//            final int row = rows[i];
//
//            RadioButton button = new RadioButton(this);
//            button.setText(col + " row " + row + " col");
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    final MediaPlayer mp = MediaPlayer.create(Options.this, R.raw.sample);
////                    mp.start();
////                    Toast.makeText(Options.this, "You clicked" + numPanel, Toast.LENGTH_SHORT)
////                            .show();
//
//                    saveNumPanelsInstalled1(col,row);
////                    saveNumPanelsInstalled2(row);
//                }
//            });
//
//            group.addView(button);
//            if(col == getNumPanelsInstalledcol(this) && row == getNumPanelsInstalledrow(this)){
//                button.setChecked(true);
//            }
////            if(row == getNumPanelsInstalledrow(this)){
////                button.setChecked(true);
////            }
//
//        }
//    }
//
//
//
//    private void saveNumPanelsInstalled(int numPanel){
//        SharedPreferences prefs =  this.getSharedPreferences("AppPrefs", MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putInt("Num installed panels", numPanel);
//        editor.apply();
//    }
//
//    private void saveNumPanelsInstalled1(int col,int row){
//        SharedPreferences prefs =  this.getSharedPreferences("Col", MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putInt("Num installed col", col);
//        editor.putInt("Num installed row", row);
//        editor.apply();
//    }
//
//
////    private void saveNumPanelsInstalled2(int row){
////        SharedPreferences prefs =  this.getSharedPreferences("Row", MODE_PRIVATE);
////        SharedPreferences.Editor editor = prefs.edit();
////        editor.putInt("Num installed panels", row);
////        editor.apply();
////    }
//
//
//    static public int getNumPanelsInstalledcol(Context context){
//        SharedPreferences prefs = context.getSharedPreferences("Col", MODE_PRIVATE);
//        return prefs.getInt("Num installed col", 4);
//
//    }    static public int getNumPanelsInstalledrow(Context context){
//        SharedPreferences prefs = context.getSharedPreferences("Row", MODE_PRIVATE);
//        return prefs.getInt("Num installed row", 6);
//    }
//
//
//    static public int getNumPanelsInstalled(Context context){
//        SharedPreferences prefs = context.getSharedPreferences("AppPrefs", MODE_PRIVATE);
//        return prefs.getInt("Num installed panels", 6);
//    }
//
//    private void BackLaunchGame(){
//
//        Button btn = (Button) findViewById(R.id.button6);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                final MediaPlayer mp = MediaPlayer.create(Options.this, R.raw.sample);
////                mp.start();
//                Intent game = new Intent(Options.this, Manuel.class);
//                startActivity(game);
//            }
//        });
//    }
//
//
//}

package com.example.as3try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        createRadioButtons();
        createRadioButtons2();
//        int savedValue = getNumPanelsInstalled2(this);
//        int savedValue2 = getNumPanelsInstalled1(this);
//        int savedValue3 = getNumPanelsInstalled(this);
//        Toast.makeText(this, "Brain: " + savedValue3 + "Col " +savedValue2 + "row" + savedValue, Toast.LENGTH_SHORT)
//                .show();

        BackLaunchGame();
    }


    private void createRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_install_size);

        int[] numPanels = getResources().getIntArray(R.array.num_solar_panels);

        for (int i = 0; i < numPanels.length; i++){
            final int numPanel = numPanels[i];

            RadioButton button = new RadioButton(this);
            button.setText(numPanel + " brain");
            button.setTextColor(Color.RED);
            button.setTextSize(24);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    final MediaPlayer mp = MediaPlayer.create(Options.this, R.raw.sample);
//                    mp.start();
//                    Toast.makeText(Options.this, "You clicked" + numPanel, Toast.LENGTH_SHORT)
//                            .show();

                    saveNumPanelsInstalled(numPanel);
                }
            });

            group.addView(button);


            if(numPanel == getNumPanelsInstalled(this)){
                button.setChecked(true);
            }

        }
    }

    private void createRadioButtons2() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_install_size2);

        int[] cols = getResources().getIntArray(R.array.col);
        int[] rows = getResources().getIntArray(R.array.row);

        for (int i = 0; i < cols.length; i++){
            final int col = cols[i];
            final int row = rows[i];

            RadioButton button = new RadioButton(this);
            button.setText(col + " Row "+ row+ " Col ");
            button.setTextColor(Color.RED);
            button.setTextSize(24);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    final MediaPlayer mp = MediaPlayer.create(Options.this, R.raw.sample);
//                    mp.start();
//                    Toast.makeText(Options.this, "You clicked" + col, Toast.LENGTH_SHORT)
//                            .show();

                    saveNumPanelsInstalled1(col,row);
//                    saveNumPanelsInstalled2(row);
//                    Toast.makeText(Options.this, "You clicked" + col +"and" + row, Toast.LENGTH_SHORT)
//                            .show();
                }
            });

            group.addView(button);


            if(col == getNumPanelsInstalled1(this) && row == getNumPanelsInstalled2(this) ){
                button.setChecked(true);
            }

        }
    }

    private void saveNumPanelsInstalled1(int col, int row){
        SharedPreferences prefs = this.getSharedPreferences("AppPrefs1", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Num installed cols", col);
        editor.putInt("Num installed rows", row);
        editor.apply();
    }

    private void saveNumPanelsInstalled(int numPanel){
        SharedPreferences prefs =  this.getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Num installed panels", numPanel);
        editor.apply();
    }




    static public int getNumPanelsInstalled1(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs1", MODE_PRIVATE);
//        int defaulcols = context.getResources().getInteger(R.integer.default_col);
        return prefs.getInt("Num installed cols", 4);
//        prefs.getInt("Num installed rows", 6);
    }

    static public int getNumPanelsInstalled2(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs1", MODE_PRIVATE);
        return prefs.getInt("Num installed rows", 6);
    }


    static public int getNumPanelsInstalled(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs", MODE_PRIVATE);
        return prefs.getInt("Num installed panels", 6);
    }

    private void BackLaunchGame(){

        Button btn = (Button) findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final MediaPlayer mp = MediaPlayer.create(Options.this, R.raw.sample);
//                mp.start();
                Intent game = new Intent(Options.this, Manuel.class);
                startActivity(game);
            }
        });
    }


}

