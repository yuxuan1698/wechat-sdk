import com.alibaba.fastjson.JSON;
import com.yuxuan.wechat.feigns.FeignBuilder;
import com.yuxuan.wechat.feigns.MessageApi;
import com.yuxuan.wechat.feigns.OAuthApi;
import com.yuxuan.wechat.feigns.TokenApi;
import com.yuxuan.wechat.models.*;
import com.yuxuan.wechat.utils.SignUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuxuan
 * @date 2019/5/22
 */
public class TestTokenApi {

    private static final String appid = "";
    private static final String secret = "";

    private static MessageApi messageApi;

    @Before
    public void init() {
        this.messageApi = FeignBuilder.builderMessageApi();
    }

    @Test
    public void wechatMessage() {
        String access_token = "";
        WechatMessage wechatMessage = new WechatMessage();
        wechatMessage.setTouser("");
        wechatMessage.setTemplate_id("h0rOgpLENr0HKoMYrNdZDTUKdldYT75_jiH4vOmOsTY");
        wechatMessage.setUrl("http://www.baidu.com");
        WechatMessage.Miniprogram miniprogram = new WechatMessage.Miniprogram("wxc3036d32665effa9", null);
        wechatMessage.setMiniprogram(miniprogram);

        Map<String, Object> data = new HashMap<>();
        Map<String, String> first = new HashMap<>();
        first.put("value", "【营业日报】");
        first.put("color", "#173177");
        data.put("first", first);
        Map<String, String> keyword1 = new HashMap<>();
        keyword1.put("value", "当期日期：2019-08-27 星期五");
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);
        Map<String, String> keyword2 = new HashMap<>();
        keyword2.put("value", "毛收收入：￥100 堂食收入：￥100");
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);
        Map<String, String> keyword3 = new HashMap<>();
        keyword3.put("value", "三十二分店");
        keyword3.put("color", "#173177");
        data.put("keyword3", keyword3);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "备注备注");
        remark.put("color", "#173177");
        data.put("remark", remark);
        wechatMessage.setData(data);

        WechatMessageResult result = messageApi.sendWechatMesssage(access_token, wechatMessage);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void appletMessage() {
        String access_token = "";
        AppletMessage appletMessage = new AppletMessage();
        appletMessage.setTouser("");
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

        BaseResult result = messageApi.sendAppletMessage(access_token, appletMessage);
        System.out.println(JSON.toJSONString(result));
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
