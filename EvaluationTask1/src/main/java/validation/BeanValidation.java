package validation;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import bean.BookBean;

public class BeanValidation {
	public static boolean validate(BookBean bookbean) {
		// Validatorを取得
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // バリデーションを実行
        validator.validate(bookbean);
		return true;
	}
}
