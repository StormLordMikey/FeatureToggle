<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Feature Toggle Manager</title>
    <#include "styles.css">
  </head>
  <body>
    <div class="bubble">
      <table class="feature-table" callpadding="0" callspacing="0">
        <thead>
          <tr class="header">
            <th></th>
            <th>name</th>
            <th>description</th>
            <th>status</th>
          </tr>
        </thead>
        <tbody>
          <#list featureToggles as feature>
          <tr>
            <td></td>
            <td>${feature.name?html}</td>
            <td>${feature.description?html}</td>
            <td>${feature.status?html}</td>
          </tr>
          </#list>
        </tbody>
      </table>
    </div>

  </body>
</html>