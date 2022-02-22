package dto;

import java.util.ArrayList;


public class UsaData {
    private ArrayList<Datum> data;
    private ArrayList<Source> source;

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public ArrayList<Source> getSource() {
        return source;
    }

    public void setSource(ArrayList<Source> source) {
        this.source = source;
    }
}
