package com.laoge.promise.common.resp;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

/**
 * Created by yuhou on 2017/5/10.
 */
@JsonComponent //指定Json序列化方式
public class Response<T> {

    private Integer code;
    private T data;
    private String msg;

    public Response() {
    }

    public Response(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("code=").append(code);
        sb.append(", data=").append(data);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Serializer extends JsonObjectSerializer<Response> {

        @Override
        protected void serializeObject(Response value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            super.serialize(value, jgen, provider);
        }
    }

    public static class Descerializer extends JsonObjectDeserializer<Response> {


        @Override
        protected Response deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
            return super.deserialize(jsonParser, context);
        }
    }
}
