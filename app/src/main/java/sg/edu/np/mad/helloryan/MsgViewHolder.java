package sg.edu.np.mad.helloryan;

import android.icu.text.ConstrainedFieldPosition;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MsgViewHolder extends RecyclerView.ViewHolder {
    TextView nameID;
    TextView description;
    ImageView pic;
    public MsgViewHolder (View viewItem){
        super(viewItem);
        nameID = viewItem.findViewById(R.id.userName);
        description = viewItem.findViewById(R.id.userDescription);
        pic = viewItem.findViewById(R.id.big_picture);
    }
}
