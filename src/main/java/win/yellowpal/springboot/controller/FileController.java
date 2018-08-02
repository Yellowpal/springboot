package win.yellowpal.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping("")
	public String index(){
		
		return "file";
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file){
		
		if(file.isEmpty()){
			return "empty";
		}
		
		try {
			byte[] b = file.getBytes();
			Path path = Paths.get(""+file.getOriginalFilename());
			
			Files.write(path, b);
			
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/limit")
	public String limit(){
		
		return "file limit";
	}
}
