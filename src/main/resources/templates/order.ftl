<#import 'macros/page.ftl' as p>
<@p.page "Order">
<h1>Welcome to order page</h1>
<a class="link" href="/">Go to main page</a>
<table id="table">
    <thead>
    <tr>
        <th>
            <div class="th_centered">
                <div class="th_name">Date_start</div>
                <div><img onclick="sortTableAsc(0)" src="/static/img/triangle.png" class="order_by" </img></div>
                <div><img onclick="sortTableDesc(0)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
            <div class="th_name">Date_end</div>
            <div><img onclick="sortTableAsc(1)" src="/static/img/triangle.png" class="order_by" </img></div>
            <div><img onclick="sortTableDesc(1)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
            <div class="th_name">FIO</div>
            <div><img onclick="sortTableAsc(2)" src="/static/img/triangle.png" class="order_by" </img></div>
            <div><img onclick="sortTableDesc(2)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
            <div class="th_name">Phone name</div>
            <div><img onclick="sortTableAsc(3)" src="/static/img/triangle.png" class="order_by" </img></div>
            <div><img onclick="sortTableDesc(3)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
        <th>
            <div class="th_centered">
            <div class="th_name">Status</div>
            <div><img onclick="sortTableAsc(4)" src="/static/img/triangle.png" class="order_by" </img></div>
            <div><img onclick="sortTableDesc(4)" src="/static/img/triangle_revert.png" class="order_by" </img></div>
            </div>
        </th>
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
        ${order.date_end!""}
        </td>
        <td>
        ${order.employee.getFio()}
        </td>
        <td>
        ${order.phone.getFullName()}
        </td>
        <td>
        <#list order.statuses as status>${status}</#list>

        </td>
        <td>
    <a href="/order/remove/${order.id}">Remove</a>
        </td>
        </tr>
    </#list>
    </tbody>
</table>
<script type="text/javascript" src="/static/js.js"></script>
</@p.page>