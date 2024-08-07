package com.hindicorp.pdfviewer;

import android.app.Activity;
import android.os.Bundle;
import android.os.*;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.primamasterbank.absensikaryawan.R;

import android.view.View;
import android.widget.Button;
import java.io.File;


public class PDFViewerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);


        PDFView pdfView = findViewById(R.id.pdfView);
        Button closeButton = findViewById(R.id.closeButton);

        //PDFView pdfView = new PDFView(this, null);
        //setContentView(pdfView);

        String pdfFilePath = getIntent().getStringExtra("pdfFilePath");


        if (pdfFilePath != null) {
            File pdfFile = new File(pdfFilePath);
            if (pdfFile.exists()) {
                pdfView.fromFile(pdfFile)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .load();

                closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish(); // Close the activity
                        }
                });

            } else {
                Toast.makeText(this, "PDF file does not exist", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "PDF file path is missing", Toast.LENGTH_LONG).show();
        }


        // byte[] pdfAsBytes = getIntent().getByteArrayExtra("pdf");
        // pdfView.fromBytes(pdfAsBytes)
        //        .enableSwipe(true)
        //        .swipeHorizontal(false)
        //        .enableDoubletap(true)
        //        .defaultPage(0)
        //        .enableAnnotationRendering(false)
        //        .password(null)
        //        .scrollHandle(null)
        //        .enableAntialiasing(true)
        //        .spacing(0)
        //        .load();
    }
}
