package com.reimia.haikang;

public class DTO {

    private Integer[] eventTypes;

    private String eventDest;

    private Integer subType;

    private Integer[] eventLvl;

    public Integer[] getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(Integer[] eventTypes) {
        this.eventTypes = eventTypes;
    }

    public String getEventDest() {
        return eventDest;
    }

    public void setEventDest(String eventDest) {
        this.eventDest = eventDest;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer[] getEventLvl() {
        return eventLvl;
    }

    public void setEventLvl(Integer[] eventLvl) {
        this.eventLvl = eventLvl;
    }
}
