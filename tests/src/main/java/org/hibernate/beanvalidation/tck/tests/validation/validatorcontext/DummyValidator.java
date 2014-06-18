/*
* JBoss, Home of Professional Open Source
* Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,  
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.beanvalidation.tck.tests.validation.validatorcontext;

import java.util.Map;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Hardy Ferentschik
 */
public class DummyValidator implements ConstraintValidator<Dummy, String> {

	private static boolean disableDefaultError;

	private static Map<String, String> errorMessages;


	@Override
	public void initialize(Dummy parameters) {
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if ( disableDefaultError ) {
			constraintValidatorContext.disableDefaultConstraintViolation();
		}

		if ( errorMessages != null ) {
			for ( Map.Entry<String, String> entry : errorMessages.entrySet() ) {
				if ( entry.getKey() == null ) {
					constraintValidatorContext.buildConstraintViolationWithTemplate( entry.getValue() )
							.addConstraintViolation();
				}
				else {
					constraintValidatorContext.buildConstraintViolationWithTemplate( entry.getValue() )
							.addNode( entry.getKey() )
							.addConstraintViolation();
				}
			}
		}

		return false;
	}

	public static void disableDefaultError(boolean b) {
		disableDefaultError = b;
	}

	public static void setCustomErrorMessages(Map<String, String> errorMessages) {
		DummyValidator.errorMessages = errorMessages;
	}
}