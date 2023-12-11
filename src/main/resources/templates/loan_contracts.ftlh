<!doctype html>
<html lang="en">
<head>
    <title>Данные о кредитном договоре</title>
</head>
<body class="bg-light">
<#include "parts/header.ftlh">
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-1 text-center">Список кредитных контрактов</h2>
            <hr class="hr mb-4">
            <h5 class="mb-3">Фильтр</h5>
            <label class="form-label">Статус подписания</label>
            <form action="/loan-contracts/filtered" method="get">
                <select name="loanContractStatus" class="form-select col-3" required>
                    <#list statuses as status>
                        <#if status == 'SIGNED'>
                            <option value="${status}">Подписан</option>
                        <#elseif status == 'NOT_SIGNED'>
                            <option value="${status}">Не подписан</option>
                        </#if>
                    </#list>
                </select>
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
                        <th scope="col">Ожидаемая сумма кредита</th>
                        <th scope="col">Одобренная сумма кредита</th>
                        <th scope="col">Одобренное время на выплату</th>
                        <th scope="col">Статус одобрения</th>
                        <th scope="col">Действие</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <#list loanContracts as loanContract>
                        <tr>
                            <th scope="row">${loanContract.id}</th>
                            <td>
                                <a href="/clients/${loanContract.loanApplication.client.id}">
                                    ${loanContract.loanApplication.client.secondName} ${loanContract.loanApplication.client.firstName} ${loanContract.loanApplication.client.patronymic}
                                </a>
                            </td>
                            <td>${loanContract.loanApplication.desiredLoan}</td>
                            <td>${loanContract.getApprovedLoan()}</td>
                            <td>${loanContract.approvedTimeToPay}</td>
                            <td>
                                <#if loanContract.loanContractStatus == "SIGNED">
                                    Подписан
                                <#elseif loanContract.loanContractStatus == "NOT_SIGNED">
                                    Не подписан
                                </#if>
                            </td>
                            <td>
                                <a href="/loan-contracts/${loanContract.id}">Подробнее</a>
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