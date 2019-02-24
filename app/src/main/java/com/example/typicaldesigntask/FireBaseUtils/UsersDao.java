package com.example.typicaldesigntask.FireBaseUtils;

import com.example.typicaldesigntask.Model.Data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;

public class UsersDao {

    public static void AddUser(Data user,
                               OnSuccessListener onSuccessListener,
                               OnFailureListener onFailureListener){
       DatabaseReference userNode= MyDataBase.getUsersBranch()
                .push();
       user.setId(userNode.getKey());
       userNode.setValue(user)
               .addOnSuccessListener(onSuccessListener)
               .addOnFailureListener(onFailureListener);

    }
}
