package sg.edu.np.mad.helloryan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        Intent newCollect = getIntent();

        Button grp1 = (Button)findViewById(R.id.group1_btn);
        grp1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSupportFragmentManager()
                    .beginTransaction().replace(R.id.Jimmy, Group1.class, null).commit();
                }
            }
        );

        Button grp2 = (Button)findViewById(R.id.group2_btn);
        grp2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSupportFragmentManager()
                            .beginTransaction().replace(R.id.Jimmy, Group2.class, null).commit();
                }
            }
        );
    }
}