package com.example.group26.myapplication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    public AFragment() {
        // Required empty public constructor
    }

    public void changeColor(int color){
        //getActivity().findViewById(R.id.fragment_root).setBackgroundColor(color);
        getView().setBackgroundColor(color);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("demo", "AFragment: onCreateView");
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a, container, false);

//        view.findViewById(R.id.buttonClickMe).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Button Pressed", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("demo", "AFragment: onResume");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("demo", "AFragment: onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("demo", "AFragment: onDestroy");
    }

    OnFragmentTextChange mListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("demo", "AFragment: onAttach");

        try {
            mListener = (OnFragmentTextChange)activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString() + " should implement OnFragmentTextChange");
        }


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("demo", "AFragment: onActivityCreated");

        getView().findViewById(R.id.buttonClickMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textEditText = (EditText)getView().findViewById(R.id.editTextInFragment);
                mListener.onTextChanged(textEditText.getText().toString());
            }
        });
    }

    public interface OnFragmentTextChange {
        void onTextChanged(String text);
    }
}
