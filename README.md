# Тестирование приложения Интернет Банка c использованием BDD Akita.
## Краткое описание
Приложение выполняет перевод денежных средств с карты на карту. После логина пользователь переходит на страницу со списком доступных ему карт. Нажав на кнопку "Пополнить" осуществляется переход на страницу перевода средств. При успешном переводе происходит возврат назад на страницу со списком карт.


Для тестового режима захардкожен пользователь: 

```
* login: 'vasya'
* password: 'qwerty123'
* verification code (hardcoded): '12345'
* cards:
    * first:
        * number: '5559 0000 0000 0001'
        * balance: 10 000 RUB
    * second:
        * number: '5559 0000 0000 0002'
        * balance: 10 000 RUB

```

 ## Тестовые сценарии и тестовые данные
 Было проведено:
* позитивное функциональное тестирование операции перевода 5000 рублей с карты 5559 0000 0000 0002 на первую карту.

## Тестовое окружение
1. Windows11 X64
2. Браузер Google Chrome v.83.0.4103.97
3. OpenJDK 11 (LTS)
4. IntelliJ IDEA 2019.2.4 (Community Edition)
5. Junit-jupiter v.5.6.1
6. Selenide v.5.12.0
7. Приложение app-ibank-build-for-testers.jar
8. BDD Akita


## Руководство использования

При разработке автотестирования использовались патерн Page Objects, BDD Akita, Lombok, Data-классы (для группировки нужных полей) 

* Запустите приложение командой 

```
java -jar ./artifacts/app-ibank-build-for-testers.jar 
```
* Запустите автотесты командой

```
./gradlew test -Dselenide.headless=true --info
```

* Проверить успешность сборки CI на Appveyor

[![Build status](https://ci.appveyor.com/api/projects/status/1ygqqkqysa7em5sb/branch/master?svg=true)](https://ci.appveyor.com/project/leonnika/aqa-hw6-akita/branch/master)

