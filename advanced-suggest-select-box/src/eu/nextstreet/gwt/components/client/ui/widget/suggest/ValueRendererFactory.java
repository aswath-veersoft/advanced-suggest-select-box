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

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Isolates the creation of suggested items rendering widgets
 * 
 * @author Zied Hamdi founder of http://into-i.fr
 * 
 * @param <T>
 *          the represented value type
 * @param <W>
 *          the returned widget type
 */
public interface ValueRendererFactory<T, W extends ValueHolderItem<T>> {
	/**
	 * Holds the items of the suggest box
	 * 
	 * @author Zied Hamdi founder of http://into-i.fr
	 * 
	 * @param <T>
	 *          the type of the value
	 */
	public static interface ListRenderer<T, W> extends IsWidget {

		/**
		 * elements in list
		 * 
		 * @return count
		 */
		int getWidgetCount();

		/**
		 * Empties the list (for recomputing)
		 */
		void clear();

		/**
		 * adds an item to the list
		 * 
		 * @param item
		 *          item
		 */
		void add(W item);

		/**
		 * returns the item at position index
		 * 
		 * @param index
		 *          position
		 * @return item
		 */
		W getAt(int index);

	}

	/**
	 * returns the widget representing an item in the suggest list
	 * 
	 * @param value
	 * @param filterText
	 * @param caseSensitive
	 * @return
	 */
	W createValueRenderer(T value, String filterText, boolean caseSensitive);

	/**
	 * Creates the widget responsible for displaying the list of possible items
	 * 
	 * @return
	 */
	ListRenderer<T, W> createListRenderer();
}