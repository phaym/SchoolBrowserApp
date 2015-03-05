

function getCoursesForStudent(studentId) {
   
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
        		getCoursesForStudent(studentId);
        	}
        	else{
        		alert(data);
        	}
        }
    });
}