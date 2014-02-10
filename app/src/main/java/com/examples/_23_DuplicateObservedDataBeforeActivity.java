package com.examples;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.examples.ui.R;

public class _23_DuplicateObservedDataBeforeActivity extends Activity implements View.OnFocusChangeListener {

    private EditText mTxtStart;
    private EditText mTxtEnd;
    private EditText mTxtLength;

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
        if (isNotInteger(mTxtStart.getText())) {
            mTxtStart.setText("0");
        }

        calculateLength();
    }

    private void endFieldFocusLost() {
        if (isNotInteger(mTxtEnd.getText())) {
            mTxtEnd.setText("0");
        }

        calculateLength();
    }

    private void lengthFieldFocusLost() {
        if (isNotInteger(mTxtLength.getText())) {
            mTxtLength.setText("0");
        }

        calculateEnd();

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

    private void calculateLength() {
        try {
            int start = Integer.parseInt(mTxtStart.getText().toString());
            int end = Integer.parseInt(mTxtEnd.getText().toString());
            int length = end - start;
            mTxtLength.setText(Integer.toString(length));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void calculateEnd() {
        try {
            int start = Integer.parseInt(mTxtStart.getText().toString());
            int length = Integer.parseInt(mTxtLength.getText().toString());
            int end = start + length;
            mTxtEnd.setText(Integer.toString(end));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
