package com.learninglanguage.app.ControlPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.learninglanguage.app.R;

import java.util.HashMap;

public class LevelThreeSettingsActivity extends AppCompatActivity {

    private MaterialSpinner animalfirst,animalsecond,colorfirst,colorsecond,shapefirst,shapesecond;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three_settings);
        initComponents();
        load();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int af = animalfirst.getSelectedIndex();
                int as = animalsecond.getSelectedIndex();
                int cf = colorfirst.getSelectedIndex();
                int cs = colorsecond.getSelectedIndex();
                int sf = shapefirst.getSelectedIndex();
                int ss = shapesecond.getSelectedIndex();

                saveAf(af);
                saveAs(as);
                saveCf(cf);
                saveCs(cs);
                saveSf(sf);
                saveSs(ss);

            }
        });
    }

    private void saveSs(int ss) {
        if (ss == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").child("second").setValue("Star");
        }else if (ss == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").child("second").setValue("Circle");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").child("second").setValue("Square");
        }

        Toast.makeText(LevelThreeSettingsActivity.this,"Saved!",Toast.LENGTH_SHORT).show();

    }

    private void saveSf(int sf) {
        if (sf == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").child("first").setValue("Star");
        }else if (sf == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").child("first").setValue("Circle");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").child("first").setValue("Square");
        }
    }

    private void saveCs(int cs) {
        if (cs == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("second").setValue("Blue");
        }else if (cs == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("second").setValue("Purple");
        }else if (cs == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("second").setValue("Red");
        }else if (cs == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("second").setValue("Black");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("second").setValue("Yellow");
        }
    }

    private void saveCf(int cf) {
        if (cf == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("first").setValue("Blue");
        }else if (cf == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("first").setValue("Purple");
        }else if (cf == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("first").setValue("Red");
        }else if (cf == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("first").setValue("Black");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("first").setValue("Yellow");
        }
    }

    private void saveAs(int as) {
        if (as == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("second").setValue("Dog");
        }else if (as == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("second").setValue("Fish");
        }else if (as == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("second").setValue("Parrot");
        }else if (as == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("second").setValue("Cat");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("second").setValue("Bear");
        }
    }

    private void saveAf(int af) {
        if (af == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("first").setValue("Dog");
        }else if (af == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("first").setValue("Fish");
        }else if (af == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("first").setValue("Parrot");
        }else if (af == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("first").setValue("Cat");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").child("first").setValue("Bear");
        }
    }

    private void load() {
        FirebaseDatabase.getInstance().getReference("Test").child("level03").child("animal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String,String> data = (HashMap<String, String>) dataSnapshot.getValue();
                    if (data.get("first").equals("Dog")){
                        animalfirst.setSelectedIndex(0);
                    }else if (data.get("first").equals("Fish")){
                        animalfirst.setSelectedIndex(1);
                    }else if (data.get("first").equals("Parrot")){
                        animalfirst.setSelectedIndex(2);
                    }else if (data.get("first").equals("Cat")){
                        animalfirst.setSelectedIndex(3);
                    }else{
                        animalfirst.setSelectedIndex(4);
                    }

                    if (data.get("second").equals("Dog")){
                        animalsecond.setSelectedIndex(0);
                    }else if (data.get("second").equals("Fish")){
                        animalsecond.setSelectedIndex(1);
                    }else if (data.get("second").equals("Parrot")){
                        animalsecond.setSelectedIndex(2);
                    }else if (data.get("second").equals("Cat")){
                        animalsecond.setSelectedIndex(3);
                    }else{
                        animalsecond.setSelectedIndex(4);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String,String> data = (HashMap<String, String>) dataSnapshot.getValue();
                    if (data.get("first").equals("Blue")){
                        colorfirst.setSelectedIndex(0);
                    }else if (data.get("first").equals("Purple")){
                        colorfirst.setSelectedIndex(1);
                    }else if (data.get("first").equals("Red")){
                        colorfirst.setSelectedIndex(2);
                    }else if (data.get("first").equals("Black")){
                        colorfirst.setSelectedIndex(3);
                    }else{
                        colorfirst.setSelectedIndex(4);
                    }

                    if (data.get("second").equals("Blue")){
                        colorsecond.setSelectedIndex(0);
                    }else if (data.get("second").equals("Purple")){
                        colorsecond.setSelectedIndex(1);
                    }else if (data.get("second").equals("Red")){
                        colorsecond.setSelectedIndex(2);
                    }else if (data.get("second").equals("Black")){
                        colorsecond.setSelectedIndex(3);
                    }else{
                        colorsecond.setSelectedIndex(4);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FirebaseDatabase.getInstance().getReference("Test").child("level03").child("shapes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String,String> data = (HashMap<String, String>) dataSnapshot.getValue();
                    if (data.get("first").equals("Star")){
                        shapefirst.setSelectedIndex(0);
                    }else if (data.get("first").equals("Circle")){
                        shapefirst.setSelectedIndex(1);
                    }else{
                        shapefirst.setSelectedIndex(2);
                    }

                    if (data.get("second").equals("Star")){
                        shapesecond.setSelectedIndex(0);
                    }else if (data.get("second").equals("Circle")){
                        shapesecond.setSelectedIndex(1);
                    }else{
                        shapesecond.setSelectedIndex(2);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void initComponents() {
        animalfirst = findViewById(R.id.l1af_box);
        animalsecond = findViewById(R.id.l1as_box);
        colorfirst = findViewById(R.id.l1cf_box);
        colorsecond = findViewById(R.id.l1cs_box);
        shapefirst = findViewById(R.id.l1sf_box);
        shapesecond = findViewById(R.id.l1ss_box);
        save = findViewById(R.id.save);

        animalfirst.setItems("Dog", "Fish", "Parrot", "Cat", "Bear");
        animalsecond.setItems("Dog", "Fish", "Parrot", "Cat", "Bear");
        colorfirst.setItems("Blue","Purple","Red","Black","Yellow");
        colorsecond.setItems("Blue","Purple","Red","Black","Yellow");
        shapefirst.setItems("Star","Circle","Square");
        shapesecond.setItems("Star","Circle","Square");

    }

}