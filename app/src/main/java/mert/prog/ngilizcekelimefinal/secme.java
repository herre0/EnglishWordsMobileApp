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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class secme extends AppCompatActivity {
    EditText eten;
    EditText ettr;

    /* renamed from: r1 */
    RadioButton f54r1;

    /* renamed from: r2 */
    RadioButton f55r2;

    /* renamed from: r3 */
    RadioButton f56r3;

    /* renamed from: r4 */
    RadioButton f57r4;

    /* renamed from: vk */
    veri_context f58vk;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_secme);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.ettr = (EditText) findViewById(R.id.et_tr);
        this.eten = (EditText) findViewById(R.id.et_en);
        this.f54r1 = (RadioButton) findViewById(R.id.r_sev1);
        this.f55r2 = (RadioButton) findViewById(R.id.r_sev2);
        this.f56r3 = (RadioButton) findViewById(R.id.r_sev3);
        this.f57r4 = (RadioButton) findViewById(R.id.r_sev4);
        this.f58vk = new veri_context(this);
        this.f58vk.mo6201ac();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006400")));
        ((Button) findViewById(R.id.btn_kaydet)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i = 0;
                if (secme.this.f54r1.isChecked()) {
                    i = 1;
                } else if (secme.this.f55r2.isChecked()) {
                    i = 2;
                } else if (secme.this.f56r3.isChecked()) {
                    i = 3;
                } else if (secme.this.f57r4.isChecked()) {
                    i = 4;
                }
                veri sp1 = new veri(secme.this.ettr.getText().toString(), secme.this.eten.getText().toString(), i, "h");
                sp1.setId(secme.this.f58vk.create_veri(sp1.getTur(), sp1.getEng(), sp1.getSeviye(), sp1.getBildimi()));
                Toast.makeText(secme.this.getApplicationContext(), "Başarıyla Eklendi.", 1).show();
                secme.this.ettr.setText("");
                secme.this.eten.setText("");
                secme.this.f54r1.setChecked(true);
                secme.this.ettr.requestFocus();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.f58vk.mo6201ac();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f58vk.kapat();
        super.onPause();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 16908332) {
            NavUtils.navigateUpTo(this, new Intent(this, act_tok.class));
        }
        if (id == R.id.action_info) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage((CharSequence) "Bu bölümde eklediğiniz kelimeler ilgili seviye bölümlerinden ziyade SPECIAL bölümüne de eklenir.Böylelikle eklediğiniz kelimeler üzerinden de alıştırmalar yapabilirsiniz.");
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
