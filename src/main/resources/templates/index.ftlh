<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Loan app</title>
</head>
<body>
<h1>LoanApplication</h1><hr>
<#list loans as loan>
    <div>
        <p><b>${loan.clientEntity.secondName} ${loan.clientEntity.firstName} | ${loan.desiredLoan}</a> </b></p>
    </div>
</#list>
<h3>Создать заявку</h3>
<form action="/loan/create" method="post">
    <H4>Данные клиента</H4>
    Фамилия: <input type="text" name="secondName" required/><br>
    Имя: <input type="text" name="firstName" required/><br>
    Отчество: <input type="text" name="patronymic"/><br>
    Серия паспорта: <input type="text" name="passportSerial" required/><br>
    Номер паспорта: <input type="text" name="passportNumber" required/><br>
    Семейное положение:
    <select name="martialStatus" required>
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
    </select><br>
    Адрес регистрации: <input type="text" name="registrationAddress"/><br>
    Номер телефона: <input type="text" name="phoneNumber" required/><br>
    <br>
    <H4>Данные о месте работы</H4>
    Срок работы: <input type="number" name="workPeriod"/><br>
    Должность: <input type="text" name="post"/><br>
    Название организации: <input type="text" name="organisationName"/><br>
    <br>
    Желаемая сумма кредита: <input type="number" name="desiredLoan"/><br>
    <button type="submit">Создать заявку</button>
</form>
</body>
</html>