package com.madesh.CDMA_Official.ScoreSheet;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.madesh.CDMA_Official.Judges.Judge_1;
import com.madesh.CDMA_Official.Judges.Judge_2;
import com.madesh.CDMA_Official.Judges.Judge_3;
import com.madesh.CDMA_Official.Judges.Judge_4;

import com.madesh.CDMA_Official.R;

public class Mallakhamb extends AppCompatActivity {

FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    private static final String SERVICE_ID = "com.maddy.CDMA_Tv";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mallakhamb);

        ImageView pole, rope, hanging;
        Button poleText, ropeText, hangingText;

        AdView mAdView = findViewById(R.id.adView);
        AdView mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest);


        pole = findViewById(R.id.PoleMallakhamb);
        poleText = findViewById(R.id.PoleMallakhambText);
        rope = findViewById(R.id.RopeMallakhamb);
        ropeText = findViewById(R.id.RopeMallakhambText);
        hanging = findViewById(R.id.HangingMallakhmb);
        hangingText = findViewById(R.id.HangingMallakhmbText);

        pole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Mallakhamb.this);
                dialog1.setContentView(R.layout.pole_choice);
                dialog1.setCancelable(true);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                Button Chief,Judge,Timer;
                AdView mAdView3 = dialog1.findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView3.loadAd(adRequest);

                Chief = dialog1.findViewById(R.id.hangingChiefJudge);
                Judge = dialog1.findViewById(R.id.judges);
                Timer = dialog1.findViewById(R.id.timer);


                dialog1.show();

                Chief.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Mallakhamb.this,PoleMallakhamb.class));
                        dialog1.dismiss();
                    }
                });
                Judge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(Mallakhamb.this);
                        dialog.setContentView(R.layout.judge_choice);
                        dialog.setCancelable(true);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;

                        Button judge1,judge2,judge3,judge4;

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
                                startActivity(new Intent(Mallakhamb.this, Judge_1.class));
                                dialog.dismiss();
                            }
                        });
                        judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_2.class));
                                dialog.dismiss();
                            }
                        });
                        judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_3.class));
                                dialog.dismiss();
                            }
                        });
                        judge4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_4.class));
                                dialog.dismiss();
                            }
                        });

                        dialog1.dismiss();
                    }
                });
                Timer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Mallakhamb.this, com.madesh.CDMA_Official.Judges.Timer.class);

                        startActivity(intent);
                    }
                });
            }
        });
        poleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Mallakhamb.this);
                dialog1.setContentView(R.layout.pole_choice);
                dialog1.setCancelable(true);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
           Button Chief,Judge,Timer;

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
                        startActivity(new Intent(Mallakhamb.this,PoleMallakhamb.class));
                        dialog1.dismiss();
                    }
                });
                Judge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(Mallakhamb.this);
                        dialog.setContentView(R.layout.judge_choice);
                        dialog.setCancelable(true);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;

                        Button judge1,judge2,judge3,judge4;

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
                                startActivity(new Intent(Mallakhamb.this, Judge_1.class));
                                Log.e("tttttt","some");
                            dialog.dismiss();
                            }
                        });
                        judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_2.class));
                            dialog.dismiss();}
                        });
                        judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_3.class));
                            dialog.dismiss();}
                        });
                        judge4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_4.class));
                            dialog.dismiss();}
                        });

                        dialog1.dismiss();
                    }
                });
                Timer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Mallakhamb.this, com.madesh.CDMA_Official.Judges.Timer.class);

                        startActivity(intent);
                    }
                });
            }
        });
        rope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Mallakhamb.this);
                dialog1.setContentView(R.layout.rope_choice);
                dialog1.setCancelable(true);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                Button Chief,Judge,Timer;

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
                        startActivity(new Intent(Mallakhamb.this,RopeMallakhamb.class));
                        dialog1.dismiss();
                    }
                });
                Judge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(Mallakhamb.this);
                        dialog.setContentView(R.layout.judge_choice);
                        dialog.setCancelable(true);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button button = dialog.findViewById(R.id.Sharebutton);
                        Button judge1,judge2,judge3,judge4;

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
                                startActivity(new Intent(Mallakhamb.this, Judge_1.class));
                                dialog.dismiss();
                            }
                        });
                        judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_2.class));
                                dialog.dismiss();
                            }
                        });
                        judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_3.class));
                                dialog.dismiss();
                            }
                        });
                        judge4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_4.class));
                                dialog.dismiss();
                            }
                        });

                        dialog1.dismiss();
                    }
                });
                Timer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Mallakhamb.this, com.madesh.CDMA_Official.Judges.Timer.class);

                        startActivity(intent);
                    }
                });
            }
        });
        ropeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Mallakhamb.this);
                dialog1.setContentView(R.layout.rope_choice);
                dialog1.setCancelable(true);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                Button button = dialog1.findViewById(R.id.Sharebutton);
                Button Chief,Judge,Timer;

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
                        startActivity(new Intent(Mallakhamb.this,RopeMallakhamb.class));
                        dialog1.dismiss();
                    }
                });
                Judge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(Mallakhamb.this);
                        dialog.setContentView(R.layout.judge_choice);
                        dialog.setCancelable(true);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button button = dialog.findViewById(R.id.Sharebutton);
                        Button judge1,judge2,judge3,judge4;

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
                                startActivity(new Intent(Mallakhamb.this, Judge_1.class));
                                dialog.dismiss();
                            }
                        });
                        judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_2.class));
                                dialog.dismiss();
                            }
                        });
                        judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_3.class));
                                dialog.dismiss();
                            }
                        });
                        judge4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_4.class));
                                dialog.dismiss();
                            }
                        });
                        dialog1.dismiss();

                    }
                });
                Timer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Mallakhamb.this, com.madesh.CDMA_Official.Judges.Timer.class);

                        startActivity(intent);
                    }
                });
            }
        });
        hanging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Mallakhamb.this);
                dialog1.setContentView(R.layout.hanging_choice);
                dialog1.setCancelable(true);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                Button Chief,Judge,Timer;

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
                        startActivity(new Intent(Mallakhamb.this,HangingMallakhamb.class));
                        dialog1.dismiss();
                    }
                });
                Judge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(Mallakhamb.this);
                        dialog.setContentView(R.layout.judge_choice);
                        dialog.setCancelable(true);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button button = dialog.findViewById(R.id.Sharebutton);
                        Button judge1,judge2,judge3,judge4;

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
                                startActivity(new Intent(Mallakhamb.this, Judge_1.class));
                                dialog.dismiss();
                            }
                        });
                        judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_2.class));
                                dialog.dismiss();
                            }
                        });
                        judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_3.class));
                                dialog.dismiss();
                            }
                        });
                        judge4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_4.class));
                                dialog.dismiss();
                            }
                        });
                        dialog1.dismiss();

                    }
                });
                Timer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Mallakhamb.this, com.madesh.CDMA_Official.Judges.Timer.class);

                        startActivity(intent);
                    }
                });
            }
        });
        hangingText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Mallakhamb.this);
                dialog1.setContentView(R.layout.hanging_choice);
                dialog1.setCancelable(true);
                dialog1.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog1.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                Button Chief,Judge,Timer;

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
                        startActivity(new Intent(Mallakhamb.this,HangingMallakhamb.class));
                        dialog1.dismiss();
                    }
                });
                Judge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(Mallakhamb.this);
                        dialog.setContentView(R.layout.judge_choice);
                        dialog.setCancelable(true);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_InputMethod;
                        Button button = dialog.findViewById(R.id.Sharebutton);
                        Button judge1,judge2,judge3,judge4;

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
                                startActivity(new Intent(Mallakhamb.this, Judge_1.class));
                                dialog.dismiss();
                            }
                        });
                        judge2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_2.class));
                                dialog.dismiss();
                            }
                        });
                        judge3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_3.class));
                                dialog.dismiss();
                            }
                        });
                        judge4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Mallakhamb.this, Judge_4.class));
                                dialog.dismiss();
                            }
                        });

                        dialog1.dismiss();
                    }
                });
                Timer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Mallakhamb.this, com.madesh.CDMA_Official.Judges.Timer.class);

                        startActivity(intent);
                    }
                });
            }
        });

    }
