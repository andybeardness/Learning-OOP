package GUI;

import ML.DataItem;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Класс ГУИ
 */
public class GUI {

  // Аттрибуты ГУИ
  JFrame frm;
  JPanel pnlAll, pnlLeft, pnlCenter, pnlRight;
  JLabel lblGender, lblHeight;
  JToggleButton tbGender;
  JTextField taHeight;
  JLabel lblResults;
  JButton btnExecute;

  // Для форматирования double
  final private DecimalFormat df = new DecimalFormat("#.##");

  /**
   * Конструктор с настройкой ГУИ
   */
  public GUI() {
    frm = new JFrame("Машинное обучение : Пол, Рост >> Вес");
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setSize(950, 400);

    lblGender = new JLabel("Выбор пола :");
    lblGender.setHorizontalAlignment(JLabel.CENTER);

    tbGender = new JToggleButton("Мужской");
    tbGender.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tbGender.getText().equals("Мужской")) {
          tbGender.setText("Женский");
        }
        else {
          tbGender.setText("Мужской");
        }
      }
    });

    lblHeight = new JLabel("Введите рост :");
    lblHeight.setHorizontalAlignment(JLabel.CENTER);

    taHeight = new JTextField();
    taHeight.setHorizontalAlignment(JTextField.CENTER);

    pnlLeft = new JPanel(new GridLayout(4, 1));
    pnlLeft.add(lblGender);
    pnlLeft.add(tbGender);
    pnlLeft.add(lblHeight);
    pnlLeft.add(taHeight);
    pnlLeft.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    lblResults = new JLabel("Тут будут результаты :");
    lblResults.setHorizontalAlignment(JLabel.CENTER);

    pnlCenter = new JPanel(new GridLayout(1, 1));
    pnlCenter.add(lblResults);
    pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    btnExecute = new JButton("Посчитать");

    pnlRight = new JPanel(new GridLayout(1, 1));
    pnlRight.add(btnExecute);
    pnlRight.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    pnlAll = new JPanel(new GridLayout(1, 3));
    pnlAll.add(pnlLeft);
    pnlAll.add(pnlCenter);
    pnlAll.add(pnlRight);

    frm.add(pnlAll);
  }

  /**
   * Запуск ГУИ
   */
  public void run() {
    frm.setVisible(true);
  }

  /**
   * Добавляем стороннего слушателя
   * @param al Слушатель
   */
  public void setExecuteButtonActionListener(ActionListener al) {
    btnExecute.addActionListener(al);
  }

  /**
   * Возвращаем элемент Данных из введённых данных
   *
   * @return Элемент Данных
   */
  public DataItem getDataItem() {
    double gender = tbGender.getText().equals("Мужской") ? 0. : 1.;
    double height = Double.parseDouble(taHeight.getText());

    return new DataItem(gender, height);
  }

  /**
   * Обновляем результаты по предсказаниям моделей
   *
   * @param pred Предсказание
   */
  public void updateResults(double pred) {
    // Устанавливаем новый текст
    String sb = "<html>" +
        "<p>Результат :</p>" +
        "<p> Композиция моделей вынесла вердикт : " +
        df.format(pred) +
        " кг</p>" +
        "</html>";
    lblResults.setText(sb);
  }
}
