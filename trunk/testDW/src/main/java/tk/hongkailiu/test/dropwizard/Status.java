package tk.hongkailiu.test.dropwizard;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    @JsonProperty("Status")
    private String status = "success";
}
