package ru.itis.demo.services.implementations;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.itis.demo.services.interfaces.SmsService;


@Slf4j
@Component
public class SmsServiceImpl implements SmsService {
//    @Value("${sms.ru.url}")
    private String smsUrl = "https://sms.ru/sms/send";

//    @Value("${sms.ru.api_id}") //спросить
    private String apiId = "94303D0C-0845-9EA5-E5A6-7319FFEA4F05";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void sendSms(String phone, String text) {
        String url = smsUrl + "?api_id=" + apiId + "&to=" + phone + "&msg=" + text + "&json=1";
        log.info(url);
        String result = restTemplate.getForObject(url, String.class);
        log.info(result);
    }

}
