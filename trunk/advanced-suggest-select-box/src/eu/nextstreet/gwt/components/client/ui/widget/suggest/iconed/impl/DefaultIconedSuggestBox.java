package eu.nextstreet.gwt.components.client.ui.widget.suggest.iconed.impl;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

import eu.nextstreet.gwt.components.client.ui.common.data.ValueRepresentationTransformer;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.iconed.IconedValueHolderLabel;
import eu.nextstreet.gwt.components.client.ui.widget.suggest.impl.DefaultSuggestBox;

/**
 * A suggest box with Icon decorated values
 * 
 * @author Zied Hamdi
 * 
 * @param <T>
 *          items type
 * @param <W>
 *          renderer
 */
public class DefaultIconedSuggestBox<T, W extends IconedValueHolderLabel<T>>
		extends DefaultSuggestBox<T, W> {
	/** Gives an image for each value */
	@SuppressWarnings("unchecked")
	protected ValueRepresentationTransformer<T, Image> iconLinker = ValueRepresentationTransformer.NULL_TRANSFORMER;

	public DefaultIconedSuggestBox(String defaultText) {
		super(defaultText);
		SimplePanel iconPanel = textField.getLeft();
		DockPanel widgetPanel = textField.getPanel();
		widgetPanel.setCellHorizontalAlignment(iconPanel, DockPanel.ALIGN_CENTER);
		widgetPanel.setCellVerticalAlignment(iconPanel, DockPanel.ALIGN_MIDDLE);
	}

	@Override
	protected void init(String defaultText) {
		super.init(defaultText);
		setValueRendererFactory(new IconedValueRendererFactory<T, W>(iconLinker));
	}

	/**
	 * Value changes trigger icon changes
	 */
	public void valueSelected(T value) {
		super.valueSelected(value);
		fillIcon(value);
	}

	/**
	 * Fills the icon part with the value's corresponding image
	 * 
	 * @param value
	 *          value
	 */
	protected void fillIcon(T value) {
		textField.setLeftWidget(iconLinker.transform(value));
	};

	/**
	 * Typed values trigger icon removal
	 */
	@Override
	public void valueTyped(String value) {
		super.valueTyped(value);
		emptyIcon();
	}

	/**
	 * Makes the icon part empty
	 */
	protected void emptyIcon() {
		textField.setLeftWidget(null);
	}

	public ValueRepresentationTransformer<T, Image> getIconLinker() {
		return iconLinker;
	}

	public void setIconLinker(ValueRepresentationTransformer<T, Image> iconLinker) {
		this.iconLinker = iconLinker;
		((IconedValueRendererFactory<T, W>) valueRendererFactory)
				.setIconLinker(iconLinker);
	}

	@Override
	public T computeSelected(String text) {
		T selected = super.computeSelected(text);
		if (selected != null)
			fillIcon(selected);
		return selected;
	}
}
