package sg.edu.np.mad.helloryan;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    public static String correctUsername;
    public static String correctPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mad-prac-06-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Users");

        myRef.child("mad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                correctUsername = dataSnapshot.child("username").getValue().toString();
                correctPassword = dataSnapshot.child("password").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Failed to read value.");
            }
        });

        EditText username = findViewById(R.id.usernameInput);
        EditText password = findViewById(R.id.passwordInput);

        Button b = findViewById(R.id.loginButton);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                if ((usernameValue.equals(correctUsername)) && (passwordValue.equals(correctPassword))){
                    Intent i2 = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(i2);
                }
            }
        });
    }
}