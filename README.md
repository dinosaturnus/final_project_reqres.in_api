# Дипломный проект по API-тестированию cайта [Reqres.in](https://reqres.in/)

## Содержание:

* <a href="#annotation">Описание</a>
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Тест кейсы</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>

<a id="annotation"></a>
## Описание
Тестовый проект состоит из API-тестов.

Краткий список интересных фактов о проекте:
- [x] Возможность локального и удалённого запуска тестов
- [x] Возможность запуска как всех тестов, так и отдельно по каждому определенному тегу
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Custom Allure listener для API requests/responses логов
- [x] Интеграция с `Allure TestOps`
- [x] Возможность запуска тестов напрямую из `Allure TestOps`
- [x] Интеграция с `Jira`
- [x] Автотесты оформлены как тестовая документация посредством аннотаций `Allure`

<a id="tools"></a>
## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="img/logo/IntelliJ_IDEA.png" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="img/logo/GitHub.png" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="img/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="img/logo/Gradle.png" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="img/logo/JUnit5.png" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="img/logo/RestAssured.png" width="50"/></a>
<a href="https://projectlombok.org/"><img alt="Lombok" height="50" src="img/logo/Lombok.png" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="img/logo/Jenkins.png" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="img/logo/Allure_Report.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="img/logo/AllureTestOps.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="img/logo/Jira.png" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="img/logo/Telegram.png" width="50"/></a>
</div>

<code>Java</code> - основной язык проекта.\
<code>REST Assured</code> — для тестирования REST-API сервисов.\
<code>Lombok</code> — библиотека для сокращения кода в классах.\
<code>Gradle</code> — используется как инструмент автоматизации сборки.\
<code>JUnit5</code> — фреймворк модульного тестирования для выполнения тестов.\
<code>Jenkins</code> — CI/CD для запуска тестов удаленно.\
<code>Allure Report</code> — для визуализации результатов тестирования.\
<code>Allure TestOps</code> — как система управления тестированием.\
<code>Telegram Bot</code> — для уведомлений о результатах тестирования.\
<code>Jira</code> — как инструмент управления проектом и таск-трекер.

**Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.

Allure-отчет включает в себя:
* Информацию reqest-е запроса
* Информацию о response ответа

<a id="cases"></a>
## Тест кейсы

Проект содержит следующие автоматизированные кейсы:
- Получение списка пользователей
- Получение информации о пользователе
- Получение информации о несуществующем пользователе
- Редактирование пользователя
- Удаление пользователя
- Создание нового пользователя с валидными данными

<a id="console"></a>
##  Запуск тестов из терминала
### Локальный запуск тестов
Все тесты запустятся локально на вашей машине:
```bash
gradle clean test
```

<a id="jenkins"></a>
## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/final_project_reqres.in_api/)
Сборка с параметрами позволяет перед запуском изменить параметры для сборки (путем выбора из списка или прямым указанием значения).
<p align="center">
  <img src="img/screenshots/JenkinsJob.png" alt="Jenkins" width="900">
</p>

После выполнения сборки в блоке <code>История сборок</code> напротив номера сборки появится
значки *Allure Report* и *Allure TestOps*, клик по которым позволит ознакомиться с более детальными отчетами о пройденных тестах.

<a id="allure"></a>
## Отчет в [Allure Report](https://jenkins.autotests.cloud/job/final_project_reqres.in_api/8/allure/)
### Основной дашборд
<p align="center">
  <img src="img/screenshots/AllureReportOverview.png" alt="allure-report-overview" width="900">
</p>

### Тесты
<p align="center">
  <img src="img/screenshots/AllureReportSuites.png" alt="allure-report-suites" width="900">
</p>

### Графики
<p align="center">
  <img src="img/screenshots/AllureReportGraphs.png" alt="allure-report-graphs" width="900">
</p>

<a id="testops"></a>
##  Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/28349)

### Основной дашборд

<p align="center">
  <img src="img/screenshots/AllureTestOpsDashboards.png" alt="allure-testops-dashboard" width="900">
</p>

### Автоматизированные тест-кейсы

<p align="center">
  <img src="img/screenshots/AllureTestOpsTestCases.png" alt="allure-testops-testcase" width="900">
</p>

### Запуски сборок

<p align="center">
  <img src="img/screenshots/AllureTestOpsLaunches.png" alt="allure-testops-launches" width="900">
</p>

<a id="jira"></a>
## Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-843"> Jira </a>
<p align="center">
<img src="img/screenshots/Jira.png" alt="jira" width="900">
</p>

<a id="telegram"></a>
## Уведомления в Telegram с использованием бота
<p align="center">
<img title="Telegram Notifications" src="img/screenshots/Telegram.png" alt="telegram" width="450">
</p>
