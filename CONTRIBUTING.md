# Guía de contribución

1. Trabajar siempre desde `develop`.
2. Crear una rama con el prefijo `feature/`, `fix/`, `docs/` o `test/`.
3. Mantener los commits pequeños y descriptivos.
4. Ejecutar `mvn clean test` antes de enviar cambios.
5. Abrir un pull request hacia `develop`.
6. Describir problema, análisis, solución y pruebas realizadas.
7. Esperar la revisión antes de hacer merge.
8. No enviar cambios directos a `master`.

Ejemplo:

```bash
git checkout develop
git pull origin develop
git checkout -b feature/editar-productos
git add .
git commit -m "feat: agregar edición de productos"
git push -u origin feature/editar-productos
```
