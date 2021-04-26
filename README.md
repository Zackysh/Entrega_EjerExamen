### Instrucciones para ejecutar Fav Shows Project

##### Arrancar API:

- > En eclipse, importar el proyecto `fav-shows-api` en `Existing Maven Projects`.
  >
  > Para ello:  `import` :arrow_right: `Maven`:arrow_right: `Existing Maven Projects`. Simplemente selecciona la carpeta `fav-shows-api` si has clonado este repositorio.

- Una vez importado el proyecto, sigue estos pasos:

  - Arrancar una base de datos (preferentemente en el puerto 3306).
  - Ejecutar esta query: `CREATE DATABASE favorites`. Revisa si se ha creado correctamente.
  - Si no tienes la BDD en el puerto 3306, dentro del proyecto ve a `resources/application.properties` y cambia el puerto al que estés utilizando.
  - Si tienes un usuario `root` sin contraseña, puedes continuar, sino crealo o introduce tus credenciales en `resources/application.properties`.

- Ahora haz click derecho en `src/main/java/com.fav.shows.api/FavShowsApplication.java` , y ejecutalo como `Java Application` . No es necesario que uses Spring dev tools.
- Por último, ejecuta esta consulta:

```sql
      USE favorites;
      INSERT INTO `favorites`.`favorites_json`
      (`favs_id`, `json`) VALUES (0, "[]");
```

##### Arrancar cliente:

- Abre la carpeta `front-end` con VS-Code (u otro editor) y ejecuta en la terminal los siguientes comandos:
  - `npm install`
  - `npm start`

#### Cosas a tener en cuenta:

Si haces click en el nombre de los shows podrás ver su contenido.
