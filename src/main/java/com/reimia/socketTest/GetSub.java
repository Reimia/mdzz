package com.reimia.socketTest;

import com.alibaba.fastjson.JSONPath;
import org.intellij.lang.annotations.Language;
import org.springframework.util.Assert;


public class GetSub {
    public static void main(String[] args) {
        @Language("JSON") String s = "{\n" +
                "  \"msgType\": \"RobotTaskResponseMsg\",\n" +
                "  \"response\": {\n" +
                "    \"header\": {\n" +
                "      \"msg\": \"Success\",\n" +
                "      \"code\": 0,\n" +
                "      \"responseId\": \"a5a3eb48-1e10-4829-80cb-3b181d5339ad\"\n" +
                "    },\n" +
                "    \"body\": {\n" +
                "      \"taskId\": 54\n" +
                "    }\n" +
                "  },\n" +
                "  \"id\": \"geekCode_geekWarehouseCode_002\"\n" +
                "}";

        String sub = getSub(s, "response.body.taskId");
        Assert.isTrue("54".equals(sub), "不正确，你的sub值是" + sub);
    }

    public static String getSub(String s1, String s2) {
        Object read = JSONPath.read(s1, "$." + s2);
        if (read == null) {
            return "";
        }
        return read.toString();
    }

}
