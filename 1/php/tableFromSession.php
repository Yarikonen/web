<?php
 session_start();
 $table="<tr>
 <th>Статус попадания </th>
 <th>Длительность выполнения</th>
 <th>Время выполнения</th>
 <th>X</th>
 <th>Y</th>
 <th>R</th>
</tr>";
if (isset($_SESSION["rows"])){
    foreach(($_SESSION["rows"]) as $el){
        $table .= $el->toString();
    }
}
echo $table;
?>