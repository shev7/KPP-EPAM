package web.maxnumber.dto;

import javax.validation.constraints.NotNull;

public class NumberDTO {
    @NotNull
    public Integer firstNumber;

    @NotNull
    public Integer secondNumber;

    @NotNull
    public Integer thirdNumber;
}
