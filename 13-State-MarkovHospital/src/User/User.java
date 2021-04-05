package User;

import GUI.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс пользователя
 */
public class User {
  StreetUserState streetState; // Состояние "Улица"
  RegistrationUserState regState; // Состояние "Регистратура"
  DoctorUserState docState; // Состояние "Терапевт"
  SurgeonUserState surgeonState; // Состояние "Хирург"

  UserState us; // Текущее состояние

  GUI gui; // ГУИ

  /**
   * Конструктор Юзера
   */
  public User() {
    // Инициация состояний
    streetState = new StreetUserState(this);
    regState = new RegistrationUserState(this);
    docState = new DoctorUserState(this);
    surgeonState = new SurgeonUserState(this);

    // Текущее состояние "Улица"
    us = streetState;

    // Создаём ГУИ
    gui = new GUI();

    // Задаём слушателей для кнопок
    gui.setStreetListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clickStreetButton();
      }
    });

    gui.setRegisterListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clickRegistrationButton();
      }
    });

    gui.setDoctorListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clickDoctorButton();
      }
    });

    gui.setSurgeonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clickSurgeonButton();
      }
    });

  }

  // -----------------------------
  // Геттеры для состояний
  // -----------------------------

  public StreetUserState getStreetState() {
    return streetState;
  }

  public RegistrationUserState getRegState() {
    return regState;
  }

  public DoctorUserState getDocState() {
    return docState;
  }

  public SurgeonUserState getSurgeonState() {
    return surgeonState;
  }

  // Методы для каждой кнопки ГУИ слушателей

  public void clickStreetButton() {
    us.clickStreetButton();
  }

  public void clickRegistrationButton() {
    us.clickRegistrationButton();
  }

  public void clickDoctorButton() {
    us.clickDoctorButton();
  }

  public void clickSurgeonButton() {
    us.clickSurgeonButton();
  }

  /**
   * Получаем ссылку на ГУИ
   *
   * @return Ссылка на ГУИ
   */
  public GUI getGUI() {
    return gui;
  }

  /**
   * Сменить состояние
   *
   * @param newState Новое состояние
   */
  public void changeState(UserState newState) {
    us = newState;
  }

}
