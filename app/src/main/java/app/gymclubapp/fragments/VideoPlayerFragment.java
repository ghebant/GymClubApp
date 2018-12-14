package app.gymclubapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import app.gymclubapp.R;
import app.gymclubapp.activities.VideoPlayerActivity;
import app.gymclubapp.recyclerViewComponents.RecyclerViewAdapter;

public class VideoPlayerFragment extends Fragment {

    private RecyclerView recyclerView = null;
    private LinearLayoutManager linearLayoutManager = null;
    private RecyclerViewAdapter recyclerViewAdapter = null;
    private List<String> adapterData;
    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_training_list, null);

        Button button = view.findViewById(R.id.buttonShowVideo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VideoPlayerActivity.class);
                startActivity(intent);
            }
        });

        //setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        adapterData = getFirstData();
        handler = new Handler();
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), adapterData, recyclerView);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                adapterData.add(null);
                recyclerViewAdapter.notifyItemInserted(adapterData.size() - 1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapterData.remove(adapterData.size() - 1);
                        recyclerViewAdapter.notifyItemRemoved(adapterData.size());
                        for (int i = 0; i < 15; i++) {
                            adapterData.add("News " + (adapterData.size() + 1));
                            recyclerViewAdapter.notifyItemInserted(adapterData.size());
                        }
                        recyclerViewAdapter.setLoaded();
                    }
                }, 2000);
                Log.d("LOGTAG", "Loading new data");
            }
        });
    }

    private List<String> getFirstData(){
        List<String> listObject = new ArrayList<String>();
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        listObject.add("Firsts news");
        return listObject;
    }
}
