<?php
require('Row.php');
require('Table.php');
if ($_SERVER["REQUEST_METHOD"]=="GET"){
session_start();
$time_start = microtime(true); 
$x = strip_tags($_GET["x"]);
echo $x.$_GET["x"];
$y=substr(strip_tags($_GET["y"]),0,15);
$r=strip_tags($_GET["r"]);
date_default_timezone_set($_GET["timeZone"]);
$row = new Row($x,$y,$r,$time_start, date("h:i:s A"));
if (validate($x,$y,$r))
{
    $row->isHit();
}




if (isset($_SESSION["rows"])){
    $table = new Table($_SESSION["rows"]);
}
else{
    $table = new Table([]);
}
$table->addRow($row);
$table->saveTable();

}
function validate($x,$y,$r){
    $xarray = array(-2,-1.5,-1,-0.5,0,0.5,1,1.5,2);
    $rarray=array(1,1.5,2,2.5,3);
    if (!in_array($x, ($xarray)) || !in_array($r, ($rarray))|| !is_numeric($y)||$y>5||$y<-5){
        return(false);
    }
    return(true);


}



?>