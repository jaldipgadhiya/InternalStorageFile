package com.android.acadgild.internalstoragefile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Save & Check file buttons
        Button saveBtn = (Button) findViewById(R.id.btnSaveFile);
        Button checkBtn = (Button) findViewById(R.id.btnChkFile);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    //String to be written inside file
                    String s = "Hello World!!";
                    //FileOutputStream to open and write data into it with MODE_PRIVATE.
                    FileOutputStream fileout=openFileOutput("mytextfile1.txt", MODE_PRIVATE);
                    //OutputStreamWriter with object of FileOutputStream
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    //Write string into OutputStreamWriter
                    outputWriter.write(s);
                    //Close OutputStreamWriter
                    outputWriter.close();

                    //display file saved message
                    Toast.makeText(getBaseContext(), "File saved successfully!",
                            Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getBaseContext(), getFilesDir() + "/" + "textfile1.txt",
                            Toast.LENGTH_LONG).show();
                    //Get file with getFilesDir() to get directory
                    File file = new File(getFilesDir() + "/" + "textfile1.txt");
                    //Check if file exists or not using File object
                    if(file.exists())
                    {
                        //Toast if file exists.
                        Toast.makeText(getBaseContext(), "File exists!",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        //Toast if file does not exist.
                        Toast.makeText(getBaseContext(), "File does not exist!",
                                Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
