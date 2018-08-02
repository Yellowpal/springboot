package win.yellowpal.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MultipartException.class)
	public String exceptionHandler(MultipartException e, RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("message", "文件超出限制");
        return "redirect:/file/limit";
	}
	
}
