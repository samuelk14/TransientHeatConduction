package com.example.android.transientheatconduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.transientheatconduction.R.id.spiner;


public class SphereP2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RelativeLayout relim;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere_p2);

        Spinner spinner;
        spinner = (Spinner) findViewById(spiner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.material_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        relim = (RelativeLayout) findViewById(R.id.relipf);



    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position==8) {

            relim.setVisibility(View.VISIBLE);
            displaymist(position);

        }
        else

            relim.setVisibility(View.GONE);
        displaymist(position);

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void displaymist(int pos){
        TextView miste = (TextView) findViewById(R.id.misterio);
        miste.setText("" + pos + "");

    }

    public void calculate (View view){

        Bundle extras1 = getIntent().getExtras();
        Double TA = Double.parseDouble(extras1.getString("temAmb"));

        Bundle extras2 = getIntent().getExtras();
        Double TM = Double.parseDouble(extras2.getString("temMat"));

        Bundle extras3 = getIntent().getExtras();
        Double TT = Double.parseDouble(extras3.getString("temTim"));

        Bundle extras4 = getIntent().getExtras();
        Double CC = Double.parseDouble(extras4.getString("conCoe"));

        EditText Diam = (EditText) findViewById(R.id.editmt);
        Double Di = Double.parseDouble(String.valueOf(Diam.getText()));



        EditText conduct = (EditText) findViewById(R.id.editmt2);
        Double con = Double.parseDouble(String.valueOf(conduct.getText()));

        EditText heatCap = (EditText) findViewById(R.id.edittt2);
        Double hC = Double.parseDouble(String.valueOf(heatCap.getText()));

        EditText density = (EditText) findViewById(R.id.edittt3);
        Double den = Double.parseDouble(String.valueOf(density.getText()));

        TextView miste = (TextView) findViewById(R.id.misterio);
        Double mi = Double.parseDouble(miste.getText().toString());




         if (mi == 0){
            Toast.makeText(getApplicationContext(), "Select a material", Toast.LENGTH_LONG).show();
        }

        else if (mi >= 1 && mi <= 7){
            Intent calcular = new Intent(SphereP2.this, ResultSphere2.class);
            calcular.putExtra("temAm", TA);
            calcular.putExtra("temMa", TM);
            calcular.putExtra("temTi", TT);
            calcular.putExtra("conCo", CC);
            calcular.putExtra("think", Di);
            calcular.putExtra("misteri", mi);
            startActivity(calcular);
        }

        if (mi == 8){

            Intent calcular = new Intent(SphereP2.this, ResultSphere2.class);
            calcular.putExtra("temAm", TA);
            calcular.putExtra("temMa", TM);
            calcular.putExtra("temTi", TT);
            calcular.putExtra("conCo", CC);
            calcular.putExtra("think", Di);
            calcular.putExtra("conduct", con);
            calcular.putExtra("heatCapa", hC);
            calcular.putExtra("misteri", mi);
            calcular.putExtra("density", den);
            startActivity(calcular);
        }

    }

}

