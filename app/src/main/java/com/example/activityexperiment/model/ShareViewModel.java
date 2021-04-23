package com.example.activityexperiment.model;

import com.example.activityexperiment.bean.ShareBean;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<ShareBean> shares = new MutableLiveData<>();

    public void setShares(ShareBean s) {
        shares.setValue(s);
    }

    public LiveData<ShareBean> getShares() {
        if (shares.getValue() == null) {
            ShareBean bean = new ShareBean();
            bean.setParent("1");
            bean.setLeft("1");
            bean.setRight("1");
            shares.setValue(bean);
        }
        return shares;
    }
}
