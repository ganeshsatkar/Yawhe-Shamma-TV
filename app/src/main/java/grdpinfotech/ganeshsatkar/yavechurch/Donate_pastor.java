package grdpinfotech.ganeshsatkar.yavechurch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Donate_pastor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_pastor);


        CardView c = (CardView) findViewById(R.id.bhim);

        CardView c4 = (CardView) findViewById(R.id.phonepe);
        CardView c5 = (CardView) findViewById(R.id.tez);





        c.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View v) {

                                      Intent intent = bhim(Donate_pastor.this);
                                      startActivity(intent);


                                  }


                              }
        );


        c4.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View v) {

                                      Intent intent = phonepe(Donate_pastor.this);
                                      startActivity(intent);


                                  }


                              }
        );


        c5.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View v) {

                                      Intent intent = tez(Donate_pastor.this);
                                      startActivity(intent);


                                  }


                              }
        );




    }





    public static Intent bhim(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.phonepe.app", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=in.org.npci.upiapp&hl=en_IN"));

        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=in.org.npci.upiapp&hl=en_IN    "));
        }


    }



    public static Intent phonepe(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.phonepe.app", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://phon.pe/ru_gane5fai4"));

        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://phon.pe/ru_gane5fai4"));
        }


    }

    public static Intent tez(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.apps.nbu.paisa.user", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://g.co/payinvite/WT8UX"));

        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://g.co/payinvite/WT8UX"));
        }


    }

}
