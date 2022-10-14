var get_X;
var get_Y;
var get_R;
function onSubmit() {
    
    let y =document.getElementById("y_v")
    
        if (validator(y.value)){
        let xRadioButtons = document.getElementsByName("x_v");
        for (let xRadioButton of xRadioButtons) {
            if (xRadioButton.checked) {
                get_X = xRadioButton.value;
                break;
            }
        }

        let rRadioButtons = document.getElementsByName("r_v");
        for (let rRadioButton of rRadioButtons) {
            if (rRadioButton.checked) {
                get_R = rRadioButton.value;
                break;
            }
        }
       
        $.get("./php/main.php", { x: get_X , r: get_R, y:y.value, timeZone:Intl.DateTimeFormat().resolvedOptions().timeZone }).done(function(data){
            document.getElementById("table").innerHTML=data;
        });
        
       
    } 
  
    
}
function validator(y){
    
    if (isNaN(parseFloat(y)) || parseFloat(y)>5.0 || parseFloat(y)<-5.0 || !isFinite(y)) {
        alert("Y must be float from -5 to 5")
        return(false)

    }
    return(true)


}
function appendTable(index, ...args){
    let table=   document.getElementbyTag("table")[index];
    var row= table.insertRow();
    args.forEach(element => {let cell = row.insertCell();
     cell.innerHTML="aboba";
    });


 }