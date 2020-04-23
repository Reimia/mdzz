package com.reimia.convert2;

public class HikvisionDataResponse<T> extends HikvisionBaseResponse {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
