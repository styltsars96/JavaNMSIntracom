require(["context-menu"], function(contextMenu) {
    // Definition of our factory
	var factory = {
		factoryName: "misc",
		getMenuItems: function(event, context) {
			var list = [];
			var helpItem = $("<li><div>Help</div></li>").attr({
                funcName: "help"
            });
			list.push(helpItem);
			return list;
		},
		help: function() {
	        createAskNameDialog();
	        dialog.dialog("open");
		}
	}
	//* 2nd Exercise: Display an item on context menu
	 //* Uncomment the following line to enable the Help command. DONE!
	contextMenu.registerItemFactory(factory, 3);

	// Now define our actions
	var dialog;
    function createAskNameDialog() {
        if(dialog) {
            return;
        }
        var dialogEl = $("<div></div>").attr({
            id: "askNameDialog",
            title: "Παρακαλώ εισάγετε το ονοματεπώνυμο σας"
        }).appendTo("body");
        var formEl = $("<form></form>").appendTo(dialogEl);
        var fieldsetEl = $("<fieldset></fieldset>").appendTo(formEl);
        var nameInput = $("<input>").attr({
            name: "name",
            id: "userNameInput",
            class: "text ui-widget-content ui-corner-all"
        }).appendTo(fieldsetEl);
        $("<input>").attr({
            type: "submit",
            tabindex: "-1",
            style: "position:absolute; top:-1000px"
        }).appendTo(fieldsetEl);
        dialog = $( "#askNameDialog" ).dialog({
            autoOpen: false,
            height: 220,
            width: 350,
            modal: true,
            buttons: {
                OK: function() {
                    requestHelp();
                },
                Cancel: function() {
                    dialog.dialog( "close" );
                }
            },
            close: function() {
            	form[0].reset();
            }
        });
        var form = dialog.find( "form" ).on( "submit", function( event ) {
            event.preventDefault();
            requestHelp();
        });

        // This function executes the Ajax call
        function requestHelp(name) {
            var name = dialog.find( "form #userNameInput")[0].value;
            dialog.dialog("close");
            $.ajax({
                method: "PUT",
                url: window.location.href + "help",
                contentType: "text/plain; charset=UTF-8",
                data: name,
                headers: {
                	/* Change for 5th Exercise
                	 * Comment out value "text/plain for header "Accept"
                	 * and uncomment "application/json"
                	 */
                	"Accept": "text/plain" // "application/json" 
                }
            }).done(function(data, textStatus, jqXHR) {
                /* 6th Exercise: Handle JSON response
                 * We should check is Context-Type is "text/plain" or
                 * "application/json". In the second case we have to do extra
                 * work since data variable is a JSON object.
                 * Extract each field of that object
                 * and create a string in order to show the information.
                 * The string should be identical with that shown in the
                 * "text/plain" case.
                 */
            	var contentType = jqXHR.getResponseHeader("Content-Type");
            	alert(data);
            }).fail(function(jqXHR, textStatus, errorThrown) {
            	/* 4th Exercise:
            	 * Write your code here to show the application error.
            	 */
            	alert(errorThrown);
            });
        }
    }
});
