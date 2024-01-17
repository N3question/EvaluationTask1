package validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import bean.BookBean;
import jakarta.servlet.http.HttpServletRequest;

public class BeanValidation {
	public static <T> boolean validate (HttpServletRequest request, BookBean bookbean, Class<T> groupClass) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); // 取得
        Set<ConstraintViolation<BookBean>> violations = validator.validate(bookbean, groupClass); // 実行
        
        if(violations.size() > 0) {
	        for (ConstraintViolation<BookBean> vi : violations) {
	        	String propertyPath = vi.getPropertyPath().toString();
	        	String errorMessage = vi.getMessage();
	        	request.setAttribute(propertyPath, errorMessage);
	        }
	        request.setAttribute("bookInfo", bookbean);
	        return true;
        }
    	return false;
	}
}
