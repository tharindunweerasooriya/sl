$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
{
$("#alertSuccess").hide();
}
$("#alertError").hide();



});


//Admin INSERT---------------------------------------
$(document).on("click", "#btnSaveA", function(event)
		{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		// Form validation-------------------
		var status = validateItemForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		// If valid------------------------
		var type = ($("#hidItemIDSaveA").val() == "") ? "POST" : "PUT";
		
		
		$.ajax(
				{
				url : "adminAPI",
				type : type,
				data : $("#formItem").serialize(),
				dataType : "text",
				complete : function(response, status)
				{
				onItemSaveComplete(response.responseText, status);
				}
				});
			});





	function onItemSaveComplete(response, status)
	{
				if (status == "success")
				{
				var resultSet = JSON.parse(response);
				if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
				} else if (resultSet.status.trim() == "error")
				{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
				}
				} else if (status == "error")
				{
				$("#alertError").text("Error while saving.");
				$("#alertError").show();
				} else
				{
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show();
				}
				
				$("#hidItemIDSaveA").val("");
				$("#formItem")[0].reset();
	}


//ADMIN UPDATE==========================================
$(document).on("click", ".btnUpdateA", function(event)
{ 
$("#hidItemIDSaveA").val($(this).data("id")); 
 
$("#ASSIGN_TO").val($(this).closest("tr").find('td:eq(6)').text());

});


//User INSERT---------------------------------------
$(document).on("click", "#btnSaveU", function(event)
		{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		// Form validation-------------------
		var status = validateItemForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		// If valid------------------------
		var type = ($("#hidItemIDSaveU").val() == "") ? "POST" : "PUT";
		
		
		$.ajax(
				{
				url : "m_userAPI",
				type : type,
				data : $("#formItem").serialize(),
				dataType : "text",
				complete : function(response, status)
				{
				onItemSaveComplete(response.responseText, status);
				}
				});
			});





	function onItemSaveComplete(response, status)
	{
				if (status == "success")
				{
				var resultSet = JSON.parse(response);
				if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
				} else if (resultSet.status.trim() == "error")
				{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
				}
				} else if (status == "error")
				{
				$("#alertError").text("Error while saving.");
				$("#alertError").show();
				} else
				{
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show();
				}
				
				$("#hidItemIDSaveU").val("");
				$("#formItem")[0].reset();
	}



//CLIENT-MODEL================================================================
function validateItemForm()
{
// CODE
if ($("#ASSIGN_TO").val().trim() == "")
{
return "Insert ASSIGN.";
}

return true;
}

//Search Admin----------------------------------------------------------------
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#divItemsGrid tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});


 
