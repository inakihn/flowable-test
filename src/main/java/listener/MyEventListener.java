package listener;

import org.flowable.common.engine.api.delegate.event.AbstractFlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;

public class MyEventListener extends AbstractFlowableEventListener {

    public void onEvent(FlowableEvent event) {
        if (event.getType() == FlowableEngineEventType.PROCESS_STARTED) {
            System.out.println("A process has started");
        } else if (event.getType() == FlowableEngineEventType.PROCESS_COMPLETED) {
            System.out.println("A process has completed");
        } else {
            System.out.println("Event received: " + event.getType());
        }
    }

    public boolean isFailOnException() {
        return false;
    }


}
