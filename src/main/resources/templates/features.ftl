<!DOCTYPE html>
<html lang="en">
    <head>

    </head>
    <body>
        <#list featureToggles as feature>
        <h1>Hello, ${feature.name?html}</h1>
        </#list>
    </body>
</html>