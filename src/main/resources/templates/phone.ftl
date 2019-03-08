<#import 'macros/page.ftl' as p>
<@p.page "Phone">
    <h1>Welcome to phone page</h1>
    <a class="link" href="/">Go to main page</a>
    <table id="table">
    <thead>
    <tr>
        <th>
            <div class="th_centered">
                <div class="th_name">Phone name</div>
                <div><img onclick="sortTableAsc(0,3)" src="/static/img/triangle.png" class="order_by" </img></div>
                <div><img onclick="sortTableDesc(0,3)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
                <div class="th_name">Firmware name</div>
                <div><img onclick="sortTableAsc(1,3)" src="/static/img/triangle.png" class="order_by" </img></div>
                <div><img onclick="sortTableDesc(1,3)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
           Firmware version
        </th>
        <th>
            Amount
        </th>
        <th>
            Free_amounts
        </th>
        <th>
            Action
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Введите</td>
        <td>количество </td>
        <td>удаляемых </td>
        <td>телeфонов: </td>
    <td>
        <input class="input" id="amount_delete" type="text" name="amount"/>
    </td>
        <td></td>
    </tr>
    <tr>
        <td>
            <input class="input" id="name" type="text" name="name"/>
        </td>
        <td>
            <input class="input" id="firmware_name" type="text" name="firmware_name"/>
        </td>
        <td>
            <input class="input" id="firmware_version" type="text" name="firmware_version"/>
        </td>
        <td>
            <input class="input" id="amount" type="text" name="amount"/>
        </td>
        <td></td>
        <td>
            <a class="link" onclick="postRequest('/phone/add',
            {name: document.getElementById('name').value,
            firmware_name: document.getElementById('firmware_name').value,
            firmware_version:document.getElementById('firmware_version').value,
            amount:document.getElementById('amount').value,
            _csrf:document.getElementById('_csrf').value});"> Add</a>
        </td>
    </tr>
    <#list phones as phone>
        <tr>
        <td>
        ${phone.name}
        </td>
        <td>
        ${phone.firmware_name}
        </td>
        <td>
        ${phone.firmware_version}
        </td>
        <td>
        ${phone.amount}
        </td>
        <td>
        ${phone.free_phone_amount}
        </td>
    <td>
    <a href="/phone/remove/${phone.id}">REMOVE</a>
    </td>
        </tr>
    </#list>
    </tbody>
    </table>
    <form style="display:none;">
    <input id="_csrf" type="hidden" name="_csrf" value="${_csrf.token}" />﻿
    </form>
<script type="text/javascript" src="/static/js.js"></script>
</@p.page>