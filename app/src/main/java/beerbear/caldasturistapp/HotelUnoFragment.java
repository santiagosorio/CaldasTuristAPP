package beerbear.caldasturistapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import beerbear.caldasturistapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelUnoFragment extends Fragment {


    public HotelUnoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_uno, container, false);
    }

}
