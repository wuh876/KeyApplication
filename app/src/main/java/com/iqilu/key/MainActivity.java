package com.iqilu.key;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String privateKeyHex = "FAB8BBE670FAE338C9E9382B9FB6485225C11A3ECB84C938F10F20A93B6215F0";
//        String x = "9EF573019D9A03B16B0BE44FC8A5B4E8E098F56034C97B312282DD0B4810AFC3";
//        String y = "CC759673ED0FC9B9DC7E6FA38F0E2B121E02654BF37EA6B63FAF2A0D6013EADF";
//
//// 数据和ID此处使用16进制表示
//        String data = "434477813974bf58f94bcf760833c2b40f77a5fc360485b0b9ed1bd9682edb45";
//        String id = "31323334353637383132333435363738";
//
//        final SM2 sm2 = new SM2(privateKeyHex, x, y);
//// 生成的签名是64位
//        sm2.usePlainEncoding();
//
//        final String sign = sm2.signHex(data, id);
//// true
//        boolean verify = sm2.verifyHex(data, sign);


        String text = "我是一段测试aaaa";

        SM2 sm2 = SmUtil.sm2();
// 公钥加密，私钥解密
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));

        Log.i("TAG", "onCreate: " + encryptStr);
        Log.i("TAG", "onCreate: " + decryptStr);

    }
}