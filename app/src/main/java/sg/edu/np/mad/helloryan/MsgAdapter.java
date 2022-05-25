package sg.edu.np.mad.helloryan;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {

    ArrayList<User> data;
    public MsgAdapter(ArrayList<User> data){
        this.data = data;
    }


    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.view7, parent, false);
        /*
        for(User abc : data){
            boolean check = Integer.toString(abc.id).endsWith("7");
            if (check){
                item = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_rec, null, false);
            }
            else{
                item = LayoutInflater.from(parent.getContext()).inflate(R.layout.view7, null, false);
            }
        }
        */

        return new MsgViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull final MsgViewHolder holder, final int position) {
        User sS = data.get(position);
        String phrase = sS.name + " " + sS.id;
        holder.nameID.setText(phrase);
        holder.description.setText(sS.description);

        if (!Integer.toString(sS.id).endsWith("7")){
            holder.pic.setVisibility(View.GONE);
        }
        else{
            holder.pic.setVisibility(View.VISIBLE);
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("Profile");
                builder.setMessage(phrase);
                builder.setCancelable(true);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        //<action>
                    }
                });
                builder.setNegativeButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("username" , phrase);
                        i.putExtra("description", sS.description);
                        i.putExtra("following", sS.followed);
                        v.getContext().startActivity(i);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();



            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}
