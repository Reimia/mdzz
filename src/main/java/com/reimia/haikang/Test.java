package com.reimia.haikang;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static String GetCameraPreviewURL() {

        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        ArtemisConfig.host = "127.0.0.1:443"; // artemis网关服务器ip端口
        ArtemisConfig.appKey = "29180881";  // 秘钥appkey
        ArtemisConfig.appSecret = "XO0wCAYGi4KV70ybjznx";// 秘钥appSecret

        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";

        /**
         * STEP3：设置接口的URI地址
         */
        final String previewURLsApi = ARTEMIS_PATH + "/api/video/v1/cameras/previewURLs";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", previewURLsApi);//根据现场环境部署确认是http还是https
            }
        };

        new HashMap<String,Object>(){{ }};
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", "748d84750e3a4a5bbad3cd4af9ed5101");
        jsonBody.put("streamType", 0);
        jsonBody.put("protocol", "rtsp");
        jsonBody.put("transmode", 1);
        jsonBody.put("expand", "streamform=ps");
        String body = jsonBody.toJSONString();
        /**
         * STEP6：调用接口
         */
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType , null);// post请求application/json类型参数
        return result;
    }

    public static void main(String[] args) {
//        String result = GetCameraPreviewURL();
//        System.out.println("result结果示例: " + result);

        String s = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"msg\": \"Success\",\n" +
                "    \"data\": {\n" +
                "        \"indexCode\": \"5dc82633-a4cb-4107-b55e-f21bbdf952f9\",\n" +
                "        \"name\": \"仓库值守人员\",\n" +
                "        \"description\": \"仓库值守人员是指守着仓库的人\"\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        DTO dto = new DTO();
        dto.setEventDest("aaa");
        dto.setEventLvl(new Integer[]{1,2,3});
        JSONObject jsonObject1 = JSONObject.parseObject(JSONObject.toJSONString(dto));
        System.out.println(1);
    }
}
