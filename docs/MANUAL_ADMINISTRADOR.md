# Manual de administrador

## Funciones disponibles

- Consultar todos los productos.
- Revisar productos caducados y próximos a caducar.
- Eliminar registros.
- Ejecutar pruebas.
- Generar el JAR.
- Configurar el puerto.

## Generar el producto

```bash
mvn clean package
```

## Ejecutar el producto

```bash
java -jar target/inventario-tienda-local-1.0.0.jar
```

## Configurar el puerto

Editar `src/main/resources/application.properties` o definir `PORT`.

## Respaldo

La versión 1.0.0 trabaja en memoria. Los datos se reinician al cerrar la
aplicación. La persistencia se implementará en una versión futura.
