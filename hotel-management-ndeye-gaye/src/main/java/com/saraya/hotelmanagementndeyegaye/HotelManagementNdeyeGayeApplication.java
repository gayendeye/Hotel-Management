package com.saraya.hotelmanagementndeyegaye;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@SpringBootApplication
public class HotelManagementNdeyeGayeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementNdeyeGayeApplication.class, args);
	}


	@Bean
	public ModelMapper getModel() {
		ModelMapper mapper = new ModelMapper();
		Converter<String, LocalDate> converter = new Converter<String, LocalDate>() {
			@Override
			public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
				return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}

		};

		mapper.addConverter(converter);


		Converter<String, LocalTime> converter1 = new Converter<String, LocalTime>() {
			@Override
			public LocalTime convert(MappingContext<String, LocalTime> mappingContext) {
				return LocalTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("HH::mm::ss"));
			}
		};
		mapper.addConverter(converter1);
		return mapper;
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("gayeeendeyeee@gmail.com");
		mailSender.setPassword("twipopdanjmqrvbp");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

}
