package app.mvvm_viewmodelsample.model.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.mvvm_viewmodelsample.model.UserData;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<UserData>> data;

    public MainViewModel() {
        data = new MutableLiveData<>();
        data.setValue(new ArrayList<UserData>());
    }

    public void getData(AssetManager manager) {
        List<UserData> list = null;
        InputStream file = null;
        try {
            file = manager.open("data.json");
            byte[] formArray = new byte[file.available()];
            file.read(formArray);
            file.close();
            Type listType = new TypeToken<ArrayList<UserData>>(){}.getType();
            list = new Gson().fromJson(new String(formArray),listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list==null)
             list= new ArrayList<>();

        data.postValue(list);
    }
}
