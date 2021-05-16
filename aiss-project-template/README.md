# **FootballWiki** :soccer:

[FootballWiki](https://aiss-footballwiki-313611.ew.r.appspot.com/) es una aplicación de utilidad para todos aquellos seguidores del fútbol, donde podrás encontrar todos los datos de tus competiciones y equipos favoritos.

##### Partes de la aplicación

Por el momento, podrás acceder a la información almacenada en [FootballWiki](https://aiss-footballwiki-313611.ew.r.appspot.com/) a través de dos registros: competiciones y equipos. En el menú [Competiciones](https://aiss-footballwiki-313611.ew.r.appspot.com/api/comp), aparecerán los nombres de las ligas y los torneos más importantes del momento, así como el país/región organizador y los equipos participantes. En el menú [Equipos](https://aiss-footballwiki-313611.ew.r.appspot.com/api/teams), podrás ver la información de una gran variedad de equipos, con datos como el nombre del equipo, su ciudad o su estadio.

##### Importación y despliegue para test local vía GitHub

Para usar el código de FootballWiki (ya sea para integrarlo en otra aplicación o para tests locales), hay dos opciones: importarlo desde el repositorio de [GitHub](https://github.com/L4-2-AISS/L4-02-AISS) o descargar el código en formato .zip. Una vez importado o descargado, lo siguiente es ir a launch_profiles > click derecho en StartDevServer.launch > Run as... > StartDevServer . Esperamos a que termine de ejecutarse y entramos a la dirección del localhost indicada en la consola.

##### Tests vía navegador Web

Si únicamente quieres comprobar cómo funciona [FootballWiki](https://aiss-footballwiki-313611.ew.r.appspot.com/) y probar las diferentes operaciones que se pueden realizar en la aplicación (los cuales se explican [aquí](https://app.swaggerhub.com/apis/jessalmun/aiss-footballwiki/1.0.0)), sólo tendrás que descargar un cliente REST compatible con tu navegador Web: 

* Google Chrome: [Advanced REST Client](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=es)
* Mozilla Forefox: [RESTClient](https://addons.mozilla.org/es/firefox/addon/restclient/)

