import com.alibaba.fastjson.JSON;
import com.yuxuan.wechat.feigns.FeignBuilder;
import com.yuxuan.wechat.feigns.OAuthApi;
import com.yuxuan.wechat.feigns.TokenApi;
import com.yuxuan.wechat.models.*;
import com.yuxuan.wechat.utils.SignUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
//        MessageApi messageApi = Feign.builder()
//                .encoder(new WechatBodyEncoder())
//                .decoder(new WeChatDecoder())
//                .errorDecoder(new WeChatErrDecoder())
//                .options(new Request.Options(5000, 20000))
//                .target(MessageApi.class, MessageApi.class.getAnnotation(Domain.class).value());
//                messageApi.sentAppletMessage("111",appletMessage);

        String message = "{\n" +
                "  \"data\": {},\n" +
//                "  \"emphasis_keyword\": \"string\",\n" +
                "  \"form_id\": \"\",\n" +
//                "  \"page\": \"string\",\n" +
                "  \"template_id\": \"\",\n" +
                "  \"touser\": \"\"\n" +
                "}";
        String ACCESS_TOKEN = "";


        AppletMessage appletMessage = JSON.parseObject(message, AppletMessage.class);
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + ACCESS_TOKEN;
        String result = HttpRequestUtil.sendPost(url, "application/json", JSON.toJSONString(appletMessage));
        System.out.println(result);
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
