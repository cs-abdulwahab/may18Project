package com.example.abdul_wahab.may18;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";
    private static final int PICK_IMAGE_REQUEST = 1;
    private StorageReference mStorageRef;

    private DatabaseReference mDatabaseRef;

    FirebaseFirestore db;


    private ImageView imgPreview;
    private Uri mImageUri;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  mStorageRef = FirebaseStorage.getInstance().getReference("uploads");

        db = FirebaseFirestore.getInstance();


        Button btnSelect = findViewById(R.id.btnSelect);
        Button btnUpload = findViewById(R.id.btnUpload);
        progressBar = findViewById(R.id.progBar);


        btnSelect.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, PICK_IMAGE_REQUEST);

                    }
                }
        );


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //upload Image in FireStoreage
                uploadImageToFirebaseStorage();

            }
        });


        imgPreview = findViewById(R.id.imgPreview);

*/
    }


    private void uploadImageToFirebaseStorage() {


        if (mImageUri != null) {

            StorageReference fileStorageReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExxtension(mImageUri));

            fileStorageReference.putFile(mImageUri)


                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Log.d(TAG, "onSuccess: ");

                            db.collection("uploads").document(""+System.currentTimeMillis() ).set(new Node("namm", taskSnapshot.getDownloadUrl(

                            ).getPath()));


                            /*

                            //adding an upload to firebase database
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(new Node("namm", taskSnapshot.getDownloadUrl().getPath()));
*/


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "onFailure: ");
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    int progress = (int) (100 * (taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount()));
                    Log.d(TAG, "onProgress: " + progress);

                    progressBar.setVisibility(View.VISIBLE);

                    progressBar.setProgress(progress);


                }
            });


        } else {
            Toast.makeText(this, "Select Image First", Toast.LENGTH_LONG).show();
        }


    }

    private String getFileExxtension(Uri mImageUri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        String ext = mimeTypeMap
                .getExtensionFromMimeType(contentResolver.getType(mImageUri));
        return ext;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Log.d(TAG, "onActivityResult: in IF Condition ready to upload");

            mImageUri = data.getData();


            Picasso.get().setIndicatorsEnabled(true);
            Picasso.get().setLoggingEnabled(true);


            Picasso.get()
                    .load(data.getData())
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.error)
                    .into(imgPreview);

        } else {
            Log.d(TAG, "onActivityResult: Else Case");
        }

    }
}


