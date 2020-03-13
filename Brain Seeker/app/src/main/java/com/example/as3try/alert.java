package com.example.as3try;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class alert extends AppCompatDialogFragment {
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //create the view to show
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.activity_alert, null);


        //create a button listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Log.i("Tage", "You clicked the dialog button.");
//                Intent game = new Intent(Pop.this, Manuel.class);
//                startActivity(game);
//                finish();
                Intent i = new Intent(getActivity(),Manuel.class);
                startActivity(i);
            }
        };

        //Build the alert dialog
        return new AlertDialog.Builder(getActivity())
//                .setTitle("Changing Message")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();

    }
}
