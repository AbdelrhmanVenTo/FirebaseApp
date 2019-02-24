package com.example.typicaldesigntask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.typicaldesigntask.Base.BaseActivity;
import com.example.typicaldesigntask.FireBaseUtils.UsersDao;
import com.example.typicaldesigntask.Model.Data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;


public class InsertActivity extends BaseActivity implements View.OnClickListener {

    protected EditText userName;
    protected EditText eMail;
    protected EditText phone;
    protected Button Submit;
    Data dataUser;
    String sUser , sEmail;
    int sPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_insert);
        FirebaseApp.initializeApp(this);
        initView();

    }

    private void initView() {
        userName = findViewById(R.id.userName);
        eMail = findViewById(R.id.eMail);
        phone = findViewById(R.id.phone);
        Submit =  findViewById(R.id.Submit);
        Submit.setOnClickListener(InsertActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Submit) {

            sUser = userName.getText().toString();
            sEmail = eMail.getText().toString();
            sPhone = Integer.parseInt(phone.getText().toString());
            dataUser = new Data(sUser,sEmail,sPhone);
            UsersDao.AddUser(dataUser,onUserAdded ,onUserAddFail);

        }

    }

    OnSuccessListener onUserAdded=new OnSuccessListener() {
        @Override
        public void onSuccess(Object o) {
            showConfirmationMessage(R.string.success, R.string.userAdded, R.string.ok,
                    new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            finish();

                        }
                    });
        }
    };
    OnFailureListener onUserAddFail= new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            showMessage(getString(R.string.fail),e.getLocalizedMessage());

        }
    };
}
