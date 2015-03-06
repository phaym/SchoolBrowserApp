

function getStudentsInCourse(courseId) {
   
	$.ajax({
        type: "GET",
        url: "StudentsInCourse",
        data: {"id": courseId },
        dataType: 'json',
        success: function(data){
    		$('#studentsInCourse tbody').remove();
    		if(data.length > 0){
	        	$.each(data, function(index, value) {
	                $('#studentsInCourse').append($('<tr>')
	                							.append($('<td>').text(value.id))
	                							.append($('<td>').text(value.firstName))
	                							.append($('<td>').text(value.lastName))
	                							);
	                					
	            });
    		}
    		else{
    			$('#studentsInCourse').append($('<tr>').append($('<td>').text("No students enrolled")));
    		}
        }
    });
}