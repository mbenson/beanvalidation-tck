/**
 * Bean Validation TCK
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.beanvalidation.tck.tests.constraints.groups.groupsequenceisolation;

import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * @author Hardy Ferentschik
 */
@GroupSequence({ Minimal.class, A.class })
public class A {
	@Max(value = 10, groups = Minimal.class)
	int size;

	@Size(max = 20)
	String name; //A group
}

interface Minimal {
}

interface Heavy {
}
