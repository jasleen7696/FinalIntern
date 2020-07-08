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

public class LevelTwoSettingsActivity extends AppCompatActivity {

    private MaterialSpinner animalfirst,animalsecond,colorfirst,colorsecond,shapefirst,shapesecond;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_settings);
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
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("second").setValue("Star");
        }else if (ss == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("second").setValue("Square");
        }else if (ss == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("second").setValue("Pentagon");
        }else if (ss == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("second").setValue("Circle");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("second").setValue("Hexagon");
        }

        Toast.makeText(LevelTwoSettingsActivity.this,"Saved!",Toast.LENGTH_SHORT).show();

    }

    private void saveSf(int sf) {
        if (sf == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("first").setValue("Star");
        }else if (sf == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("first").setValue("Square");
        }else if (sf == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("first").setValue("Pentagon");
        }else if (sf == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("first").setValue("Circle");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("first").setValue("Hexagon");
        }
    }

    private void saveCs(int cs) {
        if (cs == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("second").setValue("Black");
        }else if (cs == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("second").setValue("Purple");
        }else if (cs == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("second").setValue("Green");
        }else if (cs == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("second").setValue("Red");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("second").setValue("White");
        }
    }

    private void saveCf(int cf) {
        if (cf == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("first").setValue("Black");
        }else if (cf == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("first").setValue("Purple");
        }else if (cf == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("first").setValue("Green");
        }else if (cf == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("first").setValue("Red");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("first").setValue("White");
        }
    }

    private void saveAs(int as) {
        if (as == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("second").setValue("Lion");
        }else if (as == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("second").setValue("Bear");
        }else if (as == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("second").setValue("Horse");
        }else if (as == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("second").setValue("Parrot");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("second").setValue("Owl");
        }
    }

    private void saveAf(int af) {
        if (af == 0){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("first").setValue("Lion");
        }else if (af == 1){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("first").setValue("Bear");
        }else if (af == 2){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("first").setValue("Horse");
        }else if (af == 3){
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("first").setValue("Parrot");
        }else{
            FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("first").setValue("Owl");
        }
    }

    private void load() {
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String,String> data = (HashMap<String, String>) dataSnapshot.getValue();
                    if (data.get("first").equals("Dog")){
                        animalfirst.setSelectedIndex(0);
                    }else if (data.get("first").equals("Bear")){
                        animalfirst.setSelectedIndex(1);
                    }else if (data.get("first").equals("Horse")){
                        animalfirst.setSelectedIndex(2);
                    }else if (data.get("first").equals("Parrot")){
                        animalfirst.setSelectedIndex(3);
                    }else{
                        animalfirst.setSelectedIndex(4);
                    }

                    if (data.get("second").equals("Dog")){
                        animalsecond.setSelectedIndex(0);
                    }else if (data.get("second").equals("Bear")){
                        animalsecond.setSelectedIndex(1);
                    }else if (data.get("second").equals("Horse")){
                        animalsecond.setSelectedIndex(2);
                    }else if (data.get("second").equals("Parrot")){
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

        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String,String> data = (HashMap<String, String>) dataSnapshot.getValue();
                    if (data.get("first").equals("Black")){
                        colorfirst.setSelectedIndex(0);
                    }else if (data.get("first").equals("Purple")){
                        colorfirst.setSelectedIndex(1);
                    }else if (data.get("first").equals("Green")){
                        colorfirst.setSelectedIndex(2);
                    }else if (data.get("first").equals("Red")){
                        colorfirst.setSelectedIndex(3);
                    }else{
                        colorfirst.setSelectedIndex(4);
                    }

                    if (data.get("second").equals("Black")){
                        colorsecond.setSelectedIndex(0);
                    }else if (data.get("second").equals("Purple")){
                        colorsecond.setSelectedIndex(1);
                    }else if (data.get("second").equals("Green")){
                        colorsecond.setSelectedIndex(2);
                    }else if (data.get("second").equals("Red")){
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

        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String,String> data = (HashMap<String, String>) dataSnapshot.getValue();
                    if (data.get("first").equals("Star")){
                        shapefirst.setSelectedIndex(0);
                    }else if (data.get("first").equals("Square")){
                        shapefirst.setSelectedIndex(1);
                    }else if (data.get("first").equals("Pentagon")){
                        shapefirst.setSelectedIndex(2);
                    }else if (data.get("first").equals("Circle")){
                        shapefirst.setSelectedIndex(3);
                    }else{
                        shapefirst.setSelectedIndex(4);
                    }

                    if (data.get("second").equals("Star")){
                        shapesecond.setSelectedIndex(0);
                    }else if (data.get("second").equals("Square")){
                        shapesecond.setSelectedIndex(1);
                    }else if (data.get("second").equals("Pentagon")){
                        shapesecond.setSelectedIndex(2);
                    }else if (data.get("second").equals("Circle")){
                        shapesecond.setSelectedIndex(3);
                    }else{
                        shapesecond.setSelectedIndex(4);
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

        animalfirst.setItems("Lion", "Bear", "Horse", "Parrot", "Owl");
        animalsecond.setItems("Lion", "Bear", "Horse", "Parrot", "Owl");
        colorfirst.setItems("Black","Purple","Green","Red","White");
        colorsecond.setItems("Black","Purple","Green","Red","White");
        shapefirst.setItems("Star","Square","Pentagon","Circle","Hexagon");
        shapesecond.setItems("Star","Square","Pentagon","Circle","Hexagon");

    }

}