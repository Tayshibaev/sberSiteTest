#language: ru

Функционал: Тетирование сайта сбербанк
  Сценарий: Страхование путешественников

  Когда Выбран пункт меню "Страхование"
    И выбран вид страхования - "Страхование путешественников"
    Тогда выполнено нажатие на кнопку оформить онлайн

    Когда выран минимальный тариф
    Тогда нажатие на кнопку оформление

    Когда заполняются текстовые поля:
      |ЗАСТРАХОВАННЫЙ_фАМИЛИЯ|GGGGGGGGGGG|
      |ЗАСТРАХОВАННЫЙ_ИМЯ|HHHHHHHHHHHHH|
      |СТРАХОВАТЕЛЬ_ИМЯ|ГОШАНАНАНА|
      |СТРАХОВАТЕЛЬ_ФАМИЛИЯ|АПРОВАПРАПР|
      |СТРАХОВАТЕЛЬ_ОТЧЕСТВО|КЕНГШПРО|
      |СЕРИЯ_ПАСПОРТА|6714|
      |НОМЕР_ПАСПОРТА|444555|
    Тогда проверяются текстовые поля:
      |ЗАСТРАХОВАННЫЙ_фАМИЛИЯ|GGGGGGGGGGG|
      |ЗАСТРАХОВАННЫЙ_ИМЯ|HHHHHHHHHHHHH|
      |СТРАХОВАТЕЛЬ_ИМЯ|ГОШАНАНАНА|
      |СТРАХОВАТЕЛЬ_ФАМИЛИЯ|АПРОВАПРАПР|
      |СТРАХОВАТЕЛЬ_ОТЧЕСТВО|КЕНГШПРО|
      |СЕРИЯ_ПАСПОРТА|6714|
      |НОМЕР_ПАСПОРТА|444555|

    Когда выбран пол - "ЖЕНСКИЙ"

    Когда заполняются поля с датами:
      |Страхователь|01.03.1995|
      |Застрахованный|01.03.1995|
      |Паспорт|01.03.1995|
    Тогда проверяются поля с датами:
      |Страхователь|01.03.1995|
      |Застрахованный|01.03.1995|
      |Паспорт|01.03.1995|

    Когда нажатие на кнопку Продолжитьт
    Тогда Проверка ошибки


