package com.learninglanguage.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LevelThreeTestingColorsActivity extends AppCompatActivity {

    private CardView lay1, lay2, lay3, lay4, lay5;
    private VideoView videoview;

    private String name;
    private int count;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three_testing_colors);
        initComponents();
        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("first").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();

                    loadVideo();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        lay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Blue")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Color test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level03").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        lay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Purple")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Colors test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level03").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        lay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Red")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Colors test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level03").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        lay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Black")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Colors test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeTestingColorsActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level03").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        lay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Yellow")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Colors test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level03").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelThreeTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelThreeTestingColorsActivity.this, LevelThreeLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });
    }

    private void loadNextWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level03").child("colors").child("second").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();

                    loadVideo();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void loadVideo() {
        if (name.equals("Blue")) {
            video(R.raw.l3_blue);
        } else if (name.equals("Purple")) {
            video(R.raw.l3_purple);
        } else if (name.equals("Red")) {
            video(R.raw.l3_red);
        } else if (name.equals("Black")) {
            video(R.raw.l3_black);
        } else {
            video(R.raw.l3_yellow);
        }
    }

    private void video(int name) {
        Uri uri = Uri.parse("android.resource://com.learninglanguage.app/" + name);
        videoview.setVideoURI(uri);
        MediaController controller = new MediaController(LevelThreeTestingColorsActivity.this);
        videoview.setMediaController(controller);
        controller.setAnchorView(videoview);
        videoview.start();
    }

    private void initComponents() {
        lay1 = findViewById(R.id.lay1);
        lay2 = findViewById(R.id.lay2);
        lay3 = findViewById(R.id.lay3);
        lay4 = findViewById(R.id.lay4);
        lay5 = findViewById(R.id.lay5);
        videoview = findViewById(R.id.videoview);
    }

}