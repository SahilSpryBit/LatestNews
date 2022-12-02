package com.example.latestnewsjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusinessNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusinessNews extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BusinessNews() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusinessNews.
     */
    // TODO: Rename and change types and number of parameters
    public static BusinessNews newInstance(String param1, String param2) {
        BusinessNews fragment = new BusinessNews();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_news, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler2);


        String ApiKey = "5d510530d1msh0eaab1fe046fb56p1245a2jsn50955b0b9800";

        ApiInterface apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        apiInterface.getDataBusiness(ApiKey).enqueue(new Callback<List<ModelClass>>() {
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