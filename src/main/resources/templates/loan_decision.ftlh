<!doctype html>
<html lang="en">
<head>
    <title>Решение по кредиту</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="text-center">
    <h1 class="display-4">Статус вашей заявки</h1>
    <h2>${status}</h2>

    <div class="container">
        <div class="row">
            <#if status == "Кредит одобрен">
                <div class="col-6">
                    <a href="/" class="btn btn-primary mt-3">На главную</a>
                </div>
                <div class="col-6">
                    <a href="/loan-application-create-form/contract" class="btn btn-success mt-3">Оформить договор</a>
                </div>
            <#else>
                <div class="col-12">
                    <a href="/" class="btn btn-primary mt-3">На главную</a>
                </div>
            </#if>
        </div>
    </div>
</div>
</body>
</html>
