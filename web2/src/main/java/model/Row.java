package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Row implements Serializable {
    private double x;
    private double y;
    public Row(){
        this.exTime=System.nanoTime();
    }
    public Row(double x, double y, double r, ZoneId zone){
        this.x=x;
        this.y=y;
        this.r = r;
        this.birthTime=LocalTime.now(zone).truncatedTo(ChronoUnit.SECONDS);
        this.exTime=System.nanoTime();
    }

    public void isHit() {
        if (x>=0 &&y>=0 && y<=r && x<=r/2) booling = true;
        if (x>0 && y<=0 && x*x+y*y<=r*r/4) booling = true;
        if (x<0 && y<=0 && y>=-x-r) booling = true;
        exTime = -exTime + System.nanoTime();

    }
    @Override
    public String toString() {
        return ("<tr><td>" + booling + "</td><td>" + exTime + "</td><td>" + birthTime +  "</td>"
                + "<td name=xT>" + Math.round(x*1000.0)/1000.0 + "</td>"
                + "<td name=yT>" + Math.round(y*1000.0)/1000.0 + "</td>"
                + "<td name=rT>" + r +  "</td></tr>");
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public LocalTime getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(LocalTime birthTime) {
        this.birthTime = birthTime;
    }

    public boolean isBooling() {
        return booling;
    }

    public void setBooling(boolean booling) {
        this.booling = booling;
    }

    public long getExTime() {
        return exTime;
    }

    public void setExTime(long exTime) {
        this.exTime = exTime;
    }

    private double r;
    private LocalTime birthTime;
    private boolean booling=false;
    private long exTime;



}
