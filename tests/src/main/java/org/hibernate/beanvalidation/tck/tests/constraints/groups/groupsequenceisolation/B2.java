/**
 * Bean Validation TCK
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.beanvalidation.tck.tests.constraints.groups.groupsequenceisolation;

import javax.validation.GroupSequence;
import javax.validation.constraints.Size;

/**
 * @author Hardy Ferentschik
 */
@GroupSequence({ Minimal.class, B2.class, Heavy.class })
public class B2 extends A {
	@SafeEncryption(groups = Heavy.class)
	String encryptionKey;

	@Size(max = 20)
	String nickname; //B1 group
}
