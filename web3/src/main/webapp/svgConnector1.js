let svg = document.querySelector('svg');
var height = svg.getAttribute("height");
var width =  svg.getAttribute("width");
const pixByR = 248
function graphPoint(evt){
    let pt = svg.createSVGPoint();
    pt.x = evt.clientX; pt.y = evt.clientY;
    return pt.matrixTransform(svg.getScreenCTM().inverse());
}
function screenPoint(x,y,r){
    let pt = svg.createSVGPoint();
    pt.x = x*pixByR/r + width/2
    pt.y = -y*pixByR/r + height/2
    return(pt)
}
function redraw(xArray, yArray, rArray, r) {


    for (let i = xArray.length - 1; i >= 0; i--) {
        if (r == rArray[i]) {
            draw(screenPoint(xArray[i], yArray[i], r));
        } else {
            break
        }


    }
}
$(document).ready(function (){
    $.ajax({
        url:"TableServlet",
        type:"GET",

    }).done(function (data){

        let xArray = [];
        let yArray = [];
        let rArray = [];
        for(let row of data.split("$")){
            row = row.split(" ");
            xArray.push(row[0]);
            yArray.push(row[1]);
            rArray.push(row[2]);



        }

        if (xArray.length>1){
            redraw(xArray,yArray,rArray,rArray[rArray.length-1]);
        }

});
});




svg.addEventListener('click',function(evt){         //draw onclick
    let get_R;
    let rRadioButtons = document.getElementsByName("form:r_value");
    for (let rRadioButton of rRadioButtons) {
        if (rRadioButton.checked) {
            get_R = rRadioButton.value;
            break;
        }
    }

    if (!isNaN(parseFloat(get_R))) {
        let loc = graphPoint(evt);
        let get_X =Math.round(get_R*(loc.x - width / 2) /pixByR * 1000)/1000 ;
        let get_Y = Math.round(1000*get_R*((-loc.y + height / 2)) / pixByR)/1000;
        document.getElementById("hiddenForm:xValue").value = get_X;
        document.getElementById("hiddenForm:yValue").value = get_Y;
        document.getElementById("hiddenForm:rValue").value=get_R;
        document.getElementById("hiddenForm:phantomButton").click();

       draw(screenPoint(get_X,get_Y, get_R));

    }
},false);
var radios = document.getElementsByName("form:r_value");                                                        //clear image onchange
for(let radio of radios) {
    radio.onchange = function() {
        var radioValue = this.value;

        document.querySelectorAll(".point").forEach(el=>el.remove());
        $.ajax({
            url:"TableServlet",
            type:"GET"
        }).done(function (data){


            let xArray = []
            let yArray = []
            let rArray = []

            for(let row of data.split("$")){
                row = row.split(" ");
                xArray.push(row[0]);
                yArray.push(row[1]);
                rArray.push(row[2]);

            }

            redraw(xArray,yArray,rArray,radioValue);
        })


    }
}


function draw(p){                                                                                               //draw method
    let  point= document.createElementNS('http://www.w3.org/2000/svg','ellipse');
    point.setAttribute("cx",p.x);
    point.setAttribute("cy",p.y);
    point.setAttribute("rx",2);
    point.setAttribute("ry", 2);
    point.setAttribute("stroke","white");
    point.setAttribute("class", "point");
    $("svg").append(point);

}

