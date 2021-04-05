package GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

/**
 * Класс ГУИ
 */
public class GUI {

  // Объекты для сборки ГУИ
  private JFrame frm;
  private JPanel pnl;
  private JLabel lbl;
  private JButton btn;

  /**
   * Конструктор, который собирает и настраивает объекты
   */
  public GUI() {
    frm = new JFrame("Курсы валют через Заместителя");
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setSize(400, 500);

    pnl = new JPanel(new GridLayout(2, 1));
    pnl.setBorder(BorderFactory.createEmptyBorder(27, 27, 27, 27));

    lbl = new JLabel("Тут будут курсы");
    lbl.setHorizontalAlignment(JLabel.CENTER);

    btn = new JButton("Обновить курсы");

    pnl.add(lbl);
    pnl.add(btn);

    frm.add(pnl);
  }

  /**
   * Метод, который делает ГУИ видимым
   */
  public void run() {
    frm.setVisible(true);
  }

  public void setActionListener(ActionListener al) {
    btn.addActionListener(al);
  }

  public void updateLabel(String html) {
    lbl.setText(html);
  }

}
