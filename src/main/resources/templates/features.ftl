<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Feature Toggle Manager</title>
    <link rel="stylesheet" type="text/css" href="/assets/styles.css" />
  </head>
  <body>
    <div class="container">
      <header>Feature Toggles - "The Toggling"</header>
        <h3 class="group-heading">Production</h3>
        <ol class="group">
          <#list featureToggles as feature>
            <li class="group-item">
              <img class="icon" height="36" width="36" src="/assets/features_icon.png">
              <p class="title">${feature.name?html}</p>
              <#if feature.enabled>
              <div class="age">3 months</div>
              </#if>
              <div class="meta">
                <div class="details">
                    <#if feature.enabled>
                      <p class="status green">Enabled</p>
                      <#assign change_text="turn off">
                    <#else>
                      <p class="status red">Disabled</p>
                      <#assign change_text="turn on">
                    </#if>
                     <a href="/toggle/${feature.id}" class="change-button">${change_text}</a>
                </div>
                <div class="description"><span>${feature.description?html}</span></div>
              </div>
            </li>
          </#list>
        </ol>
    </div>
  </body>
</html>