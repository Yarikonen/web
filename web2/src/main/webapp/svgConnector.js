var svg = document.querySelector('svg');
var height = svg.getAttribute("height");
var width =  svg.getAttribute("width");
function graphPoint(evt){
    let pt = svg.createSVGPoint();
    pt.x = evt.clientX; pt.y = evt.clientY;
    return pt.matrixTransform(svg.getScreenCTM().inverse());
}
function screenPoint(x,y,r){
    let pt = svg.createSVGPoint();
    pt.x = x*248/r + width/2
    pt.y = -y*248/r + height/2
    return(pt)
}

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