import com.alibaba.fastjson.JSON;
import com.yuxuan.wechat.annotations.Domain;
import com.yuxuan.wechat.feigns.FeignBuilder;
import com.yuxuan.wechat.feigns.MessageApi;
import com.yuxuan.wechat.feigns.OAuthApi;
import com.yuxuan.wechat.feigns.TokenApi;
import com.yuxuan.wechat.feigns.coders.CommonEncoder;
import com.yuxuan.wechat.feigns.coders.WeChatDecoder;
import com.yuxuan.wechat.feigns.coders.WeChatErrDecoder;
import com.yuxuan.wechat.models.*;
import com.yuxuan.wechat.utils.SignUtil;
import feign.Feign;
import feign.Request;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuxuan
 * @date 2019/5/22
 */
public class TestTokenApi {

    private static final String appid = "";
    private static final String secret = "";

    @Before
    public void init() {

    }

    @Test
    public void message() throws IOException {
        MessageApi messageApi = Feign.builder()
                .encoder(new CommonEncoder())
                .decoder(new WeChatDecoder())
                .errorDecoder(new WeChatErrDecoder())
                .options(new Request.Options(5000, 20000))
                .target(MessageApi.class, MessageApi.class.getAnnotation(Domain.class).value());

//        String message = "{\n" +
//                "  \"data\": {},\n" +
////                "  \"emphasis_keyword\": \"string\",\n" +
//                "  \"form_id\": \"\",\n" +
////                "  \"page\": \"string\",\n" +
//                "  \"template_id\": \"\",\n" +
//                "  \"touser\": \"\"\n" +
//                "}";
//        String ACCESS_TOKEN = "";

        String message = "{\n" +
                "\"data\": {\n" +
                "\"keyword1\": {\n" +
                "\"value\": \"339208499\"\n" +
                "},\n" +
                "\"keyword2\": {\n" +
                "\"value\": \"2015年01月05日 12:30\"\n" +
                "}\n" +
                "},\n" +
                "\"form_id\": \"c64719d9607c4a0bac48ed319e5bccee\",\n" +
                "\"template_id\": \"ah6YTZgE13iwVY5-0oalroIDXowNkVHtvZky0vHv9_A\",\n" +
                "\"touser\": \"oJjEk0W6smrl95MrwKTXY1NuRgLU\"\n" +
                "}";
        String ACCESS_TOKEN = "24_v1PvZ5ddcgu-vu-qF7aerzoeEoUwmc_5r68Ztdvnhj5xruIzCFvOGdK72mhPjz3FVxLHK2NwbgSuIYtvRm3H7gewFQf_yPsOk1r0puAVuxRcxCNUd_U6MtP3-ennxmnHjN4LdUpy3257Be7zHLXbAAADHT";
        //AppletMessage appletMessage = JSON.parseObject(message, AppletMessage.class);

        AppletMessage appletMessage = new AppletMessage();
        appletMessage.setTouser("oJjEk0W6smrl95MrwKTXY1NuRgLU");
        appletMessage.setTemplate_id("ah6YTZgE13iwVY5-0oalroIDXowNkVHtvZky0vHv9_A");
        appletMessage.setForm_id("0fca94c5e67a4ea7a075724329039e36");
        Map<String, Object> data = new HashMap<>();

        Map<String, String> keyword1 = new HashMap<>();
        keyword1.put("value", "339208499");
        data.put("keyword1", keyword1);

        Map<String, String> keyword2 = new HashMap<>();
        keyword2.put("value", "2015年01月05日 12:30");
        data.put("keyword2", keyword2);

        appletMessage.setData(data);

        Map result = messageApi.sendAppletMessage(ACCESS_TOKEN, appletMessage);
        System.out.println(JSON.toJSONString(result));

//        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + ACCESS_TOKEN;
//        String result = HttpRequestUtil.sendPost(url, "application/json", JSON.toJSONString(appletMessage));
//        System.out.println(result);
    }

    @Test
    public void token() {
        TokenApi tokenApi = FeignBuilder.builderTokenApi();
        // 获取APPtoken
        Token token = tokenApi.token(appid, secret);
        System.out.println(JSON.toJSONString(token));

        // 获取ticke
        JsApiTicket jsApiTicket = tokenApi.ticket(token.getAccess_token());
        System.out.println(JSON.toJSONString(jsApiTicket));

        // 生成签名
        System.out.println(SignUtil.createJsApiSignature(appid, jsApiTicket.getTicket(), "https://api.qishixingqiu.com/"));
    }

    @Test
    public void oauth() {
        OAuthApi oAuthApi = FeignBuilder.builderOAuthApi();

        String code = "";
        // 网页授权
        AccessToken accessToken = oAuthApi.access_token(appid, secret, code);
        System.out.println(JSON.toJSONString(accessToken));

        // 获取用户信息
        UserInfo userInfo = oAuthApi.userinfo(accessToken.getAccess_token(), accessToken.getOpenid());
        System.out.println(JSON.toJSONString(userInfo));

        // 小程序授权
        CodeSession session = oAuthApi.code2session(appid, secret, code);
        System.out.println(JSON.toJSONString(session));
    }
}
