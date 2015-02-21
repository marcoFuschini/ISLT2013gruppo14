package it.unibo.IngSW.Tests.DomainModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IComunicatorTEST.class,
		IFanDeviceAndTachometerTEST.class, PhysicalComponentsTEST.class })
public class AllTests {

}
