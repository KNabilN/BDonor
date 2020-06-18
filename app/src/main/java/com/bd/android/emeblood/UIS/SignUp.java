package com.bd.android.emeblood.UIS;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    FirebaseAuth mAuth ;
    private ProgressDialog progressDialog ;
    String blood ;
    EditText uname ;
    boolean type = false ;
    boolean g = false;
    EditText umail ;
    String governorate ;
    String mail_rec = "n";
    String noti_per = "yes";
    EditText upass ;
    String gender ;
    Button signUp ;
    FirebaseFirestore mfirestore;
    CheckBox per_reg ;
    ImageView reg_male;
    ImageView reg_female;
    Button reg_op , reg_on , reg_ap , reg_an , reg_abp , reg_abn , reg_bp , reg_bn , reg_non ;
    private EditText usnumber;
    private EditText repass;



    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Spinner spinner = findViewById(R.id.govern_spinner);
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.governs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        usnumber = findViewById(R.id.unum);
        repass = findViewById(R.id.urepass);
        per_reg = findViewById(R.id.per_reg);
        reg_male = findViewById(R.id.reg_male);
        reg_female = findViewById(R.id.reg_female);
        reg_op = findViewById(R.id.reg_op);
        reg_on = findViewById(R.id.reg_on);
        reg_ap = findViewById(R.id.reg_ap);
        reg_an = findViewById(R.id.reg_an);
        reg_abp = findViewById(R.id.reg_abp);
        reg_abn = findViewById(R.id.reg_abn);
        reg_bp = findViewById(R.id.reg_bp);
        reg_bn = findViewById(R.id.reg_bn);
        reg_non = findViewById(R.id.reg_non);

        //diolog
        progressDialog = new ProgressDialog(SignUp.this);

        //firebase initilization
        mAuth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();



        // spinner

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.BloodTypes, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

