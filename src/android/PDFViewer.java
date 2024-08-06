package com.hindicorp.pdfviewer;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Base64;

public class PDFViewer extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("showPDF")) {
            String base64Data = args.getString(0);
            showPDF(base64Data, callbackContext);
            return true;
        }
        return false;
    }

    private void showPDF(String base64Data, CallbackContext callbackContext) {
        //System.out.println("PDF VIEWER 1");
        // Decode base64 data
        byte[] pdfAsBytes = Base64.decode(base64Data, Base64.DEFAULT);
        //System.out.println("PDF VIEWER 2");

        // Launch a new activity to display the PDF
        Intent intent = new Intent(cordova.getActivity(), PDFViewerActivity.class);
        //System.out.println("PDF VIEWER 3");

        intent.putExtra("pdf", pdfAsBytes);
        //System.out.println("PDF VIEWER 4");

        cordova.getActivity().startActivity(intent);
        //System.out.println("PDF VIEWER 5");

        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        //System.out.println("PDF VIEWER 6");

    }
}
