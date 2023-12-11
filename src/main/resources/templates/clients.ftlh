<!doctype html>
<html lang="en">
<head>
    <title>Клиенты</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-1 text-center">Список клиентов</h2>
            <hr class="hr mb-4">
            <h5 class="mb-3">Фильтры</h5>
            <form action="/clients/filtered" method="get">
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Фамилия</label>
                        <input type="text" class="form-control" name="secondName" placeholder="Фамилия">
                    </div>
                    <div class="col">
                        <label class="form-label">Имя</label>
                        <input type="text" class="form-control" name="firstName" placeholder="Имя">
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Отчество</label>
                        <input type="text" class="form-control" name="patronymic" placeholder="Отчество">
                    </div>
                    <div class="col">
                        <label class="form-label">Номер телефона</label>
                        <input type="text" class="form-control" name="phoneNumber" placeholder="79876543210">
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Серия паспорта</label>
                        <input type="text" class="form-control" name="passportSerial" placeholder="0000">
                    </div>
                    <div class="col">
                        <label class="form-label">Номер паспорта</label>
                        <input type="text" class="form-control" name="passportNumber" placeholder="000000">
                    </div>
                </div>
                <div class="text-center mt-3">
                    <button type="submit" class="btn btn-primary">Поиск</button>
                </div>
            </form>
            <div class="table-responsive mt-5">
                <table class="table text-center">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ФИО</th>
                        <th scope="col">Паспорт</th>
                        <th scope="col">Адрес прописки</th>
                        <th scope="col">Номер телефона</th>
                        <th scope="col">Действие</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <#list clients as client>
                        <tr>
                            <th scope="row">${client.id}</th>
                            <td>${client.secondName} ${client.firstName} ${client.patronymic}</td>
                            <td>${client.passportSerial} ${client.passportNumber}</td>
                            <td>${client.registrationAddress}</td>
                            <td>${client.phoneNumber}</td>
                            <td>
                                <a href="/clients/${client.id}">Подробнее</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>