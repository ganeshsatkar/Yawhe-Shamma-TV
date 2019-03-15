package grdpinfotech.ganeshsatkar.yavechurch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

        public class Whatsaaprequest extends AppCompatActivity {
            Button b;

            EditText e1, e2, e3, e4, e5;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_whatsaaprequest);


                b = (Button) findViewById(R.id.sendrequest);
                e1 = (EditText) findViewById(R.id.editTextname);
                e2 = (EditText) findViewById(R.id.editTextphone);
                e3 = (EditText) findViewById(R.id.editTextemail);
                e4 = (EditText) findViewById(R.id.editTextaddress);
                e5 = (EditText) findViewById(R.id.editTextmsg);


                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String toNumber = "+91 88568 05844"; // contains spaces.

                        toNumber = toNumber.replace("+", "").replace(" ", "");

                        Intent sendIntent = new Intent("android.intent.action.MAIN");
                        sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Name : " + e1.getText() + "\n\nPhone : " + e2.getText() + "\n\nEmail : " + e3.getText() + "\n\nAddress : " + e4.getText() +"\n\nMessage : " + e5.getText());
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.setPackage("com.whatsapp");
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                    }
                });

            }
        }


