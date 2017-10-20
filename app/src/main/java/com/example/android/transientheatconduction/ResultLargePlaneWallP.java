package com.example.android.transientheatconduction;

import android.icu.math.BigDecimal;
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

import static android.icu.math.BigDecimal.*;


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
        float three1 = Float.v

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

        double biot = calculateBiot(LongC, h, k);
        displaybiot(biot);

        double b = calculateb(h, As, p, Cp, V);
        displayp(b);


        displaymis(three1);

    }

    public void graficar (View view){
        Bundle extrasa = getIntent().getExtras();
        String a = extrasa.getString("conduct");

        dispalya(a);
    }

    private void displaybiot (double onee){
        TextView oneView = (TextView) findViewById(R.id.t1);
        oneView.setText("" + onee + " ");
    }

    private void displayp (double ujum){
        TextView ujumView = (TextView) findViewById(R.id.t2);
        ujumView.setText("" + ujum + " st");
    }

    private void displaymis (float thr){
        TextView threeView = (TextView) findViewById(R.id.t3);
        threeView.setText("" + thr + " :)");
    }

    private void dispalya (String aa){
        TextView aView = (TextView) findViewById(R.id.t1a);
        aView.setText("" + aa + " jj");
    }

    private double calculateBiot (double l, double hh, double kk){
        return (hh * l) / (kk);
    }

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
