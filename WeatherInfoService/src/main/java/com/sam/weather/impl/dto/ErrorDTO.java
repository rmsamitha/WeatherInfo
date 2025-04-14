package com.sam.weather.impl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.*;
import javax.validation.constraints.NotNull;

@ApiModel(description = "")
public class ErrorDTO {


    @NotNull
    private Long code = null;

    @NotNull
    private String message = null;


    private String description = null;


    private String moreInfo = null;


    /**
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("code")
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }


    /**
     * Error message.
     */
    @ApiModelProperty(required = true, value = "Error message.")
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * A detail description about the error message.
     */
    @ApiModelProperty(value = "A detail description about the error message.")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Preferably an url with more details about the error.
     */
    @ApiModelProperty(value = "Preferably an url with more details about the error.")
    @JsonProperty("moreInfo")
    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }






    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorDTO {\n");
        sb.append("  code: ").append(code).append("\n");
        sb.append("  message: ").append(message).append("\n");
        sb.append("  description: ").append(description).append("\n");
        sb.append("  moreInfo: ").append(moreInfo).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
