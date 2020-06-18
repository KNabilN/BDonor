package com.bd.android.emeblood;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bd.android.emeblood.UIS.Option;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class campaign extends AppCompatActivity implements PassBox.ExampleDialogListener{

    FirebaseFirestore firebaseFirestore;
    String date;
    EditText date_edit ;
    int counter;
    public int a = 1;
    private NotificationManagerCompat notificationManager;
    User user;
    String pass;
    Button send_camp ;
    EditText name_text;
    EditText det_text ;
    EditText address;
    String name ;
    String add ;
    String gov;
    String det = "";
    public static final String ID = "MVive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);
        name_text = findViewById(R.id.edit_camp_name);
        date_edit = findViewById(R.id.edit_camp_date);
        gov = getIntent().getStringExtra("gov");
        det_text = findViewById(R.id.edit_camp_det);
        address = findViewById(R.id.edit_camp_address);
        firebaseFirestore = FirebaseFirestore.getInstance();
        send_camp = findViewById(R.id.btn_send_cam);
                send_camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 name = name_text.getText().toString().trim();
                 add = address.getText().toString().trim();
                 date = date_edit.getText().toString().trim();
                 if (det_text != null) {
                     det = det_text.getText().toString().trim();
                 }
                if (!name.isEmpty() && !add.isEmpty() && !date.isEmpty()){
                    firebaseFirestore.collection("CP").document(
                            "cp").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            pass = documentSnapshot.getString("pass");
                            openDialog();
                        }
                    });



                }else{
                    Toast.makeText(campaign.this, "من فضلك استكمل البيانات", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void openDialog() {
        PassBox exampleDialog = new PassBox();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
    @Override
    public void applyTexts(String password) {

        if (password.equalsIgnoreCase(pass) ) {
            doIt();

        } else {
            Toast.makeText(campaign.this, "الكود خاطئ", Toast.LENGTH_LONG).show();
        }

    }
 public void doIt() {
     final String message;

    if (!det.isEmpty()) {
        message = "محافظة" +" " + gov + "\n" + " \n" +
                "هناك حملة تبرع بالدم تابعة لـ "
                + name + "\n" + " \n" +
                "المكان : " + " \n"
                + add + "\n" + " \n"
                +  "التاريخ : " + " \n" + date + " \n" + " \n"
                + "تفاصيل إضافية : " + "\n" + det;
    }else {
        message = "محافظة" +" " + gov + "\n" + " \n" +
                "هناك حملة تبرع بالدم تابعة لـ " + name + "\n" + " \n" +
                "المكان : " + " \n"
                + add + "\n" + " \n"
                +  "التاريخ : " + " \n" + date + " \n" + " \n" ;
    }

    firebaseFirestore.collection("countercamps").document("a").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @SuppressLint("CheckResult")
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

            long counter = documentSnapshot.getLong("A");
            int count = (int) counter;
            count = count + 1;

            Map<String, Object> userMap = new HashMap<>();
            userMap.put("message", message);
            userMap.put("counter", count);

            final int finalCount = count;
            firebaseFirestore.collection("Camps").document(Integer.toString(count)).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Map<String, Object> notiMap = new HashMap<>();
                        notiMap.put("A", finalCount);

                        firebaseFirestore.collection("countercamps").document("a").set(notiMap);

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
                        Intent intent = new Intent(campaign.this, Option.class);
                        String noti_type = "camp";
                        intent.putExtra("noti_type", noti_type);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        send();
                        startActivity(intent);
                        finish();
                        // go to enable sign in method in firebase
                        // and database to change safty after finish change it to request.auth != null
                    } else {
                        Toast.makeText(campaign.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    });
    }
    private void sendNotification(User user) {
        String title = "حملة تبرع بالدم";
        String body = "ستعقد حملة تبرع بالدم قريبا" ;
//retrofit to post the data
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://emeblood-1121998.firebaseapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api api = retrofit.create(api.class);
        Call<ResponseBody> call;
        call = api.sendNotification(user.token, title, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });

    }

    // send notification using our DB
    private void send() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference(gov);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        user = new User();
                        user = ds.getValue(User.class);
                        sendNotification(user);
                        counter ++ ;
                    }
                    Toast.makeText(campaign.this, "تم الإرسال إلى "+ counter, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
