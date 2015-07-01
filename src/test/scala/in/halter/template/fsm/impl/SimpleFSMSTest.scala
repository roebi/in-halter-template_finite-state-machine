package in.halter.template.fsm.impl

//import static org.junit.Assert._

import org.junit.After
import org.junit.Before
import org.junit.Test
import akka.actor.ActorSystem
import akka.testkit.TestKit
import akka.actor.ActorRef
import akka.actor.Props

/**
 * Testclass for SimpleFSMS
 */
class SimpleFSMSTest {

	@Before
	def setUp() { //} throws Exception {
	}

	@After
	def tearDown() { //} throws Exception {
	}

	@Test
	def test() {
		val system = ActorSystem.create("simpleFSMTest")
				try {
					new TestKit(system) {
						val simpleFSM = system.actorOf(Props[SimpleFSMS])
								simpleFSM.tell(SimpleFSMS.PowerOnCC, testActor)
								expectMsg(SimpleFSMS.On)
								simpleFSM.tell(SimpleFSMS.PowerOffCC, testActor)
								expectMsg(SimpleFSMS.Off)
								simpleFSM.tell(SimpleFSMS.PowerOnCC, testActor)
								expectMsg(SimpleFSMS.On)
								simpleFSM.tell(SimpleFSMS.PowerOffCC, testActor)
								expectMsg(SimpleFSMS.Off)
					}
				} finally {
					system.terminate()
				}
	}
}
