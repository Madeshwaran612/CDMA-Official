package com.madesh.CDMA_Official;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;

import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.madesh.CDMA_Official.Authentication.Login;
import com.madesh.CDMA_Official.ScoreSheet.Mallakhamb;
import com.madesh.CDMA_Official.Utility.Common;
import com.madesh.CDMA_Official.ui.Contact.ContactFragment;
import com.madesh.CDMA_Official.ui.Videos.VideoFragment;
import com.madesh.CDMA_Official.ui.dashboard.DashboardFragment;
import com.madesh.CDMA_Official.ui.home.HomeFragment;
import com.madesh.CDMA_Official.ui.notifications.NotificationsFragment;




public class MainActivity2 extends AppCompatActivity {
    MainActivity2.NetworkChangeListener networkChangeListener = new MainActivity2.NetworkChangeListener();
    public static BottomNavigationView navBot;
    static FloatingActionButton fab, fab2;
    private static final int STORAGE_PERMISSION_CODE = 101;

private AdView mAdView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Button Vtext=findViewById(R.id.VText);
        Button VBotton = findViewById(R.id.eVerify);
        FirebaseFirestore firestore =FirebaseFirestore.getInstance();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        FirebaseUser user =firebaseAuth.getCurrentUser();


        if (!user.isEmailVerified()){
            VBotton.setVisibility(View.VISIBLE);
            Vtext.setVisibility(View.VISIBLE);

            VBotton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    user.sendEmailVerification().addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity2.this,"Verification Email has been sent",Toast.LENGTH_SHORT).show();
                            VBotton.setVisibility(View.GONE);
                            Vtext.setVisibility(View.GONE);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity2.this,e.toString(),Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }else{
            VBotton.setVisibility(View.GONE);
            Vtext.setVisibility(View.GONE);
        }


        navBot = findViewById(R.id.new_bottom_nav);
        navBot.setOnNavigationItemSelectedListener(navListener);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportFragmentManager().beginTransaction().replace(R.id.new_container, new HomeFragment()).commit();
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        fab2 =findViewById(R.id.CalculatingScore);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                        if (ActivityCompat.checkSelfPermission(HangingMallakhamb.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                            PermissionUtils.requestPermission(HangingMallakhamb.this,1,Manifest.permission.ACCESS_FINE_LOCATION,true);
//                            Toast.makeText(HangingMallakhamb.this, "Request needed", Toast.LENGTH_SHORT).show();
//                            // TODO: Consider calling
//                            //    ActivityCompat#requestPermissions
//                            // here to request the missing permissions, and then overriding
//                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                            //                                          int[] grantResults)
//                            // to handle the case where the user grants the permission. See the documentation
//                            // for ActivityCompat#requestPermissions for more details.
//                            return;
//                        }
//                        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
//                            @Override
//                            public void onSuccess() {
//                                connectionStatus.setText("Discovery Started");
//                            }
//
//                            @Override
//                            public void onFailure(int reason) {
//                                connectionStatus.setText("Discovery Failed");
//                                Log.d("Discovery failed",String.valueOf(reason));
//
//                            }
//                        });
                    
                Intent i = new Intent(MainActivity2.this, Mallakhamb.class);
                startActivity(i);

                checkPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        STORAGE_PERMISSION_CODE);
            }
        });

        fab = findViewById(R.id.videobut);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity2.this);
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

                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       logout();

                    }
                });

                mailBut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.animate_windmill_enter, R.anim.animate_fade_exit).replace(R.id.new_container, new ContactFragment()).addToBackStack(null).commit();
                        hideBot();
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
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Get all the live and exclusive content of Mallakhamb all over Chennai at the Official App of Chennai District Mallakhamb Association\n" + "https://play.google.com/store/apps/details?id=com.maddy.CDMA_Tv");
                        sendIntent.setType("text/plain");

                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        startActivity(shareIntent);
                        dialog.cancel();

                    }
                });

            }
        });
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

AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(MainActivity2.this);

        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

        appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo result) {
                if (result.updateAvailability()== UpdateAvailability.UPDATE_AVAILABLE
                && result.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)){
                    try {
                        appUpdateManager.startUpdateFlowForResult(result,AppUpdateType.FLEXIBLE,MainActivity2.this,0);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0){
            Toast.makeText(this,"Start Download",Toast.LENGTH_SHORT).show();
            if (requestCode!=RESULT_OK){
                Log.d("mmm","Update flow failed"+resultCode);

            }
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();

                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new DashboardFragment();

                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new NotificationsFragment();

                    break;
                case R.id.navigation_videos:
                    selectedFragment = new VideoFragment();

                    break;


            }
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.nav_default_pop_enter_anim, R.anim.animate_fade_exit).replace(R.id.new_container, selectedFragment).commit();


            return true;
        }
    };

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity2.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity2.this,
                    new String[] { permission },
                    requestCode);
        }
        else {
//            Toast.makeText(MainActivity2.this,
//                    "Permission already granted",
//                    Toast.LENGTH_SHORT)
//                    .show();
        }
    }

    @Override
    public void onBackPressed() {


        if (navBot.getSelectedItemId() == R.id.navigation_home && getSupportFragmentManager().getBackStackEntryCount() == 1) {
            getSupportFragmentManager().popBackStack();
            showBot();


        } else if (navBot.getSelectedItemId() == R.id.navigation_home) {


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
            build.setNeutralButton("Rate Us", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.maddy.CDMA_Tv")));

                }
            });
            build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = build.create();
            alertDialog.show();

        } else if (navBot.getSelectedItemId() != R.id.navigation_home && getSupportFragmentManager().getBackStackEntryCount() != 0) {

            getSupportFragmentManager().popBackStack();
            showBot();

        } else {
            navBot.setSelectedItemId(R.id.navigation_home);


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

                Dialog dialog = new Dialog(MainActivity2.this);
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
                        navBot.setSelectedItemId(R.id.navigation_home);
                    }
                });
                dialog.show();
            }

        }
    }

    public static void showBot() {
        navBot.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);

    }

    public static void hideBot() {
        navBot.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);
    }
    public void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}