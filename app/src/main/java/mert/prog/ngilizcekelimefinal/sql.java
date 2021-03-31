package mert.prog.ngilizcekelimefinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class sql extends SQLiteOpenHelper {
    static String DB_NAME = "dbname.db";
    static String DB_PATH;
    final Context myContext;
    SQLiteDatabase myDatabase;

    public sql(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        DB_PATH = context.getFilesDir().getParent() + "/databases/";
        this.myContext = context;
    }

    public void CreateDataBase() {
        if (!checkDataBase()) {
            getReadableDatabase();
            try {
                copyDataBase();
            } catch (Exception e) {
                Log.w("hata", "Veritabanı kopyalanamıyor");
                throw new Error("Veritabanı kopyalanamıyor.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        } catch (Exception e) {
            Log.w("hata", "Veritabanı açılamadı");
        }
        if (checkDB != null) {
            checkDB.close();
        }
        if (checkDB != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void copyDataBase() {
        try {
            InputStream myInput = this.myContext.getAssets().open(DB_NAME);
            OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);
            byte[] buffer = new byte[1024];
            while (true) {
                int length = myInput.read(buffer);
                if (length > 0) {
                    myOutput.write(buffer, 0, length);
                } else {
                    myOutput.flush();
                    myInput.close();
                    myOutput.close();
                    return;
                }
            }
        } catch (Exception e) {
            Log.w("hata", "Kopya oluşturma hatası.");
        }
    }

    /* access modifiers changed from: package-private */
    public void openDataBase() {
        this.myDatabase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, (SQLiteDatabase.CursorFactory) null, 0);
    }

    public synchronized void close() {
        if (this.myDatabase != null && this.myDatabase.isOpen()) {
            this.myDatabase.close();
        }
        super.close();
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
