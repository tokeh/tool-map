function toggleFilterButtonState(btn) {
    if (btn.classList.contains("btn-outline-default")) {
        $(btn).removeClass("btn-outline-default");
        $(btn).addClass("btn-default");
    } else {
        $(btn).removeClass("btn-default");
        $(btn).addClass("btn-outline-default");
    }
}