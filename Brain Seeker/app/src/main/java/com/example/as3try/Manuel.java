package com.example.as3try;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Manuel extends AppCompatActivity {
        int i = 0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_manuel);

                setupLaunchGame();
                setupLaunchHelp();
                setupLaunchOption();
            }
            private void setupLaunchGame(){
                Button btn = (Button) findViewById(R.id.button);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = i+1;
//                        Intent game = new Intent(Manuel.this, Games.class);
                        Intent intent = Games.makeIntent(Manuel.this, i);
                        startActivity(intent);
                    }
                });

            }
            //
            private void setupLaunchHelp(){
                Button btn = (Button) findViewById(R.id.button2);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        i = i+1;
                        Intent help = new Intent(Manuel.this, Helps.class);
//                        Intent help =  SecondActivity.makeIntent();
                        startActivity(help);
                    }
                });
                
            }

            private void setupLaunchOption(){
                Button btn = (Button) findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent option = new Intent(Manuel.this, Options.class);
                        startActivity(option);
                    }
                });

            }

//
//            public static Intent makeIntent(Context context, int played){
//                Intent intent = new Intent(context, SecondActivity.class)
//
//            };
}


