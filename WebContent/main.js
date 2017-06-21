/**
 * Main JavaScript source for the hht application.
 */

function goBack() {
	window.history.back();
}

$(document).ready( function() {
    var now = new Date();
 
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);

    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;


   $('#datePicker').val(today);
});
