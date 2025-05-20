package com.videstech.truequeapp.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewCreateDTO {

    @NotNull
    private Long reviewedId;

    @Min(1)
    @Max(5)
    private int rating;

    private String comment;

}

