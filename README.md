<h1 align="center">Итоговая работа по курсу "Автоматизация тестирования"</h1>
<p>последняя сборка<br>
[![test-build](https://github.com/ImChuBZzz/autoTestsExam/actions/workflows/main.yml/badge.svg?branch=master)](https://github.com/ImChuBZzz/autoTestsExam/actions/workflows/main.yml)<br>
<h2>Задание:</h2>
<ul type="square">
<h3>
    <li>Автоматизировать пользовательский сценарий с помощью фреймворка Selenide и паттерна PageObject (выбрать кейсы на сайте mtsbank.ru, не менее пяти сценариев)
    <li>Сделать job для запуска автотестов для какого-нибудь инструмента
    <li>Интегрировать функционал генерации allure-отчета
</h3>
</ul>
<br>
<h2>Что делал:</h2>
<ol><h3>
 <li>Проверяем на странице "Акции и скидки" совпадение  количества карточек "акции от банка" с количеством карточек, которое указано в меню выбора категорий.
 <li>На странице "Вклады" проверяем данные, которые вводятся в поля "сумма вклада" и "срок вклада" попадают в заданные границы.
 <li>На странице Ипотека для ИТ проверяем совпадение срока ипотеки с количеством лет, указанных в таблице платежей.
 <li>На странице "Виртуальные карты", выбираем оформление первой карты в списке и проверяем три варианта: оформление с пустым номером, оформление с неполным номером и оформление с "правильным" номером. 
 <li>На странице "Малый бизнес и ИП" проверяем что ссылки на соц сети которые указаны нижнем блоке страницы ведут на правильные адреса групп телеграмм, вКонтакте и одноклассников.
 <li>В разделе "Расчетный счет" страницы "Малый бизнес и ИП" проверяем документ "Правила оформления Поручений на перевод иностранной валюты" это именно то что нужно.
 <li>В разделе "Онлайн банк" при переходе как частное лицо проверяем авторизацию с тремя вариантами: правильный номер, пустой номер и некорректное значение в поле ввода номера.
 <li>В разделе "Онлайн банка" проверяем что файлы по ссылкам  "условия доступа" и "политика конфиденциальности" скачиваются и они именно то, что нужно.
 <li>С главной страницы переходим в раздел "Офисы и банкоматы", переключаем на вид "списком", оставляем в фильтре только "*банкоматы*" и проверяем что в списке есть банкоматы.
</h3></ol>


