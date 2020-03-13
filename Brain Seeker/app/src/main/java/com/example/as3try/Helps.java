package com.example.as3try;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Helps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helps);


        setupLaunchBack();

        TextView textView = findViewById(R.id.textView);
        String text = "The game Brain Seeker is developed for CMPT276 Assginment 3. Player needs to find all the brain hidden to win. The number represent the amount of brain left in the row and column. Player can set the size of the table and number of brains to find. Enjoy!";

        TextView pin = findViewById(R.id.textView7);
        String all = "All the picture are found on Pininterest. Animation creation is learned on Github. Url link in textview is adopted from StackOverflow.";


        SpannableString ss = new SpannableString(text);
        SpannableString xx = new SpannableString(all);
//https://stackoverflow.com/questions/36437590/open-a-url-link-on-click-of-ok-button-in-android-studio

//

        ClickableSpan url = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "https://stackoverflow.com/questions/36437590/open-a-url-link-on-click-of-ok-button-in-android-studio";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        xx.setSpan(url,119,133, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        pin.setText(xx);
        pin.setMovementMethod(LinkMovementMethod.getInstance());

        ClickableSpan animation = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "https://github.com/daimajia/AndroidViewAnimations";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        xx.setSpan(animation,75,81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        pin.setText(xx);
        pin.setMovementMethod(LinkMovementMethod.getInstance());


        ClickableSpan clickableSpan =  new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "https://www.pinterest.ca/pin/303711568604240171/";
                Intent i = new Intent (Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };

        xx.setSpan(clickableSpan,29,40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        pin.setText(xx);
        pin.setMovementMethod(LinkMovementMethod.getInstance());


        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "https://opencoursehub.cs.sfu.ca/bfraser/grav-cms/cmpt276/home";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };

        ss.setSpan(clickableSpan1,39,46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }




    private void setupLaunchBack(){
        Button btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Helps.this, Manuel.class);
                startActivity(back);
            }
        });


    }
}
