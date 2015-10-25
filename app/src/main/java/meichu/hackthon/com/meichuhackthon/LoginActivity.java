package meichu.hackthon.com.meichuhackthon;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    private AccessToken accessToken;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //初始化FacebookSdk，記得要放第一行，不然setContentView會出錯
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //宣告callback Manager
        callbackManager = CallbackManager.Factory.create();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Hide the status bar
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.login_container);
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
                    LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile", "user_friends"));
                }
            }
        });

        //幫 LoginManager 增加callback function
        //這邊為了方便 直接寫成inner class
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            //登入成功
            @Override
            public void onSuccess(LoginResult loginResult) {

                //accessToken之後或許還會用到 先存起來
                accessToken = loginResult.getAccessToken();

                Log.d("FB", "access token got.");

//                //send request and call graph api
//                GraphRequest request = GraphRequest.newMeRequest(
//                        accessToken,
//                        new GraphRequest.GraphJSONObjectCallback() {
//
//                            //當RESPONSE回來的時候
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//
//                                //讀出姓名 ID FB個人頁面連結
//                                Log.d("FB", "complete");
//                                Log.d("FB", object.optString("name"));
//                                Log.d("FB", object.optString("link"));
//                                Log.d("FB", object.optString("id"));
//
//                            }
//                        });

//                //包入你想要得到的資料 送出request
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,link");
//                request.setParameters(parameters);
//                request.executeAsync();

                Log.i("Token", accessToken.getToken());


                Map<String, String> params = new HashMap<String, String>();
                params.put("token", "123");
//                params.put("token", accessToken.getToken());

                HttpConnection.sendPostRequest(HttpConnection.DEFAULT_DB, params, "UTF-8", new HttpConnection.Callback() {
                    @Override
                    public void handle(String response) {
                        Log.i("test", response);
                        // Log.i("response", response);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "recv", Toast.LENGTH_LONG);
                            }
                        });
                    }
                });

                Log.i("Id", accessToken.getUserId());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 轉跳至MainActivity
                        Intent intent = new Intent();
                        intent.putExtra("UserId", "s" + accessToken.getUserId());
                        intent.setClass(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    }
                });
            }

            //登入取消
            @Override
            public void onCancel() {
                // App code
                Log.d("FB", "CANCEL");
            }

            //登入失敗
            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d("FB", exception.toString());

                PackageInfo info;
                try{
                    info = getPackageManager().getPackageInfo("com.you.name", PackageManager.GET_SIGNATURES);
                    for(Signature signature : info.signatures)
                    {      MessageDigest md;
                        md =MessageDigest.getInstance("SHA");
                        md.update(signature.toByteArray());
                        String KeyResult =new String(Base64.encode(md.digest(), 0));//String something = new String(Base64.encodeBytes(md.digest()));
                        Log.e("hash key", KeyResult);
                        Toast.makeText(LoginActivity.this, "My FB Key is \n" + KeyResult, Toast.LENGTH_LONG).show();
                    }
                }catch(PackageManager.NameNotFoundException e1){Log.e("name not found", e1.toString());
                }catch(NoSuchAlgorithmException e){Log.e("no such an algorithm", e.toString());
                }catch(Exception e){Log.e("exception", e.toString());}
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
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
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
            }
            return null;
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
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

}

