package com.example.android.transientheatconduction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;




public class LumpedSystemAnalysis extends AppCompatActivity {

    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton ra;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lumped_system_analysis);

        r1 = (RadioButton) findViewById(R.id.rdb1);
        r2 = (RadioButton) findViewById(R.id.rdb2);
        r3 = (RadioButton) findViewById(R.id.rdb3);
        ra = (RadioButton) findViewById(R.id.rdba);
        rb = (RadioButton) findViewById(R.id.rdbb);

    }

    public void rbclick (View view)
    {

        if (ra.isChecked() && r1.isChecked()) {
            Intent lsaIntent = new Intent(LumpedSystemAnalysis.this, LargePlaneWall.class);
            startActivity(lsaIntent);
        }

        else if (rb.isChecked() && r1.isChecked())        {
            Intent lsaIntent = new Intent(LumpedSystemAnalysis.this, LargePlaneWall2.class);
            startActivity(lsaIntent);
        }

        else if (ra.isChecked() && r2.isChecked()) {
            Intent lsaIntent = new Intent(LumpedSystemAnalysis.this, LongCylinder.class);
            startActivity(lsaIntent);
        }

        else if (rb.isChecked() && r2.isChecked())        {
            Intent lsaIntent = new Intent(LumpedSystemAnalysis.this, LongCylinder2.class);
            startActivity(lsaIntent);
        }

        else if (ra.isChecked() && r3.isChecked()) {
            Intent lsaIntent = new Intent(LumpedSystemAnalysis.this, Sphere.class);
            startActivity(lsaIntent);
        }

        else if (rb.isChecked() && r3.isChecked())        {
            Intent lsaIntent = new Intent(LumpedSystemAnalysis.this, Sphere2.class);
            startActivity(lsaIntent);
        }
    }

    }

