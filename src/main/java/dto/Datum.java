package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Datum {
    @JsonProperty("ID Nation")
    private String iDNation;
    @JsonProperty("Nation")
    private String nation;
    @JsonProperty("ID Year")
    private int iDYear;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Population")
    private int population;
    @JsonProperty("Slug Nation")
    private String slugNation;
}
