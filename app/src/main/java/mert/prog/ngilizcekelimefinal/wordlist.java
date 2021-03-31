package mert.prog.ngilizcekelimefinal;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class wordlist extends ListActivity {

    /* renamed from: vk */
    veri_context f63vk;

    /* access modifiers changed from: protected */
    @SuppressLint("ResourceType")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist);
        ((Button) findViewById(R.id.btn_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                wordlist.this.startActivity(new Intent(wordlist.this, act_tok.class));
            }
        });
        this.f63vk = new veri_context(this);
        this.f63vk.mo6201ac();
        setListAdapter(new ArrayAdapter<>(this, 17367043, this.f63vk.call_list()));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f63vk.kapat();
        super.onPause();
    }
}
