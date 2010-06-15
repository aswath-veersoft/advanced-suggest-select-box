/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.nextstreet.gwt.components.client.ui.widget.suggest;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Composite;

public abstract class EventHandlerHolder extends Composite {
	protected List<ChangeHandler> changeHandlerList = new ArrayList<ChangeHandler>();

	public void addChangeHandler(ChangeHandler changeHandler) {
		changeHandlerList.add(changeHandler);
	}

	public void removeChangeHandler(ChangeHandler changeHandler) {
		changeHandlerList.remove(changeHandler);
	}

	private void onChange(ChangeEvent changeEvent) {
		for (ChangeHandler changeHandler : changeHandlerList) {
			changeHandler.onChange(changeEvent);
		}
	}

	/**
	 * fires an event of change
	 * 
	 * @param fromList
	 *            true if the value is from list
	 */
	protected void fireChange(boolean fromList) {
		ChangeEvent changeEvent = changedValue();
		onChange(changeEvent);
	}

	protected abstract ChangeEvent changedValue();
}
