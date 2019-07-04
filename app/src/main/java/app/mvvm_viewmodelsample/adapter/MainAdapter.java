package app.mvvm_viewmodelsample.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import app.mvvm_viewmodelsample.R;
import app.mvvm_viewmodelsample.databinding.AdapterUserDataBinding;
import app.mvvm_viewmodelsample.model.UserData;
import app.mvvm_viewmodelsample.viewHolder.MainViewHolder;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> implements View.OnClickListener {
    private List<UserData> mList;
    private LayoutInflater mLayoutInflater;

    public MainAdapter(Context context, List<UserData> list) {
        mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        AdapterUserDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.adapter_user_data, viewGroup, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int position) {
        mainViewHolder.bind(mList.get(position));
        mainViewHolder.mBinding.aivImage.setTag(position);
        // In viewholder it will make multiple click listeners so we are setting listener here only
        // it will make viewholder for controller so that data can show
        mainViewHolder.mBinding.aivImage.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateData(List<UserData> data) {
        mList.clear();
        mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aiv_image:
                int tag = (int) v.getTag();
                Toast.makeText(v.getContext(), mList.get(tag).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
