package org.chat.config;

import org.chat.utils.nlpir.Nlpir;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    /**
     * 分词封装bean
     * @return
     */
    @Bean
    public Nlpir getNlpir(){
        return new Nlpir();
    }
}
