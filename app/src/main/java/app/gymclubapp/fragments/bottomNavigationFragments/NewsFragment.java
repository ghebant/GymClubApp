package app.gymclubapp.fragments.bottomNavigationFragments;

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

import java.util.ArrayList;
import java.util.List;

import app.gymclubapp.R;
import app.gymclubapp.fragments.MainScreenActivity;
import app.gymclubapp.recyclerViewComponents.RecyclerViewAdapter;

public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<String> adapterData;
    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, null);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        adapterData = getFirstData();
        handler = new Handler();
        linearLayoutManager = new LinearLayoutManager(getContext());
        // return the data object
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
                            adapterData.add("Item" + (adapterData.size() + 1));
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
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        return listObject;
    }
}
