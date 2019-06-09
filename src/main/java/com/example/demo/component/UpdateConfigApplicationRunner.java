package com.example.demo.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import com.example.demo.config.ApplicationConfig;

@Component
public class UpdateConfigApplicationRunner  implements ApplicationRunner{

    @Autowired
    StringEncryptor encryptor;
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
        try {
            Yaml yaml = new Yaml();
            ApplicationConfig config = yaml.loadAs(new FileInputStream(new File("conf/application.yml")), ApplicationConfig.class);
            	Writer output = new OutputStreamWriter(new FileOutputStream(new File("conf/application.yml")));
				config.getHosts().forEach(e ->{
					String pwd = e.getPassword();
					if (pwd.indexOf("ENC(") != 0) {
						e.setPassword(String.format("ENC(%s)",encryptor.encrypt(pwd)));
					}
				});
				//yaml.dump(config, output);
				String newConfig = yaml.dumpAsMap(config);
				output.write(newConfig);
				output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
