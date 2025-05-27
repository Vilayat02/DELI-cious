package com.pluralsight.model;

public abstract class Item implements Priceable{
    protected int type;
    protected boolean extra;

    public Item(int type, boolean extra) {
        this.type = type;
        this.extra = extra;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

}
