package com.example.android.transientheatconduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class prueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
    }

    public void mostrar (View view){
        Bundle extras = getIntent().getExtras();
        Double one = extras.getDouble("temAm");

        Bundle extras2 = getIntent().getExtras();
        Double two = extras2.getDouble("spi");

        Bundle extras3 = getIntent().getExtras();
        Double three = extras3.getDouble("misteri");

        displayone(one);

        displaytwo(two);

        displaymis(three);
    }

    private void displayone(double onee){
        TextView oneView = (TextView) findViewById(R.id.t1);
        oneView.setText("" + onee + " s");
    }

    private void displaytwo (double twoo){
        TextView twoView = (TextView) findViewById(R.id.t2);
        twoView.setText("" + twoo + " e");
    }

    private void displaymis (double thr){
        TextView threeView = (TextView) findViewById(R.id.t3);
        threeView.setText("" + thr + " :)");
    }
}
