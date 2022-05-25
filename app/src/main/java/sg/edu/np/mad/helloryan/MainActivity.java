package sg.edu.np.mad.helloryan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    User user = new User("Ryan", "Is clueless??", 10, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.title_text);
        username.setText(user.name);

        TextView description = (TextView) findViewById(R.id.para_text);
        description.setText(user.description);

        Button follow = (Button) findViewById(R.id.follow_btn);
        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //event handler
                user.followed = !(user.followed);

                if (!user.followed){
                    follow.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG).show();
                }
                else{
                    follow.setText("Unfollow");
                }

            }
        });
        Intent receive = getIntent();
        String messageTxt = receive.getStringExtra("username");
        username.setText(messageTxt);
        String messageTxt1 = receive.getStringExtra("description");
        description.setText(messageTxt1);
        boolean status = receive.getBooleanExtra("following", false);
        if (status){
            user.followed = status;
            follow.setText("Unfollow");
        }
        else{
            user.followed = status;
            follow.setText("Follow");
        }

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