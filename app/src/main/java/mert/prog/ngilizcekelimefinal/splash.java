package mert.prog.ngilizcekelimefinal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splash extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    splash.this.startActivity(new Intent(splash.this, MainActivity.class));
                }
            }
        }.start();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        finish();
    }
}
