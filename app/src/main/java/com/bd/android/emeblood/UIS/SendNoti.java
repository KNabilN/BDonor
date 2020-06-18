package com.bd.android.emeblood.UIS;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.bd.android.emeblood.BloodTypes;
import com.bd.android.emeblood.Hospitals;
import com.bd.android.emeblood.R;
import com.bd.android.emeblood.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;

public class SendNoti extends AppCompatActivity{

    public static final String ID = "MVive";
    //x hosp
    //y bt

    FirebaseFirestore firebaseFirestore;
    String name;
    String phn;
    String number_donors;
    String number;
    String pass;
    String des;
    String choose;

    String bt;
    EditText hosname;
    EditText hosadd;

    String hn = "";
    String ha = "";

    boolean y = false;
    private FirebaseFirestore mfirestore;
    User user;
    int counter;


    CheckBox AP;
    CheckBox OP;
    CheckBox BP;
    CheckBox ABP;
    CheckBox AN;
    CheckBox ON;
    CheckBox BN;
    CheckBox ABN;
    CheckBox All;
    FirebaseAuth firebaseAuth;
    FirebaseAuth mAuth;
    public int a = 1;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendnoti);

        firebaseFirestore = FirebaseFirestore.getInstance();
        choose = getIntent().getStringExtra("govern");

        firebaseAuth = FirebaseAuth.getInstance();
       hosname = findViewById(R.id.hosname);
        hosadd = findViewById(R.id.hosadd);

        AP = findViewById(R.id.AP);
        AN = findViewById(R.id.AN);
        ABP = findViewById(R.id.ABP);
        ABN = findViewById(R.id.ABN);
        BP = findViewById(R.id.BP);
        BN = findViewById(R.id.BN);
        OP = findViewById(R.id.OP);
        ON = findViewById(R.id.ON);
        All = findViewById(R.id.all);
        mAuth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();


        All.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b == true) {
                    AP.setChecked(false);
                    AN.setChecked(false);
                    BP.setChecked(false);
                    BN.setChecked(false);
                    OP.setChecked(false);
                    ON.setChecked(false);
                    ABP.setChecked(false);
                    ABN.setChecked(false);
                }
            }
        });


        notificationManager = NotificationManagerCompat.from(this);


    }

    public void sendNot(View view) {
        pass = "";
        bt = "";
        if (AN.isChecked()) {
            bt += "A-" + "\n";
            y = true;
        }
        if (AP.isChecked()) {
            bt += "A+" + "\n";
            y = true;
        }
        if (OP.isChecked()) {
            bt += "O+" + "\n";
            y = true;
        }
        if (ON.isChecked()) {
            bt += "O-" + "\n";
            y = true;
        }
        if (ABN.isChecked()) {
            bt += "AB-" + "\n";
            y = true;
        }
        if (ABP.isChecked()) {
            bt += "AB+" + "\n";
            y = true;
        }
        if (BP.isChecked()) {
            bt += "B+" + "\n";
            y = true;
        }
        if (BN.isChecked()) {
            bt += "B-" + "\n";
            y = true;
        }
        if (All.isChecked()) {
            bt = "Any blood type";
            y = true;
        }
        if (hosname.getText().toString().isEmpty() || hosadd.getText().toString().isEmpty()){
            Toast.makeText(SendNoti.this, "من فضلك أدخل بيانات المستشفى", Toast.LENGTH_LONG).show();

        }else {
            name = getIntent().getStringExtra("mnam");
            phn = getIntent().getStringExtra("phn");
            number_donors = getIntent().getStringExtra("mnum");
            des = getIntent().getStringExtra("des");
            hn = hosname.getText().toString();
            ha = hosadd.getText().toString();

            doIt();
            //Notifications
        }

    }


    // Mails


    private void sendNotification(User user, String hn) {

//        String title = "طوارئ";
//        String body = "نحتاج متبرعين فورا في  " + hn;
////retrofit
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://emeblood-1121998.firebaseapp.com/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        api api = retrofit.create(api.class);
//        Call<ResponseBody> call;
//        call = api.sendNotification(user.token, title, body);
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
        Toast.makeText(SendNoti.this, "Bravooo ", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_Hospitals) {
            Intent intent = new Intent(SendNoti.this, Hospitals.class);
            startActivity(intent);

        } else if (id == R.id.nav_btypes) {
            Intent intent = new Intent(SendNoti.this, BloodTypes.class);
            startActivity(intent);

        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drewer_menu, menu);
        return true;
    }





    public void doIt() {
        if (y) {

            Intent openAct = new Intent(SendNoti.this,Option.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, openAct, 0);
            final String message;
            number = number_donors;
            if (phn.isEmpty() && des.isEmpty()) {
                message = "نحتاج متبرعين فورا في " + hn +
                        "\n  اسم الحالة" + " : " + name
                        + "\n" + " عدد المتبرعين المطلوب : " + number + "\n" +
                        " فصائل الدم المطلوبة \n " + bt
            + "\n"   +"العنوان" + ha;
            } else if (des.isEmpty()) {
                message = "نحتاج متبرعين فورا في " + hn +
                        "\n  اسم الحالة" + " : " + name
                        + "\n  رقم الحالة" + " : " + "\n" + phn
                        + "\n" + " عدد المتبرعين المطلوب : " + number + "\n" +
                        " فصائل الدم المطلوبة \n " + bt
                        + "\n"   +"العنوان" + ha;

            } else {
                message = "نحتاج متبرعين فورا في " + hn +
                        "\n  اسم الحالة" + " : " + name
                        + "\n  رقم الحالة" + " : " + "\n" + phn
                        + "\n  وصف الحالة" + " : " + "\n" + des
                        + "\n" + " عدد المتبرعين المطلوب : " + number + "\n" +
                        " فصائل الدم المطلوبة \n " + bt
                        + "\n"   +"العنوان" + ha;
            }

            @SuppressLint("ResourceAsColor") Notification notificat = new NotificationCompat.Builder(this, ID)
                    .setSmallIcon(R.drawable.ic_small)
                    .setContentTitle("Emergency")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(contentIntent)
                    .setAutoCancel(true)
                    .setColor(R.color.colorAccent)
                    .setOnlyAlertOnce(true)
                    .build();
            notificationManager.notify(1, notificat);


            //////


            final String finalHn = hn;
            mfirestore.collection("counter").document("po5eTpJMuOackuHypZJr").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    long counter = documentSnapshot.getLong("A");
                    int count = (int) counter;
                    count = count + 1;


                    Map<String, Object> userMap = new HashMap<>();
                    userMap.put("message", message);
                    userMap.put("number", number);
                    userMap.put("HN", finalHn);
                    userMap.put("Add", ha);
                    userMap.put("counter", count);


                    final int finalCount = count;
                    mfirestore.collection("Notification").document(Integer.toString(count)).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {


                                Map<String, Object> notiMap = new HashMap<>();
                                notiMap.put("A", finalCount);

                                mfirestore.collection("counter").document("po5eTpJMuOackuHypZJr").set(notiMap);

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    @SuppressLint("WrongConstant") NotificationChannel channel1 = new NotificationChannel(
                                            ID,
                                            "Channel",
                                            NotificationManager.IMPORTANCE_MAX
                                    );
                                    channel1.setDescription("This is Channel 1");


                                    NotificationManager manager = getSystemService(NotificationManager.class);
                                    manager.createNotificationChannel(channel1);

                                }
                                // go to main activity
                                Intent intent = new Intent(SendNoti.this, Option.class);
                                String noti_type = "pat";
                                intent.putExtra("noti_type", noti_type);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                send();
                                startActivity(intent);

                                finish();
                                // go to enable sign in method in firebase
                                // and database to change safty after finish change it to request.auth != null
                            } else {
                                Toast.makeText(SendNoti.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                            }


                        }
                    });
                }
            });


        } else {
            Toast.makeText(SendNoti.this, "Please check a Blood Type", Toast.LENGTH_LONG).show();
        }
    }

        private void send() {

        DatabaseReference db = FirebaseDatabase.getInstance().getReference(choose);
        final String finalHn1 = hn;
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        user = new User();
                        user = ds.getValue(User.class);

                        sendNotification(user, finalHn1);
                        counter ++ ;
                    }
                    Toast.makeText(SendNoti.this, "تم الإرسال إلى "+ counter, Toast.LENGTH_LONG).show();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }





}