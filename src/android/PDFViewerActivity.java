package com.hindicorp.pdfviewer;

import android.app.Activity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PDFView pdfView = new PDFView(this, null);
        setContentView(pdfView);

        byte[] pdfAsBytes = getIntent().getByteArrayExtra("pdf");
        pdfView.fromBytes(pdfAsBytes)
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
    }
}
