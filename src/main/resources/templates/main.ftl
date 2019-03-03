<#import 'macros/page.ftl' as p>
<#import 'macros/log_reg.ftl' as l_r>
<@p.page "Main">
    <h1>Welcome to main page</h1>
    <@p.hidden_blocks "d1" "View employee">
        <p>Put table</p>
        <form action="/employee/add" method="post">
        <div class="form_fields"><label> Employee name: <input type="text" name="name"/> </label></div>
        <div class="form_fields"><label> Surname: <input type="text" name="surname"/> </label></div>
        <div class="form_fields"><label> Middle name: <input type="text" name="middleName"/> </label></div>
        <div class="form_fields"><input type="submit" value="Remove"/></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />﻿
        </form>
    </@p.hidden_blocks>
    <@p.hidden_blocks "d2" "View phone">
        <p>Put table</p>
        <form action="/phone/add" method="post">
        <div class="form_fields"><label> Phone name: <input type="text" name="name"/> </label></div>
        <div class="form_fields"><label> Amount: <input type="text" name="amount"/> </label></div>
        <div class="form_fields"><label> Firmware name: <input type="text" name="firmware_name"/> </label></div>
        <div class="form_fields"><label> Firmware ver: <input type="text" name="firmware_version"/> </label></div>
        <div class="form_fields"><input type="submit" value="Add"/></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />﻿
        </form>
    </@p.hidden_blocks>
    <@p.hidden_blocks "d3" "View orders">
        <table >
        <thead>
        <tr>
            <th>Date_start</th>
            <th>FIO</th>
            <th>Phone name</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
            <td>
            ${order.date_start}
            </td>

            <td>
            ${order.employee.getFio()}
            </td>
            <td>
            ${order.phone.getFulName()}
            </td>
            <td>
            <a href="/order/remove/${order.id}">Remove</a>
            </td>
            </tr>
        </#list>
        </tbody>
        </table>
    </@p.hidden_blocks>
    <a class="link" href="/registration"> Add new user</a>
    <@l_r.logout/>
    <script type="text/javascript" src="/static/js.js"></script>
</@p.page>