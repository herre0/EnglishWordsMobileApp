package mert.prog.ngilizcekelimefinal;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import java.util.List;
import java.util.Random;

public class act_asil extends ListActivity implements View.OnClickListener {
    ArrayAdapter<veri> adaptor;

    /* renamed from: b1 */
    Button f39b1;

    /* renamed from: b2 */
    Button f40b2;

    /* renamed from: b3 */
    Button f41b3;

    /* renamed from: b4 */
    Button f42b4;
    Button bteng;

    /* renamed from: eg */
    String f43eg;

    /* renamed from: h */
    Handler f44h;
    veri here;

    /* renamed from: it */
    int f45it;

    /* renamed from: kaldık  reason: contains not printable characters */
    List<veri> f72kaldk;

    /* renamed from: ke */
    int f46ke;
    int kerre;

    /* renamed from: r */
    Random f47r;
    int seviyebilgisi;

    /* renamed from: tr */
    String f48tr;

    /* renamed from: u1 */
    int f49u1;

    /* renamed from: u2 */
    int f50u2;

    /* renamed from: u3 */
    int f51u3;

    /* renamed from: v */
    Vibrator f52v;
    Vibrator vibrator;

    /* renamed from: vk */
    veri_context f53vk;

    /* access modifiers changed from: protected */
    @SuppressLint("ResourceType")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_asil);
        this.f39b1 = (Button) findViewById(R.id.btn_1);
        this.f40b2 = (Button) findViewById(R.id.btn_2);
        this.f41b3 = (Button) findViewById(R.id.btn_3);
        this.f42b4 = (Button) findViewById(R.id.btn_4);
        this.bteng = (Button) findViewById(R.id.btn_gelen);
        this.f52v = (Vibrator) getSystemService("vibrator");
        this.bteng.setClickable(false);
        ((Button) findViewById(R.id.btn_ge)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                act_asil.this.startActivity(new Intent(act_asil.this, act_sev.class));
            }
        });
        this.f53vk = new veri_context(this);
        this.seviyebilgisi = getIntent().getIntExtra("sb", 0);
        int k = this.f53vk.Count();
        if (this.seviyebilgisi == 5) {
            this.f72kaldk = this.f53vk.m14kaldgyer(this.seviyebilgisi);
            this.f45it = Integer.parseInt(this.f72kaldk.get(0).getBildimi());
            this.f48tr = "sormak";
            this.f43eg = "ask";
            if (k < 10) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage((CharSequence) "Bu bölümü etkin kullanabilmeniz için en az 10 kelime eklemelisiniz.");
                dlgAlert.setTitle((CharSequence) "Uyarı!");
                dlgAlert.setCancelable(false);
                dlgAlert.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        act_asil.this.startActivity(new Intent(act_asil.this, MainActivity.class));
                    }
                });
                dlgAlert.create().show();
                return;
            }
            this.adaptor = new ArrayAdapter<>(this, 17367043, this.f53vk.vericekmek());
        } else {
            this.f72kaldk = this.f53vk.m14kaldgyer(this.seviyebilgisi);
            this.f53vk.kaldıgıyer(7);
            this.f45it = Integer.parseInt(this.f72kaldk.get(0).getBildimi());
            if (this.seviyebilgisi == 1) {
                this.f48tr = "kabul etmek";
                this.f43eg = "accept";
            } else if (this.seviyebilgisi == 2) {
                this.f48tr = "eklemek";
                this.f43eg = "add";
            } else if (this.seviyebilgisi == 3) {
                this.f48tr = "katılmak";
                this.f43eg = "agree";
            }
            this.adaptor = new ArrayAdapter<>(this, 17367043, this.f53vk.vericek(this.seviyebilgisi));
        }
        setListAdapter(this.adaptor);
        this.kerre = this.adaptor.getCount();
        int kaldigisayi = this.f45it + 1;
        AlertDialog.Builder dlgAlert2 = new AlertDialog.Builder(this);
        dlgAlert2.setMessage(kaldigisayi + " / " + this.kerre);
        dlgAlert2.setTitle((CharSequence) "İlerleme Durumu");
        dlgAlert2.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) null);
        dlgAlert2.create().show();
        this.f47r = new Random();
        this.f49u1 = this.f47r.nextInt(this.kerre);
        this.f50u2 = this.f47r.nextInt(this.kerre);
        this.f51u3 = this.f47r.nextInt(this.kerre);
        kelimekontrol();
        this.bteng.setText(this.adaptor.getItem(this.f45it).toString2());
        this.f39b1.setText(this.adaptor.getItem(this.f45it).toString3());
        this.f40b2.setText(this.adaptor.getItem(this.f49u1).toString3());
        this.f41b3.setText(this.adaptor.getItem(this.f50u2).toString3());
        this.f42b4.setText(this.adaptor.getItem(this.f51u3).toString3());
        this.f39b1.setOnClickListener(this);
        this.f40b2.setOnClickListener(this);
        this.f41b3.setOnClickListener(this);
        this.f42b4.setOnClickListener(this);
        this.f44h = new Handler();
    }



    public void vibration() {
        this.vibrator.vibrate(100);
    }

    public void onClick(View v) {
        if (this.f39b1.getId() == v.getId()) {
            if (this.f39b1.getText() == this.adaptor.getItem(this.f45it).toString3()) {
                this.f39b1.setBackgroundResource(R.drawable.btn_gr);
                this.bteng.setBackgroundResource(R.drawable.btn_eng);
                this.f39b1.setClickable(false);
                this.f44h.postDelayed(new Runnable() {
                    public void run() {
                        act_asil.this.randla();
                        act_asil.this.kelimekontrol();
                        act_asil.this.m13kelimedagt();
                        act_asil.this.f39b1.setClickable(true);
                    }
                }, 500);
            } else {
                this.f39b1.setBackgroundResource(R.drawable.btn_re);
                vibration();
            }
        }
        if (this.f40b2.getId() == v.getId()) {
            if (this.f40b2.getText() == this.adaptor.getItem(this.f45it).toString3()) {
                this.f40b2.setBackgroundResource(R.drawable.btn_gr);
                this.bteng.setBackgroundResource(R.drawable.btn_eng);
                this.f40b2.setClickable(false);
                this.f44h.postDelayed(new Runnable() {
                    public void run() {
                        act_asil.this.randla();
                        act_asil.this.kelimekontrol();
                        act_asil.this.m13kelimedagt();
                        act_asil.this.f40b2.setClickable(true);
                    }
                }, 500);
            } else {
                this.f40b2.setBackgroundResource(R.drawable.btn_re);
                vibration();
            }
        }
        if (this.f41b3.getId() == v.getId()) {
            if (this.f41b3.getText() == this.adaptor.getItem(this.f45it).toString3()) {
                this.f41b3.setBackgroundResource(R.drawable.btn_gr);
                this.bteng.setBackgroundResource(R.drawable.btn_eng);
                this.f41b3.setClickable(false);
                this.f44h.postDelayed(new Runnable() {
                    public void run() {
                        act_asil.this.randla();
                        act_asil.this.kelimekontrol();
                        act_asil.this.m13kelimedagt();
                        act_asil.this.f41b3.setClickable(true);
                    }
                }, 500);
            } else {
                this.f41b3.setBackgroundResource(R.drawable.btn_re);
                vibration();
            }
        }
        if (this.f42b4.getId() != v.getId()) {
            return;
        }
        if (this.f42b4.getText() == this.adaptor.getItem(this.f45it).toString3()) {
            this.f42b4.setBackgroundResource(R.drawable.btn_gr);
            this.bteng.setBackgroundResource(R.drawable.btn_eng);
            this.f42b4.setClickable(false);
            this.f44h.postDelayed(new Runnable() {
                public void run() {
                    act_asil.this.randla();
                    act_asil.this.kelimekontrol();
                    act_asil.this.m13kelimedagt();
                    act_asil.this.f42b4.setClickable(true);
                }
            }, 500);
            return;
        }
        this.f42b4.setBackgroundResource(R.drawable.btn_re);
        vibration();
    }

    /* renamed from: kelimedagıt  reason: contains not printable characters */
    public void m13kelimedagt() {
        if (this.f45it < this.kerre) {
            this.bteng.setText(this.adaptor.getItem(this.f45it).toString2());
            this.f53vk.updatet(this.seviyebilgisi, this.f48tr, this.f43eg, 1, String.valueOf(this.f45it));
            this.f46ke = this.f47r.nextInt(4);
            if (this.f46ke == 0) {
                this.f39b1.setText(this.adaptor.getItem(this.f45it).toString3());
                this.f40b2.setText(this.adaptor.getItem(this.f49u1).toString3());
                this.f41b3.setText(this.adaptor.getItem(this.f50u2).toString3());
                this.f42b4.setText(this.adaptor.getItem(this.f51u3).toString3());
            }
            if (this.f46ke == 1) {
                this.f39b1.setText(this.adaptor.getItem(this.f49u1).toString3());
                this.f40b2.setText(this.adaptor.getItem(this.f45it).toString3());
                this.f41b3.setText(this.adaptor.getItem(this.f50u2).toString3());
                this.f42b4.setText(this.adaptor.getItem(this.f51u3).toString3());
            }
            if (this.f46ke == 2) {
                this.f39b1.setText(this.adaptor.getItem(this.f49u1).toString3());
                this.f40b2.setText(this.adaptor.getItem(this.f50u2).toString3());
                this.f41b3.setText(this.adaptor.getItem(this.f45it).toString3());
                this.f42b4.setText(this.adaptor.getItem(this.f51u3).toString3());
            }
            if (this.f46ke == 3) {
                this.f39b1.setText(this.adaptor.getItem(this.f49u1).toString3());
                this.f40b2.setText(this.adaptor.getItem(this.f50u2).toString3());
                this.f41b3.setText(this.adaptor.getItem(this.f51u3).toString3());
                this.f42b4.setText(this.adaptor.getItem(this.f45it).toString3());
                return;
            }
            return;
        }
        this.f39b1.setClickable(false);
        this.f40b2.setClickable(false);
        this.f41b3.setClickable(false);
        this.f42b4.setClickable(false);
        this.bteng.setClickable(false);
        this.f53vk.updatet(this.seviyebilgisi, this.f48tr, this.f43eg, 1, String.valueOf(0));
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage((CharSequence) "TEBRİKLER!! SEVİYEYİ TAMAMLADINIZ..");
        dlgAlert.setTitle((CharSequence) "Seviye Tamamlandı");
        dlgAlert.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                act_asil.this.startActivity(new Intent(act_asil.this, act_sev.class));
            }
        });
        dlgAlert.create().show();
    }

    public void randla() {
        this.f45it++;
        this.f49u1 = this.f47r.nextInt(this.kerre);
        this.f50u2 = this.f47r.nextInt(this.kerre);
        this.f51u3 = this.f47r.nextInt(this.kerre);
    }

    public void kelimekontrol() {
        int k = 0;
        while (k < 2) {
            int k2 = k + 1;
            if (this.f49u1 == this.f50u2) {
                this.f49u1 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else if (this.f50u2 == this.f51u3) {
                this.f50u2 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else if (this.f49u1 == this.f51u3) {
                this.f51u3 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else if (this.f49u1 == this.f50u2 && this.f49u1 == this.f51u3) {
                this.f51u3 = this.f47r.nextInt(this.kerre);
                this.f50u2 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else if (this.f49u1 == this.f45it) {
                this.f49u1 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else if (this.f50u2 == this.f45it) {
                this.f50u2 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else if (this.f51u3 == this.f45it) {
                this.f51u3 = this.f47r.nextInt(this.kerre);
                k = k2 - 1;
            } else {
                k = k2 + 1;
            }
        }
        this.f39b1.setBackgroundResource(R.drawable.buton_tas);
        this.f40b2.setBackgroundResource(R.drawable.buton_tas);
        this.f41b3.setBackgroundResource(R.drawable.buton_tas);
        this.f42b4.setBackgroundResource(R.drawable.buton_tas);
        this.bteng.setBackgroundColor(-1);
    }
}
