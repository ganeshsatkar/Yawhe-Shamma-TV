package grdpinfotech.ganeshsatkar.yavechurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Donateus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donateus);

        Button b = (Button) findViewById(R.id.paynow);
        Button b1 = (Button) findViewById(R.id.paynow1);

        assert b != null;
        b.setOnClickListener(new View.OnClickListener() {

                                 public void onClick(View v) {

                                     Intent intent = new Intent(Donateus.this, Payment_gateway.class);

                                     startActivity(intent);
                                 }

                             }
        );

        assert b1 != null;
        b1.setOnClickListener(new View.OnClickListener() {

                                 public void onClick(View v) {

                                     Intent intent = new Intent(Donateus.this, Donate_pastor.class);

                                     startActivity(intent);
                                 }

                             }
        );


    }
}
