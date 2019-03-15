package grdpinfotech.ganeshsatkar.yavechurch;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

        public class Splashscreen extends Activity {
            MediaPlayer music;
            @Override    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splashscreen);

                Thread timer=new Thread()
                {
                    @Override            public void run() {
                        try                {
                            music=MediaPlayer.create(Splashscreen.this,R.raw.panni);
                            music.start();
                            sleep(4000);

                        }
                        catch(InterruptedException e)
                        {

                        }
                        finally {
                            Intent i=new Intent(Splashscreen.this,MainActivity.class);
                            startActivity(i);
                        }
                    }
                };

                timer.start();


            }

            @Override    protected void onPause() {
                super.onPause();
                music.release();
            }
        }
