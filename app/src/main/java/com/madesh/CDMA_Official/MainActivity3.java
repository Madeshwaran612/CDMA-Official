package com.madesh.CDMA_Official;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.madesh.CDMA_Official.Authentication.Login;

import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.madesh.CDMA_Official.Judges.Judge_1;
import com.madesh.CDMA_Official.Judges.Judge_2;
import com.madesh.CDMA_Official.Judges.Judge_3;
import com.madesh.CDMA_Official.Judges.Judge_4;
import com.madesh.CDMA_Official.ScoreSheet.PoleMallakhamb;
import com.madesh.CDMA_Official.Utility.Common;
import com.madesh.CDMA_Official.ui.Contact.ContactFragment;
import com.madesh.CDMA_Official.ui.Videos.VideoFragment;
import com.madesh.CDMA_Official.ui.dashboard.DashboardFragment;
import com.madesh.CDMA_Official.ui.home.HomeFragment;
import com.madesh.CDMA_Official.ui.notifications.NotificationsFragment;

public class MainActivity3 extends AppCompatActivity {

    MainActivity3.NetworkChangeListener networkChangeListener = new MainActivity3.NetworkChangeListener();
    private DrawerLayout drawer;
    NavigationView navigationView;

    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Button Vtext = findViewById(R.id.VText);
        Button VBotton = findViewById(R.id.eVerify);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        navigationView = findViewById(R.id.nav_drawer_view);


        if (!user.isEmailVerified()) {
            VBotton.setVisibility(View.VISIBLE);
            Vtext.setVisibility(View.VISIBLE);

            VBotton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    user.sendEmailVerification().addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity3.this, "Verification Email has been sent", Toast.LENGTH_SHORT).show();
                            VBotton.setVisibility(View.GONE);
                            Vtext.setVisibility(View.GONE);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity3.this, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        } else {
            VBotton.setVisibility(View.GONE);
            Vtext.setVisibility(View.GONE);
        }


