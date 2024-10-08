package Hotel.ReviewService.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewConfig {


    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
