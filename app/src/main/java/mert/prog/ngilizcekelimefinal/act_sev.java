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

public class act_sev extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_act_sev);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006400")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((Button) findViewById(R.id.special)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(act_sev.this, act_asil.class);
                i.putExtra("sb", 5);
                act_sev.this.startActivity(i);
            }
        });
        ((Button) findViewById(R.id.btn_sev1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(act_sev.this, act_asil.class);
                i.putExtra("sb", 1);
                act_sev.this.startActivity(i);
            }
        });
        ((Button) findViewById(R.id.btn_sev2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(act_sev.this, act_asil.class);
                i.putExtra("sb", 2);
                act_sev.this.startActivity(i);
            }
        });
        ((Button) findViewById(R.id.btn_sev3)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(act_sev.this, act_asil.class);
                i.putExtra("sb", 3);
                act_sev.this.startActivity(i);
            }
        });
        ((Button) findViewById(R.id.btn_sev4)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(act_sev.this, act_asil.class);
                i.putExtra("sb", 4);
                act_sev.this.startActivity(i);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 16908332) {
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
        }
        if (id == R.id.action_info) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage((CharSequence) "SWP seviyelendirildi..\nseviye 1:basit\nseviye 2:orta\nseviye 3:ileri\nseviye 4:üst\nSPECIAL:özel");
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
