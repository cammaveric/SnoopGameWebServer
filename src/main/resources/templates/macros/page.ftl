<#macro page title>
<!DOCTYPE html>
    <html lang="en">
    <head>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
    <title>${title}</title>
</head>
<body class="all">
    <#nested>
    </body>
    </html>
</#macro>

<#macro hidden_blocks id name>
    <a class="link" href="javascript:void(0)" onclick="show_info_block(document.getElementById('${id}'))" >${name}</a>
    <div id="${id}" class="hidden_forms">
    <#nested >
    </div>
</#macro>