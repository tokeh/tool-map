var unchecked_button = "btn-outline-default";
var checked_button = "btn-default";
var filter_button = "btn-outline-danger";

function toggle_filter_button_state(btn) {
    // Check button if unchecked or used as filter
    if (btn.classList.contains(unchecked_button) || btn.classList.contains(filter_button)) {
        $(btn).removeClass(unchecked_button);
        $(btn).removeClass(filter_button);
        $(btn).addClass(checked_button);

    // Uncheck button if it is checked
    } else {
        $(btn).removeClass(checked_button);
        $(btn).addClass(unchecked_button);
    }

    // Rerun button filter to check buttons that are used as filters
    filter();
}

function filter() {
    mark_filter_buttons();
    console.debug(get_filter_keywords());
}

function mark_filter_buttons() {
    // Search all filter buttons
    $(".btn-filter").map(function () {
        var keyword = $("input#filter_search").val().toLowerCase();

        // Uncheck filtered buttons when filter keyword is empty
        if (keyword.length === 0) {
            if (this.classList.contains(filter_button)) {
                $(this).removeClass(filter_button);
                $(this).addClass(unchecked_button);
            }
            return;
        }

        // Change color of filter buttons which match the keyword
        if (this.innerHTML.toLowerCase().indexOf(keyword) > -1) {

            // Button contains keyword -> red border
            if (this.classList.contains(unchecked_button)) {
                $(this).removeClass(unchecked_button);
                $(this).addClass(filter_button);
            }

            // Button does not contain keyword -> normal border
        } else {
            if (this.classList.contains(filter_button)) {
                $(this).removeClass(filter_button);
                $(this).addClass(unchecked_button);
            }
        }
    });
}

// Iterate over all filter buttons and return list of filter keywords
function get_filter_keywords() {
    var keyword_list = [];

    $(".btn-filter").map(function () {
        if (this.classList.contains(checked_button)) {
            var keyword = this.innerHTML.toLowerCase();

            // Remove animation <div>
            if (keyword.indexOf("<") > -1) {
                keyword = keyword.substring(0, keyword.indexOf('<'));
            }

            keyword_list.push(keyword);
        }
    });

    return keyword_list;
}