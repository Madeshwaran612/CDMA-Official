package com.madesh.CDMA_Official;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    Button CJPole,CJRope,CJHanging,JudPole,JudRope,JudHanging,poleTimer,ropeTimer,hangingTimer,judge1,judge2,judge3,judge4;
//    LinearLayout judge1_4;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        CJPole = findViewById(R.id.poleChiefJudge);
//        CJRope = findViewById(R.id.ropeChiefJudge);
//        CJHanging = findViewById(R.id.hangingChiefJudge);
//        JudPole = findViewById(R.id.poleJudge);
//        JudRope = findViewById(R.id.ropeJudge);
//        JudHanging = findViewById(R.id.hangingJudge);
//        poleTimer = findViewById(R.id.poleTimer);
//        ropeTimer = findViewById(R.id.ropeTimer);
//        hangingTimer = findViewById(R.id.hangingTimer);
//        judge1 = findViewById(R.id.judge1Button);
//        judge4 = findViewById(R.id.judge4Button);
//        judge2 = findViewById(R.id.judge2Button);
//        judge3 = findViewById(R.id.judge3Button);
//        judge1_4 = findViewById(R.id.JudgeChoiceButtons);
//
//        CJPole.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, PoleMallakhamb.class));
//            }
//        });
//        CJRope.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, RopeMallakhamb.class));
//            }
//        });
//        CJHanging.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, HangingMallakhamb.class));
//            }
//        });
//        JudPole.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                judge1_4.setVisibility(View.VISIBLE);
//            }
//        });
//        JudRope.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                judge1_4.setVisibility(View.VISIBLE);
//            }
//        });
//        JudHanging.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                judge1_4.setVisibility(View.VISIBLE);
//            }
//        });
//        poleTimer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        ropeTimer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        hangingTimer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        judge1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Judge_1.class));
//            }
//        });
//        judge2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Judge_2.class));
//            }
//        });
//        judge3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Judge_3.class));
//
//            }
//        });
//        judge4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Judge_4.class));
//
//            }
//        });
//
//
//
//



    }




//    NetworkChangeListener networkChangeListener = new NetworkChangeListener();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setTheme(R.style.splash);
//        setContentView(R.layout.activity_main);
//
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController;
//
//        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//
//        NavigationUI.setupWithNavController(navView, navController);
//
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        ImageButton club;
//        club = findViewById(R.id.clubbutton);
//        club.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.popup);
//                dialog.setCancelable(true);
//                dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
//                dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
//                Button button = dialog.findViewById(R.id.Sharebutton);
//                Button fbBut, instaBut, mailBut, club;
//
//                fbBut = dialog.findViewById(R.id.fbButton);
//                instaBut = dialog.findViewById(R.id.instaButton);
//                mailBut = dialog.findViewById(R.id.mailButton);
//
//                mailBut.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent l = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto: chennaidistrictmallakhamb@gmail.com"));
//                        startActivity(l);
//                        dialog.cancel();
//                    }
//                });
//                instaBut.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent j = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/chennaidistrictmallakhamb?igshid=19h98473xcigm"));
//                        startActivity(j);
//                        dialog.cancel();
//                    }
//                });
//                fbBut.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent K = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/chennaidistrictmallakhamb/"));
//                        startActivity(K);
//                        dialog.cancel();
//                    }
//                });
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent sendIntent = new Intent();
//                        sendIntent.setAction(Intent.ACTION_SEND);
//                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Get all the live and exclusive content of Mallakhamb all over Chennai at the Official App of Chennai District Mallakhamb Association\n" + "https://play.google.com/store/apps/details?id=com.maddy.CDMA_Tv");
//                        sendIntent.setType("text/plain");
//
//                        Intent shareIntent = Intent.createChooser(sendIntent, null);
//                        startActivity(shareIntent);
//                        dialog.cancel();
//
//                    }
//                });
//                dialog.show();
//
//            }
//        });
//        FloatingActionButton fab = findViewById(R.id.videobut);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected()) {
//
//            Dialog dialog = new Dialog(this);
//            dialog.setContentView(R.layout.alert);
//            dialog.setCancelable(false);
//            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//            dialog.getWindow().getAttributes().windowAnimations = android.R.style.TextAppearance_Holo_WindowTitle;
//            dialog.show();
//            Button button = dialog.findViewById(R.id.retry);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    recreate();
//                }
//            });
//            dialog.show();
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        final AlertDialog.Builder buid = new AlertDialog.Builder(this);
//        buid.setMessage("Are you sure want to exit?");
//        buid.setCancelable(true);
//        buid.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//        buid.setCancelable(true);
//        buid.setNeutralButton("rate us", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.maddy.CDMA_Tv")));
//
//            }
//        });
//        buid.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//        AlertDialog alertDialog = buid.create();
//        alertDialog.show();
//    }
//
//    @Override
//    public void onStart() {
//        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        registerReceiver(networkChangeListener, filter);
//        super.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        unregisterReceiver(networkChangeListener);
//        super.onStop();
//    }
//
//
//    public class NetworkChangeListener extends BroadcastReceiver {
//        Button button7;
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (!Common.isConnectedToInternet(context)) {
//
//                Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.alert);
//                dialog.setCancelable(false);
//                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//                dialog.getWindow().getAttributes().windowAnimations = android.R.style.TextAppearance_Holo_WindowTitle;
//                dialog.show();
//                Button button = dialog.findViewById(R.id.retry);
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        recreate();
//                    }
//                });
//                dialog.show();
//            }
//
//        }
//    }
//    public static class networkControler extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//
//            return true;
//        }
//    }

