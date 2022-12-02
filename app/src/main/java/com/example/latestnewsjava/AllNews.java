package com.example.latestnewsjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllNews extends Fragment {

    public AllNews() {
        // Required empty public constructor
    }

    public static AllNews newInstance(String param1, String param2) {
        AllNews fragment = new AllNews();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_news, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);


        String ApiKey = "5d510530d1msh0eaab1fe046fb56p1245a2jsn50955b0b9800";

        ApiInterface apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        apiInterface.getData(ApiKey).enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {

                if(response.isSuccessful()){

                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                    List<ModelClass> modelClass = response.body();

                    for(int i = 0 ; i < modelClass.size(); i++){

                        MyAdapter adapter = new MyAdapter(getContext(), modelClass);
                        recyclerView.setAdapter(adapter);
                    }

                    Log.d("Testinggg", "Suceeessss");
                }else{
                    Log.d("Testinggg", "Elseeeee");
                }
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Log.d("Testinggg", "Failll : "+t.getLocalizedMessage());
            }
        });

        return view;
    }
}