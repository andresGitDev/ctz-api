package ar.com.ctz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.com.ctz.entity.Dollar;
import ar.com.ctz.repository.CtzRepository;

@Service
public class CtzService {

	  @Value("${dolar.url}")
	  private String dollarUrl;
	  
	  @Autowired
	  private CtzRepository ctzRepository;
	  
	  public List<Dollar> getDollarPrices() {
	    return ctzRepository.getPrices(dollarUrl);
	  }


}
