package com.yuxuan.wechat.feigns.coders;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 异常响应处理
 *
 * @author yuxuan
 * @date 2019/5/23
 */
public class WeChatErrDecoder implements ErrorDecoder {

    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }

    @Override
    public Exception decode(String s, Response response) {
        try {
            String respBody = inputStream2String(response.body().asInputStream());
            System.out.println(respBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw FeignException.errorStatus(s, response);
    }
}
