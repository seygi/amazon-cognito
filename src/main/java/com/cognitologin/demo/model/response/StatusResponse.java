package com.cognitologin.demo.model.response;

public class StatusResponse {

    private Integer status;

    private String message;

    public StatusResponse() {

    }

    public StatusResponse(Integer status) {
        this.status = status;
    }

    public StatusResponse(Integer status, String message) {
        this.status = status;
        this.message = message;

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusResponse{");
        sb.append("status=").append(status);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

