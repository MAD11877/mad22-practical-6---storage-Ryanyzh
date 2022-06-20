package sg.edu.np.mad.helloryan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper {

    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_FOLLOWED = "Followed";

    public DbHandler(Context context) {
        super(context, "userDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE Users (Id INTEGER PRIMARY KEY AUTOINCREMENT, Name STRING, Description STRING, Followed BOOLEAN)";
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void insertMessage (User user){
        SQLiteDatabase db = this.getWritableDatabase();
        String INSERT = "INSERT INTO " + TABLE_USERS + " (" + COLUMN_NAME +  ", " +
                COLUMN_DESCRIPTION + ", " + COLUMN_FOLLOWED + ") VALUES (" + "\"" + user.name + "\", "
                + "\"" + user.description + "\", " +  "\"" + user.followed + "\"" + ")";
        System.out.println(INSERT);
        db.execSQL(INSERT);
        db.close();

        /*
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, 0);
        values.put(COLUMN_NAME, user.name);
        values.put(COLUMN_DESCRIPTION, user.description);
        values.put(COLUMN_FOLLOWED, user.followed);

        //SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
        return values;

         */
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<User> userList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);
        while (cursor.moveToNext()){
            String name = cursor.getString((int)cursor.getColumnIndex(COLUMN_NAME));
            String description = cursor.getString((int)cursor.getColumnIndex(COLUMN_DESCRIPTION));
            Integer id = cursor.getInt((int)cursor.getColumnIndex(COLUMN_ID));
            Boolean follow = Boolean.parseBoolean(cursor.getString((int)cursor.getColumnIndex(COLUMN_FOLLOWED)));
            /*
            //String message = cursor.getString(1);
            boolean followStatus;
            if (cursor.getInt(3) == 1){ followStatus = true; }
            else{ followStatus = false; }
            */
            User newer = new User(name, description, id, follow) ;
            userList.add(newer);
        }
        return userList;
    }

    public void updateUsers(User user){
        SQLiteDatabase db = getWritableDatabase();
        Boolean updateFollow = user.followed;
        Integer refId = user.id;
        String UPDATE = "UPDATE " + TABLE_USERS + " SET " + COLUMN_FOLLOWED  + " = \"" + updateFollow + "\" WHERE " +
                COLUMN_ID + " = \"" + refId + "\"";
        db.execSQL(UPDATE);
        db.close();
    }


    public void clear(){
        SQLiteDatabase db = getWritableDatabase();
        String delete = "DELETE FROM " + TABLE_USERS;
        db.execSQL(delete);
        db.close();
    }
}
