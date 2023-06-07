package ar.com.ctz.repository;

import static org.springframework.http.HttpMethod.GET;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import ar.com.ctz.component.CtzExtractor;
import ar.com.ctz.entity.Dollar;


@Repository
public class CtzRepository {

  @Autowired
  private CtzExtractor ctzExtractor;
  
  public List<Dollar> getPrices(
      final String dollarUrl) {
    try {
      RestTemplate template = new RestTemplate();
      URI url = new URI(dollarUrl);
      RequestCallback callback = (ClientHttpRequest r) -> {};
      return template.execute(url, GET, callback, ctzExtractor);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }
  
}