// /// /






        reg_non.setOnClickListener(this);
        reg_ap.setOnClickListener(this);
        reg_an.setOnClickListener(this);
        reg_op.setOnClickListener(this);
        reg_on.setOnClickListener(this);
        reg_bp.setOnClickListener(this);
        reg_bn.setOnClickListener(this);
        reg_abp.setOnClickListener(this);
        reg_abn.setOnClickListener(this);

        reg_male.setOnClickListener(this);
        reg_female.setOnClickListener(this);

        uname = findViewById(R.id.uuser);
        umail = findViewById(R.id.umail);
        upass =findViewById(R.id.upass);

        signUp = findViewById(R.id.reg_create_btn);

        signUp.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        final String mName = uname.getText().toString().trim();
        final String mMail = umail.getText().toString().trim();
        final String mNum = usnumber.getText().toString().trim();
        final String re_pass = repass.getText().toString().trim();





        if(view == reg_abn) {
            blood = "AB-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;


        }
         if (view == reg_abp){
            blood = "AB+";
             reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_abp.setBackground(getResources().getDrawable(R.drawable.circlee));
             reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
             reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
             type = true;
         }
        if (view == reg_op){
            blood = "O+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;

        }
        if (view == reg_on){
            blood = "O-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;

        }
        if (view == reg_ap){
            blood = "A+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;
        }
        if (view == reg_an){
            blood = "A-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;
        }
        if (view == reg_bp){
            blood = "B+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;

        }
        if (view == reg_bn){
            blood = "B-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circle));
            type = true;

        }
        if (view == reg_non){
            blood = "NON";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_non.setBackground(getResources().getDrawable(R.drawable.circlee));
            type = true ;


        }
        if(view == reg_male){
            reg_male.setImageResource(R.drawable.mpc);
            gender="male";
            reg_female.setImageResource(R.drawable.fep);
            g = true;
        }
        if(view == reg_female){
            reg_female.setImageResource(R.drawable.fec);
            reg_male.setImageResource(R.drawable.mp);
            gender="female";
            g = true;
        }

        if(per_reg.isChecked()){
            mail_rec = "y";
        }

        final String mPass = upass.getText().toString().trim();
        if (view == signUp) {



                if (mName.isEmpty()) {
                    Toast.makeText(this, "Your Name please", Toast.LENGTH_LONG).show();
                    return;
                }
                if (mMail.isEmpty()) {
                    Toast.makeText(this, "Your Mail please", Toast.LENGTH_LONG).show();
                    return;
                }

                if (mPass.isEmpty()) {
                    Toast.makeText(this, "Your Password please", Toast.LENGTH_LONG).show();
                    //stopping the function executing further
                    return;
                }
            if (re_pass.isEmpty()) {
                Toast.makeText(this, "أعد إدخال كلمة السر من فضلك", Toast.LENGTH_LONG).show();
                //stopping the function executing further
                return;
            }
            if (! mPass.equals(re_pass)) {
                Toast.makeText(this, "الرقم السري غير متطابق", Toast.LENGTH_LONG).show();
                //stopping the function executing further
                return;
            }
                int counterr=0;
                for (int i=0 ;i < mNum.length() ;i++){
                     counterr ++ ;
                }
            if (mNum.isEmpty()) {
                Toast.makeText(this, "Your Number please", Toast.LENGTH_LONG).show();
                //stopping the function executing further
                return;
            }
            if (counterr != 11 ){
                Toast.makeText(this, "رقم الهاتف خاطئ", Toast.LENGTH_LONG).show();
                return;

            }
            if (governorate.equalsIgnoreCase("اختر محافظتك")){
                Toast.makeText(this, "اختر محافظتك", Toast.LENGTH_LONG).show();
                return;
            }
            if (g == false){
                Toast.makeText(this, "من فضلك اختر النوع", Toast.LENGTH_LONG).show();
                return;
            }
            if (type == false){
                Toast.makeText(this, "من فضلك اختر فصيلة دمك", Toast.LENGTH_LONG).show();
                return;
            }


// if valid

                progressDialog.setMessage("Wait please ...");
                progressDialog.show();

                //create account



                mAuth.createUserWithEmailAndPassword(mMail, mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            final String user_id = mAuth.getCurrentUser().getUid();
                            final String mBlood = blood;
                            final String gov = governorate;


                            Map<String, Object> userMap = new HashMap<>();
                            userMap.put("name", mName);
                            userMap.put("blood", mBlood);
                            userMap.put("points", 0);
                            userMap.put("permission", mail_rec);
                            userMap.put("counter", 0);
                            userMap.put("response", "no");
                            userMap.put("gender", gender);
                            userMap.put("hospial", "a");
                            userMap.put("phone", mNum);
                            userMap.put("noti_per", noti_per);
                            userMap.put("gov", gov);


                            Map<String,Object> usere = new HashMap<>();
                            usere.put("name", mName);
                            usere.put("phone", mNum);
                            if(per_reg.isChecked()) {
                                if (mBlood.equalsIgnoreCase("O+")) {

                                    mfirestore.collection("Grp op").document(user_id).set(usere);

                                }

                                if (mBlood.equalsIgnoreCase("O-")) {

                                        mfirestore.collection("Grp on").document(user_id).set(usere);

                                }
                                if (mBlood.equalsIgnoreCase("A+")) {
                                        mfirestore.collection("Grp ap").document(user_id).set(usere);

                                }
                                if (mBlood.equalsIgnoreCase("A-")) {

                                        mfirestore.collection("Grp an").document(user_id).set(usere);

                                }
                                if (mBlood.equalsIgnoreCase("AB+")) {

                                        mfirestore.collection("Grp abp").document(user_id).set(usere);

                                }
                                if (mBlood.equalsIgnoreCase("AB-")) {

                                        mfirestore.collection("Grp abn").document(user_id).set(usere);

                                }
                                if (mBlood.equalsIgnoreCase("B+")) {

                                        mfirestore.collection("Grp bp").document(user_id).set(usere);

                                }
                                if (mBlood.equalsIgnoreCase("B-")) {

                                        mfirestore.collection("Grp bn").document(user_id).set(usere);

                                }


                            }
                            saveToken();
                            //عشان كل اكونت جديد يتعمله فولدر كده
                            mfirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        progressDialog.hide();

                                        // go to main activity
                                        Intent intent = new Intent(SignUp.this, IntroFrag.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish();
                                        // go to enable sign in method in firebase
                                        // and database to change safty after finish change it to request.auth != null
                                    } else {
                                        progressDialog.hide();
                                        Toast.makeText(SignUp.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                                    }


                                }
                            });
                        } else {
                            progressDialog.hide();
                            Toast.makeText(SignUp.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }


                    }
                });

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        governorate = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }




    /////



    private void saveToken() {


        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if ( task.isSuccessful()){
                            String token =task.getResult().getToken();
                            User user = new User(token);
                            DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference(governorate);
                            dbUsers.child(mAuth.getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        progressDialog.hide();
                                    }
                                }
                            });
                        }
                    }
                });


    }
}
