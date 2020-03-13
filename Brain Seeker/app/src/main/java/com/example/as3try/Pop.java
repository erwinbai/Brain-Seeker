package com.example.as3try;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pop extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_alert);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.75), (int) (height * 0.75));
        getWindow().setGravity(Gravity.CENTER);

        setupLaunchFinish();
    }


    private void setupLaunchFinish() {
        Button btn = (Button) findViewById(R.id.finish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(Pop.this, Manuel.class);
                startActivity(game);
                finish();
            }
        });
    }
}
