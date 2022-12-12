package beans;

import sql.Saveable;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Row implements Serializable, Saveable {
    private double x;
    private double y;
    private double r=1;
    private LocalTime birthTime;
    private boolean hit =false;
    private long exTime;
    public Row(){
        this.exTime=System.nanoTime();
        this.birthTime=LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }
    public Row(double x, double y, double r, ZoneId zone){
        this.x=x;
        this.y=y;
        this.r = r;
        this.birthTime=LocalTime.now(zone).truncatedTo(ChronoUnit.SECONDS);
        this.exTime=System.nanoTime();
    }


    public void checkZone() {
        if (x>=0 &&y>=0 && y<=r && x<=r/2) hit = true;
        if (x>0 && y<=0 && x*x+y*y<=r*r/4) hit = true;
        if (x<0 && y<=0 && y>=-x-r) hit = true;
        exTime = -exTime + System.nanoTime();

    }
    @Override
    public String toString() {
        return ("<tr><td>" + hit + "</td><td>" + exTime + "</td><td>" + birthTime +  "</td>"
                + "<td name=xT>" + Math.round(x*1000.0)/1000.0 + "</td>"
                + "<td class=yT>" + Math.round(y*1000.0)/1000.0 + "</td>"
                + "<td class=rT>" + r +  "</td></tr>");
    }
    public String data(){
        return("$" + x + " " + y + " " + r);
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

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public long getExTime() {
        return exTime;
    }

    public void setExTime(long exTime) {
        this.exTime = exTime;
    }


    @Override
    public void save() {

    }
}
