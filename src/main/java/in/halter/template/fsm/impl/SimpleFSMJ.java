package in.halter.template.fsm.impl;

import in.halter.template.fsm.api.Data;
import in.halter.template.fsm.api.PowerOff;
import in.halter.template.fsm.api.PowerOn;
import in.halter.template.fsm.api.SimpleState;
import akka.actor.AbstractFSM;

/**
 * State(S) x Event(E) goes to Actions (A), State(S')
 * @author Roebi
 */
public class SimpleFSMJ extends AbstractFSM<SimpleState, Data> {
	{
        // fsm body
		startWith(OffState.Off, new SomeData());

        // transitions

        // from Off to On
		when(OffState.Off,
				matchEvent(PowerOn.class, SomeData.class,
						(eventPowerOn, uninitialized) ->
				goTo(OnState.On)
				.using(new SomeData())
				.replying(OnState.On)
						)
				);

		// from On to Off
		when(OnState.On,
				matchEvent(PowerOff.class, SomeData.class,
						(eventPowerOff, uninitialized) ->
				goTo(OffState.Off)
				.using(new SomeData())
				.replying(OffState.Off)
						)
				);

		onTermination(
				matchStop(Normal(),
						(state, data) -> {
							goTo(OffState.Off)
							.using(new SomeData());
						}).
						stop(Shutdown(),
								(state, data) -> {
									goTo(OffState.Off)
									.using(new SomeData());
								}).
								stop(Failure.class,
										(reason, state, data) -> {
											goTo(OffState.Off)
											.using(new SomeData());
										})
				);
		
		initialize();

    }
}
