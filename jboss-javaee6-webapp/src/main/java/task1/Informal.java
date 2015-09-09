package task1;

import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;

@Qualifier
@Retention(RUNTIME)
public @interface Informal {
	
}
