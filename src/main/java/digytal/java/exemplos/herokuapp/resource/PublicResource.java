package digytal.java.exemplos.herokuapp.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import digytal.java.exemplos.herokuapp.model.ResponseBot;

@RestController
@RequestMapping("/bot")
public class PublicResource {
	
	@GetMapping(value = "/images", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBot imgs() throws IOException {
		ResponseBot response = new ResponseBot();
		String [] imgs = {"1","2","3"};
    	List<String> body = new ArrayList();
    	for(String i:imgs) {
    		String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/bot/image/")
			.path(i+".jpeg")
			.toUriString();
    		body.add(uri);
    	}
		response.setBody(body);
    	return response;

	}
	//se mudar esta linha, precisa mudar linha { .path("/bot/image/") } 
	@GetMapping(value = "/image/{img}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> img(@PathVariable("img") String img) throws IOException {
		ClassPathResource resourceFile = new ClassPathResource(String.format("img/%s", img));
		byte[] bytes = bytes(resourceFile.getInputStream());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

	private byte[] bytes(InputStream is) throws IOException {
		byte[] bytes = StreamUtils.copyToByteArray(is);
		return bytes;
	}

}
