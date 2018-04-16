package com.example.android.transientheatconduction;


import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class ResultLargePlaneWallP extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    public SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public ViewPager mViewPager;

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_large_plane_wall_p);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }



    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    ResultLargePlaneWall1 resultLargePlaneWall1;
                    resultLargePlaneWall1 = new ResultLargePlaneWall1();
                    return resultLargePlaneWall1;
                case 1:
                    ResultLargePlaneWall1g resultLargePlaneWall1g;
                    resultLargePlaneWall1g = new ResultLargePlaneWall1g();
                    return resultLargePlaneWall1g;

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RESULT";
                case 1:
                    return "GRAPHIC RESULT";

            }
            return null;
        }
    }

    public void mostrar (View view){


        Bundle extras3 = getIntent().getExtras();
        Double three = extras3.getDouble("misteri");

        Bundle extras2 = getIntent().getExtras();
        Double Lc = extras2.getDouble("len");

        Bundle extras11 = getIntent().getExtras();
        Double thi = extras11.getDouble("think");

        Bundle extras12 = getIntent().getExtras();
        Double wi = extras12.getDouble("width");

        Bundle extras4 = getIntent().getExtras();
        Double h = extras4.getDouble("conCo");

        Bundle extras5 = getIntent().getExtras();
        Double k = extras5.getDouble("conduct");

        Bundle extras6 = getIntent().getExtras();
        Double p = extras6.getDouble("density");

        Bundle extras7 = getIntent().getExtras();
        Double Cp = extras7.getDouble("heatCapa");

        Bundle extras8 = getIntent().getExtras();
        Double Tt = extras8.getDouble("temTi");

        Bundle extras9 = getIntent().getExtras();
        Double Ta = extras9.getDouble("temAm");

        Bundle extras10 = getIntent().getExtras();
        Double Tm = extras10.getDouble("temMa");

        double V = calculateV(Lc, thi, wi);

        double As = calculateAs(Lc, thi, wi);

        double LongC = calculateLc(V, As);
        float LonC = (float) LongC;
        displaymis(LonC);

        double biot = calculateBiot(LongC, h, k);
        float biott = (float) biot;
        displaybiot(biott);

        double b = calculateb(h, As, p, Cp, V);
        float bb = (float) b;
        displayb(bb);

        double t = calculatet(bb, Tt, Ta, Tm);
        t = t / 3600;
        if (t == 1){
            int tt = (int) t;
            displayt(tt);
        }
        else if (t != 1) {
            double th = Math.floor(t);
            //en tn guardo el decimal restante.
            double tn = t - Math.floor(t);
            //tm guarda el decimal restante por 60.
            double tm = tn * 60;
            //tmin guarda el menor numero de tm que serian los minutos.
            double tmin = Math.floor(tm);
            //ts guarda los decimales de tm
            double ts = tm - Math.floor(tm);
            double tse = ts * 60;
            tse = Math.ceil(tse);
            int tseg = (int) tse;
            displaytime(th, tmin, tseg);
        }

    }

    public void graficar (View view){
        Bundle extras3 = getIntent().getExtras();
        Double three = extras3.getDouble("misteri");

        Bundle extras2 = getIntent().getExtras();
        Double Lc = extras2.getDouble("len");

        Bundle extras11 = getIntent().getExtras();
        Double thi = extras11.getDouble("think");

        Bundle extras12 = getIntent().getExtras();
        Double wi = extras12.getDouble("width");

        Bundle extras4 = getIntent().getExtras();
        Double h = extras4.getDouble("conCo");

        Bundle extras5 = getIntent().getExtras();
        Double k = extras5.getDouble("conduct");

        Bundle extras6 = getIntent().getExtras();
        Double p = extras6.getDouble("density");

        Bundle extras7 = getIntent().getExtras();
        Double Cp = extras7.getDouble("heatCapa");

        Bundle extras8 = getIntent().getExtras();
        Double Tt = extras8.getDouble("temTi");

        Bundle extras9 = getIntent().getExtras();
        Double Ta = extras9.getDouble("temAm");

        Bundle extras10 = getIntent().getExtras();
        Double Tm = extras10.getDouble("temMa");

        double V = calculateV(Lc, thi, wi);

        double As = calculateAs(Lc, thi, wi);

        double LongC = calculateLc(V, As);
        float LonC = (float) LongC;
        displaymis(LonC);

        double biot = calculateBiot(LongC, h, k);
        float biott = (float) biot;
        displaybiot(biott);

        double b = calculateb(h, As, p, Cp, V);
        float bb = (float) b;
        displayb(bb);

        float T = (float)Tm.doubleValue();
        mChart = (LineChart) findViewById(R.id.graficaLPW);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        for (Double i = Tm; i >= Tt; i--){
            double u = calculatet(bb, i, Ta, Tm);
            float U = (float)u;

            yValues.add(new Entry(U, T));
            T = T - 1;
        }


        LineDataSet set1 = new LineDataSet(yValues, "Temperature T(t) vs Time (seg)");

        set1.setFillAlpha(110);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        mChart.setData(data);
    }

    private void displaybiot (float onee){
        TextView oneView = (TextView) findViewById(R.id.t2);
        oneView.setText("El número de Biot es " + onee + " ");
    }

    private void displayb (float ujum){
        TextView ujumView = (TextView) findViewById(R.id.t3);
        ujumView.setText("El valor del exponente b es " + ujum + " s^-1");
    }

    private void displaymis (float thr){
        TextView threeView = (TextView) findViewById(R.id.t1);
        threeView.setText("La longitud caracteristica es " + thr + " m");
    }



    private void displayt (int tt){
        TextView timeView = (TextView) findViewById(R.id.t4);
        timeView.setText("El tiempo es " + tt + " h");
    }

    private void displaytime (double h, double m, double s) {
        TextView timeView = (TextView) findViewById(R.id.t4);
        timeView.setText("El tiempo es " + h + " h " + m + " min " + s + " seg");
    }

    private double calculateBiot (double l, double hh, double kk){
        return (hh * l) / (kk);
    }

    private double calculatet (float b, double tf, double ta, double tm) {return ((- 1 / b) * Math.log((tf - ta) / (tm - ta)));}

    private double calculateLc (double v, double as){
        return (v) / (as);
    }

    private double calculateV (double l, double t, double w){
        return (l * t * w);
    }

    private double calculateAs (double l, double t, double w){
        return (2 * (l * t) + 2 * (l * w) + 2 * (t * w));
    }

    private double calculateb (double h, double as, double r, double cp, double v){
        return  ((h * as) / (r * cp * v));
    }



}
