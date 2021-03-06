package com.examples.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.examples.*;
import com.examples.ui.UIInputStream.OnInputWaitsListener;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {
	
	private RelativeLayout mLayout;
	private EditText mInput;
	private TextView mOutput;
	private ScrollView mScroll;
	private static MainActivity mInstance;
	private static UIInputStream mInputStream = new UIInputStream();
	private static OutputStream mOutputStream = new OutputStream() {
		@Override
		public void write(int b) {
			MainActivity.getInstance().write((byte)b);
		}
	};
	
	private Handler mGuiThread = new Handler();
	
	private static final String KEY_IS_DONE = "KEY_IS_DONE";
	private static final String KEY_IS_WAITS_INPUT = "KEY_IS_WAITS_INPUT";
	private static final String KEY_OUTPUT_TEXT = "KEY_OUTPUT_TEXT"; 
	private static final String KEY_INPUT_TEXT = "KEY_INPUT_TEXT"; 
	
	private boolean mIsDone;
	private boolean mIsWaitsInput;
	private boolean mMustSetHeight;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	System.setIn(mInputStream);
    	System.setOut(new PrintStream(mOutputStream));
    	System.setErr(new PrintStream(mOutputStream));
    	
    	mLayout = (RelativeLayout) findViewById(R.id.layout);
    	mInput = (EditText) findViewById(R.id.input);
        mOutput = (TextView) findViewById(R.id.output);
        mScroll = (ScrollView) findViewById(R.id.scroll);
        mInstance = this;
        
        mInput.setVisibility(View.INVISIBLE);
        mInput.setOnKeyListener(onInputKey());
        mInputStream.setOnInputWaitsListener(onInputStreamWaits());
        mOutput.setOnTouchListener(onOutputTouch());
        mLayout.setOnCreateContextMenuListener(this);
    }

	private OnKeyListener onInputKey() {
		return new OnKeyListener() {
			@Override
			public boolean onKey(View view, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_ENTER) {
					String text = mInput.getText().toString();
					mInput.setText("");
					mInput.setVisibility(View.INVISIBLE);
					
					// Restore the original scroll height
		    		setScrollHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
					mIsWaitsInput = false;
					mInputStream.addText(text);
					return true;
				}
				return false;
			}
		};
	}

	private OnInputWaitsListener onInputStreamWaits() {
		return new OnInputWaitsListener() {
			@Override
			public void onInputWaits() {
		    	mGuiThread.post(new Runnable() {
					@Override
					public void run() {
						mIsWaitsInput = true;
				    	waitsInputOn();
					}
				});
			}
		};
	}
	
	private void waitsInputOn() {
		if (!mMustSetHeight && mInput.getVisibility() == View.VISIBLE)
			mMustSetHeight = mInput.getHeight() < mOutput.getLineHeight();
		
		if (mMustSetHeight)
    		setScrollHeight(mLayout.getHeight() - (mLayout.getHeight() / 5));
    	
		mInput.setVisibility(View.VISIBLE);
	}

	private OnTouchListener onOutputTouch() {
		return new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent e) {
	    		if (mIsWaitsInput) {
	    			waitsInputOn();
	    			return true;
	    		}
				return false;
			}
		};
	}
	
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	mMustSetHeight = false;
    	
    	if (mIsDone)
    		return;
    	
    	ExecutorService executor = Executors.newSingleThreadExecutor();
    	executor.execute(new Runnable() {
			@Override
			public void run() {
		    	try {
                    closeAfter(60);
			    	//
			    	// Console program execution starts here
			    	//
//		    		Program.main(new String[0]);
//		    		ReadingInputTest.main(new String[0]);
//                    _01_ExtractMethod.main(new String[0]);
//                    _02_InlineMethod.main(new String[0]);
//                    _03_InlineTemp.main(new String[0]);
//                    _04_ReplaceTempWithQuery.main(new String[0]);
//                    _05_IntroduceExplainingVariable.main(new String[0]);
//                    _06_SplitTemporaryVariable.main(new String[0]);
//                    _07_RemoveAssignmentsToParameters.main(new String[0]);
//                    _08_ReplaceMethodWithMethodObject.main(new String[0]);
//                    _09_SubstituteAlgorithm.main(new String[0]);
//                    _10_MoveMethod.main(new String[0]);
//                    _11_MoveField.main(new String[0]);
//                    _12_ExtractClass.main(new String[0]);
//                    _13_InlineClass.main(new String[0]);
//                    _14_HideDelegate.main(new String[0]);
//                    _15_RemoveMiddleMan.main(new String[0]);
//                    _16_IntroduceForeignMethod.main(new String[0]);
//                    _17_IntroduceLocalExtension.main(new String[0]);
//                    _18_SelfEncapsulateField.main(new String[0]);
//                    _19_ReplaceDataValueWithObject.main(new String[0]);
//                    _20_ChangeValueToReference.main(new String[0]);
//                    _21_ChangeReferenceToValue.main(new String[0]);
//                    _22_ReplaceArrayWithObject.main(new String[0]);
//                    _24_ChangeUnidirectionalAsscociationToBidirectional.main(new String[0]);
//                    _25_ChangeBidirectionalAsscociationToUnidirectional.main(new String[0]);
//                    _26_ReplaceMagicNumberWithSymbolicConstant.main(new String[0]);
//                    _27_EncapsulateField.main(new String[0]);
//                    _28_EncapsulateCollection.main(new String[0]);
//                    _29_EncapsulateArray.main(new String[0]);
//                    _30_ReplaceTypeCodeWithClass.main(new String[0]);
//                    _31_ReplaceTypeCodeWithSubclasses.main(new String[0]);
//                    _32_ReplaceTypeCodeWithStateStrategy.main(new String[0]);
//                    _33_ReplaceSubclassWithFields.main(new String[0]);
//                    _34_DecomposeConditional.main(new String[0]);
//                    _35_ConsolidateConditionalExpression.main(new String[0]);
//                    _36_ConsolidateDuplicateConditionalFragments.main(new String[0]);
//                    _37_RemoveControlFlag.main(new String[0]);
//                    _38_ReplaceNestedConditionalWithGuardClauses.main(new String[0]);
//                    _39_ReplaceConditionalWithPolymorphism.main(new String[0]);
//                    _40_IntroduceNullObject.main(new String[0]);
//                    _41_IntroduceAssertion.main(new String[0]);
//                    _42_RenameMethod.main(new String[0]);
//                    _43_SeparateQueryFromModifier.main(new String[0]);
//                    _44_ParameterizeMethod.main(new String[0]);
//                    _45_ReplaceParameterWithExplicitMethods.main(new String[0]);
//                    _46_PreserveWholeObject.main(new String[0]);
//                    _47_ReplaceParameterWithMethod.main(new String[0]);
//                    _48_IntroduceParameterObject.main(new String[0]);
//                    _49_RemoveSettingMethod.main(new String[0]);
//                    _50_ReplaceConstructorWithFactoryMethod.main(new String[0]);
//                    _51_EncapsulateDowncast.main(new String[0]);
//                    _52_ReplaceErrorCodeWithException.main(new String[0]);
//                    _53_ReplaceExceptionWithTest.main(new String[0]);
//                    _54_PullUpMethod.main(new String[0]);
//                    _55_PullUpConstructorBody.main(new String[0]);
//                    _56_PushDownMethod.main(new String[0]);
                    _57_PushDownField.main(new String[0]);
		    	} catch (Throwable ex) {
		        	setErrorColor();
		    		ex.printStackTrace();
		    	}
			}
		});
    	executor.shutdown();
    	mIsDone = true;
	}

    private void closeAfter(final int seconds) {

        Thread t = new Thread() {

            @Override
            public void run() {

                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mGuiThread.post(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.this.finish();
                    }
                });
            }
        };
        t.start();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// Save input state
    	outState.putBoolean(KEY_IS_WAITS_INPUT, mIsWaitsInput);
    	outState.putCharSequence(KEY_INPUT_TEXT, mInput.getText());

    	// Output text state
    	outState.putBoolean(KEY_IS_DONE, mIsDone);
    	outState.putCharSequence(KEY_OUTPUT_TEXT, mOutput.getText());
    	
    	super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
    	super.onRestoreInstanceState(savedState);
    	
    	mIsDone = savedState.getBoolean(KEY_IS_DONE);
    	if (mIsDone) {
    		CharSequence outputText = savedState.getCharSequence(KEY_OUTPUT_TEXT);
    		mOutput.setText(outputText);
    		scrollToEnd();
    	}
    	
    	mIsWaitsInput = savedState.getBoolean(KEY_IS_WAITS_INPUT);
		if (mIsWaitsInput) {
			CharSequence inputText = savedState.getCharSequence(KEY_INPUT_TEXT);
			mInput.setText(inputText);
			waitsInputOn();
		}
    }

	public static MainActivity getInstance() {
		return mInstance;
	}
    
    public void write(final byte b) {
    	mGuiThread.post(new Runnable() {
			@Override
			public void run() {
				mOutput.append(String.valueOf((char)b));
				
				if (b == '\n')
					scrollToEnd();
			}
		});
    }
    
    private void scrollToEnd() {
    	mScroll.post(new Runnable() {
			@Override
			public void run() {
				mScroll.fullScroll(View.FOCUS_DOWN);
			}
		});
    }
    
    private void setScrollHeight(int height) {
    	ViewGroup.LayoutParams lp = mScroll.getLayoutParams();
    	
    	if (height == 0 || lp.height == height)
    		return;
    	
    	lp.height = height;
    	mScroll.setLayoutParams(lp);
    	scrollToEnd();
    }

	private void setErrorColor() {
		mGuiThread.post(new Runnable() {
			@Override
			public void run() {
				mOutput.setTextColor(Color.RED);
			}
		});
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        createMenu(menu);
        return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, v, menuInfo);
        createMenu(menu);
    }

	private void createMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	return onMenuItemSelected(item);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	return onMenuItemSelected(item);
    }

    private boolean onMenuItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_exit)
            System.exit(0);
        else if (item.getItemId() == R.id.menu_clear)
            mOutput.setText("");
        return true;
    }
}
