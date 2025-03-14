Тестирование 2 api:

* Рик и Морти https://rickandmortyapi.com/documentation/#episode-schema
    * Проверка информации о последнем персонаже из эпизода Рика и Морти

* Reqres https://reqres.in/
    * Тестирование создания пользователя через API reqres

Технологии проекта

* Java 17
* JUnit 5
* Cucumber
* AssertJ
* RestAssured
* Jackson
* Allure
* Maven

Все зависимости лежат в pom.xml <br>

Запуск тестов через консоль ``` mvn clean test ```<br>
Генерация Allure отчета через консоль ```mvn allure:report ```<br>
Просмотр Allure отчета через консоль ```mvn allure:serve ```
