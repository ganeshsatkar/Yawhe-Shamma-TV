       package grdpinfotech.ganeshsatkar.yavechurch;

       import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.EXTRA_EMAIL;
import static android.content.Intent.EXTRA_SUBJECT;
import static android.content.Intent.EXTRA_TEXT;
import static android.content.Intent.createChooser;

       public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private boolean exit = false;
    private WebView webView;
    TextView tt;
    AdView adView;
    private InterstitialAd interstitialAd;


// bottomnavigation




           private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                   = new BottomNavigationView.OnNavigationItemSelectedListener() {

               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   switch (item.getItemId()) {

                       case R.id.navigation_request:

                           Intent i = new Intent(MainActivity.this, Whatsaaprequest.class);
                           startActivity(i);
                           return true;


                       case R.id.navigation_donation:
                           Intent i1 = new Intent(MainActivity.this, Donateus.class);
                           startActivity(i1);
                           return true;

                       /*case R.id.navigation_testimonial:
                           startActivity(new Intent(Intent.ACTION_VIEW,
                                   Uri.parse(
                                           "https://api.whatsapp.com/send?phone=+919960759032&text=Write%20your%20feedback%20here"
                                   )));
                           return true;*/


                       case R.id.navigation_fullscreen:
                           Intent launchYouTube1 = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");

                           startActivity(new Intent(launchYouTube1.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCdUEvdSqptvoLh6R7y79v5w")));
                           // https://www.youtube.com/channel/UCc2PCIrC5HOjBNDnKnJa3VQ

                           return true;
                   }
                   return false;
               }
           };






// end bottom navigation












           @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




              // mTextMessage = (TextView) findViewById(R.id.message);
               BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
               navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);









//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        webView = (WebView) findViewById(R.id.webview);
               //webView.getSettings().setLoadWithOverviewMode(true);
               //webView.getSettings().setUseWideViewPort(true);

               tt = (TextView) findViewById(R.id.text1);

        checkConnection();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
    }


    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


           @Override
           protected  void onPause()
           {

               super.onPause();
               webView.onPause();
           }


           @Override
           protected void onResume(){

               super.onResume();
               webView.onResume();
           }



    public void checkConnection() {
        if (isOnline()) {
               Toast.makeText(MainActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();

            //webView.loadUrl("https://www.grdpinfotech.com/church/");

            webView.loadUrl("https://www.youtube.com/channel/UCdUEvdSqptvoLh6R7y79v5w");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());





            adView = (AdView) findViewById(R.id.adView);

            //webView.onPause();
            // webView.pauseTimers();
            AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
            adView.loadAd(adRequest);

            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdUnitId("ca-app-pub-7233052509464359/5936673806");
            interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    // startActivity(new Intent(MainActivity.this,Designby.class));
                    finish();
                    interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
                }
            });

        } else {
            Toast.makeText(MainActivity.this, "You are not connected to Internet", Toast.LENGTH_LONG).show();
            tt.setText("         Can't Connect to the Server.\n Plese Check Your Internet Connection");
        }
    }









    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                //super.onBackPressed();
                if (exit) {
                    next();
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Tap Back button again to exit", Toast.LENGTH_SHORT).show();

                }
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 2000);

                exit = true;
            }
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
        if (id == R.id.action_Email) {

            Intent intent = new Intent(ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(EXTRA_EMAIL, new String[]{"yawheshammachurch@gmail.com"});
            intent.putExtra(EXTRA_SUBJECT, "subject");
            intent.putExtra(EXTRA_TEXT, "mail body");
            startActivity(createChooser(intent, ""));

        }

        if (id == R.id.action_Contact) {

            String phone = "+919766796321";
            Intent intent = new Intent(ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);

        }


        if (id == R.id.broadcast) {

            Intent launchYouTube1 = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");

            startActivity(new Intent(launchYouTube1.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCdUEvdSqptvoLh6R7y79v5w")));

        }




        if (id == R.id.mailcheck) {

            Intent launchGoogleChrome = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.youtube.creator");
            startActivity(launchGoogleChrome);
        }


        if (id == R.id.drivecheck) {

            Intent launchGoogleChrome = getPackageManager().getLaunchIntentForPackage("org.wordpress.android");
            startActivity(launchGoogleChrome);


        }

        if (id == R.id.mailcheck1) {

            Intent launchGoogleChrome1 = getPackageManager().getLaunchIntentForPackage("com.instamojo.app");
            startActivity(launchGoogleChrome1);


        }











        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent i = new Intent(MainActivity.this, Home.class);
            startActivity(i);



        }  else if (id == R.id.prayer) {
            Intent i = new Intent(MainActivity.this, Request.class);
            startActivity(i);

             //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCqkYdg0BCQLJ1p3Hn9vjATw")));

        } else if (id == R.id.contact) {

            Intent i = new Intent(MainActivity.this, Contact.class);
            startActivity(i);

            //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCqkYdg0BCQLJ1p3Hn9vjATw")));


        /*}  else if (id == R.id.bibleread) {
            Intent i = new Intent(MainActivity.this, Payment_read_bible.class);
            startActivity(i);
*/
            //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCqkYdg0BCQLJ1p3Hn9vjATw")));

        }  else if (id == R.id.churchstory) {
            Intent i = new Intent(MainActivity.this, Church_poem.class);
            startActivity(i);

            //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCqkYdg0BCQLJ1p3Hn9vjATw")));



        } else if (id == R.id.broadcast) {

            Intent launchYouTube1 = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");

            startActivity(new Intent(launchYouTube1.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCdUEvdSqptvoLh6R7y79v5w")));

            /*Intent launchGoogleChrome = getPackageManager().getLaunchIntentForPackage("com.vaultmicro.camerafi.live");
            startActivity(launchGoogleChrome);*/


        }

        else if (id == R.id.testimonial1) {

            //startActivity(new Intent(Intent.ACTION_VIEW,

            //        Uri.parse(
            //              "https://api.whatsapp.com/send?phone=+918856805844&text=Write%20your%20feedback%20or%20prayer%20request%20here"
            //    )));


            String toNumber = "+91 88568 05844"; // contains spaces.
            toNumber = toNumber.replace("+", "").replace(" ", "");

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Write Your Feedback, Video Message & Video Request Here");
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setPackage("com.whatsapp");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }




        else if(id==R.id.share){

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBodyText = getString(R.string.sharelink);
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
            return true;



        }

        else if (id == R.id.designby) {
            Intent i = new Intent(MainActivity.this, Designby.class);
            startActivity(i);


        }





            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void next()
    {
        if(interstitialAd.isLoaded())
        {
            interstitialAd.show();
        }
        else
        {
            //    startActivity(new Intent(MainActivity.this,Next.class));
            // startActivity(new Intent(MainActivity.this,Designby.class));
            finish();
        }}








}
