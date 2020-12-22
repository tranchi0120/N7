package com.example.nhom7;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.android.material.textfield.TextInputLayout;

//AppCompatActivity
public class LoginActivity extends AppCompatActivity {
    Button btnLogin, bt1;
    ImageView imgEye;
    //final TextInputLayout usernameWrapper = findViewById(R.id.usernameWrapper);
    TextInputEditText edtUser,edtpass;
    TextView txtSignUp;
    int status=1;
    TextView bq;

    private EditText emailEt, passwordEt;
    private Button signin;
    private TextView signup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bq = (TextView) findViewById(R.id.boqua);
        bq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Home.class);
                startActivity(intent);
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        progressDialog = new ProgressDialog(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });





        bt1 = (Button)  findViewById(R.id.dk);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, singup.class);
                startActivity(intent);
            }
        });
//        btnLogin =(Button) findViewById(R.id.);
//        edtUser =(TextInputEditText) findViewById(R.id.username);
//        edtpass=(TextInputEditText) findViewById(R.id.password);
//        txtSignUp=(TextView) findViewById(R.id.textviewSignUp);

        /*edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() ==0) {
                    usernameWrapper.setError("Bạn bắt buộc phải nhập username");
                } else {
                    usernameWrapper.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(edtUser.getText().toString().equals("nhom7") && edtpass.getText().toString().equals("1234")) {
//                    Intent myIntent=new Intent(com.example.nhom7.LoginActivity.this, LoadingLoginActivity.class);
//                    startActivity(myIntent);
//                    Toast.makeText(com.example.nhom7.LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Toast.makeText(com.example.nhom7.LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }

    public void Login() {
        String email=emailEt.getText().toString();
        String password=passwordEt.getText().toString();
        if (TextUtils.isEmpty(email)){
            emailEt.setError("Enter your email");
            return;
        }
        else if (TextUtils.isEmpty(password)){
            passwordEt.setError("Enter password");
            return;
        }

        else if(!isVallidEmail(email)){
            emailEt.setError("Invail email");
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,Home.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this,"NoSuccessfully registered",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
    private Boolean isVallidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target)&& Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

}