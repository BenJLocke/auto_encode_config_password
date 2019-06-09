package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.Yaml;

import com.example.demo.config.ApplicationConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPassword {

    @Autowired
    StringEncryptor encryptor;
 
    @Value("${code.push.password}")
    private  String bb;
 
    @Test
    public void encry(){
// 加密
        String username = encryptor.encrypt("admin");
        String pwd = encryptor.encrypt(bb);
        System.out.println("userName：" + username);
        System.out.println("pwd：" + pwd);
//解密
        //String codeName =ConfigUtil.getCodeValue("CODE_PUSH_ACCOOUNT");//获取任意配置的工具类
        //System.out.println("codeName：" + codeName);
        System.out.println("明文：" + bb);
        System.out.println("明文：" + encryptor.decrypt(pwd));
    }
    
    @Test
    public void uppdateApplication() {
        try {
            Yaml yaml = new Yaml();
            	Map map =(Map)yaml.load(new FileInputStream(new File("conf/application.yml")));
            	Writer output = new OutputStreamWriter(new FileOutputStream(new File("conf/application1.yml")));
				yaml.dump(map, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testApplicationConfig() {
        try {
            Yaml yaml = new Yaml();
            ApplicationConfig config = yaml.loadAs(new FileInputStream(new File("conf/application.yml")), ApplicationConfig.class);
            	Writer output = new OutputStreamWriter(new FileOutputStream(new File("conf/application2.yml")));
				config.getHosts().forEach(e ->{
					String pwd = e.getPassword();
					if (pwd.indexOf("ENC(") != 0) {
						e.setPassword(String.format("ENC(%s)",encryptor.encrypt(pwd)));
					}
				});
				yaml.dump(config, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
