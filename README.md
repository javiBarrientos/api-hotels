# Apihotels

Primer proyecto personal full-stack en octubre de 2020. Se trata de una pagina web que gestiona reserva de habitaciones de hotel. **La aplicacion no esta completa por falta de tiempo**. La intencion de esta web era aprender a hacer una api que se comunique con una bbdd relacional y consumirla con un front.

## Historias de usuario
1. Mostrar todos los hoteles
2. Lista de los hoteles con mejor puntuacion
3. Lista de los hoteles con mas estrellas
4. Poder registrarte/loguearte
5. Diferentes roles para administrar usuarios (CRUD)
6. Reserva de habitacion por dias

## Tecnologias
Por parte del front
- Vue
- Vuex
- NPM
- Webpack
- axios
- bootstrap
- bootstrap-vue

Por parte del back
- Springboot
- MVN
- JPA
- MYSQL
- JWT
- Hibernate
 
## Instalacion
Para poder instalar la aplicacion hara falta mvn, npm y mysql.
Comandos de instalacion de la aplicacion:

Instalar dependencias npm y lanzar servidor web.
> npm install && npm run dev

Instalar las dependencias de maven y lanzar aplicacion spring-boot.
> mvn clean install 
> mvnw spring-boot:run
## Posibles mejoras
Toda la aplicacion podria mejorar en muchos aspectos, empezando por el front mejorar la gestion de ficheros y ordenarlos mas, refactorizar el componente **AlojamientosVue** y mejorar los nombre de variables en general.

Por la parte del back crear dto, usar lombok, mejores nombres de ficheros y una mejor disposicion de las carpetas.

Y de la bbdd un mejor diseño de ella y mas compleja es muy simple actualmente.

## Contribuidores
[Javi Barrientos](https://github.com/javiBarrientos)
