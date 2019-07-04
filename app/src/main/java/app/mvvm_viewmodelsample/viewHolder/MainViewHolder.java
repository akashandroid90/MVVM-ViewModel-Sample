package app.mvvm_viewmodelsample.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import app.mvvm_viewmodelsample.databinding.AdapterUserDataBinding;
import app.mvvm_viewmodelsample.model.UserData;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private AdapterUserDataBinding mBinding;

    public MainViewHolder(@NonNull AdapterUserDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(UserData userData) {
        mBinding.setData(userData);
        mBinding.executePendingBindings();
    }
}
