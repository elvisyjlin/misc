package meichu.hackthon.com.meichuhackthon;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static List<DiaryItem> diaryItemList;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private String userId;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private static CustomViewPager mViewPager;
    private static NavigationView navigationView;

    /* The following strings are for test. They need retrieving from MySQL. */
    private static String userName = "User";
    private static String account = "user@facebook.com";
    private static String[] test_strings = {"Hello.", "I am Elvis.", "Ha ha!", "I don't like you...", "LOL",
                                        "Hmm...", "Oops!", "](-_-)[", "So sad.", "Bye!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            userId = null;
        } else {
            userId = extras.getString("UserId");
        }

        diaryItemList = new ArrayList<DiaryItem>();

        ContentCrawler.sendDiaryRequest(userId, "2015-09-24 23:59:00", "2015-10-24 23:59:00", new ContentCrawler.Callback() {
            @Override
            public void handle(List<DiaryItem> datas) {
                Log.i("handle()", Integer.toString(datas.size()));
                for(DiaryItem d : datas) {
                    diaryItemList.add(d);
                }
                mViewPager.getAdapter().notifyDataSetChanged();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        TextView textView = (TextView) headerLayout.findViewById(R.id.navTextView);
        textView.setText(userName);
        textView = (TextView) headerLayout.findViewById(R.id.navSubTextView);
        textView.setText(account);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (CustomViewPager) findViewById(R.id.main_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // swipe to page 2
                if (state == 0 && mViewPager.getCurrentItem() == 1) {

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_diary) {
            getSupportFragmentManager().popBackStack(0, 0);
            backToDiary();
        } else if (id == R.id.nav_calendar) {
            Fragment calendarFragment = new CalendarFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container, calendarFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            mViewPager.setSwipeable(false);
        } else if (id == R.id.nav_hashtag) {

//        } else if (id == R.id.nav_manage) {
//
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return diaryItemList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "SECTION "+(position+1);
        }
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    DiaryItem diaryItem = diaryItemList.get(getArguments().getInt(ARG_SECTION_NUMBER) - 1);
                    TextView textView;
                    textView = (TextView) rootView.findViewById(R.id.time_label);
                    textView.setText(diaryItem.getmTime());
                    textView = (TextView) rootView.findViewById(R.id.mood_label);
                    textView.setText(diaryItem.getmMood());
                    final ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view);
                    imageView.setImageDrawable(null);
                    if(diaryItem.getmPicture()!=null) {
                        try {
                            ContentCrawler.drawableFromUrl(diaryItem.getmPicture(), new ContentCrawler.DrawableCallback() {
                                @Override
                                public void handle(final Drawable d) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if(d!=null) {
                                                imageView.setImageDrawable(d);
                                            }
                                        }
                                    });
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    textView = (TextView) rootView.findViewById(R.id.content_label);
                    textView.setText(diaryItem.getmContent());
                    textView = (TextView) rootView.findViewById(R.id.location_label);
                    textView.setText(diaryItem.getmLocation());
                }
            });

            Log.i("onCreateView", "i=" + getArguments().getInt(ARG_SECTION_NUMBER));
            backToDiary();
            return rootView;
        }
    }

    public static class CalendarFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.calendar_main, container, false);
            return view;
        }

    }

    private static void backToDiary() {
        if(!mViewPager.getSwipeable()) {
            mViewPager.setSwipeable(true);
        }
        navigationView.getMenu().getItem(0).setChecked(true);
    }

}
