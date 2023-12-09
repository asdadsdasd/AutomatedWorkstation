<!doctype html>
<html lang="en">
<head>
    <title>Clients</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-1 text-center">Список заявок на получение кредита</h2>
            <hr class="hr mb-4">
            <h5 class="mb-3">Фильтр</h5>
            <label class="form-label">Статус одобрения</label>
            <select name="loanApplicationStatus" class="form-select col-3" required>
                <#list statuses as status>
                    <#if status == 'MOT_CONSIDERED'>
                        <option value="${status}">Рассматрицвается</option>
                    <#elseif status == 'APPROVED'>
                        <option value="${status}">Одобрено</option>
                    <#elseif status == 'NOT_APPROVED'>
                        <option value="${status}">Не одобрено</option>
                    </#if>
                </#list>
            </select>
            <div class="text-center mt-3">
                <button type="submit" class="btn btn-primary">Поиск</button>
            </div>
            <div class="table-responsive mt-5">
                <table class="table text-center">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ФИО</th>
                        <th scope="col">Сумма кредита</th>
                        <th scope="col">Статус одобрения</th>
                        <th scope="col">Действие</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <#list loanApplications as loanApplication>
                        <tr>
                            <th scope="row">${loanApplication.id}</th>
                            <td>
                                <a href="/clients/${loanApplication.client.id}">
                                    ${loanApplication.client.secondName} ${loanApplication.client.firstName} ${loanApplication.client.patronymic}
                                </a>
                            </td>
                            <td>${loanApplication.desiredLoan}</td>
                            <td>
                                <#if loanApplication.loanApplicationStatus == "MOT_CONSIDERED">
                                    Рассматривается
                                <#elseif loanApplication.loanApplicationStatus == "APPROVED">
                                    Одобрено
                                <#elseif loanApplication.loanApplicationStatus == "NOT_APPROVED">
                                    Не одобрено
                                </#if>
                            </td>
                            <td>
                                <a href="/loanApplication/${loanApplication.id}">Подробнее</a>
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