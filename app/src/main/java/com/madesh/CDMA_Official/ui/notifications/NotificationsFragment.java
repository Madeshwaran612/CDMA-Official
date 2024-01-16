package com.madesh.CDMA_Official.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;

import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.madesh.CDMA_Official.ClubsFragment.AYANAVARAM.AYANAVARAM;
import com.madesh.CDMA_Official.ClubsFragment.CSK.CSK;
import com.madesh.CDMA_Official.ClubsFragment.EAGLE.EAGLE;
import com.madesh.CDMA_Official.ClubsFragment.ICF.ICF;
import com.madesh.CDMA_Official.ClubsFragment.Thamizhanfrag.ThamizhanFrag;
import com.madesh.CDMA_Official.R;

public class NotificationsFragment extends Fragment implements View.OnClickListener {





    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = root.findViewById(R.id.adViewClubs);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        ImageButton tmsa, rpficf, rpfaya, csk, eagle;
        Button tmsa1, rpficf1, rpfaya1, csk1, eagle1;



        tmsa =root.findViewById(R.id.tamizhan);
        rpficf =root.findViewById(R.id.RPFICF);
        rpfaya = root.findViewById(R.id.RPFayanavaram);
        csk = root.findViewById(R.id.CSK);
        eagle = root.findViewById(R.id.eagle);
        tmsa.setOnClickListener(this::onClick);
        rpficf.setOnClickListener(this::onClick);
        rpfaya.setOnClickListener(this::onClick);
        csk.setOnClickListener(this::onClick);
        eagle.setOnClickListener(this::onClick);
        tmsa1 =root.findViewById(R.id.imageButton);
        rpficf1 =root.findViewById(R.id.imageButton2);
        rpfaya1 = root.findViewById(R.id.imageButton8);
        csk1 = root.findViewById(R.id.imageButton6);
        eagle1 = root.findViewById(R.id.imageButton7);
        tmsa1.setOnClickListener(this::onClick);
        rpficf1.setOnClickListener(this::onClick);
        rpfaya1.setOnClickListener(this::onClick);
        csk1.setOnClickListener(this::onClick);
        eagle1.setOnClickListener(this::onClick);
        return root;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tamizhan:
            case R.id.imageButton:
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.nav_default_pop_enter_anim,R.anim.animate_fade_exit)
                        .replace(R.id.frag_container, new ThamizhanFrag()).addToBackStack(null).commit();
                Toast.makeText(getActivity(), "Welcome to Tamizhan Mallakhamb", Toast.LENGTH_SHORT).show();


                break;
            case R.id.RPFICF:
            case R.id.imageButton2:
                Toast.makeText(getActivity(), "Welcome to MTC, ICF", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.nav_default_pop_enter_anim,R.anim.animate_fade_exit)
                        .replace(R.id.frag_container, new ICF()).addToBackStack(null).commit();

                break;
            case R.id.RPFayanavaram:
            case R.id.imageButton8:
                Toast.makeText(getActivity(), "Welcome to MTC, Ayanavaram", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.nav_default_pop_enter_anim,R.anim.animate_fade_exit)
                        .replace(R.id.frag_container, new AYANAVARAM()).addToBackStack(null).commit();

                break;
            case R.id.CSK:
            case R.id.imageButton6:
                Toast.makeText(getActivity(), "Welcome to CSK Sports Club", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.nav_default_pop_enter_anim,R.anim.animate_fade_exit)
                        .replace(R.id.frag_container, new CSK()).addToBackStack(null).commit();

                break;
            case R.id.eagle:
            case R.id.imageButton7:
                Toast.makeText(getActivity(), "Welcome to Eagle Mallakhamb", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.nav_default_pop_enter_anim,R.anim.animate_fade_exit)
                        .replace(R.id.frag_container, new EAGLE()).addToBackStack(null).commit();

                break;


        }

    }

}

