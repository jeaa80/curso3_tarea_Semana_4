package com.jesus.curso3_semana4_petagram_final.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jesus.curso3_semana4_petagram_final.fragments.Fragmento_Perfil;
import com.jesus.curso3_semana4_petagram_final.fragments.Fragmento_Principal;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> arraList = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);

    }
    @NonNull
        @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new Fragment();
        switch (position){
            case 0:
                fragment = new Fragmento_Principal();
                break;
            case 1:
                fragment = new Fragmento_Perfil();
                break;
        }

        //return arraList.get(position);
        return fragment;
    }

    @Override
    public int getItemCount() {

        //return arraList.size();
        return 2;
    }

    public void addfragment(Fragment fragment){arraList.add(fragment);}

}
