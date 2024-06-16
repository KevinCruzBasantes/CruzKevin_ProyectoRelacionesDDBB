# CruzKevin_ProyectoRelacionesDDBB
Proyecto de persistencia aerolinea
Este proyecto de persistencia de Aerolínea es una aplicación Java desarrollada con Spring Boot y JPA (Java Persistence API). 
El objetivo principal es gestionar aerolíneas, vuelos, pasajeros y su información asociada mediante operaciones CRUD

Entidades JPA:
Airline: Representa una aerolínea con nombre y una lista de vuelos asociados.
Flight: Representa un vuelo con un número de vuelo único, asociado a una aerolínea y con una lista de pasajeros.
Passenger: Representa a un pasajero con nombre, información personal y asociado a un vuelo.
PassengerInfo: Contiene la información personal de un pasajero, como correo electrónico y teléfono.

Relaciones entre Entidades:
One-to-Many: Una aerolínea puede tener muchos vuelos 
Many-to-One: Muchos pasajeros pueden estar en un mismo vuelo
One-to-One: Cada pasajero tiene una única información personal asociada
Many-to-Many: Muchos pasajeros pueden estar en muchos vuelos 

Funcionalidad:
Crear, leer, actualizar y eliminar aerolíneas.
Crear, leer, actualizar y eliminar vuelos asociados a aerolíneas.
Crear, leer, actualizar y eliminar pasajeros asociados a vuelos, incluyendo su información personal.
Establecer y gestionar la relación many-to-many entre pasajeros y vuelos.

Configuración del Proyecto
El proyecto está configurado con:
Base de datos MySQL.
Persistencia gestionada mediante Spring Data JPA.
Uso de Spring Boot para simplificar la configuración y el desarrollo.
Gestión de dependencias con Maven.

Ejecución del Proyecto
Para ejecutar el proyecto localmente:
Asegúrate de tener configurada una base de datos MySQL local.
Actualiza las credenciales de la base de datos en el archivo application.properties.