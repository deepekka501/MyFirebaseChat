package com.devlomi.record_view;



public interface OnRecordListener {
    void onStart();
    void onCancel();
    void onFinish(long recordTime,boolean limitReached);
    void onLessThanSecond();
}
