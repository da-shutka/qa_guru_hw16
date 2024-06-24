# Проект по автоматизации тестирования для [<img width="10%" title="Bercut" src="media/icons/Reqres.png"/>](https://reqres.in/)

## :scroll: Содержание
- [Используемый стек](#computer-используемый-стек)
- [Автоматизированные тесты](#ballot_box_with_check-api-тесты-для-пользователей)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Уведомления в Telegram](#-уведомления-в-telegram)

## :computer: Используемый стек
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/icons/Intellij_IDEA.svg"/></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg"/></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg"/></a> 
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg"/></a>
<a href="https://rest-assured.io/"><img width="6%" title="Rest Assured" src="media/icons/rest_assured.png"/></a>
<a href="https://projectlombok.org/"><img width="6%" title="Lombok" src="media/icons/lombok.png"/></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/GitHub.svg"/></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg"/></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg"/></a> 
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg"/></a>
</p>

Api автотесты:
- Реализованы на языке ```Java```
- В качестве сборщика используется ```Gradle```
- Используется фреймворк ```JUnit 5```
- Для удаленного запуска используется сборка в ```Jenkins```
- Для сборки формируется ```Allure Report```
- Результат отправляется в ```Telegram``` канал при помощи бота

Allure-отчет:
* Шаги теста
* Детали запроса
* Детали ответа

## :ballot_box_with_check: API тесты для пользователей

- ```POST /api/users``` -- создание
- ```PUT /api/users/2``` -- обновление
- ```PATCH /api/users/2``` -- частичное обновление
- ```DELETE /api/users/2``` -- удаление
- ```GET /api/users?page=2``` -- получение списка, 2ая страница

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/icons/Jenkins.svg"> Сборка в Jenkins
[<img width="50%" title="Jenkins" src="media/img/Jenkins_Job.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit16/)

### *Команды для запуска из терминала*

***Локальный запуск:***
```bash
gradle clean test
```

***Запуск в Jenkins:***
```java
clean test
```

Для запуска сборки необходимо:
1. Перейти в сборку
2. Нажать ```Собрать сейчас```/```Build now```

## <img width="4%" style="vertical-align:middle" title="Allure_Report" src="media/icons/Allure_Report.svg"> Allure-отчет
После выполнения сборки в блоке ```История сборок```/```Build History``` напротив конкретной сборки отображается значок
[<img width="2%" title="IntelliJ IDEA" src="media/icons/Allure_Report.svg"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit14/allure/),
при нажатии на который открывается страница со сформированным html-отчетом и тестовой документацией.

### *Главная страница отчета*
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Main.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit16/1/allure/)

### *Тест-кейсы*
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Test.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit16/1/allure/#suites)

### *Детали запроса*
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Request.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit16/1/allure/#suites)

### *Детали ответа*
[<img width="50%" title="Allure Report" src="media/img/Allure_Report_Response.PNG"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-unit16/1/allure/#suites)


## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в ```Telegram```, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

[<img width="30%" title="Telegram Notifications" src="media/img/Telegram_Result.PNG">]()
