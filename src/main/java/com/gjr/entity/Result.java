package com.gjr.entity;

import com.alibaba.druid.support.json.JSONUtils;
import com.gjr.constant.ErrorCode;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geng
 * on 2017/3/19.
 */
public class Result<T> {
    public static final Integer SUCCESS = 1;
    public static final Integer FAILED = 0;

    private T data;
    private Integer status;


    public static <T> Builder<T> builder() {
        return new Builder<T>();
    }

    public static class Builder<T> {
        private T data;
        private Integer status;
        private String stage;

        public Builder() {

        }

        public Result build() {
            Assert.notNull(status, "status不能为空");
            Assert.notNull(data, "data不能为空");
            if (null != stage) {
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("data", data);
                map.put("stage", stage);
                Result<Map<String, Object>> result = new Result<Map<String, Object>>();
                result.setData(map);
                result.setStatus(this.status);
                return result;
            }
            Result<T> result = new Result<T>();
            result.setData(data);
            result.setStatus(this.status);
            return result;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder data(String message) {
            Map<String, String> map = new HashMap();
            map.put("message", message);
            this.data = (T) map;
            return this;
        }


        public Builder node(String node) {
            this.data = (T) JSONUtils.parse(node);
            return this;
        }

        public Builder stage(String stage) {
            this.stage = stage;
            return this;
        }

        public Builder failed(ErrorCode errorCode, String message) {
            Map<String, Object> map = new HashMap();
            map.put("errorCode", 0);
            map.put("message", message);
            this.data = (T) map;
            this.status = FAILED;
            return this;
        }

        public Builder failed(ErrorCode errorCode) {
            Map<String, Object> map = new HashMap();
            map.put("errorCode", errorCode.getIndex());
            map.put("message", errorCode.getName());
            this.data = (T) map;
            this.status = FAILED;
            return this;
        }

        public Builder success() {
            this.status = SUCCESS;
            return this;
        }

        public Builder failed() {
            this.status = FAILED;
            return this;
        }
    }

    public Result() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}