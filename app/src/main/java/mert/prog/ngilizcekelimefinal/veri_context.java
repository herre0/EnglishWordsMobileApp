package mert.prog.ngilizcekelimefinal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.core.view.PointerIconCompat;

import java.util.ArrayList;
import java.util.List;

public class veri_context {

    /* renamed from: a */
    int f60a = PointerIconCompat.TYPE_CELL;

    /* renamed from: db */
    SQLiteDatabase f61db;
    sql mdb;

    /* renamed from: ot */
    int f62ot = 1;

    public veri_context(Context c) {
        this.mdb = new sql(c);
    }

    /* renamed from: ac */
    public void mo6201ac() {
        this.f61db = this.mdb.getWritableDatabase();
    }

    public void kapat() {
        this.mdb.close();
    }

    public int create_veri(String tur, String eng, int seviye, String bildimi) {
        ContentValues val = new ContentValues();
        val.put("tur", tur);
        val.put("eng", eng);
        val.put("seviye", Integer.valueOf(seviye));
        val.put("bildimi", bildimi);
        return (int) this.f61db.insert("dbtablo", (String) null, val);
    }

    public List<veri> call_list() {
        List<veri> liste = new ArrayList<>();
        Cursor c = this.mdb.getReadableDatabase().query("dbtablo", new String[]{"_id", "tur", "eng", "seviye", "bildimi"}, " _id > ?", new String[]{String.valueOf(this.f60a)}, (String) null, (String) null, (String) null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            int i = c.getInt(0);
            veri spr = new veri(this.f62ot, c.getString(1), c.getString(2), c.getInt(3), c.getString(4));
            this.f62ot++;
            liste.add(spr);
            c.moveToNext();
        }
        c.close();
        return liste;
    }

    public List<veri> vericek(int level) {
        List<veri> liste = new ArrayList<>();
        Cursor c = this.mdb.getReadableDatabase().query("dbtablo", new String[]{"_id", "tur", "eng", "seviye", "bildimi"}, " seviye = ?", new String[]{String.valueOf(level)}, (String) null, (String) null, (String) null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            liste.add(new veri(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3), c.getString(4)));
            c.moveToNext();
        }
        c.close();
        return liste;
    }

    public List<veri> vericekmek() {
        List<veri> liste = new ArrayList<>();
        Cursor c = this.mdb.getReadableDatabase().query("dbtablo", new String[]{"_id", "tur", "eng", "seviye", "bildimi"}, " _id > ?", new String[]{String.valueOf(this.f60a)}, (String) null, (String) null, (String) null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            liste.add(new veri(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3), c.getString(4)));
            c.moveToNext();
        }
        c.close();
        return liste;
    }

    public void updatet(int id, String tur, String eng, int seviye, String bildimi) {
        ContentValues cv = new ContentValues();
        cv.put("tur", tur);
        cv.put("eng", eng);
        cv.put("seviye", Integer.valueOf(seviye));
        cv.put("bildimi", bildimi);
        this.mdb.getWritableDatabase().update("dbtablo", cv, "_id=" + id, (String[]) null);
    }

    public int Count() {
        Cursor c = this.mdb.getReadableDatabase().rawQuery("select count(*) from dbtablo where bildimi = 'h'", (String[]) null);
        c.moveToFirst();
        return c.getInt(0);
    }

    public List<veri> kaldıgıyer(int idbilgisi) {
        List<veri> liste = new ArrayList<>();
        Cursor c = this.mdb.getReadableDatabase().query("dbtablo", new String[]{"_id", "tur", "eng", "seviye", "bildimi"}, " _id = ?", new String[]{String.valueOf(idbilgisi)}, (String) null, (String) null, (String) null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            liste.add(new veri(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3), c.getString(4)));
            c.moveToNext();
        }
        c.close();
        return liste;
    }
}
