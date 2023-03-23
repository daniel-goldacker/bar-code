package io.github.danielgoldacker.barCode.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class QrcodeRequest {

    @NotBlank(message = "text is required")
    private String text;

    @NotNull(message = "width is required")
    private Integer width;

    @NotNull(message = "height is required")
    private Integer height; 
    
}
