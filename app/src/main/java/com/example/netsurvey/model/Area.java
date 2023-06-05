package com.example.netsurvey.model;

public class Area {
    private int id;
    private String start,end,corridor,region,shoulderType,startPoint,endPoint,road,link, subLink;

    public Area(int id, String start, String end, String corridor, String region, String shoulderType, String startPoint, String endPoint, String road, String link, String subLink) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.corridor = corridor;
        this.region = region;
        this.shoulderType = shoulderType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.road = road;
        this.link = link;
        this.subLink = subLink;
    }

    public Area(String start, String end, String corridor, String region, String shoulderType, String startPoint, String endPoint, String road, String link, String subLink) {
        this.start = start;
        this.end = end;
        this.corridor = corridor;
        this.region = region;
        this.shoulderType = shoulderType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.road = road;
        this.link = link;
        this.subLink = subLink;
    }

    public Area() {
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSubLink() {
        return subLink;
    }

    public void setSubLink(String subLink) {
        this.subLink = subLink;
    }

    public int getId() {
        return id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCorridor() {
        return corridor;
    }

    public void setCorridor(String corridor) {
        this.corridor = corridor;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShoulderType() {
        return shoulderType;
    }

    public void setShoulderType(String shoulderType) {
        this.shoulderType = shoulderType;
    }
}
