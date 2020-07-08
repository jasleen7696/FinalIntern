package com.learninglanguage.app.ControlPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.learninglanguage.app.Adapters.UserAdapter;
import com.learninglanguage.app.Classes.User;
import com.learninglanguage.app.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewUsersActivity extends AppCompatActivity {

    private ImageView back;
    private RecyclerView user_view;
    private ArrayList<User> userList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        initComponents();
        loadUsers();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void loadUsers() {
        FirebaseDatabase.getInstance().getReference("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    HashMap<String, HashMap<String, String>> data = (HashMap<String, HashMap<String, String>>) dataSnapshot.getValue();
                    for (String key : data.keySet()) {
                        HashMap<String, String> user = data.get(key);
                        userList.add(new User(user.get("uid"),user.get("email"),user.get("fname"),user.get("lname"),user.get("password")));
                    }

                    linearLayoutManager = new LinearLayoutManager(ViewUsersActivity.this);
                    userAdapter = new UserAdapter(ViewUsersActivity.this,userList);
                    user_view.setLayoutManager(linearLayoutManager);
                    user_view.setAdapter(userAdapter);

                } else {
                    Snackbar.make(findViewById(R.id.layout), "No Registered Users!",
                            Snackbar.LENGTH_SHORT)
                            .show();
                    onBackPressed();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initComponents() {
        user_view = findViewById(R.id.recycler_view);
        back = findViewById(R.id.back);
    }
}