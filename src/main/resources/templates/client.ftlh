<!doctype html>
<html lang="en">
<head>
    <title>Данные о клиенте</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-1 text-center">Клиент ${client.id}</h2>
            <hr class="hr mb-4">
            <h5 class="mb-3">Паспортные данные</h5>
            <form>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Фамилия</label>
                        <p class="form-control">${client.secondName}</p>
                    </div>
                    <div class="col">
                        <label class="form-label">Имя</label>
                        <p class="form-control">${client.firstName}</p>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Отчество</label>
                        <p class="form-control">${client.patronymic}</p>
                    </div>
                    <div class="col">
                        <label class="form-label">Семейное положение</label>
                        <#if client.martialStatus == "SINGLE">
                            <p class="form-control">Не женат/Не замужем</p>
                        <#elseif client.martialStatus == "MARRIED">
                            <p class="form-control">Женат/Замужем</p>
                        <#elseif client.martialStatus == "DIVORCED">
                            <p class="form-control">Разведен/Разведена</p>
                        <#elseif client.martialStatus == "WIDOWED">
                            <p class="form-control">Вдовец/Вдова</p>
                        </#if>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Серия паспорта</label>
                        <p class="form-control">${client.passportSerial}</p>
                    </div>
                    <div class="col">
                        <label class="form-label">Номер паспорта</label>
                        <p class="form-control">${client.passportNumber}</p>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Адрес прописки</label>
                        <p class="form-control">${client.registrationAddress}</p>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <label class="form-label">Номер телефона</label>
                        <p class="form-control">${client.phoneNumber}</p>
                    </div>
                </div>
                <hr class="hr mb-4">
                <h5 class="mb-3">Сведения о занятости</h5>
                <div class="row mb-2">
                    <#list employments as employment>
                        <div class="col-5">
                            <label class="form-label">Должность</label>
                            <p class="form-control">${employment.post}</p>
                        </div>
                        <div class="col-5">
                            <label class="form-label">Название организации</label>
                            <p class="form-control">${employment.organisationName}</p>
                        </div>
                        <div class="col-2">
                            <label class="form-label">Период работы</label>
                            <p class="form-control">${employment.workPeriod}</p>
                        </div>
                    </#list>
                </div>
                <hr class="hr mb-4">
            </form>
        </div>
    </div>
</div>

</body>
</html>