package com.example.android.transientheatconduction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivityTHC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thc);

        ImageView lsa = (ImageView) findViewById(R.id.lsa);

        lsa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent lsaIntent = new Intent(MainActivityTHC.this, LumpedSystemAnalysis.class);
                startActivity(lsaIntent);
            }
        });

    }
}
