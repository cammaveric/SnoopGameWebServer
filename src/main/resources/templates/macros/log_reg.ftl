<#macro l_r path>
    <form action="${path}" method="post">
        <div class="form_fields"><label> User Name : <input type="text" name="username"/> </label></div>
        <div class="form_fields"><label> Password: <input type="password" name="password"/> </label></div>
        <div class="form_fields"><input type="submit" value="Sign In"/></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />﻿
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
    <input class="button2" type="submit" value="Sign Out"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />﻿
    </form>
</#macro>