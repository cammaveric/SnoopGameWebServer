<#import 'macros/page.ftl' as p>

<@p.page "Employee">
    <h1>Welcome to employee page</h1>
    <a class="link" href="/">Go to main page</a>
    <table id="table">
    <thead>
    <tr>
        <th>
            <div class="th_centered">
                <div class="th_name">Surname</div>
                <div><img onclick="sortTableAsc(0,2)" src="/static/img/triangle.png" class="order_by" </img></div>
                <div><img onclick="sortTableDesc(0,2)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
                <div class="th_name">Name</div>
                <div><img onclick="sortTableAsc(1,2)" src="/static/img/triangle.png" class="order_by" </img></div>
                <div><img onclick="sortTableDesc(1,2)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
                <div class="th_name">Middle name</div>
                <div><img onclick="sortTableAsc(2,2)" src="/static/img/triangle.png" class="order_by" </img></div>
                <div><img onclick="sortTableDesc(2,2)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            Action
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <input class="input" id="surname" type="text" name="surname"/>
        </td>
        <td>
            <input class="input" id="name" type="text" name="name"/>
        </td>
        <td>
            <input class="input" id="middleName" type="text" name="middleName"/>
        </td>
        <td>
            <a class="link" onclick="postRequest('/employee/add',
            {surname: document.getElementById('surname').value,
            name: document.getElementById('name').value,
            middleName:document.getElementById('middleName').value,
            _csrf:document.getElementById('_csrf').value});"> Add</a>
        </td>
    </tr>
    <#list employees as employee>
        <tr>
        <td>
        ${employee.surname}
        </td>
        <td>
        ${employee.name}
        </td>
        <td>
        ${employee.middleName}
        </td>
    <td>
<a href="/employee/remove/${employee.id}"> Remove</a>
    </td>
        </tr>
    </#list>
    </tbody>
    </table>
    <form style="display: none">
        <input id="_csrf" type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
<script type="text/javascript" src="/static/js.js"></script>
</@p.page>