<?php
class Table{
    private $rows;
    function __construct($rows){
        $this->rows=array($rows);
        
    }
    function saveTable(){
        if(count($this->rows)>22){
            array_shift($this->rows);
        }
        $_SESSION["rows"]=$this->rows;
        $table="<tr>
        <th>Статус попадания </th>
        <th>Длительность выполнения</th>
        <th>Время выполнения</th>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
    </tr>";
        
        foreach($this->rows as $el){
            $table .= $el;
        }
    
     echo $table;
    }
    function addRow($row){
        array_push($this->rows,$row);
    }

}
?>