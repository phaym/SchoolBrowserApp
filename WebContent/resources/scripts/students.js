

function getCoursesForStudent(studentId, callback) {
   
	$.ajax({
        type: "GET",
        url: "CoursesForStudent",
        data: {"id": studentId },
        dataType: 'json',
        success: function(data){
    		$('#coursesForStudents tbody').remove();
    		if(data.length > 0){
	        	$.each(data, function(index, value) {
	                
	                	$('#coursesForStudents').append($('<tr>')
	                							.append($('<td>').text(value.courseTitle))
	                							.append($('<td>').text(value.courseCode))
	                							);
	                	if(typeof callback == "function")
	   	        		 	callback(studentId, value.id);
	            });
	        	
    		}
            else{
            	$('#coursesForStudents').append($('<tr>').append($('<td>').text("No classes enrolled")));
            }
        }
    });
}

function enrollStudent(studentId, courseId){

	$.ajax({
        type: "POST",
        url: "EnrollStudent",
        data: {"studentId": studentId, "courseId" : courseId },
        dataType: 'json',
        success: function(data){
    		
        	if(data == "Success"){
        		getCoursesForStudent(studentId, addWithdrawButton);
        	}
        	else{
        		alert(data);
        	}
        }
    });
}

function withdrawFromCourse(studentId, courseId ){
	
	$.ajax({
        type: "POST",
        url: "WithdrawStudent",
        data: {"studentId": studentId, "courseId" : courseId },
        dataType: 'json',
        success: function(data){
    		
        	if(data == "Success"){
        		getCoursesForStudent(studentId, addWithdrawButton);
        	}
        	else{
        		alert(data);
        	}
        }
    });
}

function addWithdrawButton(studentId, courseId){
	
	$('#coursesForStudents tbody tr').last()
		.append("<td>")
		.append('<input type="button" value="Withdraw Course" onclick="withdrawFromCourse(\''+ studentId + '\',\'' + courseId+'\')"/>');
}