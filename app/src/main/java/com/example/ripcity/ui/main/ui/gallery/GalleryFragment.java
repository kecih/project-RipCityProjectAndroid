package com.example.ripcity.ui.main.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ripcity.R;
import com.example.ripcity.ui.main.ui.UserHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
RecyclerView RV;
List<UserHelperClass> users;
DatabaseReference reference;


GalleryAdapter GA;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        RV=view.findViewById(R.id.recyclerview_users);
        RV.setHasFixedSize(true);
        RV.setLayoutManager(new LinearLayoutManager(getContext()));
        users=new ArrayList<>();

        reference=FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();

                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    UserHelperClass muser = snapshot1.getValue(UserHelperClass.class);
                    users.add(muser);
                }
                GA=new GalleryAdapter(getActivity(),users);
                RV.setAdapter(GA);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}