package it.unibo.IngSW.Tests.DomainModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IComunicationTEST.class,
		IFanDeviceAndTachometerTEST.class, PhysicalComponentsTEST.class })
public class AllTests {

}