//    private void startAdvertising() {
//        AdvertisingOptions advertisingOptions =
//                new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_CLUSTER).build();
//        ConnectionLifecycleCallback connectionLifecycleCallback= new ConnectionLifecycleCallback() {
//
//                @Override
//                public void onConnectionInitiated(String endpointId, ConnectionInfo info) {
//                    PayloadCallback payloadCallback = new PayloadCallback() {
//                        @Override
//                        public void onPayloadReceived(@NonNull String s, @NonNull Payload payload) {
//                            byte[] receivedBytes = payload.asBytes();
//                        }
//
//                        @Override
//                        public void onPayloadTransferUpdate(@NonNull String s, @NonNull PayloadTransferUpdate payloadTransferUpdate) {
//
//                        }
//                    };
//                    new AlertDialog.Builder(Mallakhamb.this)
//                            .setTitle("Accept connection to " + info.getEndpointName())
//                            .setMessage("Confirm the code matches on both devices: " + info.getAuthenticationToken())
//                            .setPositiveButton(
//                                    "Accept",
//                                    (DialogInterface dialog, int which) ->
//                                            // The user confirmed, so we can accept the connection.
//                                            Nearby.getConnectionsClient(Mallakhamb.this)
//                                                    .acceptConnection(endpointId, payloadCallback))
//                            .setNegativeButton(
//                                    android.R.string.cancel,
//                                    (DialogInterface dialog, int which) ->
//                                            // The user canceled, so we should reject the connection.
//                                            Nearby.getConnectionsClient(Mallakhamb.this).rejectConnection(endpointId))
//                            .setIcon(android.R.drawable.ic_dialog_alert)
//                            .show();
//                }
//
//
//            @Override
//            public void onConnectionResult(@NonNull String s, @NonNull ConnectionResolution connectionResolution) {
//
//            }
//
//            @Override
//            public void onDisconnected(@NonNull String s) {
//
//            }
//        };
//        Nearby.getConnectionsClient(Mallakhamb.this)
//                .startAdvertising(
//                        getUserNickname(), SERVICE_ID, connectionLifecycleCallback, advertisingOptions)
//                .addOnSuccessListener(
//                        (Void unused) -> {
//                            // We're advertising!
//                        })
//                .addOnFailureListener(
//                        (Exception e) -> {
//                            // We were unable to start advertising.
//                        });
//    }
//
//    private String getUserNickname() {
//        String s ="u";
//        return s;
//    }
//
//    private void startDiscovery() {
//        DiscoveryOptions discoveryOptions =
//                new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_CLUSTER).build();
//        EndpointDiscoveryCallback endpointDiscoveryCallback=new EndpointDiscoveryCallback() {
//            @Override
//            public void onEndpointFound(@NonNull String s, @NonNull DiscoveredEndpointInfo discoveredEndpointInfo) {
//
//            }
//
//            @Override
//            public void onEndpointLost(@NonNull String s) {
//
//            }
//        };
//        Nearby.getConnectionsClient(Mallakhamb.this)
//                .startDiscovery(SERVICE_ID, endpointDiscoveryCallback, discoveryOptions)
//                .addOnSuccessListener(
//                        (Void unused) -> {
//                            // We're discovering!
//                        })
//                .addOnFailureListener(
//                        (Exception e) -> {
//                            // We're unable to start discovering.
//                        });
//    }



}



