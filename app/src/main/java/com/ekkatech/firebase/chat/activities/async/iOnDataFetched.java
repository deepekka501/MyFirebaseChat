package com.ekkatech.firebase.chat.activities.async;

public interface iOnDataFetched {
    void showProgressBar(int progress);

    void hideProgressBar();

    void setDataInPageWithResult(Object result);
}