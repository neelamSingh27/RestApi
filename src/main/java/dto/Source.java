package dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Source {
    private ArrayList<String> measures;
    private Annotations annotations;
    private String name;
    private ArrayList<Object> substitutions;
}
