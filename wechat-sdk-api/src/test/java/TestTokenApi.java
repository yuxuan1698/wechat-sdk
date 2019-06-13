import com.alibaba.fastjson.JSON;
import com.yuxuan.wechat.feigns.FeignBuilder;
import com.yuxuan.wechat.feigns.OAuthApi;
import com.yuxuan.wechat.feigns.TokenApi;
import com.yuxuan.wechat.models.*;
import com.yuxuan.wechat.utils.SignUtil;
import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.Ticket;

/**
 * @author yuxuan
 * @date 2019/5/22
 */
public class TestTokenApi {

    private static final String appid = "";
    private static final String secret = "";

    @Before
    public void init(){

    }

    @Test
    public void token(){
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
    public void oauth(){
        OAuthApi oAuthApi = FeignBuilder.builderOAuthApi();

        String code = "";
        // 网页授权
        AccessToken accessToken = oAuthApi.access_token(appid, secret, code);
        System.out.println(JSON.toJSONString(accessToken));

        // 获取用户信息
        UserInfo userInfo = oAuthApi.userinfo(accessToken.getAccess_token(),accessToken.getOpenid());
        System.out.println(JSON.toJSONString(userInfo));

        // 小程序授权
        CodeSession session = oAuthApi.code2session(appid, secret, code);
        System.out.println(JSON.toJSONString(session));
    }
}
