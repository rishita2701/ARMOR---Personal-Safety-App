package com.personalsafety.armor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class DataHolder extends Fragment {
    private RecyclerView mRecyclerView;

    private ArrayList<Model> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;
   /* Configure configure=new Configure();*/
   private final String[] First_Aid={"1. Make sure your household has a first aid kit.  It should have basic medicines which are readily accessible" , "2. Keep your first aid kit, all medications, including non-prescription drugs out of children's reach.", "3. Before assisting a victim, protect yourself first.  Assess the scene and determine the prevalent hazards, if any.  Whenever possible, wear gloves to protect yourself from blood and other bodily fluids." , "4. When an emergency occurs, make sure the tongue does not block the victim's airway and that the mouth is free of any secretions and foreign objects.  It's  important that the person is breathing freely. And if not, administer artificial respiration promptly." , "5. See that the victim has a pulse and good blood circulation as you check for signs of bleeding. Act fast if the victim is bleeding severely, swallowed poison or his heart or breathing has stopped." , "6. It's vitally important not to move a person with serious neck or back injuries unless you have to save him from further danger.  If he has vomited and there is no danger that his neck is broken, turn him aside to prevent choking and keep him warm by covering him with blankets or coats.", "7. Have someone call for medical assistance while you apply first aid. The person who calls the doctor should explain the nature of the emergency and ask for advice on what should be done by the time the ambulance arrives.", "8. Be calm and give psychological support to the patient.", "9. Don't give fluids to an unconscious or semi conscious person.  Fluids may enter his windpipe and cause suffocation." , "10. Look for an emergency medical identification card to find out if the victim is allergic to medicines or has any serious health problems that require special care."};
    private final String[] Self_Defence={"1. Carry pepper spray" , "2. Shout loudly" , "3. Use busy roads at night" ,
            "4. Learn self-defence techniques" , "5. Switch ON the emergency SOS feature in your mobile" ,
            "6. Have your keys and phone in your hand, ready for when you need them" ,
            "7. Locking your car immediately after getting in"};

    public static DataHolder getInstance(String title) {
        DataHolder fra = new DataHolder();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        initData();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerAdapter(mRecyclerView.getContext(), mDatas));

        return v;
    }

    /* private void initData() {
         mDatas = new ArrayList<>();
         for (int i = 'A'; i < 'z'; i++) {
             mDatas.add(mTitle + (char) i);
         }
     }*/
    private void initData() {
        mDatas = new ArrayList<>();
        if (mTitle.equals("First_Aid")) {
            for (int i = 0; i < First_Aid.length; i++) {

                mDatas.add(new Model(First_Aid[i]));
            }
        }

       else if (mTitle.equals("Self_defence")) {
            for (int i = 0; i < Self_Defence.length; i++) {

                mDatas.add(new Model(Self_Defence[i]));
            }
        }

    }
}

