function validate(check) {
    var valid = true;
    for (var i = check.length - 1; i >= 0; i--) {
        if (check[i].val() === "") {
            alert(check[i].attr('title'));
            valid = false;
        }
    }
    return valid;
}