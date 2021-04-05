package GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

/**
 * Класс для ГУИ
 */
public class GUI {
  // Элементы ГУИ
  JFrame frm;
  JPanel pnlUp, pnlDown, pnlAll;
  JButton btnStreet, btnReg, btnDoc, btnSurgeon;
  JLabel lblResult;

  /**
   * Конструктор, который собирает ГУИ
   */
  public GUI() {
    frm = new JFrame("Марковские процессы в поликлинике");
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setSize(400, 800);

    btnStreet = new JButton("Пойти на улицу");
    btnReg = new JButton("Пройти к регистрации");
    btnDoc = new JButton("Пойти к терапевту");
    btnSurgeon = new JButton("Пойти к хирургу");

    pnlDown = new JPanel(new GridLayout(2, 2));
    pnlDown.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlDown.add(btnStreet);
    pnlDown.add(btnReg);
    pnlDown.add(btnDoc);
    pnlDown.add(btnSurgeon);

    lblResult = new JLabel("Тут будет информация обо всём");
    lblResult.setHorizontalAlignment(JLabel.CENTER);

    pnlUp = new JPanel(new GridLayout(1, 1));
    pnlUp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlUp.add(lblResult);

    pnlAll = new JPanel(new GridLayout(2, 1));
    pnlAll.add(pnlUp);
    pnlAll.add(pnlDown);

    frm.add(pnlAll);
  }

  /**
   * Метод, который делает ГУИ видимым, ака запускает его
   */
  public void run() {
    frm.setVisible(true);
  }

  // ----------------------------
  // Методы, для подключения слушателей
  // ----------------------------

  public void setStreetListener(ActionListener al) {
    btnStreet.addActionListener(al);
  }

  public void setRegisterListener(ActionListener al) {
    btnReg.addActionListener(al);
  }

  public void setDoctorListener(ActionListener al) {
    btnDoc.addActionListener(al);
  }

  public void setSurgeonListener(ActionListener al) {
    btnSurgeon.addActionListener(al);
  }

  // Метод для обновления результата
  public void updateResults(String location, String matrix, String totals) {

    String sb = "<html>" +
        "<p>Текущая локация : </p>" +
        "<p>" + location + "</p>" +
        "<br>" +
        "<p>Матрица переходов : </p>" +
        matrix +
        "<br>" +
        "<p>Итоговая вероятность состояния : </p>" +
        totals +
        "</html>";

    lblResult.setText(sb);
  }

}
