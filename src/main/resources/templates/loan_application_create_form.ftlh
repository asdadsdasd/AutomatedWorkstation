<!doctype html>
<html lang="en">
<head>
    <#--<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
    <title>Заявка на кредит</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-1 text-center">Оформление заявки на кредит</h2>
            <hr class="hr mb-4">
            <h5 class="mb-3">Паспортные данные</h5>
            <form>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Фамилия</label>
                        <input type="text" class="form-control" placeholder="Фамилия">
                    </div>
                    <div class="col">
                        <label class="form-label">Имя</label>
                        <input type="text" class="form-control" placeholder="Имя">
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Отчество</label>
                        <input type="text" class="form-control" placeholder="Отчество">
                    </div>
                    <div class="col">
                        <label class="form-label">Семейное положение</label>
                        <select name="martialStatus" class="form-select" required>
                            <#list statuses as status>
                                <#if status == 'SINGLE'>
                                    <option value="${status}">Не женат/Не замужем</option>
                                <#elseif status == 'MARRIED'>
                                    <option value="${status}">Женат/Замужем</option>
                                <#elseif status == 'DIVORCED'>
                                    <option value="${status}">Разведен/Разведена</option>
                                <#elseif status == 'WIDOWED'>
                                    <option value="${status}">Вдовец/Вдова</option>
                                </#if>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Серия паспорта</label>
                        <input type="text" class="form-control" placeholder="0000">
                    </div>
                    <div class="col">
                        <label class="form-label">Номер паспорта</label>
                        <input type="text" class="form-control" placeholder="000000">
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Адрес прописки</label>
                        <input type="text" class="form-control" placeholder="г.Город ул.Улица д.Дом кв.Квартира">
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <label class="form-label">Номер телефона</label>
                        <input type="text" class="form-control" placeholder="79876543210">
                    </div>
                </div>
                <hr class="hr mb-4">
            </form>
            <h5 class="mb-3">Сведения о занятости</h5>
            <form>
                <div class="row mb-2">
                    <div class="col-5">
                        <label class="form-label">Должности</label>
                        <input type="text" class="form-control" placeholder="Должность">
                    </div>
                    <div class="col-5">
                        <label class="form-label">Название организации</label>
                        <input type="text" class="form-control" placeholder="ООО КОМПАНИ">
                    </div>
                    <div class="col-2">
                        <label class="form-label">Период работы</label>
                        <input type="number" class="form-control" placeholder="14">
                    </div>
                </div>
                <hr class="hr mb-4">
            </form>
            <h5 class="mb-3">Запрашиваемая сумма кредита</h5>
            <form>
                <div class="row mb-2">
                    <div class="col-4">
                        <label class="form-label">Сумма</label>
                        <input type="text" class="form-control" placeholder="15000">
                    </div>
                </div>
            </form>
            <div class="text-center mt-3">
                <button type="submit" class="btn btn-primary">Отправить форму</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>