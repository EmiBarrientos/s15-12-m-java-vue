# Propiedades360

Propiedades360 es una aplicación para gestionar reservas y visitas de inmuebles.

## Requisitos

Para ejecutar este proyecto en local, necesitarás:

- Java JDK 8 o superior instalado en tu sistema.
- Maven para compilar y construir el proyecto.
- MySQL instalado en tu máquina y una base de datos creada para el proyecto.
- Un IDE de tu elección, como IntelliJ IDEA o Eclipse.

## Configuración de la Base de Datos

1. Instala MySQL si aún no lo has hecho.
2. Crea una base de datos en MySQL para este proyecto.
3. Actualiza el archivo `src/main/resources/application.properties` con la información de tu base de datos MySQL. Asegúrate de especificar el nombre de la base de datos, el nombre de usuario y la contraseña.

## Ejecución del Proyecto

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE.
3. Configura la conexión a la base de datos MySQL según se indica en el paso anterior.
4. Ejecuta el proyecto desde tu IDE o utilizando el comando `mvn spring-boot:run` en la terminal en la carpeta raíz del proyecto.
5. Una vez que la aplicación esté en funcionamiento, puedes acceder a ella desde tu navegador web visitando `http://localhost:8080`.

## Uso de la Aplicación

- Una vez que la aplicación esté en funcionamiento, podrás realizar reservas y programar visitas con propietarios de inmuebles.
- Utiliza los endpoints proporcionados en el controlador de la reserva y visita para confirmar o cancelar reservas y visitas.

## Contribuir

Si deseas contribuir a este proyecto, ¡te damos la bienvenida! Por favor, sigue estos pasos:

1. Haz un fork de este repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commits (`git commit -am 'Agrega nueva funcionalidad'`).
4. Sube tus cambios a tu fork (`git push origin feature/nueva-funcionalidad`).
5. Crea una nueva Pull Request y describe tus cambios detalladamente.

## Problemas o Preguntas

Si encuentras algún problema o tienes alguna pregunta, por favor abre un issue en este repositorio y te ayudaremos.

¡Gracias por utilizar Propiedades360!
