package in.halter.template.fsm.impl;


import SimpleFSMS.Data
import SimpleFSMS.Off
import SimpleFSMS.On
import SimpleFSMS.PowerOffCC
import SimpleFSMS.PowerOnCC
import akka.actor.AbstractFSM

object SimpleFSMS {
	trait State
	final case object Off extends State
	final case object On extends State
	final case object PowerOffCC
	final case object PowerOnCC
	case class Data(i : Int)
}

/**
 * State(S) x Event(E) goes to Actions (A), State(S')
 * @author Roebi
 */
class SimpleFSMS extends AbstractFSM[SimpleFSMS.State, SimpleFSMS.Data] {
	import SimpleFSMS._

	// fsm body
	startWith(Off, Data(0))

	// transitions

	// from Off to On
	when(Off) {
	case Event(PowerOnCC, Data(0)) => {
		goto(On)
		.using(Data(0))
		.replying(On)
	}
	}

	// from On to Off
	when(On) {
	case Event(PowerOffCC, Data(0)) => {
		goto(Off)
		.using(Data(0))
		.replying(Off)
	}
	}

	initialize()
}
