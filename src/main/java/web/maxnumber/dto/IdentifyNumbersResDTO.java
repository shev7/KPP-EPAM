package web.maxnumber.dto;

import web.maxnumber.entities.CustomNumber;

import javax.validation.constraints.NotNull;

import java.util.List;

public class IdentifyNumbersResDTO {
    @NotNull
    public List<CustomNumber> list;

    @NotNull
    public Integer maxNumber;

    @NotNull
    public Integer minNumber;

    @NotNull
    public Integer sum;

    @NotNull
    public Double average;
}
