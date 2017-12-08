package com.intracom.ems.workshop.model;

public class Link {
    private String ipA;
    private String portA;
    private String ipB;
    private String portB;
    private double[] pointA;
    private double[] pointB;

    public String getIpA() {
        return ipA;
    }

    public void setIpA(String ip) {
        this.ipA = ip;
    }

    public String getPortA() {
        return portA;
    }

    public void setPortA(String port) {
        this.portA = port;
    }

    public String getIpB() {
        return ipB;
    }

    public void setIpB(String ip) {
        this.ipB = ip;
    }

    public String getPortB() {
        return portB;
    }

    public void setPortB(String port) {
        this.portB = port;
    }

    public double[] getPointA() {
        return pointA;
    }

    public void setPointA(double[] point) {
        this.pointA = point;
    }

    public double[] getPointB() {
        return pointB;
    }

    public void setPointB(double[] point) {
        this.pointB = point;
    }
}
