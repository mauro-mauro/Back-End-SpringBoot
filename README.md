## Proyecto Integrador Portfolio Web Full Stack #yoProgramo

Con un poco de conocimiento previo de Java como autodidacta, realizo este primer proyecto con spring boot. 
Este back end provee las APIs necesarias para acceder a registros almacenados en una base de datos (MySQL), compuestos por los datos personales, estudios cursados, experiencia laboral y conocimiento de las tecnologías. 
Posee un login con autentificación JWT (JSON Web Token), habilitando la posibilidad de agregar, actualizar o eliminar registros.
También cuenta con refresh token.
Además del archivo propiedades por defecto, tiene uno para desarrollo, uno para producción y otro para las contraseñas, este último no se encuentra publicado en github.

## Modificación del proyecto original

Originalmente la aplicación contaba con tablas relacionadas, pero una vez subida a la nube, descubrí que las relaciones demoraban mucho la primer carga de spring boot, teniendo varias tablas relacionadas, excedía el tiempo de respuesta entrando en estado de crash. Por este motivo decidí no usar tablas relacionadas, y en su lugar, usar consultas a la base de datos personalizadas, logrando el mismo resultado con tiempo de primer carga optimo.

[Ver pagina web](https://mauroperaltaportfolio.web.app)
