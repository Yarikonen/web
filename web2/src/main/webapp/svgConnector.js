
document.getElementById('image1').addEventListener('click', function (event) {
    var get_R;
    let rRadioButtons = document.getElementsByName("r_v");
    for (let rRadioButton of rRadioButtons) {
        if (rRadioButton.checked) {
            get_R = rRadioButton.value;
            break;
        }
    }
    if (!isNaN(parseFloat(get_R))) {
        document.getElementById("image1").innerHTML = event.clientX.toString() + " " + event.clientY.toString() +" "+ document.getElementById("y_v").value;
    }

}, true);