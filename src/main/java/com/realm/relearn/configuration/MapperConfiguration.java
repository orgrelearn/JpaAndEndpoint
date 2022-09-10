package com.realm.relearn.configuration;

import com.realm.relearn.dto.PostResponse;
import com.realm.relearn.model.Post;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class MapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {

        Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };

        Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(source, format);
                return localDate;
            }
        };

        PropertyMap<Post, PostResponse> propertyMap = new PropertyMap<Post, PostResponse>(){
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setTitle(source.getTitle());
                map().setDescription(source.getDescription());
                map().setContent(source.getContent());
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(String.class, LocalDate.class);
        modelMapper.addConverter(toStringDate);
        modelMapper.getTypeMap(String.class,LocalDate.class).setProvider(localDateProvider);

        return modelMapper;
    }
}
