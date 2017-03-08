/**
 * Bean Validation TCK
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.beanvalidation.tck.tests.constraints.constraintcomposition.nestedconstraintcomposition;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import javax.validation.constraints.Pattern;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Hardy Ferentschik
 */
@Pattern(regexp = "abc", message = "Pattern must match {regexp}")
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
@NestedCompositeConstraint
public @interface CompositeConstraint3 {
	public abstract String message() default "CompositeConstraint3 failed.";

	public abstract Class<?>[] groups() default { };

	public abstract Class<? extends Payload>[] payload() default { };
}
