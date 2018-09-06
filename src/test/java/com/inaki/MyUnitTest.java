package com.inaki;

import listener.MyEventListener;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.flowable.task.api.Task;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyUnitTest {

	@Rule
	public FlowableRule flowableRule = new FlowableRule();

    private MyEventListener myEventListener = new MyEventListener();

	@Test
	@Deployment(resources = {"com/inaki/my-process.bpmn20.xml"})
	public void test() {

        flowableRule.getRuntimeService().addEventListener(myEventListener);

        ProcessInstance processInstance = flowableRule.getRuntimeService().startProcessInstanceByKey("my-process");
		assertNotNull(processInstance);

		Task task = flowableRule.getTaskService().createTaskQuery().singleResult();
		assertEquals("Flowable is awesome!", task.getName());
	}

}
