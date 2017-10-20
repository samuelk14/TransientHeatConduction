package com.example.android.transientheatconduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class LongCylinder2 extends AppCompatActivity {

    RadioButton rbe;
    LinearLayout opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_cylinder2);

        rbe = (RadioButton) findViewById(R.id.rbe);
        opt = (LinearLayout) findViewById(R.id.options);

    }

    public void show (View view){

        opt.setVisibility(View.VISIBLE);
    }

    public void noShow (View view){
        opt.setVisibility(View.GONE);
    }

}
