package eu.nextstreet.gwt.components.client.ui.widget.suggest.iconed.impl;

import com.google.gwt.user.client.ui.Image;

import eu.nextstreet.gwt.components.client.ui.common.data.ValueRepresentationTransformer;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.ValueHolderLabel;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.ValueRendererFactory;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.iconed.IconedValueHolderLabel;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.impl.simple.DefaultListRenderer;

public class IconedValueRendererFactory<T, W extends IconedValueHolderLabel<T>>
		implements ValueRendererFactory<T, W> {

	/** Gives an image for each value */
	protected ValueRepresentationTransformer<T, Image> iconLinker;

	public IconedValueRendererFactory(
			ValueRepresentationTransformer<T, Image> transformer) {
		this.iconLinker = transformer;
	}

	@Override
	public W createValueRenderer(T value, String filterText, boolean caseSensitive) {
		Image icon = constructIcon(value);
		@SuppressWarnings("unchecked")
		W toReturn = (W) new IconedValueRenderer<T>(value, icon, filterText,
				caseSensitive);
		toReturn.setStyleName(ValueHolderLabel.ITEM_DEFAULT_STYLE);
		return toReturn;
	}

	/**
	 * Constructs an icon from a value through the transformer
	 * 
	 * @param value
	 *          value
	 * @return icon
	 */
	protected Image constructIcon(T value) {
		if (iconLinker == null)
			return null;

		Image icon = iconLinker.transform(value);
		return icon;
	}

	@Override
	public eu.nextstreet.gwt.components.client.ui.widget.suggest.ValueRendererFactory.ListRenderer<T, W> createListRenderer() {
		DefaultListRenderer<T, W> defaultListRenderer = new DefaultListRenderer<T, W>();
		defaultListRenderer.setSpacing(0);
		return defaultListRenderer;
	}

	public ValueRepresentationTransformer<T, Image> getIconLinker() {
		return iconLinker;
	}

	public void setIconLinker(ValueRepresentationTransformer<T, Image> iconLinker) {
		this.iconLinker = iconLinker;
	}

}
