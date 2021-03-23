package com.dochsoft.fullmoon.segmentmod.firebaseDatabase;

/*import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InitFirebase {

    public static void firebaseInit() {
        try {
            FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccount.json");

// Initialize the app with a service account, granting admin privileges
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://<databaseName>.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);

// As an admin, the app has access to read and write all data, regardless of Security Rules
            DatabaseReference ref = FirebaseDatabase.getInstance()
                    .getReference("restricted_access/secret_document");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Object document = dataSnapshot.getValue();
                    System.out.println(document);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                }
            });
        } catch (IOException e) { }

    }
} */
