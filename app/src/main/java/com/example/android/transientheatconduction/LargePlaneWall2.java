package com.example.android.transientheatconduction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class LargePlaneWall2 extends AppCompatActivity {

    RadioButton rbe;
    LinearLayout opt;
    RadioButton rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_plane_wall2);

        rbe = (RadioButton) findViewById(R.id.rbe);
        opt = (LinearLayout) findViewById(R.id.options);
        rc = (RadioButton) findViewById(R.id.rbc);

    }

    public void show (View view){

        opt.setVisibility(View.VISIBLE);
    }

    public void noShow (View view){
        opt.setVisibility(View.GONE);
    }

    public void siguiente (View view) {

        EditText temAmb = (EditText) findViewById(R.id.etat);
        String getTA = temAmb.getText().toString();

        EditText temMat = (EditText) findViewById(R.id.editmt);
        String getTM = temMat.getText().toString();

        EditText temTim = (EditText) findViewById(R.id.edittt);
        String getTT = temTim.getText().toString();

        EditText conCoe = (EditText) findViewById(R.id.edtcc);
        String getCC = conCoe.getText().toString();

        if (getTA.isEmpty()) {
            temAmb.setError("empty field");
            temAmb.requestFocus();
        } else if (getTM.isEmpty()) {
            temMat.setError("empty field");
            temMat.requestFocus();
        } else if (getTT.isEmpty()) {
            temTim.setError("empty field");
            temTim.requestFocus();
        } else if (!rc.isChecked() && !rbe.isChecked()) {
            Toast.makeText(getApplicationContext(), "Select an option", Toast.LENGTH_LONG).show();
        } else if (rc.isChecked()) {

            Intent next2 = new Intent(LargePlaneWall2.this, LargePlaneWallP2.class);
            next2.putExtra("temAmb", getTA);
            next2.putExtra("temMat", getTM);
            next2.putExtra("temTim", getTT);
            startActivity(next2);
        } else if (getCC.isEmpty()) {
            conCoe.setError("empty field");
            conCoe.requestFocus();
        } else if (rbe.isChecked()) {
            Intent next2 = new Intent(LargePlaneWall2.this, LargePlaneWallP2.class);
            next2.putExtra("temAmb", getTA);
            next2.putExtra("temMat", getTM);
            next2.putExtra("temTim", getTT);
            next2.putExtra("conCoe", getCC);
            startActivity(next2);
        }
    }
}
