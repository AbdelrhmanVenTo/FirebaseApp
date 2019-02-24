package com.example.typicaldesigntask.FireBaseUtils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyDataBase {

   private static FirebaseDatabase firebaseDatabase;

   static FirebaseDatabase getInstance(){
       if(firebaseDatabase==null)
           firebaseDatabase= FirebaseDatabase.getInstance();

       return firebaseDatabase;
   }

   private static final String Users="user";
   public static DatabaseReference getUsersBranch(){
       return getInstance().getReference(Users);
   }


}
