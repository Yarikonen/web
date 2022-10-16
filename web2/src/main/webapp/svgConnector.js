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

$(document).ready(function (){                                  //redraw onload
    let xArray = document.getElementsByName("xT");
    let yArray = document.getElementsByName("yT");
    let rArray = document.getElementsByName("rT");
    let r = rArray[rArray.length-1].innerHTML;
    for (let i = xArray.length-1; i >=0; i--) {
        if (r===rArray[i].innerHTML){
            draw(screenPoint(xArray[i].innerHTML,yArray[i].innerHTML,r));
        }
        else{
            break
        }
    }
})

svg.addEventListener('click',function(evt){         //draw onclick
    let get_R;
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