package sg.edu.np.mad.helloryan;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        DbHandler db = new DbHandler(this);
        ArrayList<User> userObjects = db.getUsers();

        if (userObjects.size() == 0)
        {
            for (int u = 0; u < 20; u++)
            {
                User newUser = new User();
                Random random = new Random();
                newUser.id = u + 1;
                newUser.name = "Name-" + Integer.toString(random.nextInt(999999999));
                newUser.description = "Description " + Integer.toString(random.nextInt(999999999));
                int followInt = random.nextInt(2);
                if (followInt == 1) { newUser.followed = true; }
                else { newUser.followed = false; }
                db.insertMessage(newUser);
                userObjects.add(newUser);
            }
        }


        /*ArrayList<User> newUserList = db.getUsers();
        for(int i = 0; i < newUserList.size(); i++){
            System.out.println(newUserList.get(i).id);
        }
         */

        RecyclerView rv = findViewById(R.id.rv_id);
        MsgAdapter adapter = new MsgAdapter(userObjects);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

    }
}