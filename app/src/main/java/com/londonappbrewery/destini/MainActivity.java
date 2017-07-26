package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private int[] mStoryArray= new int[]{
            R.string.T1_Story,R.string.T2_Story,R.string.T3_Story, R.string.T4_End,R.string.T5_End,R.string.T6_End
    };

    private int[] mAns1Array= new int[]{
            R.string.T1_Ans1,R.string.T2_Ans1,R.string.T3_Ans1
    };

    private int[] mAns2Array = new int[]{
            R.string.T1_Ans2,R.string.T2_Ans2,R.string.T3_Ans2
    };

    int mStoryIndex= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mStoryIndex=savedInstanceState.getInt("mStoryIndex");
            Log.d("destini-andriod","savedInstanceState:mStoryIndex:"+mStoryIndex);
            if(mStoryIndex==4||mStoryIndex==5||mStoryIndex==6){
                mStoryIndex=0;
            }
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        final TextView storyTextView= (TextView)findViewById(R.id.storyTextView);
        final Button buttonTop = (Button) findViewById(R.id.buttonTop);
        final Button buttonBottom = (Button) findViewById(R.id.buttonBottom);

        if(mStoryIndex==0){
            storyTextView.setText(mStoryArray[0]);
            buttonTop.setText(mAns1Array[0]);
            buttonBottom.setText(mAns2Array[0]);
            mStoryIndex=1;
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mStoryIndex==1 || mStoryIndex==2){
                    storyTextView.setText(mStoryArray[2]);
                    buttonTop.setText(mAns1Array[2]);
                    buttonBottom.setText(mAns2Array[2]);
                    mStoryIndex=3;
                }else if(mStoryIndex==3){
                    storyTextView.setText(mStoryArray[5]);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                    mStoryIndex=5;
                }else{
                    //TODO : reset to 1;
                    Log.d("destini-andriod","top Button :else part:");
                }


            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if(mStoryIndex==1 ){
                        storyTextView.setText(mStoryArray[1]);
                        buttonTop.setText(mAns1Array[1]);
                        buttonBottom.setText(mAns2Array[1]);
                        mStoryIndex=2;
                    }else if(mStoryIndex==2){
                        storyTextView.setText(mStoryArray[3]);
                        buttonTop.setVisibility(View.GONE);
                        buttonBottom.setVisibility(View.GONE);
                        mStoryIndex=4;
                    }else if(mStoryIndex==3){
                        storyTextView.setText(mStoryArray[4]);
                        buttonTop.setVisibility(View.GONE);
                        buttonBottom.setVisibility(View.GONE);
                        mStoryIndex=4;
                    }else{
                        //TODO : reset to 1;
                        Log.d("destini-andriod","bottom Button :Else");
                    }


                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState){

        super.onSaveInstanceState(outState);
        outState.putInt("mStoryIndex",mStoryIndex);
    }
}
