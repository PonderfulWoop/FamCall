package com.Shirol.famcall;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.Shirol.famcall.MainActivity.dbManager;

public class HistFrag extends Fragment {
     private RecyclerView recyclerView;
     private RecyclerView.Adapter userAdapter;
     private RecyclerView.LayoutManager layoutManager;
     private List<CallDetails> callDetailsList;
     private Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View hist =  inflater.inflate(R.layout.nav_history, null);
        recyclerView = hist.findViewById(R.id.recycView);
        callDetailsList = new ArrayList<>();
        callDetailsList.clear();

        loadDB async = new loadDB();
        async.execute();

        return hist;
    }

    public class loadDB extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            cursor = dbManager.fetch();
            if (cursor != null && cursor.getCount() != 0) {
                Log.i("not empty", "Yaha aya");
                callDetailsList.clear();
                cursor.moveToLast();
                do{
                    CallDetails userDetailsItem = new CallDetails();
                    userDetailsItem.setUser_id(cursor.getInt(0));
                    userDetailsItem.setCallName(cursor.getString(1));
                    userDetailsItem.setCallDuration(cursor.getString(2));
                    userDetailsItem.setDate(cursor.getString(3));
                    callDetailsList.add(userDetailsItem);
                }while (cursor.moveToPrevious());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            layoutManager = new LinearLayoutManager(getContext());
            userAdapter = new CallDetailsAdapter(callDetailsList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(userAdapter);
        }
    }
}
