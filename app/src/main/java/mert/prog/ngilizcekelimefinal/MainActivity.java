package mert.prog.ngilizcekelimefinal;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    sql dbHelper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006400")));
        this.dbHelper = new sql(this);
        try {
            this.dbHelper.CreateDataBase();
        } catch (Exception e) {
            Log.w("hata", "Veritabanı oluşturulamadı ve kopyalanamadı!");
        }

        ((Button) findViewById(R.id.btn_ozel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, act_tok.class));
            }
        });
        ((Button) findViewById(R.id.btn_basla)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, act_sev.class));
            }
        });
        ((Button) findViewById(R.id.btn_hakkında)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage((CharSequence) "Hoşgeldiniz.. \nbasit, orta, ileri ve üst düzey kelimelerin bulunduğu SWP'de kelime bilginizi pekiştirebilir,yeni kelimeler öğrenebilir hatta kendi kelime deponuzu oluşturabilirsiniz.En çok kullanılan +1000 kelime ile belli seviyeye geleceksiniz..\nsonrasında kendi branşınızdan kelimeler de ekleyip size özel kelime havuzu oluşturabileceksiniz ve dilediğiniz zaman tekrar edip pekiştirebileceksiniz...\n\nSWP 1.2");
                dlgAlert.setTitle((CharSequence) "Special Words Pouch");
                dlgAlert.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) null);
                dlgAlert.create().show();
            }
        });
    }
}
