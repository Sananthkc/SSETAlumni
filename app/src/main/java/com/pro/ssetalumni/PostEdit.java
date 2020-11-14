package com.pro.ssetalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostEdit extends AppCompatActivity {

    EditText title,description;
    Button updatePost, deletePost;
    private DatabaseReference mDatabase;
    String ImageUrl, descsend;
    int ADMIN=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_edit);

        AdminCheck adminCheck = (AdminCheck) getApplicationContext();
        ADMIN = adminCheck.getADMIN();

        if (ADMIN == 1) {

            title = findViewById(R.id.edit_name_poster);
            description = findViewById(R.id.edit_text_view_description);
            updatePost = findViewById(R.id.updatePostButton);
            deletePost = findViewById(R.id.deletePostButton);

            final Intent i = getIntent();
            //   String gettitle = i.getStringExtra("title");
            String getdesc = i.getStringExtra("desc");
            ImageUrl = i.getStringExtra("imageurl");
            final String id = i.getStringExtra("id");
            Log.d("test", "id=" + id);

            mDatabase = FirebaseDatabase.getInstance().getReference();
            // title.setText(gettitle);
            description.setText(getdesc);
            updatePost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
                    UpdatePost(id);
                }
            });

            deletePost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
                    DeletePost(id);
                }
            });
        }
        else {
            Log.d("abc", String.valueOf(ADMIN));
        }
    }

        private void UpdatePost (String id){
            //  titlesend = title.getText().toString();
            descsend = description.getText().toString();

            UploadImage uploadImage = new UploadImage("", descsend, ImageUrl);
            mDatabase.child("uploads").child(id).setValue(uploadImage).
                    addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(PostEdit.this, "Post Updated", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        }
                    });
        }

        private void DeletePost (String id){
            mDatabase.child("uploads").child(id).removeValue()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(PostEdit.this, "Post Deleted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));

                        }
                    });
        }


}