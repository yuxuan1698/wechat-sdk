package com.yuxuan.wechat.utils;

import com.alibaba.fastjson.JSON;
import com.yuxuan.wechat.models.DecryptedPhone;
import com.yuxuan.wechat.models.DecryptedUserInfo;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * 添加依赖
 * <dependency>
 * <groupId>org.bouncycastle</groupId>
 * <artifactId>bcprov-jdk15on</artifactId>
 * <version>1.54</version>
 * </dependency>
 */

/**
 * 微信小程序解密手机号工具
 *
 * @author yuxuan
 * @date 2018/5/24
 */
public class AesDecrypt {

    public static void main(String[] args) {

//        String encryData = "G2J/RiEqYRyBfgythQUWs6Hhi47VDFtoCG8ot7E7/+6ejSvZJKKTG38YSEWlaFtnGbV6S6fJhfQmudQcNXdLI6gUPs0FYuHc/ggOL6ehU6qNtDwSew1VXUCsksOrnvICxayvYqfkt2JijD2bNCIMH8J8GxAuh/UWpICtLAALktlvym3tGH5jr/M3xBb1rJDbUuxyKs9Hs/ethnTzBu/oPg==";
//        String sessionKey = "xE75LxA5yyjpDBKKnNU5uA==";
//        String iv = "WKPymPH75xXd7+2j1VL35Q==";
//        String decryptData = decrypt(encryData, sessionKey, iv);
//        System.out.println(decryptData);
//        DecryptedPhone decryptedPhone = JSON.parseObject(decryptData, DecryptedPhone.class);
//        System.out.println(JSON.toJSONString(decryptedPhone));

        String encryData = "j2XoDJemR/PeT4IBDj4Bnlw1vgGloIEah6E0ltYlp8cQTBG/+unM9Xs6ziV5R6D1otC1raUAg209ltK1S2vHq9t9WVoeKBUYki/BZfWlXYCk+dRcj++GjFow18OW3wIElZ+KSSu9u6M4g4I8Z5672yt9jgnoisz3qKEpyD3Bxm6hkMB9gTPhFeP3Ll6unBxqZvxE8MJbpyoX4peJykngfZ1zsOvFpHJIZtP8ru/53I+BMepsXvXMHDkgr7CPsijxUVbMBewXK2kwT3gizbd3yQyvrLkpU2P0hNLW/6KkhuNSlGTaoyhznXj2HnvvEYJr/7Oc2h4gD4h2QrvRdr4eF9pWkO723t0U9iekcAGmNHfAXgyVT+JbH9aDq1GTRkHXOd8zgkP0jTTaw4lHXY3HkZ7ZSL63DeA/hnl5+iQNnAtLvS3UqQT/XofPV3Y58tt3LxPSexF8PID4zU5ULQvRBeAsbq38xRM+zDEeke3lPqk=";
        String sessionKey = "dDdM6HJLTBqBOyDuPcWEpw==";
        String iv = "S/mmnSpvYValrTdWw1TJAQ==";

        String decryptData = decrypt(encryData, sessionKey, iv);
        System.out.println(decryptData);
        DecryptedUserInfo decryptedUserInfo = JSON.parseObject(decryptData, DecryptedUserInfo.class);

        System.out.println(JSON.toJSONString(decryptedUserInfo));

    }


    public static boolean initialized = false;

    /**
     * 解密
     * @param encryptedData  getPhoneNumber 取到的加密字段
     * @param sessionKey
     * @param iv
     * @return
     */
    public static String decrypt(String encryptedData, String sessionKey, String iv){
        try {
            byte[] resultByte = decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if(null != resultByte && resultByte.length > 0){
                String decryptData = new String(resultByte, "UTF-8");
                return decryptData;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES解密
     * @param content 密文
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchProviderException
     */
    public static byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");

            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void initialize(){
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    //生成iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception{
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }
}
