package mert.prog.ngilizcekelimefinal;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class act_tok extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_act_tok);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((Button) findViewById(R.id.btn_hakkında)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                act_tok.this.startActivity(new Intent(act_tok.this, secme.class));
            }
        });
        ((Button) findViewById(R.id.btn_basla)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                act_tok.this.startActivity(new Intent(act_tok.this, wordlist.class));
            }
        });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006400")));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 16908332) {
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
        }
        if (id == R.id.action_info) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage((CharSequence) "Özelleştirmeye başlayın..\nBu sayfada istediğiniz seviyede kelime ekleyebilir ve eklediğiniz kelimeleri görebilirsiniz.\nDikkat edin eklediğiniz kelimeler kalıcı olarak listenizde yer tutar..");
            dlgAlert.setTitle((CharSequence) "Special Words Pouch");
            dlgAlert.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) null);
            dlgAlert.create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
