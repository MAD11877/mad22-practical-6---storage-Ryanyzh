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

        ArrayList<User> userObjects = new ArrayList<>();


        for (int u = 0; u < 20; u++)
        {
            Random random = new Random();
            boolean userFollowed;
            String userName = "Name";
            int userId = (int)random.nextInt(999999999);
            String userDescription = "Description " + Integer.toString(random.nextInt(999999999));
            int followInt = random.nextInt(2);
            if (followInt == 1)
            {
                userFollowed = true;
            }
            else
            {
                userFollowed = false;
            }
            User newUser = new User (userName, userDescription, userId, userFollowed);
            userObjects.add(newUser);
        }

        for (int h = 0; h < userObjects.size(); h++){
            System.out.println(userObjects.get(h).followed);
        }

        RecyclerView rv = findViewById(R.id.rv_id);
        MsgAdapter adapter = new MsgAdapter(userObjects);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);


    }
}