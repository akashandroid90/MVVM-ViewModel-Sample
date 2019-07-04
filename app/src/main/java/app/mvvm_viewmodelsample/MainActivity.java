package app.mvvm_viewmodelsample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import app.mvvm_viewmodelsample.adapter.MainAdapter;
import app.mvvm_viewmodelsample.model.UserData;
import app.mvvm_viewmodelsample.model.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected MainViewModel getViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        MainViewModel model = getViewModel();
        mAdapter = new MainAdapter(this, model.data.getValue());
        model.data.observe(this, new Observer<List<UserData>>() {
            @Override
            public void onChanged(@Nullable List<UserData> data) {
                mAdapter.updateData(data);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
        model.getData(getAssets());

        View viewById = findViewById(R.id.aiv_image);
        if (viewById!=null)
            viewById.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Development Sample", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
