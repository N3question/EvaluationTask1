package validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class BeanValidation {
//	public static boolean validate(HttpServletRequest request, BookBean bookbean) {
////		// Validatorを取得
////        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
////        Validator validator = factory.getValidator();
////        
////        // バリデーションを実行
////        Set<ConstraintViolation<BookBean>> result = validator.validate(bookbean);
//        
//        // リクエストパラメータに値をセット
//        request.setAttribute("message", result.iterator().next().getMessage());
//       
//        return true;
//	}
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Set<ConstraintViolation<T>> validate(T entity) {
        return validator.validate(entity);
    }
}
