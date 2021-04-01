package Application.Factory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Интерфейс абстрактной фабрики
 *
 * Который создаёт каждый элемент ГУИ
 */
public interface AbstractFactoryGUI {
  JFrame createFrame();
  JPanel createPanel();
  JLabel createLabel();
  JButton createButton();
  JLabel createImage();
}
