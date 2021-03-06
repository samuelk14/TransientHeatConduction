package com.example.android.transientheatconduction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.transientheatconduction.R.id.rbc;


public class LargePlaneWall extends AppCompatActivity {


    LinearLayout opt;
    RadioButton re;
    RadioButton rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_plane_wall);


        opt = (LinearLayout) findViewById(R.id.options);
        re = (RadioButton) findViewById(R.id.rbe);
        rc = (RadioButton) findViewById(rbc);

    }

    public void show (View view){ opt.setVisibility(View.VISIBLE); }

    public void noShow (View view){ opt.setVisibility(View.GONE);    }


    public void siguiente (View view){

        EditText temAmb = (EditText) findViewById(R.id.etat);
        String getTA = temAmb.getText().toString();

        EditText temMat = (EditText) findViewById(R.id.editmt);
        String getTM = temMat.getText().toString();

        EditText temTim = (EditText) findViewById(R.id.edittt);
        String getTT = temTim.getText().toString();

        EditText conCoe = (EditText) findViewById(R.id.edtcc);
        String getCC = conCoe.getText().toString();

        if (getTA.isEmpty()){
            temAmb.setError("empty field");
            temAmb.requestFocus();
        }

        else if (getTM.isEmpty()){
            temMat.setError("empty field");
            temMat.requestFocus();
        }

        else if (getTT.isEmpty()){
            temTim.setError("empty field");
            temTim.requestFocus();
        }

        else if (!rc.isChecked() && !re.isChecked()){
            Toast.makeText(getApplicationContext(), "Select an option", Toast.LENGTH_LONG).show();
        }

        else if (rc.isChecked()){

        Intent next = new Intent(LargePlaneWall.this, LargePlaneWallP.class);
            next.putExtra("temAmb", getTA);
            next.putExtra("temMat", getTM);
            next.putExtra("temTim", getTT);
        startActivity(next);
        }

        else if (getCC.isEmpty()){
            conCoe.setError("empty field");
            conCoe.requestFocus();
        }

        else if (re.isChecked()){

            Intent next = new Intent(LargePlaneWall.this, LargePlaneWallP.class);
            next.putExtra("temAmb", getTA);
            next.putExtra("temMat", getTM);
            next.putExtra("temTim", getTT);
            next.putExtra("conCoe", getCC);
            startActivity(next);
        }



    }


}
