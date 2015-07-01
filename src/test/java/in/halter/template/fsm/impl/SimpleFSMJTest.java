package in.halter.template.fsm.impl;

import in.halter.template.fsm.api.PowerOff;
import in.halter.template.fsm.api.PowerOn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestKit;

/**
 * Testclass for SimpleFSMJ
 * @author Roebi
 *
 */
public class SimpleFSMJTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ActorSystem system = ActorSystem.create("simpleFSMTest");
		try {
			new TestKit(system) {
				{
					ActorRef simpleFSM = system.actorOf(Props.create(SimpleFSMJ.class));
					simpleFSM.tell(
							new PowerOn(),
							testActor()); 
					expectMsg(OnState.On);
					simpleFSM.tell(
							new PowerOff(),
							testActor()); 
					expectMsg(OffState.Off);
					simpleFSM.tell(
							new PowerOn(),
							testActor()); 
					expectMsg(OnState.On);
					simpleFSM.tell(
							new PowerOff(),
							testActor()); 
					expectMsg(OffState.Off);
				}
			};
		} finally {
			system.terminate();
		};
	}
}
