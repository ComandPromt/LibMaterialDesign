package comboFonts;

import java.awt.GraphicsEnvironment;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComboBox;

import combo_suggestion.ComboSuggestionUI;

@SuppressWarnings({ "serial", "rawtypes" })

public class ComboFont extends JComboBox {

	@SuppressWarnings("unchecked")
	public ComboFont() {

		setUI(new ComboSuggestionUI());

		this.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				int notches = e.getWheelRotation();

				int valorIndice = getSelectedIndex();

				if (notches < 0) {

					valorIndice--;

				}

				else {

					valorIndice++;

				}

				if (valorIndice < 0) {

					valorIndice = 0;

				}

				if (valorIndice >= getItemCount()) {

					valorIndice = getItemCount();

					valorIndice--;

				}

				setSelectedIndex(valorIndice);

			}

		});

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		String[] fontFamilies = ge.getAvailableFontFamilyNames();

		for (String ff : fontFamilies) {

			addItem(ff);

		}

	}

}
