package com.reimia.socketTest.response;

import java.util.UUID;

public class AllotmentLineResponse {
    String id = "zjft_AllotmentLine_001";
    String msgType = "TbrainToAllotmentLineResponseMsg";
    Response response;

    class Response {
        Header header;
        Body body;

        class Header {
            String responseId = UUID.randomUUID().toString();
            int code = 0;
            String msg = "success";

            public String getResponseId() {
                return responseId;
            }

            public void setResponseId(String responseId) {
                this.responseId = responseId;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }
        }

        class Body {

        }

        public Header getHeader() {
            return header;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
