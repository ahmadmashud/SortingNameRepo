<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
    <div style="padding: 50px;">
           <center><h1>SORTING NAME</h1></center> 
        <div style="margin-left: 100px;">
            	 <form id="uploadForm" action="/sorting/proses" method="POST" enctype="multipart/form-data">
            	 	 <div class="btn" style="padding:40px">
                          <span>Choose File : </span>
                          <br>
                           <br>
                           <input type="file" name="filePath">
                      </div>
                      <div style="padding-left: 40px;">
                      		<button class="waves-effect waves-light " id="btnProses">PROCCESS</button>
                      		<button class="waves-effect waves-light " id="btnReset">REST</button>
                      </div>
                        
            	 </form>
            	 	<br>
            	 	<div style="margin-left:30px" id="data">
             		
             	</div>
            
        </div>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function () {

	 $("#btnReset").click(function(){
		 event.preventDefault();
		 location.reload();
	 });
	
    $("#btnProses").click(function (event) {

        event.preventDefault();

        var form = $('#uploadForm')[0];
        
        $("#btnProses").prop('disabled',true);
        
        var data = new FormData(form);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/sorting/proses",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                var dataString = "";
                for (var i = 0; i < data.length; i++) {
                	var no = i+1;
                	$("#data").append(no+". "+data[i].firstName+" "+data[i].lastName+"<br>");
                	if (data[i].firstName == "") {
	                	dataString = dataString + data[i].lastName+"\n";
					}else{
	                	dataString = dataString + data[i].firstName+" "+data[i].lastName+"\n";
					}
				}
            	download(dataString, "data-sorted", "text");
            },
            error: function (e) {
                console.log("ERROR : ", e);

            }
        });

    });
    
    function download(data, filename, type) {
        var file = new Blob([data], {type: type});
        if (window.navigator.msSaveOrOpenBlob) // IE10+
            window.navigator.msSaveOrOpenBlob(file, filename);
        else { // Others
            var a = document.createElement("a"),
                    url = URL.createObjectURL(file);
            a.href = url;
            a.download = filename;
            document.body.appendChild(a);
            a.click();
            setTimeout(function() {
                document.body.removeChild(a);
                window.URL.revokeObjectURL(url);  
            }, 0); 
        }
    }
    	

});
</script>
</html>