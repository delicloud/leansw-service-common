package com.thoughtworks.lean.config.contract;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by jxzhong on 10/18/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "status", "title", "details"})
public class ResponseError implements Serializable {

    @ApiModelProperty(value = "Error ID", required = false)
    private final String id;

    @ApiModelProperty(value = "Error HTTP status code", required = false)
    private final String status;

    @ApiModelProperty(value = "Error shot description", required = false)
    private final String title;

    @ApiModelProperty(value = "Error code", required = false)
    private final String code;

    @ApiModelProperty(value = "Error details", required = false)
    private final String details;

    public ResponseError(String title) {
        this(null, null, null, title, null);
    }

    public ResponseError(Integer statusCode, String title) {
        this(null, statusCode, null, title, null);
    }

    public ResponseError(String title, String details) {
        this(null, null, null, title, details);
    }

    public ResponseError(Integer statusCode, String title, String details) {
        this(null, statusCode, null, title, details);
    }

    public ResponseError(String id, Integer statusCode, String code, String title, String details) {
        this.id = id;
        this.status = statusCode == null ? null : statusCode.toString();
        this.title = title;
        this.code = code;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseError{");
        sb.append("id='").append(id).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", details='").append(details).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
