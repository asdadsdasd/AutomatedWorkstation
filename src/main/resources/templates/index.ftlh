<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Loan app</title>
</head>
<body class="bg-light">
<style>
    #content_blocks{
        margin-top: 300px;
    }
</style>
<#include "parts/header.ftlh">
<div class="container" id="content_blocks">
    <div class="row">
        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box text-center">
                <h4 class="content_box"><a href="/loan-application-create-form/create">Оформить заявку</a></h4>
                <p class="description">Перейти к оформлению заявки на кредит для физлиц</p>
            </div>
        </div>

        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box text-center">
                <h4 class="content_box"><a href="/clients">Список клиентов</a></h4>
                <p class="description">Перейти к списку всех клиентов банка</p>
            </div>
        </div>

        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box text-center">
                <h4 class="content_box"><a href="/loan-applications">Список заявок</a></h4>
                <p class="description">Перейти к списку оформленных заявок на получение кредита</p>
            </div>
        </div>

        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
            <div class="icon-box text-center">
                <h4 class="content_box"><a href="/loan-contracts">Список договоров</a></h4>
                <p class="description">Перейти к списку кредитных договоров со статусом подписания</p>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>