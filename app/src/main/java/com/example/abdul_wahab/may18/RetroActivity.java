package com.example.abdul_wahab.may18;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.abdul_wahab.may18.models.Dummy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";
    private static final int PICK_IMAGE_REQUEST = 321;
    private ImageView imageview;
    private Button btnUpload;
    private Uri mImageUri;
    private ArrayList<String> pathList;
    private File filer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);


        imageview = findViewById(R.id.imageView);
        btnUpload = findViewById(R.id.btnUpload);

        ICustomerService CustomerService = ServiceGenerator.createService(ICustomerService.class);
//        Customer c = new Customer(7, "tttttttttttttttttttt", "tttt");

        Dummy dummy = new Dummy(1, 1, "wwwwwwwwwwwwwwww", "assssssssssssssssss");

        Call<Dummy> dummycall = CustomerService.updateDummy(1, dummy);

        dummycall.enqueue(new Callback<Dummy>() {
            @Override
            public void onResponse(Call<Dummy> call, Response<Dummy> response) {
                Log.d(TAG, "onResponse: ");
                String s = ";";
            }

            @Override
            public void onFailure(Call<Dummy> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

/*
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);*/


/*
        Intent mIntent = new Intent(this, PickImageActivity.class);
        mIntent.putExtra(PickImageActivity.KEY_LIMIT_MAX_IMAGE, 60);
        mIntent.putExtra(PickImageActivity.KEY_LIMIT_MIN_IMAGE, 1);
        startActivityForResult(mIntent, PickImageActivity.PICKER_REQUEST_CODE);

*/

     /*   btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ICustomerService CustomerService = ServiceGenerator.createService(ICustomerService.class);
                Customer c = new Customer("nameeee", "prooo");

                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(mImageUri, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String mediaPath = cursor.getString(columnIndex);
                // Set the Image in ImageView for Previewing the Media
                imageview.setImageBitmap(BitmapFactory.decodeFile(mediaPath));

                filer = new File(mediaPath);

                cursor.close();


                RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), filer);


                // MultipartBod9y.Part is used to send also the actual file name
                MultipartBody.Part image1 =
                        MultipartBody.Part.createFormData("picture", filer.getName(), reqFile);

                //RequestBody rbImage = RequestBody.create(MediaType.parse(MultipartBody.MIXED), "name");
                RequestBody rbName = RequestBody.create(MultipartBody.FORM, "name");
                RequestBody rbProfilePic = RequestBody.create(MultipartBody.FORM, "profile_pic");

                Call<Customer> addcall = CustomerService.addCustomer(image1, rbName, rbProfilePic);

                addcall.enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        Log.d(TAG, "onResponse: ");
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {

                        Log.d(TAG, "onFailure: ");
                    }
                });

            }
        });*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


/*
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != RESULT_OK) {
            return;
        }
        if (resultCode == -1 && requestCode == PickImageActivity.PICKER_REQUEST_CODE) {
            this.pathList = intent.getExtras().getStringArrayList(PickImageActivity.KEY_DATA_RESULT);


            filer = new File(pathList.get(0));
            mImageUri = Uri.parse(pathList.get(0));
            if (this.pathList != null && !this.pathList.isEmpty()) {
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < pathList.size(); i++) {
                    sb.append("Photo" + (i + 1) + ":" + pathList.get(i));
                    sb.append("\n");
                }
                //tvResult.setText(sb.toString()); // here this is textview for sample use...
                Log.d(TAG, "onActivityResult: " + sb.toString());


                Log.d(TAG, "onActivityResult: ");

            }
        }
    }

*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Log.d(TAG, "onActivityResult: in IF Condition ready to upload");

            mImageUri = data.getData();

            Log.d(TAG, "onActivityResult: " + mImageUri);


            Picasso.get().setIndicatorsEnabled(true);
            Picasso.get().setLoggingEnabled(true);


            Picasso.get()
                    .load(data.getData())
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.error)
                    .into(imageview);

        } else {
            Log.d(TAG, "onActivityResult: Else Case");
        }

    }

}
