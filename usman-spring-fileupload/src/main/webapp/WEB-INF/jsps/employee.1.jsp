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
        <style>

            body { font-family: sans-serif; }
            #confirmBox
            {
                display: none;
                background-color: #eee;
                border-radius: 5px;
                border: 1px solid #aaa;
                position: fixed;
                width: 300px;
                left: 50%;
                margin-left: -150px;
                padding: 6px 8px 8px;
                box-sizing: border-box;
                text-align: center;
            }
            #confirmBox .button {
                background-color: #ccc;
                display: inline-block;
                border-radius: 3px;
                border: 1px solid #aaa;
                padding: 2px;
                text-align: center;
                width: 80px;
                cursor: pointer;
            }
            #confirmBox .button:hover
            {
                background-color: #ddd;
            }
            #confirmBox .message
            {
                text-align: left;
                margin-bottom: 8px;
            }
        </style>

    </head>
    <body>
        <h1>Hello Usman!</h1>
        <input type="button" id="btnDialog" value="Open Dialog" onclick="openDialog();" />
        <br/><br/>
    </body>
</html>

<div id='modal_dialog'>
    <div class='title'>
    </div>
    <input type='button' value='yes' id='btnYes' />
    <input type='button' value='no' id='btnNo' />
</div>

<script type="text/javascript">

    function openDialog()
    {
        if (dialog('Are you sure?')) {
            alert('blah....');
        }
    }
    function doSomething() {
        var warning = 'Are you sure you want to do this?';
        $('.title').html(warning);
        var dialog = $('#modal_dialog').dialog();
        function Yes() {
            dialog.dialog('close');
            // Do something
        }
        function No() {
            dialog.dialog('close');
            // Do something else
        }
        $('#btnYes').click(Yes);
        $('#btnNo').click(No);
    }
    function dialog(message, yesCallback, noCallback) {
        $('.title').html(message);
        var dialog = $('#modal_dialog').dialog();

        $('#btnYes').click(function () {
            dialog.dialog('close');
            yesCallback();
        });
        $('#btnNo').click(function () {
            dialog.dialog('close');
            noCallback();
        });
    }
    dialog('Are you sure you want to do this?',
            function () {
                // Do something
                doSomething();
            },
            function () {
                // Do something else
                alert('else');
            }
    );
</script>
