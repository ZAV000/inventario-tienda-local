# Issues para GitHub

## Issue 1 — Crear estructura inicial del proyecto

**Descripción:**  
Crear la estructura inicial del sistema de inventario utilizando Java, Maven y JUnit.

**Análisis:**  
El proyecto requiere una base organizada que facilite la incorporación de nuevas funciones y la ejecución automatizada de pruebas.

**Solución propuesta:**  
Crear un proyecto Maven con paquetes separados para código principal y pruebas.

**Criterios de aceptación:**
- Existe un archivo `pom.xml`.
- El proyecto compila correctamente.
- Maven reconoce las pruebas JUnit.

**Tiempo estimado:** 2 horas  
**Etiquetas:** `backend`, `beta`, `setup`  
**Milestone:** Beta

---

## Issue 2 — Implementar modelo de producto

**Descripción:**  
Crear una clase que represente los productos registrados en el inventario.

**Análisis:**  
Cada producto necesita nombre, cantidad en piso, cantidad en bodega y fecha de caducidad.

**Solución propuesta:**  
Implementar la clase `Producto` con validaciones para impedir cantidades negativas.

**Criterios de aceptación:**
- El producto almacena nombre y fecha de caducidad.
- Se registran cantidades de piso y bodega.
- Se calcula la cantidad total.
- No se permiten cantidades negativas.

**Tiempo estimado:** 3 horas  
**Etiquetas:** `backend`, `beta`, `feature`  
**Milestone:** Beta

---

## Issue 3 — Implementar semáforo de caducidad

**Descripción:**  
Clasificar los productos según su fecha de caducidad.

**Análisis:**  
Se requiere identificar rápidamente productos caducados, próximos a caducar y vigentes.

**Solución propuesta:**  
Crear un servicio que devuelva ROJO cuando el producto ya caducó, AMARILLO cuando falten siete días o menos y VERDE cuando falten más de siete días.

**Criterios de aceptación:**
- Los productos caducados se clasifican como ROJO.
- Los productos con siete días o menos se clasifican como AMARILLO.
- Los productos con más de siete días se clasifican como VERDE.

**Tiempo estimado:** 4 horas  
**Etiquetas:** `backend`, `beta`, `feature`, `priority-high`  
**Milestone:** Beta

---

## Issue 4 — Crear pruebas unitarias con JUnit

**Descripción:**  
Validar automáticamente la lógica del semáforo de caducidad.

**Análisis:**  
Las pruebas permiten detectar errores antes de integrar cambios al branch develop.

**Solución propuesta:**  
Crear tres pruebas JUnit: una para ROJO, una para AMARILLO y una para VERDE.

**Criterios de aceptación:**
- Las pruebas se ejecutan con `mvn test`.
- Las tres pruebas finalizan correctamente.
- Travis CI muestra una compilación exitosa.

**Tiempo estimado:** 2 horas  
**Etiquetas:** `testing`, `beta`, `priority-high`  
**Milestone:** Beta

---

## Issue 5 — Configurar integración continua con Travis CI

**Descripción:**  
Conectar el repositorio con Travis CI para ejecutar pruebas en cada cambio.

**Análisis:**  
La integración continua reduce el riesgo de integrar código con errores.

**Solución propuesta:**  
Agregar el archivo `.travis.yml` y configurar la ejecución de `mvn clean test`.

**Criterios de aceptación:**
- Travis CI reconoce el repositorio.
- Se ejecuta el comando de pruebas.
- El dashboard muestra el build en estado exitoso.

**Tiempo estimado:** 2 horas  
**Etiquetas:** `ci`, `beta`, `devops`  
**Milestone:** Beta

---

## Issue 6 — Incorporar fotografías de productos

**Descripción:**  
Permitir asociar una imagen a cada producto.

**Análisis:**  
Las fotografías facilitarán la identificación visual de productos por parte de usuarios nuevos.

**Solución propuesta:**  
Diseñar un módulo de carga y almacenamiento de imágenes para una versión posterior.

**Fuera de alcance en Beta:**  
Esta función no se desarrollará en la primera versión.

**Tiempo estimado:** 6 horas  
**Etiquetas:** `future`, `out-of-scope`, `ga`, `frontend`  
**Milestone:** General Availability (GA)

---

## Issue 7 — Implementar lector de códigos de barras

**Descripción:**  
Registrar productos mediante lectura de códigos de barras.

**Análisis:**  
La función reduciría el tiempo de captura, pero requiere hardware o acceso a cámara.

**Solución propuesta:**  
Evaluar una biblioteca de lectura de códigos y desarrollar un prototipo en una versión futura.

**Fuera de alcance en Beta:**  
Esta función no se desarrollará en la primera versión.

**Tiempo estimado:** 10 horas  
**Etiquetas:** `future`, `out-of-scope`, `ga`  
**Milestone:** General Availability (GA)

---

## Issue 8 — Crear reportes y exportación

**Descripción:**  
Generar reportes de productos caducados, próximos a caducar y existencias.

**Análisis:**  
Los reportes facilitarán la toma de decisiones y el control periódico del inventario.

**Solución propuesta:**  
Agregar exportación a CSV o PDF en la versión estable.

**Fuera de alcance en Beta:**  
Esta función se reserva para GA.

**Tiempo estimado:** 8 horas  
**Etiquetas:** `future`, `ga`, `reporting`  
**Milestone:** General Availability (GA)
