package app.gymclubapp.recyclerViewComponents;

import android.view.View;
import android.widget.ProgressBar;

import app.gymclubapp.R;

public class ProgressViewHolder extends RecyclerViewHolders{
    public ProgressBar progressBar;
    public ProgressViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
    }
}
