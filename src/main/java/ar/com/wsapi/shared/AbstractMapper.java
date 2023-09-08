package ar.com.wsapi.shared;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AbstractMapper {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public final static ModelMapper mapper = new ModelMapper();
	
	

}
