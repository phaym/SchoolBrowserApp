

function getCoursesForStudent(studentId) {
   
	$.ajax({
        type: "GET",
        url: "CoursesForStudent",
        data: {"id": studentId },
        dataType: 'json',
        success: function(data){
    		$('#coursesForStudents tbody').remove();
        	$.each(data, function(index, value) {
                $('#coursesForStudents').append($('<tr>')
                							.append($('<td>').text(value.courseTitle))
                							.append($('<td>').text(value.courseCode))
                							);
                					
            });
        }
    });
}