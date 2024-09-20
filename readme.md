This plugin use native plugin : ccom.github.mhiew:android-pdf-viewer:3.2.0-beta.1


1. Please add repository :
   maven { url 'https://jitpack.io' }
   to platforms/android/app/repositories.gradle

2. after add the plugin check platforms/android/app/build.gradle
   there must be implementation "ccom.github.mhiew:android-pdf-viewer:3.2.0-beta.1"

3. Install via cordova
   cordova plugin add com.hindicorp.pdfviewer

3. USAGE :
   PDFViewer.showPDF(base64PDFString, successCallback, errorCallback);


