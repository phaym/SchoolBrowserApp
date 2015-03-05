

function processTree() {
   
	var treeString = $('#treeString').val();
	var nodeValue = $('#valueToCheck').val();
	$.ajax({
        type: "GET",
        url: "LevelsForValue",
        data: {"tree": treeString, "nodeValue":nodeValue },
        dataType: 'json',
        success: function(data){
    		var result = "";
        	$.each(data, function(index, value) {
        		result = result + value + " ,";				
            });
        	result = result.slice(0,-2);
        	$('#resultField').html(result);
        }
    });
}