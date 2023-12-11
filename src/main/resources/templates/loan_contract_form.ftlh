<!doctype html>
<html lang="en">
<head>
    <title>Подписание договора</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-1 text-center">Кредитный договор</h2>
            <hr class="hr mb-4">
            <h5 class="mb-3">Паспортные данные</h5>
            <form action="/loan-application-create-form/contract" method="post">
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Фамилия</label>
                        <p class="form-control">${loanContract.loanApplication.client.secondName}</p>
                    </div>
                    <div class="col">
                        <label class="form-label">Имя</label>
                        <p class="form-control">${loanContract.loanApplication.client.firstName}</p>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Отчество</label>
                        <p class="form-control">${loanContract.loanApplication.client.patronymic}</p>
                    </div>
                    <div class="col">
                        <label class="form-label">Семейное положение</label>
                        <#if loanContract.loanApplication.client.martialStatus == "SINGLE">
                            <p class="form-control">Не женат/Не замужем</p>
                        <#elseif loanContract.loanApplication.client.martialStatus == "MARRIED">
                            <p class="form-control">Женат/Замужем</p>
                        <#elseif loanContract.loanApplication.client.martialStatus == "DIVORCED">
                            <p class="form-control">Разведен/Разведена</p>
                        <#elseif loanContract.loanApplication.client.martialStatus == "WIDOWED">
                            <p class="form-control">Вдовец/Вдова</p>
                        </#if>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Серия паспорта</label>
                        <p class="form-control">${loanContract.loanApplication.client.passportSerial}</p>
                    </div>
                    <div class="col">
                        <label class="form-label">Номер паспорта</label>
                        <p class="form-control">${loanContract.loanApplication.client.passportNumber}</p>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col">
                        <label class="form-label">Адрес прописки</label>
                        <p class="form-control">${loanContract.loanApplication.client.registrationAddress}</p>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <label class="form-label">Номер телефона</label>
                        <p class="form-control">${loanContract.loanApplication.client.phoneNumber}</p>
                    </div>
                </div>
                <hr class="hr mb-4">
                <h5 class="mb-3">Сведения о занятости</h5>
                <div class="row mb-2">
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
                </div>
                <hr class="hr mb-4">
                <h5 class="mb-3">Запрашиваемая сумма кредита</h5>
                <div class="row mb-2">
                    <div class="col-4">
                        <label class="form-label">Сумма</label>
                        <p class="form-control">${loanContract.loanApplication.desiredLoan}</p>
                    </div>
                </div>
                <h5 class="mb-3">Одобренные параметры кредита</h5>
                <div class="row mb-2">
                    <div class="col-4">
                        <label class="form-label">Одобренная сумма</label>
                        <p class="form-control">${loanContract.approvedLoanAmount}</p>
                    </div>
                    <div class="col-4">
                        <label class="form-label">Одобренное время на выплату</label>
                        <p class="form-control">${loanContract.approvedTimeToPay}</p>
                    </div>
                </div>
                <div class="text-center mt-3">
                    <div class="text-center mt-3">
                        <form action="/loan-application-create-form/contract" method="post">
                            <button type="submit" name="contractAction" value="sign" class="btn btn-success">Подписать договор</button>
                        </form>
                        <form action="/loan-application-create-form/contract" method="post">
                            <button type="submit" name="contractAction" value="reject" class="btn btn-danger">Не подписывать договор</button>
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>