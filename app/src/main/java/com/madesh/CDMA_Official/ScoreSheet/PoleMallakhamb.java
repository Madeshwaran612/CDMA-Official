package com.madesh.CDMA_Official.ScoreSheet;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.madesh.CDMA_Official.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoleMallakhamb extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



//    Button chiefJudge, Judge, Timer, add1, add2, add3, add4, add5, add6, reset1, reset2, reset3, reset4, reset5, reset6, to1, to2, to3, to4, to5, setCompName,
//            judge1, judge2, judge3, judge4;
//    EditText compName, teamName1, teamName2, teamName3, teamName4, teamName5, teamName6, age1, age2, age3, age4, age5, age6,
//            difficulty1, difficulty2, difficulty3, difficulty4, difficulty5, difficulty6,
//            combination1, combination2, combination3, combination4, combination5, combination6,
//            execution1, execution2, execution3, execution4, execution5, execution6,
//            originality1, originality6, originality5, originality4, originality3, originality2;
//    TextView total1, total6, total5, total4, total3, total2,playerName1,playerName2,playerName3,playerName4,playerName5,playerName6;
//    CardView userChoice, compNameCard, judgeCard, judgeChoice,player1,player2,player3,player4,player5,player6;
//
//
//    public float summer(float s, float d, float f, float g) {
//
//        float Z = s + d + f + g;
//        return Z;
//
//    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mallakhamb_hanging);
//
//        player1 = findViewById(R.id.player1Card);
//        player2 = findViewById(R.id.player2Card);
//        player3 = findViewById(R.id.player3Card);
//        player4 = findViewById(R.id.player4Card);
//        player5 = findViewById(R.id.player5Card);
//        player6 = findViewById(R.id.player6Card);
//
//        difficulty1 = findViewById(R.id.difficultyMark_1);
//        difficulty2 = findViewById(R.id.difficultyMark_2);
//        difficulty3 = findViewById(R.id.difficultyMark_3);
//        difficulty4 = findViewById(R.id.difficultyMark_4);
//        difficulty5 = findViewById(R.id.difficultyMark_5);
//        difficulty6 = findViewById(R.id.difficultyMark_6);
//
//
//        combination1 = findViewById(R.id.CombinationMark_1);
//        combination2 = findViewById(R.id.CombinationMark_2);
//        combination3 = findViewById(R.id.CombinationMark_3);
//        combination4 = findViewById(R.id.CombinationMark_4);
//        combination5 = findViewById(R.id.CombinationMark_5);
//        combination6 = findViewById(R.id.CombinationMark_6);
//
//
//        execution1 = findViewById(R.id.ExecutionMark_1);
//        execution2 = findViewById(R.id.ExecutionMark_2);
//        execution3 = findViewById(R.id.ExecutionMark_3);
//        execution4 = findViewById(R.id.ExecutionMark_4);
//        execution5 = findViewById(R.id.ExecutionMark_5);
//        execution6 = findViewById(R.id.ExecutionMark_6);
//
//
//        originality1 = findViewById(R.id.originalityMark_1);
//        originality2 = findViewById(R.id.originalityMark_2);
//        originality3 = findViewById(R.id.originalityMark_3);
//        originality4 = findViewById(R.id.originalityMark_4);
//        originality5 = findViewById(R.id.originalityMark_5);
//        originality6 = findViewById(R.id.originalityMark_6);
//
//        age1 = findViewById(R.id.ageGroup1);
//        age2 = findViewById(R.id.ageGroup2);
//        age3 = findViewById(R.id.ageGroup3);
//        age4 = findViewById(R.id.ageGroup4);
//        age5 = findViewById(R.id.ageGroup5);
//        age6 = findViewById(R.id.ageGroup6);
//
//        compName = findViewById(R.id.compName);
//
//        teamName1 = findViewById(R.id.teamName1);
//        teamName2 = findViewById(R.id.teamName2);
//        teamName3 = findViewById(R.id.teamName3);
//        teamName4 = findViewById(R.id.teamName4);
//        teamName5 = findViewById(R.id.teamName5);
//        teamName6 = findViewById(R.id.teamName6);
//
//        total1 =findViewById(R.id.Total_1);
//        total2 =findViewById(R.id.Total_2);
//        total3 =findViewById(R.id.Total_3);
//        total4 =findViewById(R.id.Total_4);
//        total5 =findViewById(R.id.Total_5);
//        total6 =findViewById(R.id.Total_6);
//
//        userChoice = findViewById(R.id.UserChoice);
//        compNameCard = findViewById(R.id.compNameCard);
//        judgeCard = findViewById(R.id.chiefJudgeCard);
//        judgeChoice = findViewById(R.id.JudgeChoice);
//
//        chiefJudge = findViewById(R.id.chiefJudge);
//        Judge = findViewById(R.id.judges);
//        Timer = findViewById(R.id.timer);
//
//        add1 = findViewById(R.id.ADD_1);
//        add2 = findViewById(R.id.ADD_2);
//        add3 = findViewById(R.id.ADD_3);
//        add4 = findViewById(R.id.ADD_4);
//        add5 = findViewById(R.id.ADD_5);
//        add6 = findViewById(R.id.ADD_6);
//
//        reset1 = findViewById(R.id.ResetButton_1);
//        reset2 = findViewById(R.id.ResetButton_2);
//        reset3 = findViewById(R.id.ResetButton_3);
//        reset4 = findViewById(R.id.ResetButton_4);
//        reset5 = findViewById(R.id.ResetButton_5);
//        reset6 = findViewById(R.id.ResetButton_6);
//
//        to1 = findViewById(R.id.toPlayer1);
//        to2 = findViewById(R.id.toPlayer2);
//        to3 = findViewById(R.id.toPlayer3);
//        to4 = findViewById(R.id.toPlayer4);
//        to5 = findViewById(R.id.toPlayer5);
//
//        setCompName = findViewById(R.id.compNameFireBase);
//
//        judge1 = findViewById(R.id.judge1);
//        judge4 = findViewById(R.id.judge4);
//        judge3 = findViewById(R.id.judge3);
//        judge2 = findViewById(R.id.judge2);
//
//
//        chiefJudge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                compNameCard.setVisibility(View.VISIBLE);
//                userChoice.setVisibility(View.GONE);
//            }
//        });
//
//        setCompName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                judgeCard.setVisibility(View.VISIBLE);
//            }
//        });
//        Judge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                judgeChoice.setVisibility(View.VISIBLE);
//            }
//        });
//        Timer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HangingMallakhamb.this, com.maddy.CDMA_Tv.Judges.Timer.class));
//            }
//        });
//        judge1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HangingMallakhamb.this, com.maddy.CDMA_Tv.Judges.Judge_2.class));
//            }
//        });
//        judge2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HangingMallakhamb.this, com.maddy.CDMA_Tv.Judges.Judge_2.class));
//            }
//        });
//        judge3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HangingMallakhamb.this, com.maddy.CDMA_Tv.Judges.Judge_3.class));
//            }
//        });
//        judge4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HangingMallakhamb.this, com.maddy.CDMA_Tv.Judges.Judge_4.class));
//            }
//        });
//        add1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (difficulty1.getText().length() == 0) {
//                    difficulty1.setText("0.0");
//                }
//                if (combination1.getText().length() == 0) {
//                    combination1.setText("0.0");
//                }
//                if (execution1.getText().length() == 0) {
//                    execution1.setText("0.0");
//                }
//                if (originality1.getText().length() == 0) {
//                    originality1.setText("0.0");
//                }
//
//                if (TextUtils.isEmpty(teamName1.getText())) {
//                    teamName1.setError("Mention Player's Team Name");
//                }
////                if (TextUtils.isEmpty(playerName1.getText())) {
////                    playerName1.setError("Player's Name is Required");
////                }
//                if (TextUtils.isEmpty(age1.getText())) {
//                    age1.setError("Mention Player's Age Category");
//                }
//
//                total1.setText(String.valueOf(summer(Float.parseFloat(difficulty1.getText().toString()),
//                        Float.parseFloat(combination1.getText().toString()),
//                        Float.parseFloat(execution1.getText().toString()),
//                        Float.parseFloat(originality1.getText().toString()))));
//                total1.setVisibility(View.VISIBLE);
//                player2.setVisibility(View.VISIBLE);
//                player1.setVisibility(View.GONE);
//            }
//        });
//        add2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (difficulty2.getText().length() == 0) {
//                    difficulty2.setText("0.0");
//                }
//                if (combination2.getText().length() == 0) {
//                    combination2.setText("0.0");
//                }
//                if (execution2.getText().length() == 0) {
//                    execution2.setText("0.0");
//                }
//                if (originality2.getText().length() == 0) {
//                    originality2.setText("0.0");
//                }
//
//                if (TextUtils.isEmpty(teamName2.getText())) {
//                    teamName2.setError("Mention Player's Team Name");
//                }
////                if (TextUtils.isEmpty(playerName2.getText())) {
////                    playerName2.setError("Player's Name is Required");
////                }
//                if (TextUtils.isEmpty(age2.getText())) {
//                    age2.setError("Mention Player's Age Category");
//                }
//
//                total2.setText(String.valueOf(summer(Float.parseFloat(difficulty2.getText().toString()),
//                        Float.parseFloat(combination2.getText().toString()),
//                        Float.parseFloat(execution2.getText().toString()),
//                        Float.parseFloat(originality2.getText().toString()))));
//                total2.setVisibility(View.VISIBLE);
//                player3.setVisibility(View.VISIBLE);
//                player2.setVisibility(View.GONE);
//            }
//        });
//        add3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (difficulty3.getText().length() == 0) {
//                    difficulty3.setText("0.0");
//                }
//                if (combination3.getText().length() == 0) {
//                    combination3.setText("0.0");
//                }
//                if (execution3.getText().length() == 0) {
//                    execution3.setText("0.0");
//                }
//                if (originality3.getText().length() == 0) {
//                    originality3.setText("0.0");
//                }
//
//                if (TextUtils.isEmpty(teamName3.getText())) {
//                    teamName3.setError("Mention Player's Team Name");
//                }
////                if (TextUtils.isEmpty(playerName3.getText())) {
////                    playerName3.setError("Player's Name is Required");
////                }
//                if (TextUtils.isEmpty(age3.getText())) {
//                    age3.setError("Mention Player's Age Category");
//                }
//
//                total3.setText(String.valueOf(summer(Float.parseFloat(difficulty3.getText().toString()),
//                        Float.parseFloat(combination3.getText().toString()),
//                        Float.parseFloat(execution3.getText().toString()),
//                        Float.parseFloat(originality3.getText().toString()))));
//                total3.setVisibility(View.VISIBLE);
//                player4.setVisibility(View.VISIBLE);
//                player3.setVisibility(View.GONE);
//            }
//        });
//        add4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (difficulty4.getText().length() == 0) {
//                    difficulty4.setText("0.0");
//                }
//                if (combination4.getText().length() == 0) {
//                    combination4.setText("0.0");
//                }
//                if (execution4.getText().length() == 0) {
//                    execution4.setText("0.0");
//                }
//                if (originality4.getText().length() == 0) {
//                    originality4.setText("0.0");
//                }
//
//                if (TextUtils.isEmpty(teamName4.getText())) {
//                    teamName4.setError("Mention Player's Team Name");
//                }
////                if (TextUtils.isEmpty(playerName4.getText())) {
////                    playerName4.setError("Player's Name is Required");
////                }
//                if (TextUtils.isEmpty(age4.getText())) {
//                    age4.setError("Mention Player's Age Category");
//                }
//
//                total4.setText(String.valueOf(summer(Float.parseFloat(difficulty4.getText().toString()),
//                        Float.parseFloat(combination4.getText().toString()),
//                        Float.parseFloat(execution4.getText().toString()),
//                        Float.parseFloat(originality4.getText().toString()))));
//                total4.setVisibility(View.VISIBLE);
//                player5.setVisibility(View.VISIBLE);
//                player4.setVisibility(View.GONE);
//            }
//        });
//        add5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player6.setVisibility(View.VISIBLE);
//                player5.setVisibility(View.GONE);
//                if (difficulty5.getText().length() == 0) {
//                    difficulty5.setText("0.0");
//                }
//                if (combination5.getText().length() == 0) {
//                    combination5.setText("0.0");
//                }
//                if (execution5.getText().length() == 0) {
//                    execution5.setText("0.0");
//                }
//                if (originality5.getText().length() == 0) {
//                    originality5.setText("0.0");
//                }
//
//                if (TextUtils.isEmpty(teamName5.getText())) {
//                    teamName5.setError("Mention Player's Team Name");
//                }
////                if (TextUtils.isEmpty(playerName5.getText())) {
////                    playerName5.setError("Player's Name is Required");
////                }
//                if (TextUtils.isEmpty(age5.getText())) {
//                    age5.setError("Mention Player's Age Category");
//                }
//
//                total5.setText(String.valueOf(summer(Float.parseFloat(difficulty5.getText().toString()),
//                        Float.parseFloat(combination5.getText().toString()),
//                        Float.parseFloat(execution5.getText().toString()),
//                        Float.parseFloat(originality5.getText().toString()))));
//                total5.setVisibility(View.VISIBLE);
//            }
//        });
//        add6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (difficulty6.getText().length() == 0) {
//                    difficulty6.setText("0.0");
//                }
//                if (combination6.getText().length() == 0) {
//                    combination6.setText("0.0");
//                }
//                if (execution6.getText().length() == 0) {
//                    execution6.setText("0.0");
//                }
//                if (originality6.getText().length() == 0) {
//                    originality6.setText("0.0");
//                }
//
//                if (TextUtils.isEmpty(teamName6.getText())) {
//                    teamName6.setError("Mention Player's Team Name");
//                }
////                if (TextUtils.isEmpty(playerName6.getText())) {
////                    playerName6.setError("Player's Name is Required");
////                }
//                if (TextUtils.isEmpty(age6.getText())) {
//                    age6.setError("Mention Player's Age Category");
//                }
//
//                total6.setText(String.valueOf(summer(Float.parseFloat(difficulty6.getText().toString()),
//                        Float.parseFloat(combination6.getText().toString()),
//                        Float.parseFloat(execution6.getText().toString()),
//                        Float.parseFloat(originality6.getText().toString()))));
//                total2.setVisibility(View.VISIBLE);
//            }
//        });
//        reset1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                total1.setVisibility(View.INVISIBLE);
//                difficulty1.setText(null);
//                combination1.setText(null);
//                execution1.setText(null);
//                originality1.setText(null);
//                playerName1.setText(null);
//            }
//        });
//        reset2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                total2.setVisibility(View.INVISIBLE);
//                difficulty2.setText(null);
//                combination2.setText(null);
//                execution2.setText(null);
//                originality2.setText(null);
//                playerName2.setText(null);
//            }
//        });
//        reset3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                total3.setVisibility(View.INVISIBLE);
//                difficulty3.setText(null);
//                combination3.setText(null);
//                execution3.setText(null);
//                originality3.setText(null);
//                playerName3.setText(null);
//            }
//        });
//        reset4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                total4.setVisibility(View.INVISIBLE);
//                difficulty4.setText(null);
//                combination4.setText(null);
//                execution4.setText(null);
//                originality4.setText(null);
//                playerName4.setText(null);
//            }
//        });
//        reset5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                total5.setVisibility(View.INVISIBLE);
//                difficulty5.setText(null);
//                combination5.setText(null);
//                execution5.setText(null);
//                originality5.setText(null);
//                playerName5.setText(null);
//            }
//        });
//        reset6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                total6.setVisibility(View.INVISIBLE);
//                difficulty6.setText(null);
//                combination6.setText(null);
//                execution6.setText(null);
//                originality6.setText(null);
//                playerName6.setText(null);
//            }
//        });
//        to1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player2.setVisibility(View.GONE);
//                player1.setVisibility(View.VISIBLE);
//            }
//        });
//        to2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player3.setVisibility(View.GONE);
//                player2.setVisibility(View.VISIBLE);
//            }
//        });
//        to3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player4.setVisibility(View.GONE);
//                player3.setVisibility(View.VISIBLE);
//            }
//        });
//        to4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player5.setVisibility(View.GONE);
//                player4.setVisibility(View.VISIBLE);
//            }
//        });
//        to5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player6.setVisibility(View.GONE);
//                player5.setVisibility(View.VISIBLE);
//            }
//        });
//
//    }
//
//
//
//
//    private void createPdf(String CompName, String TeamName, String AgeGrp,
//                           String playerName1, String playerName2, String playerName3, String playerName4, String playerName5, String playerName6,
//                           String Total1, String Total2, String Total3, String Total4, String Total5, String Total6) throws FileNotFoundException {
//
//
//        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
//        File file = new File(pdfPath, "ScoreSheet for " + TeamName + ".pdf");
//        OutputStream outputStream = new FileOutputStream(file);
//        Uri uri = Uri.fromFile(file);
//
//
//        PdfWriter writer = new PdfWriter(file);
//        PdfDocument pdfDocument = new PdfDocument(writer);
//        Document document = new Document(pdfDocument);
//        pdfDocument.setDefaultPageSize(PageSize.A6);
//
//
//        document.setMargins(0, 0, 0, 0);
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
//        }
//
//        Paragraph CompetitionName = new Paragraph(CompName + "\n").setBold().setFontSize(24).setTextAlignment(TextAlignment.CENTER);
//        Paragraph TeamNameHead = new Paragraph("Team: " + TeamName).setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER);
//        Paragraph AgeHead = new Paragraph(AgeGrp).setBold().setFontSize(18).setTextAlignment(TextAlignment.CENTER);
//
//        float[] width = {50f, 100f, 100f};
//        Table table = new Table(width);
//        table.setHorizontalAlignment(HorizontalAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("S.no"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph("Players Name"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph("Score"))).setTextAlignment(TextAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("1"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(playerName1))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(Total1))).setTextAlignment(TextAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("2"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(playerName2))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(Total2))).setTextAlignment(TextAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("3"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(playerName3))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(Total3))).setTextAlignment(TextAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("4"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(playerName4))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(Total4))).setTextAlignment(TextAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("5"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(playerName5))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(Total5))).setTextAlignment(TextAlignment.CENTER);
//
//
//        table.addCell(new Cell().add(new Paragraph("6"))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(playerName6))).setTextAlignment(TextAlignment.CENTER);
//        table.addCell(new Cell().add(new Paragraph(Total6))).setTextAlignment(TextAlignment.CENTER);
//
//
//        document.add(CompetitionName);
//        document.add(TeamNameHead);
//        document.add(AgeHead);
//        document.add(table);
//
//        document.close();
//    }
//
//
//}


    //

    TextView m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44, m51, m52, m53, m54, m61, m62, m63, m64, timing1, timing2, timing3, timing4, timing5, timing6;
    ImageButton p1, p2, p3, p4, p5, p6;
    Button OnOff, join, send;
    TextView connectionStatus;
    ListView list;
    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;

    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;
    List<WifiP2pDevice> peers = new ArrayList<WifiP2pDevice>();
    String[] deviceNameArray;
    WifiP2pDevice[] deviceArray;

    CollectionReference collectionReference;
    DocumentReference documentReference;



    FirebaseStorage fStorage = FirebaseStorage.getInstance();//uploading files
    FirebaseDatabase fDataBase = FirebaseDatabase.getInstance();//store urls of uploaded files
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();

    CardView card_1, card_2, card_3, card_4, card_5, card_6;
    EditText EditTextName, EditTextRepresent, difficulty, combination, execution, originality, competitionName, roomCode;
    EditText EditTextName2, difficulty2, combination2, execution2, originality2;
    EditText EditTextName3, difficulty3, combination3, execution3, originality3;
    EditText EditTextName4, difficulty4, combination4, execution4, originality4;
    EditText EditTextName5, difficulty5, combination5, execution5, originality5;
    EditText EditTextName6, difficulty6, combination6, execution6, originality6;

    EditText MinorD1, MinorD2, MinorD3, MinorD4, MinorD5, MinorD6;
    EditText MajorD1, MajorD2, MajorD3, MajorD4, MajorD5, MajorD6;

    Button reset, reset2, reset3, reset4, reset5, reset6;
    Button add, add2, add3, add4, add5, add6;

    Button generatePDF, createRoombut;

    TextView total, total2, total3, total4, total5, total6, EditTextAge6;
    TextView getBackToPlayer1, getBackToPlayer2, getBackToPlayer3, getBackToPlayer4, getBackToPlayer5;

    String UserEmail = firebaseAuth.getCurrentUser().getEmail();

    private InterstitialAd  mInterstitialAds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mallakhamb_pole);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ageCategoryChief, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mInterstitialAds = new InterstitialAd(this);
        mInterstitialAds.setAdUnitId("ca-app-pub-7842166538836228/5291278919");
        mInterstitialAds.loadAd(new AdRequest.Builder().build());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        remoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().build());
        HashMap<String,Object> defaults = new HashMap<>();
        defaults.put("max_chars",6);
        remoteConfig.setDefaultsAsync(defaults);

        final Task<Void> fetch = remoteConfig.fetch(0);
        fetch.addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                remoteConfig.fetchAndActivate();
                updateMaxLength();
            }
        });


        createRoombut = findViewById(R.id.createButton);
        roomCode = findViewById(R.id.roomCode);

        MajorD1 = findViewById(R.id.MajorDeduction_1);
        MajorD2 = findViewById(R.id.MajorDeduction_2);
        MajorD3 = findViewById(R.id.MajorDeduction_3);
        MajorD4 = findViewById(R.id.MajorDeduction_4);
        MajorD5 = findViewById(R.id.MajorDeduction_5);
        MajorD6 = findViewById(R.id.MajorDeduction_6);

        MinorD1 = findViewById(R.id.MinorDeduction_1);
        MinorD2 = findViewById(R.id.MinorDeduction_2);
        MinorD3 = findViewById(R.id.MinorDeduction_3);
        MinorD4 = findViewById(R.id.MinorDeduction_4);
        MinorD5 = findViewById(R.id.MinorDeduction_5);
        MinorD6 = findViewById(R.id.MinorDeduction_6);

        timing1 = findViewById(R.id.timing1);
        timing2 = findViewById(R.id.timing2);
        timing3 = findViewById(R.id.timing3);
        timing4 = findViewById(R.id.timing4);
        timing5 = findViewById(R.id.timing5);
        timing6 = findViewById(R.id.timing6);

        p5 = findViewById(R.id.timingRefresh);

        m11 = findViewById(R.id.P1J1);
        m12 = findViewById(R.id.P1J2);
        m13 = findViewById(R.id.P1J3);
        m14 = findViewById(R.id.P1J4);

        m21 = findViewById(R.id.P2J1);
        m22 = findViewById(R.id.P2J2);
        m23 = findViewById(R.id.P2J3);
        m24 = findViewById(R.id.P2J4);

        m31 = findViewById(R.id.P3J1);
        m32 = findViewById(R.id.P3J2);
        m33 = findViewById(R.id.P3J3);
        m34 = findViewById(R.id.P3J4);

        m41 = findViewById(R.id.P4J1);
        m42 = findViewById(R.id.P4J2);
        m43 = findViewById(R.id.P4J3);
        m44 = findViewById(R.id.P4J4);

        m51 = findViewById(R.id.P5J1);
        m52 = findViewById(R.id.P5J2);
        m53 = findViewById(R.id.P5J3);
        m54 = findViewById(R.id.P5J4);

        m61 = findViewById(R.id.P6J1);
        m62 = findViewById(R.id.P6J2);
        m63 = findViewById(R.id.P6J3);
        m64 = findViewById(R.id.P6J4);

        p1 = findViewById(R.id.Player1Refresh);
        p2 = findViewById(R.id.Player2Refresh);
        p3 = findViewById(R.id.Player3Refresh);
        p4 = findViewById(R.id.Player4Refresh);


        card_1 = findViewById(R.id.Card1);
        card_2 = findViewById(R.id.Card2);
        card_3 = findViewById(R.id.Card3);
        card_4 = findViewById(R.id.Card4);
        card_5 = findViewById(R.id.Card5);
        card_6 = findViewById(R.id.Card6);


        add = findViewById(R.id.ADD_1);
        add2 = findViewById(R.id.ADD_2);
        add3 = findViewById(R.id.ADD_3);
        add4 = findViewById(R.id.ADD_4);
        add5 = findViewById(R.id.ADD_5);
        add6 = findViewById(R.id.ADD_6);


        generatePDF = findViewById(R.id.GeneratePDF);
        generatePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (EditTextName.length() == 0) {

                    EditTextName.setText("-");
                }
                if (EditTextName2.length() == 0) {

                    EditTextName2.setText("-");
                }
                if (EditTextName3.length() == 0) {

                    EditTextName3.setText("-");
                }
                if (EditTextName4.length() == 0) {

                    EditTextName4.setText("-");
                }
                if (EditTextName5.length() == 0) {

                    EditTextName5.setText("-");
                }
                if (EditTextName6.length() == 0) {

                    EditTextName6.setText("-");
                }
                if (competitionName.length() == 0) {
                    competitionName.setError("Competition Name is Required");
                    Toast.makeText(PoleMallakhamb.this, "Competition Name is Required", Toast.LENGTH_SHORT).show();
                }
                if (EditTextAge6.length() == 0) {
                    EditTextAge6.setError("Enter Player's Age Category");
                    Toast.makeText(PoleMallakhamb.this, "Enter Player's Age Category", Toast.LENGTH_SHORT).show();
                }
                if (EditTextRepresent.length() == 0) {
                    EditTextRepresent.setError("Enter Player's Team");
                    Toast.makeText(PoleMallakhamb.this, "Enter Player's Team", Toast.LENGTH_SHORT).show();
                } else {


                    String time1 = timing1.getText().toString();
                    String time2 = timing2.getText().toString();
                    String time3 = timing3.getText().toString();
                    String time4 = timing4.getText().toString();
                    String time5 = timing5.getText().toString();
                    String time6 = timing6.getText().toString();
                    String CompName = competitionName.getText().toString();
                    String TeamName = EditTextRepresent.getText().toString();
                    String AgeGrp = EditTextAge6.getText().toString();
                    String playerName1 = EditTextName.getText().toString();
                    String playerName2 = EditTextName2.getText().toString();
                    String playerName3 = EditTextName3.getText().toString();
                    String playerName4 = EditTextName4.getText().toString();
                    String playerName5 = EditTextName5.getText().toString();
                    String playerName6 = EditTextName6.getText().toString();
                    String grandTotal = total.getText().toString();
                    String grandTotal2 = total2.getText().toString();
                    String grandTotal3 = total3.getText().toString();
                    String grandTotal4 = total4.getText().toString();
                    String grandTotal5 = total5.getText().toString();
                    String grandTotal6 = total6.getText().toString();
                    String s11 = m11.getText().toString();
                    String s12 = m12.getText().toString();
                    String s13 = m13.getText().toString();
                    String s14 = m14.getText().toString();
                    String s21 = m21.getText().toString();
                    String s22 = m22.getText().toString();
                    String s23 = m23.getText().toString();
                    String s24 = m24.getText().toString();
                    String s31 = m31.getText().toString();
                    String s32 = m32.getText().toString();
                    String s33 = m33.getText().toString();
                    String s34 = m34.getText().toString();
                    String s41 = m41.getText().toString();
                    String s42 = m42.getText().toString();
                    String s43 = m43.getText().toString();
                    String s44 = m44.getText().toString();
                    String s51 = m51.getText().toString();
                    String s52 = m52.getText().toString();
                    String s53 = m53.getText().toString();
                    String s54 = m54.getText().toString();
                    String s61 = m61.getText().toString();
                    String s62 = m62.getText().toString();
                    String s63 = m63.getText().toString();
                    String s64 = m64.getText().toString();
                    String ref = "0";

                    if (s11.equals(ref) || s12.equals(ref) || s13.equals(ref) || s14.equals(ref) || s21.equals(ref) || s22.equals(ref) ||
                            s23.equals(ref) || s24.equals(ref) || s31.equals(ref) || s32.equals(ref) || s33.equals(ref) || s34.equals(ref) ||
                            s41.equals(ref) || s42.equals(ref) || s43.equals(ref) || s44.equals(ref) || s51.equals(ref) || s52.equals(ref) ||
                            s53.equals(ref) || s54.equals(ref) || s61.equals(ref) || s62.equals(ref) || s63.equals(ref) || s64.equals(ref)) {
                        Toast.makeText(PoleMallakhamb.this, "Make Sure to Refresh Judges Score", Toast.LENGTH_SHORT).show();
                    } else {

                        try {
                            createPdf(CompName, TeamName, AgeGrp,
                                    playerName1, playerName2, playerName3, playerName4, playerName5, playerName6,
                                    grandTotal, grandTotal2, grandTotal3, grandTotal4, grandTotal5, grandTotal6,
                                    s11, s21, s31, s41, s51, s61,
                                    s12, s22, s32, s42, s52, s62,
                                    s13, s23, s33, s43, s53, s63,
                                    s14, s24, s34, s44, s54, s64,
                                    time1, time2, time3, time4, time5, time6);


                        } catch (FileNotFoundException e) {
                            Toast.makeText(PoleMallakhamb.this, "Moved To createPdf" + e, Toast.LENGTH_SHORT).show();
                            competitionName.setText(e.toString());
                        }
                        if (mInterstitialAds.isLoaded()) {
                            mInterstitialAds.show();
                            finish();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                    }



                }

            }
        });


        competitionName = findViewById(R.id.CompetitionName);



        difficulty = findViewById(R.id.difficultyMark_1);
        difficulty2 = findViewById(R.id.difficultyMark_2);
        difficulty3 = findViewById(R.id.difficultyMark_3);
        difficulty4 = findViewById(R.id.difficultyMark_4);
        difficulty5 = findViewById(R.id.difficultyMark_5);
        difficulty6 = findViewById(R.id.difficultyMark_6);


        combination = findViewById(R.id.CombinationMark_1);
        combination2 = findViewById(R.id.CombinationMark_2);
        combination3 = findViewById(R.id.CombinationMark_3);
        combination4 = findViewById(R.id.CombinationMark_4);
        combination5 = findViewById(R.id.CombinationMark_5);
        combination6 = findViewById(R.id.CombinationMark_6);


        execution = findViewById(R.id.ExecutionMark_1);
        execution2 = findViewById(R.id.ExecutionMark_2);
        execution3 = findViewById(R.id.ExecutionMark_3);
        execution4 = findViewById(R.id.ExecutionMark_4);
        execution5 = findViewById(R.id.ExecutionMark_5);
        execution6 = findViewById(R.id.ExecutionMark_6);


        originality = findViewById(R.id.originalityMark_1);
        originality2 = findViewById(R.id.originalityMark_2);
        originality3 = findViewById(R.id.originalityMark_3);
        originality4 = findViewById(R.id.originalityMark_4);
        originality5 = findViewById(R.id.originalityMark_5);
        originality6 = findViewById(R.id.originalityMark_6);


        total = findViewById(R.id.Total_1);
        total2 = findViewById(R.id.Total_2);
        total3 = findViewById(R.id.Total_3);
        total4 = findViewById(R.id.Total_4);
        total5 = findViewById(R.id.Total_5);
        total6 = findViewById(R.id.Total_6);


        EditTextName = findViewById(R.id.playerName_1);
        EditTextName2 = findViewById(R.id.playerName_2);
        EditTextName3 = findViewById(R.id.playerName_3);
        EditTextName4 = findViewById(R.id.playerName_4);
        EditTextName5 = findViewById(R.id.playerName_5);
        EditTextName6 = findViewById(R.id.playerName_6);


        EditTextRepresent = findViewById(R.id.playerRepresenting);


        EditTextAge6 = findViewById(R.id.playerAgeCategory);


        getBackToPlayer1 = findViewById(R.id.toPlayer1);
        getBackToPlayer2 = findViewById(R.id.toPlayer2);
        getBackToPlayer3 = findViewById(R.id.toPlayer3);
        getBackToPlayer4 = findViewById(R.id.toPlayer4);
        getBackToPlayer5 = findViewById(R.id.toPlayer5);


        reset = findViewById(R.id.ResetButton_1);
        reset2 = findViewById(R.id.ResetButton_2);
        reset3 = findViewById(R.id.ResetButton_3);
        reset4 = findViewById(R.id.ResetButton_4);
        reset5 = findViewById(R.id.ResetButton_5);
        reset6 = findViewById(R.id.ResetButton_6);

        createRoombut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age= "Age Category";
                if (roomCode.getText().length() == 0||competitionName.getText().length()==0|| EditTextAge6.getText().toString().equals(age)) {

                    Toast.makeText(PoleMallakhamb.this, "Enter Room Code & Competition name & Age Group", Toast.LENGTH_SHORT).show();
                    roomCode.setError("Room Code is required");
                    competitionName.setError("Competition name is required");
                    EditTextAge6.setError("Age Group is required");
                } else {

                    roomCode.setError(null);
                    competitionName.setError(null);
                    EditTextAge6.setError(null);
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                            collection(roomCode.getText().toString().trim().toLowerCase());


                   collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                Toast.makeText(PoleMallakhamb.this, "Room Code Already Taken choose different code", Toast.LENGTH_SHORT).show();
                            } else {

                                Map<String, String> user = new HashMap<>();
                                user.put("Total1", "0.0");
                                user.put("Total2", "0.0");
                                user.put("Total3", "0.0");
                                user.put("Total4", "0.0");
                                user.put("Total5", "0.0");
                                user.put("Total6", "0.0");


                               collectionReference.document("Chief Judge").set(user);
                               collectionReference.document("Judge 1").set(user);
                                collectionReference.document("Judge 2").set(user);
                              collectionReference.document("Judge 3").set(user);
                                collectionReference.document("Judge 4").set(user);
                               collectionReference.document("Timer").set(user);

                                card_1.setVisibility(View.VISIBLE);

                                createRoombut.setVisibility(View.INVISIBLE);
                            }
                        }
                    });


                }


            }
        });


        getBackToPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_1.setVisibility(View.VISIBLE);
                card_2.setVisibility(View.GONE);

            }
        });
        getBackToPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_2.setVisibility(View.VISIBLE);
                card_3.setVisibility(View.GONE);

            }
        });
        getBackToPlayer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_3.setVisibility(View.VISIBLE);
                card_4.setVisibility(View.GONE);

            }
        });
        getBackToPlayer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_4.setVisibility(View.VISIBLE);
                card_5.setVisibility(View.GONE);

            }
        });
        getBackToPlayer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_5.setVisibility(View.VISIBLE);
                card_6.setVisibility(View.GONE);

            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total.setVisibility(View.INVISIBLE);
                difficulty.setText(null);
                combination.setText(null);
                execution.setText(null);
                originality.setText(null);
                EditTextName.setText(null);
                MinorD1.setText(null);
                MajorD1.setText(null);

            }
        });

        reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total2.setVisibility(View.INVISIBLE);
                difficulty2.setText(null);
                combination2.setText(null);
                execution2.setText(null);
                originality2.setText(null);
                EditTextName2.setText(null);
                MinorD2.setText(null);
                MajorD2.setText(null);

            }
        });
        reset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total3.setVisibility(View.INVISIBLE);
                difficulty3.setText(null);
                combination3.setText(null);
                execution3.setText(null);
                originality3.setText(null);
                EditTextName3.setText(null);
                MinorD3.setText(null);
                MajorD3.setText(null);

            }
        });
        reset4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total4.setVisibility(View.INVISIBLE);
                difficulty4.setText(null);
                combination4.setText(null);
                execution4.setText(null);
                originality4.setText(null);
                EditTextName4.setText(null);
                MinorD4.setText(null);
                MajorD4.setText(null);

            }
        });
        reset5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total5.setVisibility(View.INVISIBLE);
                difficulty5.setText(null);
                combination5.setText(null);
                execution5.setText(null);
                originality5.setText(null);
                EditTextName5.setText(null);
                MinorD5.setText(null);
                MajorD5.setText(null);

            }
        });
        reset6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total6.setVisibility(View.INVISIBLE);
                difficulty6.setText(null);
                combination6.setText(null);
                execution6.setText(null);
                originality6.setText(null);
                EditTextName6.setText(null);
                MinorD6.setText(null);
                MajorD6.setText(null);

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roomCode.getText().length() == 0) {
                    Toast.makeText(PoleMallakhamb.this, "Enter the Room Code", Toast.LENGTH_SHORT).show();
                } else {


                    String collectionID = firebaseAuth.getCurrentUser().getEmail();
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                    collection(roomCode.getText().toString().trim().toLowerCase());

                    collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                if (difficulty.getText().length() == 0) {
                                    difficulty.setText("0.0");
                                }
                                if (combination.getText().length() == 0) {
                                    combination.setText("0.0");
                                }
                                if (execution.getText().length() == 0) {
                                    execution.setText("0.0");
                                }
                                if (originality.getText().length() == 0) {
                                    originality.setText("0.0");
                                }
                                if (MinorD1.getText().length() == 0) {
                                    MinorD1.setText("0");
                                }
                                if (MajorD1.getText().length() == 0) {
                                    MajorD1.setText("0");
                                }
                                if (TextUtils.isEmpty(competitionName.getText())) {
                                    competitionName.setError("Name of the Competition is Required");
                                }
                                if (TextUtils.isEmpty(EditTextRepresent.getText())) {
                                    EditTextRepresent.setError("Mention Player's Team Name");
                                }
                                if (TextUtils.isEmpty(EditTextName.getText())) {
                                    EditTextName.setError("Player's Name is Required");
                                }
                                if (TextUtils.isEmpty(EditTextAge6.getText())) {
                                    EditTextAge6.setError("Mention Player's Age Category");
                                }

                                total.setText(String.valueOf(sum(Float.parseFloat(difficulty.getText().toString()),
                                        Float.parseFloat(combination.getText().toString()),
                                        Float.parseFloat(execution.getText().toString()),
                                        Float.parseFloat(originality.getText().toString()), Float.parseFloat(MinorD1.getText().toString())
                                        , Float.parseFloat(MajorD1.getText().toString()))));
                                total.setVisibility(View.VISIBLE);

                                card_1.setVisibility(View.GONE);
                                card_2.setVisibility(View.VISIBLE);
                                Map<String, String> user = new HashMap<>();
                                user.put("Total1", total.getText().toString());
                                collectionReference.document("Chief Judge").set(user);
                            } else {
                                Toast.makeText(PoleMallakhamb.this, "check room code", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collectionID = firebaseAuth.getCurrentUser().getEmail();
                collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                        .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                collection(roomCode.getText().toString().trim().toLowerCase());

                collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            if (TextUtils.isEmpty(EditTextRepresent.getText())) {
                                EditTextRepresent.setError("Mention Player's Team Name");
                            }
                            if (TextUtils.isEmpty(EditTextName2.getText())) {
                                EditTextName2.setError("Player's Name is Required");
                            }
                            if (TextUtils.isEmpty(EditTextAge6.getText())) {
                                EditTextAge6.setError("Mention Player's Age Category");
                            }
                            if (difficulty2.getText().length() <= 0) {
                                difficulty2.setText("0.0");
                            }
                            if (combination2.getText().length() <= 0) {
                                combination2.setText("0.0");
                            }
                            if (execution2.getText().length() <= 0) {
                                execution2.setText("0.0");
                            }
                            if (originality2.getText().length() <= 0) {
                                originality2.setText("0.0");
                            }
                            if (MinorD2.getText().length() == 0) {
                                MinorD2.setText("0");
                            }
                            if (MajorD2.getText().length() == 0) {
                                MajorD2.setText("0");
                            }
                            total2.setText(String.valueOf(sum(Float.parseFloat(difficulty2.getText().toString()),
                                    Float.parseFloat(combination2.getText().toString()),
                                    Float.parseFloat(execution2.getText().toString()),
                                    Float.parseFloat(originality2.getText().toString()), Float.parseFloat(MajorD2.getText().toString())
                                    , Float.parseFloat(MinorD2.getText().toString()))));

                            total2.setVisibility(View.VISIBLE);

                            card_2.setVisibility(View.GONE);
                            card_3.setVisibility(View.VISIBLE);

                            Map<String, String> user = new HashMap<>();
                            user.put("Total1", total.getText().toString());
                            user.put("Total2", total2.getText().toString());


                          collectionReference.document("Chief Judge").set(user);
                        } else {
                            Toast.makeText(PoleMallakhamb.this, "Check Room Code", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collectionID = firebaseAuth.getCurrentUser().getEmail();
                collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                        .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                collection(roomCode.getText().toString().trim().toLowerCase());

                collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            if (TextUtils.isEmpty(EditTextRepresent.getText())) {
                                EditTextRepresent.setError("Mention Player's Team Name");
                            }
                            if (TextUtils.isEmpty(EditTextName3.getText())) {
                                EditTextName3.setError("Player's Name is Required");
                            }
                            if (TextUtils.isEmpty(EditTextAge6.getText())) {
                                EditTextAge6.setError("Mention Player's Age Category");
                            }
                            if (TextUtils.isEmpty(difficulty3.getText())) {
                                difficulty3.setText("0.0");
                            }
                            if (TextUtils.isEmpty(combination3.getText())) {
                                combination3.setText("0.0");
                            }
                            if (TextUtils.isEmpty(execution3.getText())) {
                                execution3.setText("0.0");
                            }
                            if (TextUtils.isEmpty(originality3.getText())) {
                                originality3.setText("0.0");
                            }
                            if (MinorD3.getText().length() == 0) {
                                MinorD3.setText("0");
                            }
                            if (MajorD3.getText().length() == 0) {
                                MajorD3.setText("0");
                            }
                            total3.setText(String.valueOf(sum(Float.parseFloat(difficulty3.getText().toString()),
                                    Float.parseFloat(combination3.getText().toString()),
                                    Float.parseFloat(execution3.getText().toString()),
                                    Float.parseFloat(originality3.getText().toString()), Float.parseFloat(MajorD3.getText().toString())
                                    , Float.parseFloat(MinorD3.getText().toString()))));

                            total3.setVisibility(View.VISIBLE);

                            card_3.setVisibility(View.GONE);
                            card_4.setVisibility(View.VISIBLE);

                            Map<String, String> user = new HashMap<>();
                            user.put("Total1", total.getText().toString());
                            user.put("Total2", total2.getText().toString());
                            user.put("Total3", total3.getText().toString());


                           collectionReference.document("Chief Judge").set(user);
                        } else {
                            Toast.makeText(PoleMallakhamb.this, "Check Room Code", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collectionID = firebaseAuth.getCurrentUser().getEmail();
                collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                        .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                collection(roomCode.getText().toString().trim().toLowerCase());

                collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            if (TextUtils.isEmpty(EditTextRepresent.getText())) {
                                EditTextRepresent.setError("Mention Player's Team Name");
                            }
                            if (TextUtils.isEmpty(EditTextName4.getText())) {
                                EditTextName4.setError("Player's Name is Required");
                            }
                            if (TextUtils.isEmpty(EditTextAge6.getText())) {
                                EditTextAge6.setError("Mention Player's Age Category");
                            }
                            if (TextUtils.isEmpty(difficulty4.getText())) {
                                difficulty4.setText("0.0");
                            }
                            if (TextUtils.isEmpty(combination4.getText())) {
                                combination4.setText("0.0");
                            }
                            if (TextUtils.isEmpty(execution4.getText())) {
                                execution4.setText("0.0");
                            }
                            if (TextUtils.isEmpty(originality4.getText())) {
                                originality4.setText("0.0");
                            }
                            if (MinorD4.getText().length() == 0) {
                                MinorD4.setText("0");
                            }
                            if (MajorD4.getText().length() == 0) {
                                MajorD4.setText("0");
                            }
                            total4.setText(String.valueOf(sum(Float.parseFloat(difficulty4.getText().toString()),
                                    Float.parseFloat(combination4.getText().toString()),
                                    Float.parseFloat(execution4.getText().toString()),
                                    Float.parseFloat(originality4.getText().toString()), Float.parseFloat(MajorD4.getText().toString())
                                    , Float.parseFloat(MinorD4.getText().toString()))));

                            total4.setVisibility(View.VISIBLE);

                            card_4.setVisibility(View.GONE);
                            card_5.setVisibility(View.VISIBLE);

                            Map<String, String> user = new HashMap<>();
                            user.put("Total1", total.getText().toString());
                            user.put("Total2", total2.getText().toString());
                            user.put("Total3", total3.getText().toString());
                            user.put("Total4", total4.getText().toString());


                            collectionReference.document("Chief Judge").set(user);

                        } else {
                            Toast.makeText(PoleMallakhamb.this, "Check Room Code", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collectionID = firebaseAuth.getCurrentUser().getEmail();
                collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                        .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                collection(roomCode.getText().toString().trim().toLowerCase());
                collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            if (TextUtils.isEmpty(EditTextRepresent.getText())) {
                                EditTextRepresent.setError("Mention Player's Team Name");
                            }
                            if (TextUtils.isEmpty(EditTextName5.getText())) {
                                EditTextName5.setError("Player's Name is Required");
                            }
                            if (TextUtils.isEmpty(EditTextAge6.getText())) {
                                EditTextAge6.setError("Mention Player's Age Category");
                            }
                            if (TextUtils.isEmpty(difficulty5.getText())) {
                                difficulty5.setText("0.0");
                            }
                            if (TextUtils.isEmpty(combination5.getText())) {
                                combination5.setText("0.0");
                            }
                            if (TextUtils.isEmpty(execution5.getText())) {
                                execution5.setText("0.0");
                            }
                            if (TextUtils.isEmpty(originality5.getText())) {
                                originality5.setText("0.0");
                            }
                            if (MinorD5.getText().length() == 0) {
                                MinorD5.setText("0");
                            }
                            if (MajorD5.getText().length() == 0) {
                                MajorD5.setText("0");
                            }

                            total5.setText(String.valueOf(sum(Float.parseFloat(difficulty5.getText().toString()),
                                    Float.parseFloat(combination5.getText().toString()),
                                    Float.parseFloat(execution5.getText().toString()),
                                    Float.parseFloat(originality5.getText().toString()), Float.parseFloat(MajorD5.getText().toString()),
                                    Float.parseFloat(MinorD5.getText().toString()))));

                            total5.setVisibility(View.VISIBLE);

                            card_5.setVisibility(View.GONE);
                            card_6.setVisibility(View.VISIBLE);

                            Map<String, String> user = new HashMap<>();
                            user.put("Total1", total.getText().toString());
                            user.put("Total2", total2.getText().toString());
                            user.put("Total3", total3.getText().toString());
                            user.put("Total4", total4.getText().toString());
                            user.put("Total5", total5.getText().toString());


                            collectionReference.document("Chief Judge").set(user);

                        } else {
                            Toast.makeText(PoleMallakhamb.this, "Check room code", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });


        add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collectionID = firebaseAuth.getCurrentUser().getEmail();
                collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                        .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                collection(roomCode.getText().toString().trim().toLowerCase());
                collectionReference.document("Chief Judge").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            if (TextUtils.isEmpty(EditTextRepresent.getText())) {
                                EditTextRepresent.setError("Mention Player's Team Name");
                            }
                            if (TextUtils.isEmpty(EditTextName6.getText())) {
                                EditTextName6.setError("Player's Name is Required");
                            }
                            if (TextUtils.isEmpty(EditTextAge6.getText())) {
                                EditTextAge6.setError("Mention Player's Age Category");
                            }
                            if (TextUtils.isEmpty(difficulty6.getText())) {
                                difficulty6.setText("0.0");
                            }
                            if (TextUtils.isEmpty(combination6.getText())) {
                                combination6.setText("0.0");
                            }
                            if (TextUtils.isEmpty(execution6.getText())) {
                                execution6.setText("0.0");
                            }
                            if (TextUtils.isEmpty(originality6.getText())) {
                                originality6.setText("0.0");
                            }
                            if (MinorD6.getText().length() == 0) {
                                MinorD6.setText("0");
                            }
                            if (MajorD6.getText().length() == 0) {
                                MajorD6.setText("0");
                            }

                            total6.setText(String.valueOf(sum(Float.parseFloat(difficulty6.getText().toString()),
                                    Float.parseFloat(combination6.getText().toString()),
                                    Float.parseFloat(execution6.getText().toString()),
                                    Float.parseFloat(originality6.getText().toString()), Float.parseFloat(MajorD6.getText().toString()),
                                    Float.parseFloat(MinorD6.getText().toString()))));

                            total6.setVisibility(View.VISIBLE);


                            Map<String, String> user = new HashMap<>();
                            user.put("Total1", total.getText().toString());
                            user.put("Total2", total2.getText().toString());
                            user.put("Total3", total3.getText().toString());
                            user.put("Total4", total4.getText().toString());
                            user.put("Total5", total5.getText().toString());
                            user.put("Total6", total6.getText().toString());


                            generatePDF.setVisibility(View.VISIBLE);


                           collectionReference.document("Chief Judge").set(user);
                        } else {
                            Toast.makeText(PoleMallakhamb.this, "Check room code", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roomCode.getText().length() == 0||competitionName.getText().length()==0||EditTextAge6.getText().length()==0) {
                    Toast.makeText(PoleMallakhamb.this, "Enter Room Code & Competition name & Age Group", Toast.LENGTH_SHORT).show();
                    roomCode.setError("Room Code is required");
                    competitionName.setError("Competition name is required");
                    EditTextAge6.setError("Age Group is required");
                } else {
                    String collectionID = firebaseAuth.getCurrentUser().getEmail();
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                    collection(roomCode.getText().toString().trim().toLowerCase());
                   collectionReference.document("Judge 1").get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("qq", e.toString());
                        }
                    }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            String T1 = documentSnapshot.getString("Total1");
                            String T2 = documentSnapshot.getString("Total2");
                            String T3 = documentSnapshot.getString("Total3");
                            String T4 = documentSnapshot.getString("Total4");
                            String T5 = documentSnapshot.getString("Total5");
                            String T6 = documentSnapshot.getString("Total6");


                            m11.setText(T1);
                            m21.setText(T2);
                            m31.setText(T3);
                            m41.setText(T4);
                            m51.setText(T5);
                            m61.setText(T6);
                        }
                    });
                }
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roomCode.getText().length() == 0||competitionName.getText().length()==0||EditTextAge6.getText().length()==0) {
                    Toast.makeText(PoleMallakhamb.this, "Enter Room Code & Competition name & Age Group", Toast.LENGTH_SHORT).show();
                    roomCode.setError("Room Code is required");
                    competitionName.setError("Competition name is required");
                    EditTextAge6.setError("Age Group is required");
                } else {
                    String collectionID = firebaseAuth.getCurrentUser().getEmail();
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                    collection(roomCode.getText().toString().trim().toLowerCase());
                    collectionReference.document("Judge 2").get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("qq", e.toString());
                        }
                    }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            String T1 = documentSnapshot.getString("Total1");
                            String T2 = documentSnapshot.getString("Total2");
                            String T3 = documentSnapshot.getString("Total3");
                            String T4 = documentSnapshot.getString("Total4");
                            String T5 = documentSnapshot.getString("Total5");
                            String T6 = documentSnapshot.getString("Total6");


                            m12.setText(T1);
                            m22.setText(T2);
                            m32.setText(T3);
                            m42.setText(T4);
                            m52.setText(T5);
                            m62.setText(T6);
                        }
                    });
                }
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roomCode.getText().length() == 0||competitionName.getText().length()==0||EditTextAge6.getText().length()==0) {
                    Toast.makeText(PoleMallakhamb.this, "Enter Room Code & Competition name & Age Group", Toast.LENGTH_SHORT).show();
                    roomCode.setError("Room Code is required");
                    competitionName.setError("Competition name is required");
                    EditTextAge6.setError("Age Group is required");
                } else {
                    String collectionID = firebaseAuth.getCurrentUser().getEmail();
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                    collection(roomCode.getText().toString().trim().toLowerCase());
                   collectionReference.document("Judge 3").get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("qq", e.toString());
                        }
                    }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            String T1 = documentSnapshot.getString("Total1");
                            String T2 = documentSnapshot.getString("Total2");
                            String T3 = documentSnapshot.getString("Total3");
                            String T4 = documentSnapshot.getString("Total4");
                            String T5 = documentSnapshot.getString("Total5");
                            String T6 = documentSnapshot.getString("Total6");


                            m13.setText(T1);
                            m23.setText(T2);
                            m33.setText(T3);
                            m43.setText(T4);
                            m53.setText(T5);
                            m63.setText(T6);
                        }
                    });
                }
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roomCode.getText().length() == 0||competitionName.getText().length()==0||EditTextAge6.getText().length()==0) {
                    Toast.makeText(PoleMallakhamb.this, "Enter Room Code & Competition name & Age Group", Toast.LENGTH_SHORT).show();
                    roomCode.setError("Room Code is required");
                    competitionName.setError("Competition name is required");
                    EditTextAge6.setError("Age Group is required");
                } else {
                    String collectionID = firebaseAuth.getCurrentUser().getEmail();
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                    collection(roomCode.getText().toString().trim().toLowerCase());
                    collectionReference.document("Judge 4").get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("qq", e.toString());
                        }
                    }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            String T1 = documentSnapshot.getString("Total1");
                            String T2 = documentSnapshot.getString("Total2");
                            String T3 = documentSnapshot.getString("Total3");
                            String T4 = documentSnapshot.getString("Total4");
                            String T5 = documentSnapshot.getString("Total5");
                            String T6 = documentSnapshot.getString("Total6");


                            m14.setText(T1);
                            m24.setText(T2);
                            m34.setText(T3);
                            m44.setText(T4);
                            m54.setText(T5);
                            m64.setText(T6);
                        }
                    });
                }
            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roomCode.getText().length() == 0||competitionName.getText().length()==0||EditTextAge6.getText().length()==0) {
                    Toast.makeText(PoleMallakhamb.this, "Enter Room Code & Competition name & Age Group", Toast.LENGTH_SHORT).show();
                    roomCode.setError("Room Code is required");
                    competitionName.setError("Competition name is required");
                    EditTextAge6.setError("Age Group is required");
                } else {
                    String collectionID = firebaseAuth.getCurrentUser().getEmail();
                    collectionReference = fStore.collection(competitionName.getText().toString().trim().toLowerCase())
                            .document(EditTextAge6.getText().toString().trim().toLowerCase()).
                                    collection(roomCode.getText().toString().trim().toLowerCase());
                    collectionReference.document("Timer").get().addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("qq", e.toString());
                        }
                    }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            String T1 = documentSnapshot.getString("Total1");
                            String T2 = documentSnapshot.getString("Total2");
                            String T3 = documentSnapshot.getString("Total3");
                            String T4 = documentSnapshot.getString("Total4");
                            String T5 = documentSnapshot.getString("Total5");
                            String T6 = documentSnapshot.getString("Total6");


                            timing1.setText(T1);
                            timing2.setText(T2);
                            timing3.setText(T3);
                            timing4.setText(T4);
                            timing5.setText(T5);
                            timing6.setText(T6);
                        }
                    });
                }
            }
        });


    }

    private void updateMaxLength() {
        int max = (int) remoteConfig.getLong("max_chars");
        roomCode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max)});
    }


    private void createPdf(String CompName, String TeamName, String AgeGrp,
                           String playerName1, String playerName2, String playerName3, String playerName4, String playerName5, String playerName6,
                           String cJTotal1, String cJTotal2, String cJTotal3, String cJTotal4, String cJTotal5, String cJTotal6,
                           String j1Total1, String j1Total2, String j1Total3, String j1Total4, String j1Total5, String j1Total6,
                           String j2Total1, String j2Total2, String j2Total3, String j2Total4, String j2Total5, String j2Total6,
                           String j3Total1, String j3Total2, String j3Total3, String j3Total4, String j3Total5, String j3Total6,
                           String j4Total1, String j4Total2, String j4Total3, String j4Total4, String j4Total5, String j4Total6,
                           String t1, String t2, String t3, String t4, String t5, String t6) throws FileNotFoundException {


        String player1total = String.valueOf(finalScore(Float.parseFloat(j1Total1), Float.parseFloat(j2Total1), Float.parseFloat(j3Total1), Float.parseFloat(j4Total1),
                Float.parseFloat(cJTotal1)));
        String player2total = String.valueOf(finalScore(Float.parseFloat(j1Total2), Float.parseFloat(j2Total2), Float.parseFloat(j3Total2), Float.parseFloat(j4Total2),
                Float.parseFloat(cJTotal2)));
        String player3total = String.valueOf(finalScore(Float.parseFloat(j1Total3), Float.parseFloat(j2Total3), Float.parseFloat(j3Total3), Float.parseFloat(j4Total3),
                Float.parseFloat(cJTotal3)));
        String player4total = String.valueOf(finalScore(Float.parseFloat(j1Total4), Float.parseFloat(j2Total4), Float.parseFloat(j3Total4), Float.parseFloat(j4Total4),
                Float.parseFloat(cJTotal4)));
        String player5total = String.valueOf(finalScore(Float.parseFloat(j1Total5), Float.parseFloat(j2Total5), Float.parseFloat(j3Total5), Float.parseFloat(j4Total5),
                Float.parseFloat(cJTotal5)));
        String player6total = String.valueOf(finalScore(Float.parseFloat(j1Total6), Float.parseFloat(j2Total6), Float.parseFloat(j3Total6), Float.parseFloat(j4Total6),
                Float.parseFloat(cJTotal6)));


        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "ScoreSheet for " + TeamName + ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        Uri uri = Uri.fromFile(file);


        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        pdfDocument.setDefaultPageSize(PageSize.A4);


        document.setMargins(0, 0, 0, 0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        }

        Paragraph CompetitionName = new Paragraph(CompName + "\n").setBold().setFontSize(24).setTextAlignment(TextAlignment.CENTER);
        Paragraph TeamNameHead = new Paragraph("Team: "+TeamName+"\n" ).setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER);
        Paragraph AgeHead = new Paragraph(AgeGrp).setBold().setFontSize(16).setTextAlignment(TextAlignment.CENTER);
        Paragraph Apparatus = new Paragraph("Pole Mallakhamb").setBold().setFontSize(16).setTextAlignment(TextAlignment.CENTER);


        float[] width = {25f, 100f, 100f, 100f, 100f, 100f, 100f, 100f, 100f};
        Table table = new Table(width);
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("S.no"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("Players Name"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("J1"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("J2"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("J3"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("J4"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("SJ"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("Set Timing"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph("Score"))).setTextAlignment(TextAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("1"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(playerName1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j1Total1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j2Total1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j3Total1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j4Total1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(cJTotal1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(t1))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(player1total))).setTextAlignment(TextAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("2"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(playerName2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j1Total2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j2Total2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j3Total2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j4Total2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(cJTotal2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(t2))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(player2total))).setTextAlignment(TextAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("3"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(playerName3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j1Total3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j2Total3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j3Total3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j4Total3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(cJTotal3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(t3))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(player3total))).setTextAlignment(TextAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("4"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(playerName4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j1Total4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j2Total4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j3Total4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j4Total4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(cJTotal4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(t4))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(player4total))).setTextAlignment(TextAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("5"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(playerName5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j1Total5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j2Total5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j3Total5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j4Total5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(cJTotal5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(t5))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(player5total))).setTextAlignment(TextAlignment.CENTER);


        table.addCell(new Cell().add(new Paragraph("6"))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(playerName6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j1Total6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j2Total6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j3Total6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(j4Total6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(cJTotal6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(t6))).setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell().add(new Paragraph(player6total))).setTextAlignment(TextAlignment.CENTER);


        document.add(CompetitionName);
        document.add(TeamNameHead);
        document.add(AgeHead);
        document.add(Apparatus);
        document.add(table);

        document.close();

        Toast.makeText(PoleMallakhamb.this, "Pdf Created @" + pdfPath, Toast.LENGTH_SHORT).show();

        StorageReference reference = fStorage.getReference();
        reference.child(UserEmail).child(CompName).child(TeamName).putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                String url = taskSnapshot.getUploadSessionUri().toString();
                DatabaseReference databaseReference = fDataBase.getReference();

                String f = firebaseAuth.getCurrentUser().getUid();
                databaseReference.child(f).child(CompName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(PoleMallakhamb.this, "Uploaded success", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PoleMallakhamb.this, e.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("SomethingWrong", e.toString());
                    }
                });


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PoleMallakhamb.this, "firebaseDown 23" + e, Toast.LENGTH_SHORT).show();
                Log.d("SomethingWrong", e.toString());

            }
        });

    }

    public double sum(float s, float d, float f, float g, float h, float j) {

        double Z = s + d + f + g - (h * 0.1) - (j * 0.5);
        return Z;

    }

    public float finalScore(float j1, float j2, float j3, float j4, float cj) {

        float H1 = j1;
        float H2 = j2;
        float H3 = j3;
        float H4 = j4;
        float fS = 0;
        float p = cj;

        if (H1 != 0 && H2 != 0 && H3 != 0 && H4 != 0) {  // for 4+1 judges


            float x[] = {H1, H2, H3, H4};
            float y;
            float z;


            float smallest = x[0];
            float largest = x[0];

            for (int in = 0; in <= 3; in++) {
                if (x[in] < smallest) {
                    smallest = x[in];
                }
            }

            for (int i = 0; i <= 3; i++) {
                if (x[i] > largest) {
                    largest = x[i];
                }
            }

            y = (H1 + H2 + H3 + H4 - smallest - largest) / 2;


            if (y < 5 && (p - y > 1 || y - p > 1)) {
                z = (y + cj) / 2;
                 fS=z;
            } else if ((5 < y) && (y <= 6) && (p - y > 0.5 || y - p > 0.5)) {
                z = (y + cj) / 2;
                fS=z;
            } else if ((6 < y) && (y <= 7) && (p - y > 0.4 || y - p > 0.4)) {
                z = (y + cj) / 2;
                fS=z;
            } else if ((7 < y) && (y <= 8) && (p - y > 0.3 || y - p > 0.3)) {
                z = (y + cj) / 2;
                fS=z;
            } else if ((8 < y) && (y <= 9) && (p - y > 0.2 || y - p > 0.2)) {
                z = (y + cj) / 2;
                fS=z;
            } else if ((9 < y) && (y <= 10) && (p - y > 0.1 || y - p > 0.1)) {
                z = (y + cj) / 2;
                fS=z;
            }
            fS=y;
        }

        if (H1 != 0 && H2 != 0 && H3 != 0 && H4 == 0) {    // for 3+1 judges

            float x[] = {H1, H2, H3};
            float y;
            float z;


            float smallest = x[0];
            float largest = x[0];

            for (int in = 0; in <= 3; in++) {
                if (x[in] < smallest) {
                    smallest = x[in];
                }
            }

            for (int i = 0; i <= 3; i++) {
                if (x[i] > largest) {
                    largest = x[i];
                }
            }

            y = ((H1 + H2 + H3  - smallest - largest)+p) /2;

//
//            if (y < 5 && (p - y > 1 || y - p > 1)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((5 < y) && (y <= 6) && (p - y > 0.5 || y - p > 0.5)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((6 < y) && (y <= 7) && (p - y > 0.4 || y - p > 0.4)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((7 < y) && (y <= 8) && (p - y > 0.3 || y - p > 0.3)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((8 < y) && (y <= 9) && (p - y > 0.2 || y - p > 0.2)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((9 < y) && (y <= 10) && (p - y > 0.1 || y - p > 0.1)) {
//                z = (y + cj) / 2;
//                fS=z;
//            }
            fS=y;
        }

        if (H1 != 0 && H2 != 0 && H3 == 0 && H4 == 0) {    // for 3+1 judges

            float x[] = {H1, H2};
            float y;
            float z;

            z = (H1 +H2)/2;
            y = (z+p)/2;

//
//            float smallest = x[0];
//            float largest = x[0];
//
//            for (int in = 0; in <= 3; in++) {
//                if (x[in] < smallest) {
//                    smallest = x[in];
//                }
//            }
//
//            for (int i = 0; i <= 3; i++) {
//                if (x[i] > largest) {
//                    largest = x[i];
//                }
//            }
//
//            y = ((H1 + H2 + H3  - smallest - largest)+p) /2;

//
//            if (y < 5 && (p - y > 1 || y - p > 1)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((5 < y) && (y <= 6) && (p - y > 0.5 || y - p > 0.5)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((6 < y) && (y <= 7) && (p - y > 0.4 || y - p > 0.4)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((7 < y) && (y <= 8) && (p - y > 0.3 || y - p > 0.3)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((8 < y) && (y <= 9) && (p - y > 0.2 || y - p > 0.2)) {
//                z = (y + cj) / 2;
//                fS=z;
//            } else if ((9 < y) && (y <= 10) && (p - y > 0.1 || y - p > 0.1)) {
//                z = (y + cj) / 2;
//                fS=z;
//            }
            fS=y;
        }

        if (H1 != 0 && H2 == 0 && H3 == 0 && H4 == 0){    // for 3+1 judges

            float x[] = {H1};
            float y;
            float z;

            z = (H1 +p)/2;

            fS=z;
        }

        return fS;
    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Are you sure want to exit Chief Judging?");
        build.setCancelable(true);
        build.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        build.setCancelable(true);

        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mInterstitialAds.isLoaded()) {
                    mInterstitialAds.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                finish();
            }
        });
        AlertDialog alertDialog = build.create();
        alertDialog.show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        EditTextAge6.setText(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


//    private void initialWork() {
//        OnOff = findViewById(R.id.OnOff);
//        join = findViewById(R.id.Discover);
//        send = findViewById(R.id.Send);
//        list = findViewById(R.id.listNetwork);
//        connectionStatus = findViewById(R.id.conStatus);
//
//        join.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (ActivityCompat.checkSelfPermission(HangingMallakhamb.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                    PermissionUtils.requestPermission(HangingMallakhamb.this,1,Manifest.permission.ACCESS_FINE_LOCATION,true);
//                    Toast.makeText(HangingMallakhamb.this, "Request needed", Toast.LENGTH_SHORT).show();
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
//                    @Override
//                    public void onSuccess() {
//                        connectionStatus.setText("Discovery Started");
//                    }
//
//                    @Override
//                    public void onFailure(int reason) {
//                        connectionStatus.setText("Discovery Failed");
//                        Log.d("Discovery failed",String.valueOf(reason));
//
//                    }
//                });
//            }
//        });
//
//        OnOff.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//                WifiManager wifiManager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);;
//
//                if (wifiManager.isWifiEnabled()){
//                    wifiManager.setWifiEnabled(false);
//
//                }else {
//                    wifiManager.setWifiEnabled(true);
//                    Toast.makeText(HangingMallakhamb.this, "turned on", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
//        mChannel = mManager.initialize(this,getMainLooper(),null);
//
//
//        mReceiver = new WifiDirectBroadcastReceiver(mManager,mChannel,this);
//
//        mIntentFilter = new IntentFilter();
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
//
//    }
//
//    public WifiP2pManager.PeerListListener peerListListener = new WifiP2pManager.PeerListListener() {
//        @Override
//        public void onPeersAvailable(WifiP2pDeviceList peerList) {
//            if (!peerList.getDeviceList().equals(peers)){
//
//                peers.clear();
//                peers.addAll(peerList.getDeviceList());
//
//                deviceNameArray = new String[peerList.getDeviceList().size()];
//                deviceArray = new WifiP2pDevice[peerList.getDeviceList().size()];
//                int index =0;
//
//                for (WifiP2pDevice device : peerList.getDeviceList()){
//
//                    deviceNameArray[index] = device.deviceName;
//                    deviceArray[index] = device;
//                    index++;
//                }
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<String >(getApplicationContext(), android.R.layout.simple_list_item_1,deviceNameArray);
//                list.setAdapter(adapter);
//                if (peers.size()==0){
//                    Toast.makeText(HangingMallakhamb.this, "No Device Found", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//
//        }
//    };
//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(mReceiver,mIntentFilter);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(mReceiver);
//    }
//}
