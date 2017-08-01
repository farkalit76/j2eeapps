<html>
    <head>
        <TITLE>Test - Spring MVC Example with AJAX call</TITLE>

        <style type="text/css">
            body {
                background-image:
                    url('http://cdn3.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
            }
        </style>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script type="text/javascript">
            function runAjax() {
                $.ajax({
                    url: 'ajaxtest',
                    success: function (data) {
                        $('#result').html(data);
                    }
                });
            }
        </script>

        <script type="text/javascript">
            var intervalId = 0;
            intervalId = setInterval(runAjax, 3000);
        </script>
    </head>

    <body>
        <div align="center">
            <br> <br> ${message} <br> <br>
            <div id="result"></div>
            <br>
            <p>
                by <a href="http://www.vertexgroup.com/enable-the-business/vertexone/">VertexOne.com</a>
            </p>
        </div>
    </body>
</html>