// var exec = require('cordova/exec');
// console.log('Loading PDFViewer plugin...');
// exports.showPDF = function(base64Data, success, error) {
//     exec(success, error, 'PDFViewer', 'showPDF', [base64Data]);
// };

var exec = require('cordova/exec');

function PDFViewer() {
    console.log('PDFViewer.js: is created');
}

PDFViewer.prototype.showPDF = function(base64Data, success, error) {
    console.log('Calling PDFViewer.showPDF...');
    exec(success, error, 'PDFViewer', 'showPDF', [base64Data]);
};

module.exports = new PDFViewer();