package com.examples;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.examples.ui.R;

import java.util.Observable;
import java.util.Observer;

public class _23_DuplicateObservedDataAfterActivity extends Activity implements View.OnFocusChangeListener, Observer {

    private EditText mTxtStart;
    private EditText mTxtEnd;
    private EditText mTxtLength;

    private Interval mSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplicate_observed_data);

        mTxtStart = (EditText) findViewById(R.id.txt_start);
        mTxtEnd = (EditText) findViewById(R.id.txt_end);
        mTxtLength = (EditText) findViewById(R.id.txt_length);

        mTxtStart.setOnFocusChangeListener(this);
        mTxtEnd.setOnFocusChangeListener(this);
        mTxtLength.setOnFocusChangeListener(this);

        mSubject = new Interval();
        mSubject.addObserver(this);
        update(mSubject, null);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (view == mTxtStart) {
            startFieldFocusLost();
        } else if (view == mTxtEnd) {
            endFieldFocusLost();
        } else if (view == mTxtLength) {
            lengthFieldFocusLost();
        }
    }

    private void startFieldFocusLost() {
        String start = mTxtStart.getText().toString();
        setStart(isNotInteger(start) ? "0" : start);
    }

    private void endFieldFocusLost() {
        String end = mTxtEnd.getText().toString();
        setEnd(isNotInteger(end) ? "0" : end);
    }

    private void lengthFieldFocusLost() {
        String length = mTxtLength.getText().toString();
        setLength(isNotInteger(length) ? "0" : length);
    }

    private boolean isNotInteger(CharSequence text) {

        if (TextUtils.isEmpty(text)) {
            return true;
        }

        for (byte b : text.toString().getBytes()) {
            if (!Character.isDigit((char)b)) {
                return true;
            }
        }

        return false;
    }

//    public String getStart() {
//        return Integer.toString(mSubject.getStart());
//    }

    public void setStart(String value) {
        try {
            mSubject.setStart(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

//    public String getEnd() {
//        return Integer.toString(mSubject.getEnd());
//    }

    public void setEnd(String value) {
        try {
            mSubject.setEnd(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

//    public String getLength() {
//        return Integer.toString(mSubject.getLength());
//    }

    public void setLength(String value) {
        try {
            mSubject.setLength(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        mTxtStart.setText(Integer.toString(mSubject.getStart()));
        mTxtEnd.setText(Integer.toString(mSubject.getEnd()));
        mTxtLength.setText(Integer.toString(mSubject.getLength()));
    }
}

class Interval extends Observable {

    private int mStart = 0;
    private int mEnd = 0;
    private int mLength = 0;

    public int getStart() {
        return mStart;
    }

    public void setStart(int value) {
        mStart = value;
        calculateLength();

        setChanged();
        notifyObservers();
    }

    public int getEnd() {
        return mEnd;
    }

    public void setEnd(int value) {
        mEnd = value;
        calculateLength();

        setChanged();
        notifyObservers();
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int value) {
        mLength = value;
        calculateEnd();

        setChanged();
        notifyObservers();
    }

    private void calculateLength() {
        mLength = mEnd - mStart;
    }

    private void calculateEnd() {
        mEnd = mStart + mLength;
    }
}