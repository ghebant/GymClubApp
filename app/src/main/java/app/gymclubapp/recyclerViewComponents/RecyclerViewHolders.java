package app.gymclubapp.recyclerViewComponents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.gymclubapp.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView imageView;
    public TextView textTitle;

    public RecyclerViewHolders(View view) {
        super(view);
        view.setOnClickListener(this);
        textTitle = (TextView)view.findViewById(R.id.textCardView);
        imageView = view.findViewById(R.id.imageViewItemList);
    }

    @Override
    public void onClick(View view) {
    }
}
