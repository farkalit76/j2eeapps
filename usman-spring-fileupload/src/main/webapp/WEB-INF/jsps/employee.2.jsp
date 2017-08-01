<%-- 
    Document   : employee
    Created on : 30 Jul, 2015, 2:00:34 PM
    Author     : 72010995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

    </head>
    <body>
        <h1>Hello Usman!</h1>
      
        <input type="button" id="btnOpenDialog" value="Open Confirm Dialog" />
         <div id="dialog-confirm"></div>
        
    </body>
</html>


<script type="text/javascript">

    function fnOpenNormalDialog() {
        alert('sdsssss');
        $("#dialog-confirm").html("Confirm Dialog Box");

        // Define the Dialog and its properties.
        $("#dialog-confirm").dialog({
            resizable: false,
            modal: true,
            title: "Modal",
            height: 250,
            width: 400,
            buttons: {
                "Yes": function () {
                    $(this).dialog('close');
                    callback(true);
                },
                "No": function () {
                    $(this).dialog('close');
                    callback(false);
                }
            }
        });
    }

    $('#btnOpenDialog').click(fnOpenNormalDialog);

    function callback(value) {
        if (value) {
            alert("Confirmed");
        } else {
            alert("Rejected");
        }
    }

</script>