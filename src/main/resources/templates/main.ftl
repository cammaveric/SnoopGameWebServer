<#import 'macros/page.ftl' as p>
<#import 'macros/log_reg.ftl' as l_r>
<@p.page "Main">
    <h1>Welcome to main page</h1>
<a class="link" href="/employee">View employee</a>
    <a class="link" href="/phone">View phone</a>
    <a class="link" href="/order">View orders</a>
    <a class="link" href="/registration"> Add new user</a>
    <@l_r.logout/>
</@p.page>