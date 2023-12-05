import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/*
@Service
public class WeatherService {

    private String apiKey = "apikey ?添加추가";  //api key 추가
    private String baseUrl = "http://api.openweathermap.org/data/2.5/forecast";

    public boolean willRainWithinHour(String city, LocalDateTime matchDateTime) {
        String url = baseUrl + "?q=" + city + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        // 检查一小时前是否下雨 한 시간 전에 비가 내렸는지 확인
        return false;  // true or false
    }
}
*/