//        navBot = findViewById(R.id.new_bottom_nav);
//        navBot.setOnNavigationItemSelectedListener(navListener);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        navigationView.setCheckedItem(R.id.nav_home_drawer);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new HomeFragment()).commit();
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected()) {

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.alert);
            dialog.setCancelable(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.TextAppearance_Holo_WindowTitle;
            dialog.show();
            Button button = dialog.findViewById(R.id.retry);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recreate();
                }
            });
            dialog.show();
        }

        FloatingActionButton fab;
        fab = findViewById(R.id.share);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity3.this);
                dialog.setContentView(R.layout.popup);
                dialog.setCancelable(true);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                Button button = dialog.findViewById(R.id.Sharebutton);
                Button fbBut, instaBut, mailBut, logout;

                fbBut = dialog.findViewById(R.id.fbButton);
                instaBut = dialog.findViewById(R.id.instaButton);
                mailBut = dialog.findViewById(R.id.mailButton);
                logout = dialog.findViewById(R.id.logout);
                dialog.show();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Get all the live and exclusive content of Mallakhamb all over Chennai at the Official App of Chennai District Mallakhamb Association\n" + "https://play.google.com/store/apps/details?id=com.madesh.CDMA_Official");
                        sendIntent.setType("text/plain");

                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        startActivity(shareIntent);
                        dialog.cancel();
                    }
                });


                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logout();

                    }
                });

                mailBut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).replace(R.id.frag_container, new ContactFragment()).addToBackStack(null).commit();
                        dialog.cancel();

                    }
                });
                instaBut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent j = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/chennaidistrictmallakhamb?igshid=19h98473xcigm"));
                        startActivity(j);
                        dialog.cancel();
                    }
                });
                fbBut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent K = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/chennaidistrictmallakhamb/"));
                        startActivity(K);
                        dialog.cancel();
                    }
                });
            }
        });
        checkPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_CODE);

        Toolbar toolBar = findViewById(R.id.ToolBar);
        setSupportActionBar(toolBar);

        drawer = findViewById(R.id.drawer_Layout);


        NavigationView navigationView = findViewById(R.id.nav_drawer_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home_drawer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new HomeFragment()).setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).commit();
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_stream_drawer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new DashboardFragment()).setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).commit();
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_clubs_drawer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new NotificationsFragment()).setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).commit();
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_videos_drawer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new VideoFragment()).setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).commit();
                        drawer.closeDrawers();
                        break;
                    case R.id.pole:
                        Dialog dialog1 = new Dialog(MainActivity3.this);
                        dialog1.setContentView(R.layout.pole_choice);
                        dialog1.setCancelable(true);
                        dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button Chief, Judge, Timer;

                        Chief = dialog1.findViewById(R.id.hangingChiefJudge);
                        Judge = dialog1.findViewById(R.id.judges);
                        Timer = dialog1.findViewById(R.id.timer);

                        AdView mAdView3 = dialog1.findViewById(R.id.adView);
                        AdRequest adRequest = new AdRequest.Builder().build();
                        mAdView3.loadAd(adRequest);

                        dialog1.show();

                        Chief.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MainActivity3.this, PoleMallakhamb.class));
                                dialog1.dismiss();
                            }
                        });
                        Judge.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Dialog dialog = new Dialog(MainActivity3.this);
                                dialog.setContentView(R.layout.judge_choice);
                                dialog.setCancelable(true);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                                dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;

                                Button judge1, judge2, judge3, judge4;

                                judge1 = dialog.findViewById(R.id.judge12);
                                judge2 = dialog.findViewById(R.id.judge2);
                                judge3 = dialog.findViewById(R.id.judge3);
                                judge4 = dialog.findViewById(R.id.judge4);

                                AdView mAdView3 = dialog.findViewById(R.id.adView);
                                AdRequest adRequest = new AdRequest.Builder().build();
                                mAdView3.loadAd(adRequest);

                                dialog.show();

                                judge1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_1.class));
                                        Log.e("tttttt", "some");
                                        dialog.dismiss();
                                    }
                                });
                                judge2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_2.class));
                                        dialog.dismiss();
                                    }
                                });
                                judge3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_3.class));
                                        dialog.dismiss();
                                    }
                                });
                                judge4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_4.class));
                                        dialog.dismiss();
                                    }
                                });

                                dialog1.dismiss();
                            }
                        });
                        Timer.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity3.this, com.madesh.CDMA_Official.Judges.Timer.class);

                                startActivity(intent);
                            }
                        });
                        drawer.closeDrawers();
                        break;
                    case R.id.hanging:
                        Dialog dialog12 = new Dialog(MainActivity3.this);
                        dialog12.setContentView(R.layout.hanging_choice);
                        dialog12.setCancelable(true);
                        dialog12.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog12.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button Chief2, Judge2, Timer2;

                        Chief2 = dialog12.findViewById(R.id.hangingChiefJudge);
                        Judge2 = dialog12.findViewById(R.id.judges);
                        Timer2 = dialog12.findViewById(R.id.timer);

                        AdView mAdView32 = dialog12.findViewById(R.id.adView);
                        AdRequest adRequest2 = new AdRequest.Builder().build();
                        mAdView32.loadAd(adRequest2);

                        dialog12.show();

                        Chief2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MainActivity3.this, PoleMallakhamb.class));
                                dialog12.dismiss();
                            }
                        });
                        Judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Dialog dialog = new Dialog(MainActivity3.this);
                                dialog.setContentView(R.layout.judge_choice);
                                dialog.setCancelable(true);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                                dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;

                                Button judge1, judge2, judge3, judge4;

                                judge1 = dialog.findViewById(R.id.judge12);
                                judge2 = dialog.findViewById(R.id.judge2);
                                judge3 = dialog.findViewById(R.id.judge3);
                                judge4 = dialog.findViewById(R.id.judge4);

                                AdView mAdView3 = dialog.findViewById(R.id.adView);
                                AdRequest adRequest = new AdRequest.Builder().build();
                                mAdView3.loadAd(adRequest);

                                dialog.show();

                                judge1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_1.class));
                                        Log.e("tttttt", "some");
                                        dialog.dismiss();
                                    }
                                });
                                judge2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_2.class));
                                        dialog.dismiss();
                                    }
                                });
                                judge3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_3.class));
                                        dialog.dismiss();
                                    }
                                });
                                judge4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_4.class));
                                        dialog.dismiss();
                                    }
                                });

                                dialog12.dismiss();
                            }
                        });
                        Timer2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity3.this, com.madesh.CDMA_Official.Judges.Timer.class);

                                startActivity(intent);
                                dialog12.dismiss();
                            }
                        });
                        drawer.closeDrawers();
                        break;
                    case R.id.rope:
                        Dialog dialog13 = new Dialog(MainActivity3.this);
                        dialog13.setContentView(R.layout.rope_choice);
                        dialog13.setCancelable(true);
                        dialog13.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog13.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button Chief3, Judge3, Timer3;

                        Chief3 = dialog13.findViewById(R.id.hangingChiefJudge);
                        Judge3 = dialog13.findViewById(R.id.judges);
                        Timer3 = dialog13.findViewById(R.id.timer);

                        AdView mAdView33 = dialog13.findViewById(R.id.adView);
                        AdRequest adRequest3 = new AdRequest.Builder().build();
                        mAdView33.loadAd(adRequest3);

                        dialog13.show();

                        Chief3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MainActivity3.this, PoleMallakhamb.class));
                                dialog13.dismiss();
                            }
                        });
                        Judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Dialog dialog = new Dialog(MainActivity3.this);
                                dialog.setContentView(R.layout.judge_choice);
                                dialog.setCancelable(true);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                                dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;

                                Button judge1, judge2, judge3, judge4;

                                judge1 = dialog.findViewById(R.id.judge12);
                                judge2 = dialog.findViewById(R.id.judge2);
                                judge3 = dialog.findViewById(R.id.judge3);
                                judge4 = dialog.findViewById(R.id.judge4);

                                AdView mAdView3 = dialog.findViewById(R.id.adView);
                                AdRequest adRequest = new AdRequest.Builder().build();
                                mAdView3.loadAd(adRequest);

                                dialog.show();

                                judge1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_1.class));
                                        Log.e("tttttt", "some");
                                        dialog.dismiss();
                                    }
                                });
                                judge2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_2.class));
                                        dialog.dismiss();
                                    }
                                });
                                judge3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_3.class));
                                        dialog.dismiss();
                                    }
                                });
                                judge4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(MainActivity3.this, Judge_4.class));
                                        dialog.dismiss();
                                    }
                                });

                                dialog13.dismiss();
                            }
                        });
                        Timer3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity3.this, com.madesh.CDMA_Official.Judges.Timer.class);

                                startActivity(intent);
                                dialog13.dismiss();
                            }
                        });
                        drawer.closeDrawers();
                        break;
                    default:

                }

                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolBar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START, true);
        }
        if (navigationView.getId() != R.id.nav_home_drawer && navigationView.getId() != R.id.nav_stream_drawer
                && navigationView.getId() != R.id.nav_videos_drawer) {
            getSupportFragmentManager().popBackStack();

        } else {
            final AlertDialog.Builder build = new AlertDialog.Builder(this);
            build.setMessage("Are you sure want to exit?");
            build.setCancelable(true);
            build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            build.setCancelable(true);

//            playstore not working
//
//            build.setNeutralButton("Rate Us", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.madesh.CDMA_Official")));
//
//                }
//            });
            build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = build.create();
            alertDialog.show();
        }
        if (navigationView.getId() == R.id.nav_clubs_drawer) {
            navigationView.setCheckedItem(R.id.nav_home_drawer);
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).replace(R.id.frag_container, new HomeFragment()).commit();
            Toast.makeText(this, "sssss", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity3.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity3.this,
                    new String[]{permission},
                    requestCode);
        } else {
//            Toast.makeText(MainActivity2.this,
//                    "Permission already granted",
//                    Toast.LENGTH_SHORT)
//                    .show();
        }
    }

    @Override
    public void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }

    public class NetworkChangeListener extends BroadcastReceiver {
        Button button7;

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!Common.isConnectedToInternet(context)) {

                Dialog dialog = new Dialog(MainActivity3.this);
                dialog.setContentView(R.layout.alert);
                dialog.setCancelable(false);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().getAttributes().windowAnimations = android.R.style.TextAppearance_Holo_WindowTitle;
                dialog.show();
                Button button = dialog.findViewById(R.id.retry);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recreate();
                    }
                });
                dialog.show();
            }

        }
    }
}