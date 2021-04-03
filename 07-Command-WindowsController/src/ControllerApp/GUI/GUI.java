package ControllerApp.GUI;

import ControllerApp.Command.CommandOpenCalc;
import ControllerApp.Command.CommandOpenNote;
import ControllerApp.Command.CommandOpenPaint;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 * Класс ГУИ
 */
public class GUI {
  // Объекты класса
  JFrame frame;
  JPanel panel;
  JButton btnCalc, btnPaint, btnNote;

  // Слушатели для кнопок
  ActionListener alCalc, alPaint, alNote;

  // Вспомогательные объекты
  Dimension size;

  /**
   * Конструктор инициализирует слушателей
   */
  public GUI() {
    alCalc = new CommandOpenCalc();
    alPaint = new CommandOpenPaint();
    alNote = new CommandOpenNote();
  }

  /**
   * Запускает приложение
   */
  public void run() {
    // Получаю размер экрана
    size = Toolkit.getDefaultToolkit().getScreenSize();

    // Настраиваю фрейм
    frame = new JFrame("Пуль управления Windows");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(size);

    // Инициализирую кнопки
    btnCalc = new JButton("Открыть Калькулятор");
    btnPaint = new JButton("Открыть Paint");
    btnNote = new JButton("Открыть Блокнот");

    // Собираю кнопки
    buttonBuilder(btnCalc, alCalc, Colors.COLOR_RED);
    buttonBuilder(btnPaint, alPaint, Colors.COLOR_GREEN);
    buttonBuilder(btnNote, alNote, Colors.COLOR_BLUE);

    // Настраиваю панель
    panel = new JPanel(new GridLayout(3, 1));
    panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
    panel.setBackground(Colors.COLOR_BACKGROUND);

    // Добавляю кнопки на панель
    panel.add(btnCalc);
    panel.add(btnPaint);
    panel.add(btnNote);

    // Добавляю панель на фрейм
    frame.add(panel);

    // Делаю фрейм видимым
    frame.setVisible(true);
  }

  /**
   * Собиратель для кнопок
   *
   * @param button Ссылка на кнопку
   * @param al Ссылка на слушателя
   * @param c Ссылка на цвета текста и границ кнопки
   */
  public void buttonBuilder(JButton button, ActionListener al, Color c) {
    // Настраиваю внешний вид кнопки
    button.setFont(new Font(button.getFont().getName(), Font.BOLD, 50));
    button.setFocusPainted(false);
    button.setBackground(Colors.COLOR_BACKGROUND);
    button.setForeground(c);
    button.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, c));

    // Добавляю слушателя
    button.addActionListener(al);
  }
}
