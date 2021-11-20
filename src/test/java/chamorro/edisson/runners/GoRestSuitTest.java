package chamorro.edisson.runners;

import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GoRestCreateUser.class, GoRestConsultUser.class, GoRestDeleteUser.class })

public class GoRestSuitTest {
 
}
