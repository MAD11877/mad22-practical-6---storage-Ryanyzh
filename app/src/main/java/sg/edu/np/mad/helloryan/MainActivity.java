package sg.edu.np.mad.helloryan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receive = getIntent();
        String messageTxt = receive.getStringExtra("username");
        String messageTxt1 = receive.getStringExtra("description");
        boolean status = receive.getBooleanExtra("following", false);

        User user = new User(messageTxt, messageTxt1, 0, status);

        TextView username = (TextView) findViewById(R.id.title_text);
        username.setText(messageTxt);

        TextView description = (TextView) findViewById(R.id.para_text);
        description.setText(messageTxt1);

        Button follow = (Button) findViewById(R.id.follow_btn);
        if (status){
            user.followed = status;
            follow.setText("Unfollow");
        }
        else{
            user.followed = status;
            follow.setText("Follow");
        }

        DbHandler db = new DbHandler(this);

        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                System.out.println(user.id);
                //event handler
                user.followed = !(user.followed);

                if (!user.followed){
                    follow.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    follow.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                System.out.println(user.followed);
                db.updateUsers(user);
                System.out.println("Update");
            }
        });



        Button message = (Button) findViewById(R.id.message_btn);
        message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(in);
            }
        });
    }
}