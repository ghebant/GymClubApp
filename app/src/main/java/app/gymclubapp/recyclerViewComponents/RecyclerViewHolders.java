package app.gymclubapp.recyclerViewComponents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.gymclubapp.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    //public ImageView displayedImage;
    public TextView textTitle;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        textTitle = (TextView)itemView.findViewById(R.id.textCardView);
    }

    @Override
    public void onClick(View view) {
    }
}
