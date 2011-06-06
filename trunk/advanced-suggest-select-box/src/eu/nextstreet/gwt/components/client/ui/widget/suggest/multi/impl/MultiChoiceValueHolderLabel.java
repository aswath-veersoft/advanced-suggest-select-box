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

package eu.nextstreet.gwt.components.client.ui.widget.suggest.multi.impl;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Image;

import eu.nextstreet.gwt.components.client.ui.widget.suggest.ValueHolderItem;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.ValueRendererFactory;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.iconed.impl.IconedValueRenderer;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.multi.BasicMultiChoiceValueHolderItem;

/**
 * 
 * @author Zied Hamdi
 * @param <T>
 *          item value type
 */
public class MultiChoiceValueHolderLabel<T>
		extends
		BasicMultiChoiceValueHolderItem<T, IconedValueRenderer<T>, MultiChoiceValueHolderLabel<T>> {
	private static final String MULTI_CHOICE_ITEM = "eu-nextstreet-MultiChoiceItem";

	/**
	 * 
	 * @param value
	 *          value
	 * @param valueRendererFactory
	 *          the factory the created this instance
	 */
	public MultiChoiceValueHolderLabel(T value,
			ValueRendererFactory<T, ? extends ValueHolderItem<T>> valueRendererFactory) {
		super(value, valueRendererFactory);
		setStyleName(MULTI_CHOICE_ITEM);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.nextstreet.gwt.components.client.ui.common.data.
	 * ValueRepresentationTransformer#transform(java.lang.Object)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public IconedValueRenderer<T> transform(T value) {
		return new IconedValueRenderer<T>(value,
				(Image) ((MultiChoiceValueRendererFactory) getValueRendererFactory())
						.getIconLinker().transform(value), "", false, valueRendererFactory);
	}

	// -------------------- these are unused for now ------------------

	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return concreteWidget.addMouseDownHandler(handler);
	}

	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		return concreteWidget.addMouseUpHandler(handler);
	}

	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return concreteWidget.addMouseOutHandler(handler);
	}

	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return concreteWidget.addMouseOverHandler(handler);
	}

	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		return concreteWidget.addMouseMoveHandler(handler);
	}

	public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		return concreteWidget.addMouseWheelHandler(handler);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return concreteWidget.addClickHandler(handler);
	}

}
