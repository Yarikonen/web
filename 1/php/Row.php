<?php
class Row
{
    public $x,$y,$birthTime, $time,$r, $booling="notValid",$exTime=0;
    function __construct($x,$y,$r,$birthTime, $time)
    {
        $this->x=$x;
        $this->y=$y;
        $this->r=$r;
        $this->birthTime=$birthTime;
        $this->time=$time;
    }
    function toString(){
        return '<tr><td>' . $this->booling . '</td><td>' . sprintf('%.2e', $this->exTime) . '</td><td>' . $this->time . '</td>'
        . '<td>' . $this->x . '</td>'
        . '<td>' . $this->y . '</td>'
        . '<td>' . $this->r . '</td></tr>';
    }
    function isHit(){
        $this->booling="no";
        if($this->x>=0 && $this->x<=$this->r/2&& $this->y<=$this->r && $this->y>=0){ $this->booling="yes";}
        if($this->x>0 && $this->y<=0&&$$this->x**2+$this->y**2<=($this->r**2)/4) {$this->booling="yes";}
        if($this->x<0 && $this->y>=-$this->x-$this->r&&$this->y<=0) {$this->booling="yes";}
        $time_end = microtime(true);
        $this-> exTime=$time_end-$this->birthTime;

    }
   
}

?>