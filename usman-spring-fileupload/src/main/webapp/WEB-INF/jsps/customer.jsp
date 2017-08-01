<%-- 
    Document   : customer
    Created on : 22 Jul, 2015, 11:04:37 AM
    Author     : 72010995
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    </head>
    <body>
    <center>
        <h1>Customer World!</h1>
        <h1>Name : ${name}</h1>

        <input type="text" id="filePath" name="filePath" value="C:\\Farkalit\\Tomcat-8.0\\apache-gateway\\conf"  size="50" />

        <input type="button" id="btPath" name="btPath"  value="Path Validate"/>
        <br/>
        <br/>
        <input type="text" id="txtPath" name="txtPath" value="\\testdwv024\\d$\\server"  size="50" />
        <input type="button" id="btLoc" name="btLoc"  value="Location Validate"/>
        <br/>
        <br/>
        <input type="text" id="txtNumPath" name="txtNumPath" value="\\255.255.255.200"  size="50" />
        <input type="button" id="btNumPath" name="btNumPath"  value="Numeric Path Validate"/>
        <br/>
        <br/>
        <input type="text" id="txtAllPath" name="txtAllPath" value="\\255.255.255.200"  size="50" />
        <input type="button" id="btAllPath" name="btAllPath"  value="All Path Validate"/>
        <!--
       <br/>
       <input type="file" name="fileLocation" id="fileLocation" />
        -->
    </center>
</body>
</html>

<script type="text/javascript">


    $('#btPath').click(function () {

        var filePath = $("#filePath").val();
        alert('Path::' + filePath);
        var regex = /^([a-zA-Z]:)(\\\\[\w-#.\s\\]+)+$/;
        if (regex.test(filePath)) {
            alert('valid');
        } else {
            alert('invalid');
        }
    });

    $('#btLoc').click(function () {

        var filePaths = $("#txtPath").val();
        alert('filePaths:' + filePaths);
        var regex = /^([a-zA-Z]:)(\\\\[\w-#.\s\\]+)|(\\\\[\w-#$.\s\\]+)+$/;
        if (regex.test(filePaths))
        {
            alert("validate");
        } else {
            alert("not validate");
        }
    });


    $('#btNumPath').click(function () {

        var filePaths = $("#txtNumPath").val();
        alert('filePaths:' + filePaths);
        var regex = /^(?!0)(?!.*\.$)(\\\\)(((1?\d?\d|25[0-5]|2[0-4]\d)(\.|$)?){4})(\\\\[\w-#.\s\\]+)*$/;
        //var regex = /^\\\\([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])$/;
        //var regex = /^\\\\([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])(\\\\[\w-#.\s\\]+)*$/;
        if (regex.test(filePaths))
        {
            alert("validate");
        } else {
            alert("not validate");
        }
    });

//All Path, Location and IP Address validation
    $('#btAllPath').click(function () {

        var filePaths = $("#txtAllPath").val();
        alert('filePaths:' + filePaths);
        var regex = /^([a-zA-Z]:)(\\\\[\w-#.\s\\]+)|(\\\\[\w-#$.\s\\]+)|(?!0)(?!.*\.$)(\\\\)(((1?\d?\d|25[0-5]|2[0-4]\d)(\.|$)?){4})(\\\\[\w-#.\s\\]+)*$/;
        if (regex.test(filePaths))
        {
            alert("validate");
        } else {
            alert("not validate");
        }
    });


//        if (flagRead == null) {
//            $('#fileReadLocation').validationEngine('showPrompt', 'Invalid File Read Location.', 'error', 'bottomLeft', true);
//            $('#fileReadLocation').focus();
//            return false;
//        }


</script>